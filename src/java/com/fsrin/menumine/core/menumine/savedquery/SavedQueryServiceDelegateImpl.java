/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fsrin.menumine.common.ServiceDelegateException;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.common.util.MiscellaneousNotificationAlert;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.webwork.util.Sorter;

/**
 * @author Nick
 * 
 * 
 */
public class SavedQueryServiceDelegateImpl implements
        SavedQueryServiceDelegate, ApplicationContextAware {

    
    private Log log = LogFactory.getLog(SavedQueryServiceDelegateImpl.class);

    /*
     * 2006-02-06 RSC Saved queries -- simple loading.
     */

    private static String SIMPLE_LOAD_BY_USER = " select new "
            + SavedQuery.class.getName()
            + " (s.id, s.name, s.mineType, s.userName, s.groupName, s.timestamp) from "
            + SavedQuery.class.getName()
            + " as s where s.userName = :userName and "
            + "s.permission in (1,2)";

    private static String SIMPLE_LOAD_TEMPLATE = " select new "
            + SavedQuery.class.getName()
            + " (s.id, s.name, s.mineType, s.userName, s.groupName, s.timestamp, s.templateGroup) from "
            + SavedQuery.class.getName() + " as s where " + "s.permission = 3 order by s.templateGroup, s.name";

    private static String SIMPLE_LOAD_BY_ID = " select new "
            + SavedQuery.class.getName()
            + " (s.id, s.name, s.mineType, s.userName, s.groupName, s.timestamp) from "
            + SavedQuery.class.getName() + " as s where s.id = :id";

    private SavedQueryDao savedQueryDao;

    public SavedQueryServiceDelegateImpl() {
        super();

    }

    public Collection getByUser(User user)
            throws SavedQueryServiceDelegateException {
        return this.getByUser(user.getUsername());
    }

    public Collection getByUser(String userName)
            throws SavedQueryServiceDelegateException {

        SavedQueryFilterParameters params = new SavedQueryFilterParameters();
        params.setUserName(userName);

        return savedQueryDao.search(params);

    }

    public Collection getByUserAndName(String userName, String queryName)
            throws SavedQueryServiceDelegateException {

        SavedQueryFilterParameters params = new SavedQueryFilterParameters();
        params.setUserName(userName);
        params.setName(queryName);

        Collection c = savedQueryDao.search(params);

        return c;
    }

    public SavedQuery getByUser(String userName, String queryName)
            throws SavedQueryServiceDelegateException {

        Collection c = this.getByUserAndName(userName, queryName);

        SavedQuery ret = null;

        if (c.size() != 1) {
            return null;
        } else {
            ret = (SavedQuery) c.toArray()[0];
        }

        ret.synchSelectedFields();

        return ret;

    }

    /*
     * 2006-02-06 RSC
     */
    public Collection getSimpleByUser(String userName)
            throws SavedQueryServiceDelegateException {

        SavedQuery options = new SavedQuery();
        options.setUserName(userName);

        Collection ret = GenericDAOFactory.factory.buildAdmin().find(
                SIMPLE_LOAD_BY_USER, options);

        return ret;

    }

    /**
     * We will get all of the groups this user belongs to, then look up all of
     * the querys for each group. Most likly each user will have only one group,
     * but here we should be able to handle that case.
     */
    public Collection getByGroup(User user)
            throws SavedQueryServiceDelegateException {

        Collection groups = null;
        try {
            groups = UserGroupServiceDelegate.factory.build().getGroupsByUser(
                    user);
        } catch (ServiceDelegateException e1) {
            throw new SavedQueryServiceDelegateException(e1);
        }

        Collection querys = new TreeSet(new Sorter().getAscending("name"));
        for (Iterator iter = groups.iterator(); iter.hasNext();) {
            UserGroup element = (UserGroup) iter.next();
            Collection tempQuerys = this.getByGroup(element);
            querys.addAll(tempQuerys);
        }

        return querys;

    }

    private Collection getByGroup(UserGroup element)
            throws SavedQueryServiceDelegateException {
        SavedQueryFilterParameters params = new SavedQueryFilterParameters();
        params.setGroupName(element.getName());
        params.setPermissionObject(SavedQuery.GROUP_QUERY_PERMISSION);

        return savedQueryDao.search(params);

    }

    public void saveNew(SavedQuery savedQuery)
            throws SavedQueryServiceDelegateException {

        savedQuery.setTimestamp(new Date());

        this.getSavedQueryDao().saveNew(savedQuery);

        /*
         * Throw this when a savedQuery is changed, so the manager can handle
         * it.
         */
        this.getApplicationContext().publishEvent(
                new SavedQueryModificationEvent(this, savedQuery));

    }

    public void update(SavedQuery savedQuery)
            throws SavedQueryServiceDelegateException {

        this.getSavedQueryDao().update(savedQuery);

        /*
         * Throw this when a savedQuery is changed, so the manager can handle
         * it.
         */
        this.getApplicationContext().publishEvent(
                new SavedQueryModificationEvent(this, savedQuery));

    }

    public SavedQueryDao getSavedQueryDao() {
        return savedQueryDao;
    }

    public void setSavedQueryDao(SavedQueryDao savedQueryDao) {
        this.savedQueryDao = savedQueryDao;
    }

    public Collection getByUserAndGroup(User user)
            throws SavedQueryServiceDelegateException {

        Collection userQuerys = this.getByUser(user);
        Collection groupQuerys = this.getByGroup(user);

        TreeSet sorted = new TreeSet(new Sorter().getAscending("id"));
        sorted.addAll(userQuerys);
        sorted.addAll(groupQuerys);

        return sorted;
    }

    /**
     * has some case specific modes.
     */
    public void delete(SavedQuery savedQuery) {

        try {
            /*
             * 2006-03-21 RSC ideal situation this works.
             */
            this.getSavedQueryDao().delete(savedQuery.getId());
        } catch (Exception e) {
            /*
             * 2006-03-21 RSC if it fails, it probably fails because we've got
             * something goofy with MFFP.
             */
            if (savedQuery.getId() != null) {
                long sqId = savedQuery.getId().longValue();

                savedQuery.setMasterFoodFilterParameters(null);
                savedQuery.setFieldsToDisplayBean(null);
                this.getSavedQueryDao().delete(savedQuery);

                new MiscellaneousNotificationAlert()
                        .sendAlert("Used alerternate saved query delete method.");
            } else {
                new MiscellaneousNotificationAlert()
                        .sendAlert("attempted to Use alerternate saved query delete method by savedQueryID was null.");

            }
        }

        /*
         * Throw this when a savedQuery is changed, so the manager can handle
         * it.
         */
        this.getApplicationContext().publishEvent(
                new SavedQueryModificationEvent(this, savedQuery));
    }

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        applicationContext = arg0;
    }

    protected ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public SavedQuery getById(Long id)
            throws SavedQueryServiceDelegateException {

        SavedQuery ret = this.getSavedQueryDao().get(id);

        if (ret != null)
            ret.synchSelectedFields();

        return ret;
    }

    /*
     * 2006-09-06 rsc
     * just does a double check that permissions are set to custom template
     * permissions.
     * 
     * (non-Javadoc)
     * @see com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate#getTemplateById(java.lang.Long)
     */
    public SavedQuery getTemplateById(Long id)
            throws SavedQueryServiceDelegateException {

        SavedQuery ret = this.getSavedQueryDao().get(id);

        if (ret != null)
            ret.synchSelectedFields();

        if (ret.getPermission() != SavedQuery.CUSTOM_TEMPLATE_PERMISSION.intValue() ) {
            throw new SavedQueryServiceDelegateException("not a template");
        }
        
        return ret;
    }

    /*
     * 2006-02-06 RSC
     */
    public SavedQuery getSimpleById(Long id)
            throws SavedQueryServiceDelegateException {

        SavedQuery options = new SavedQuery();
        options.setId(id);

        Collection temp = GenericDAOFactory.factory.buildAdmin().find(
                SIMPLE_LOAD_BY_ID, options);

        SavedQuery ret = null;

        if (temp.size() == 1) {
            ret = (SavedQuery) temp.toArray()[0];
        }

        return ret;

    }

    public Collection getSimpleTemplates()
            throws SavedQueryServiceDelegateException {

        Collection ret = GenericDAOFactory.factory.buildAdmin().find(
                SIMPLE_LOAD_TEMPLATE);

        return ret;
    }

}