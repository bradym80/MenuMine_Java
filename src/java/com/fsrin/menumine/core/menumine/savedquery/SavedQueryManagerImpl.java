/*
 * Created on May 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.fsrin.menumine.common.webwork.UserLoginEvent;
import com.fsrin.menumine.common.webwork.UserLogoutEvent;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;
import com.fstx.stdlib2.authen.users.UserServiceDelegateException;

/**
 * @author Nick This class manages requested saved querys so we don't repeatedly
 *         have to hit the database. Since it takes a while load we place a
 *         request to build the list then we pick it up later.
 * 
 */
public class SavedQueryManagerImpl implements SavedQueryManager,
        ApplicationListener {

    private static Log log = LogFactory.getLog(SavedQueryManagerImpl.class);

    private SavedQueryServiceDelegate savedQueryServiceDelegate = null;

    private Map userQueries = new HashMap();

    private Map groupQueries = new HashMap();

    private Collection userQueue = Collections
            .synchronizedList(new ArrayList());

    /*
     * Find the queries that authenticatedUser has access to by virtue of group
     * affiliation.
     */
    public Collection getGroupQueries(AuthenticatedUser authenticatedUser) {
        log.debug("getting group queries.");

        if (!groupQueries.containsKey(authenticatedUser.getUsername())) {

            this.addUserToQueue(authenticatedUser.getUser());

        }

        /*
         * User names are guaranteed unique
         */
        if (groupQueries.get(authenticatedUser.getUsername()) != null) {
            return (Collection) groupQueries.get(authenticatedUser
                    .getUsername());
        }

        return null;
    }

    /*
     * Finds the queries this user has created.
     */
    public Collection getUserQueries(AuthenticatedUser authenticatedUser) {

        log.debug("getting user queries.");

        if (!userQueries.containsKey(authenticatedUser.getUsername())) {
            /*
             * 2006-02-06 RSC This is the general old way.
             */
            // this.addUserToQueue(authenticatedUser.getUser());
            try {
                userQueries.put(authenticatedUser.getUsername(), this
                        .getSavedQueryServiceDelegate().getSimpleByUser(
                                authenticatedUser.getUsername()));
            } catch (SavedQueryServiceDelegateException e) {
                e.printStackTrace();
            }

        }

        /*
         * User names are guaranteed unique
         */
        if (userQueries.get(authenticatedUser.getUsername()) != null) {

            return (Collection) userQueries
                    .get(authenticatedUser.getUsername());
        }
        return null;
    }

    private void addUserToQueue(User user) {
        if (!userQueue.contains(user)) {
            userQueue.add(user);
        }
    }

    public synchronized void process() {
        // for (Iterator iter = userQueue.iterator(); iter.hasNext();) {
        // Object o = iter.next();
        // if (!(o instanceof User)) {
        // continue;
        // }
        // User user = (User) o;
        //
        // Collection queries = null;
        // try {
        // queries = this.getSavedQueryServiceDelegate().getByUser(user);
        // } catch (SavedQueryServiceDelegateException e) {
        // e.printStackTrace();
        // } catch (RuntimeException e) {
        // e.printStackTrace();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // userQueries.put(user.getUsername(), queries);
        //
        // try {
        // queries = this.getSavedQueryServiceDelegate().getByGroup(user);
        // } catch (SavedQueryServiceDelegateException e) {
        // e.printStackTrace();
        // }
        // groupQueries.put(user.getUsername(), queries);
        // /*
        // * Once we are done with it we can remove it from the queue.
        // */
        // iter.remove();
        // }

    }

    public SavedQueryServiceDelegate getSavedQueryServiceDelegate() {
        return savedQueryServiceDelegate;
    }

    public void setSavedQueryServiceDelegate(
            SavedQueryServiceDelegate savedQueryServiceDelegate) {
        this.savedQueryServiceDelegate = savedQueryServiceDelegate;
    }

    /*
     * 5-31-2005 Nick This method responds to Events from the Spring Application
     * Context. It would be moved to an event handler that can interact with
     * this.
     * 
     * (non-Javadoc)
     * 
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        log.debug("handling application event " + applicationEvent.toString());

        if (applicationEvent instanceof UserLoginEvent) {

            AuthenticatedUser authenticatedUser = ((UserLoginEvent) applicationEvent)
                    .getAuthenticatedUser();
            userQueue.add(authenticatedUser.getUser());

        }
        if (applicationEvent instanceof UserLogoutEvent) {

            AuthenticatedUser authenticatedUser = ((UserLogoutEvent) applicationEvent)
                    .getAuthenticatedUser();
            if (authenticatedUser != null) {
                removeFromCache(authenticatedUser.getUser());
            }

        }

        if (applicationEvent instanceof SavedQueryModificationEvent) {
            SavedQuery savedQuery = ((SavedQueryModificationEvent) applicationEvent)
                    .getSavedQuery();
            removeFromCache(savedQuery.getUserName());
            User u = null;
            try {
                u = UserServiceDelegate.factory.build().getByUsername(
                        savedQuery.getUserName());
            } catch (UserServiceDelegateException e) {
                LogFactory.getLog(this.getClass()).error(
                        "Error finding Saved Querys for "
                                + savedQuery.getUserName()
                                + ", No User Object Found!");
                e.printStackTrace();
            }

            /*
             * 2006-02-06 RSC Removed since we're just going to process them as
             * needed.
             */
            // this.addUserToQueue(u);
        }

    }

    /*
     * We may need to remove the querys from our list. We probably don't need to
     * hang on to every thing. If a user logs in once then never returns we
     * shouldn't keep the querys around.
     * 
     * 
     */
    private void removeFromCache(User user) {
        this.removeFromCache(user.getUsername());

    }

    private void removeFromCache(String username) {
        this.userQueries.remove(username);
        this.groupQueries.remove(username);
        this.userQueue.remove(username);

    }

}