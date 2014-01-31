/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserRole;

/**
 * @author Nick
 * 
 *  
 */
public class ForumManagerImpl implements ForumManager {

    private ForumServiceDelegate forumServiceDelegate = new ForumServiceDelegateBasicMockImpl();

    public ForumManagerImpl() {
        super();

    }

    private void createAndPersistMessage(AuthenticatedUser user,
            UserGroup group, ForumMessage messageData, Date date,
            String forumGroup) throws ForumManagerException {

        /*
         * Nick 2005.5.23 The messageData is used only as a data transport
         * object. Rather then pass the message and topic as two strings I just
         * stick them in a ForumMessage, this will make it easier to add fields
         * to the messge.
         *  
         */

        ForumMessage forumMessage = new ForumMessage();
        forumMessage.setDate(date);
        forumMessage.setForumGroup(forumGroup);
        forumMessage.setGroup(group.getName());
        forumMessage.setMessage(messageData.getMessage());
        forumMessage.setTopic(messageData.getTopic());
        forumMessage.setUser(user.getUsername());

        try {
            this.getForumServiceDelegate().save(forumMessage);
        } catch (ForumServiceDelegateException e) {

            e.printStackTrace();
            throw new ForumManagerException(e);
        }

    }

    public void addPublicMessage(AuthenticatedUser user, UserGroup group,
            ForumMessage messageData) throws ForumManagerException {

        this.createAndPersistMessage(user, group, messageData, new Date(),
                ForumMessage.PUBLIC);

    }

    public void addPrivateMessage(AuthenticatedUser user, UserGroup group,
            ForumMessage messageData) throws ForumManagerException {
        this.createAndPersistMessage(user, group, messageData, new Date(),
                ForumMessage.PRIVATE);

    }

    public void addChefMessage(AuthenticatedUser user, UserGroup group,
            ForumMessage messageData, String contactInfo)
            throws ForumManagerException {
        this.createAndPersistMessage(user, group, messageData, new Date(),
                ForumMessage.CHEF);

    }

    public Collection getPublicMessages() throws ForumManagerException {
        ForumMessageSearchParameters parameters = new ForumMessageSearchParameters();
        parameters.setForumGroup(ForumMessage.PUBLIC);

        try {
            return this.getForumServiceDelegate().search(parameters);
        } catch (ForumServiceDelegateException e) {
            e.printStackTrace();
            throw new ForumManagerException(e);
        }
    }

    public Collection getPrivateMessages(AuthenticatedUser user, UserGroup group)
            throws ForumManagerException {

        if (group == null) {
            /*
             * If they are not in a group, there should be no messages.
             */
            return new ArrayList();
        }

        ForumMessageSearchParameters parameters = new ForumMessageSearchParameters();
        parameters.setForumGroup(ForumMessage.PRIVATE);

        parameters.setGroup(group.getName());

        try {
            return this.getForumServiceDelegate().search(parameters);
        } catch (ForumServiceDelegateException e) {
            e.printStackTrace();
            throw new ForumManagerException(e);
        }
    }

    public Collection getChefMessages(AuthenticatedUser user, UserGroup group)
            throws ForumManagerException {
        if (group.getName().equals("chef")) {
            return this.getChefMessagesForChefs(user, group);
        } else {
            return this.getChefMessagesForUser(user, group);
        }
    }

    private Collection getChefMessagesForUser(AuthenticatedUser user,
            UserGroup group) throws ForumManagerException {
        ForumMessageSearchParameters parameters = new ForumMessageSearchParameters();
        parameters.setForumGroup(ForumMessage.CHEF);

        parameters.setUser(user.getUsername());

        try {
            return this.getForumServiceDelegate().search(parameters);
        } catch (ForumServiceDelegateException e) {
            e.printStackTrace();
            throw new ForumManagerException(e);
        }
    }

    private Collection getChefMessagesForChefs(AuthenticatedUser user,
            UserGroup group) throws ForumManagerException {
        ForumMessageSearchParameters parameters = new ForumMessageSearchParameters();
        parameters.setForumGroup(ForumMessage.CHEF);
        try {
            return this.getForumServiceDelegate().search(parameters);
        } catch (ForumServiceDelegateException e) {
            e.printStackTrace();
            throw new ForumManagerException(e);
        }
    }

    public void deleteMessage(ForumMessage message, AuthenticatedUser user,
            UserGroup group) throws ForumManagerException {
        if (user.getUser().getRole() != UserRole.ADMIN) {
            throw new ForumManagerException("Only Admins can delete messages!");
        }

        try {
            this.getForumServiceDelegate().delete(message);
        } catch (ForumServiceDelegateException e) {
            e.printStackTrace();
            throw new ForumManagerException(e);
        }

    }

    public ForumServiceDelegate getForumServiceDelegate() {
        return forumServiceDelegate;
    }

    public void setForumServiceDelegate(
            ForumServiceDelegate forumServiceDelegate) {
        this.forumServiceDelegate = forumServiceDelegate;
    }

    public void deleteMessage(Long target, AuthenticatedUser user,
            UserGroup userGroup) throws ForumManagerException {
        ForumMessage message = this.getForumServiceDelegate().getById(target);

        this.deleteMessage(message, user, userGroup);

    }

}