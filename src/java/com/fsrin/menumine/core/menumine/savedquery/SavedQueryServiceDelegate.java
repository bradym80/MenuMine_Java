/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.Collection;

import com.fstx.stdlib2.authen.users.User;

/**
 * @author Nick
 * 
 * 
 */
public interface SavedQueryServiceDelegate {
    String SPRING_BEAN_NAME = "savedQueryServiceDelegate";

    SavedQueryServiceDelegateFactory factory = new SavedQueryServiceDelegateFactory();

    public abstract Collection getByUser(User user)
            throws SavedQueryServiceDelegateException;

    public abstract Collection getByUser(String userName)
            throws SavedQueryServiceDelegateException;

    /*
     * 2006-02-07 RSC Get By Id.
     */
    public abstract SavedQuery getById(Long id)
            throws SavedQueryServiceDelegateException;

    public abstract SavedQuery getSimpleById(Long id)
            throws SavedQueryServiceDelegateException;

    public abstract SavedQuery getTemplateById(Long id)
            throws SavedQueryServiceDelegateException;

    /*
     * 2006-02-06 RSC We also need a way to get queries out by name.,
     */
    public abstract SavedQuery getByUser(String userName, String queryName)
            throws SavedQueryServiceDelegateException;

    public abstract Collection getByUserAndName(String userName,
            String queryName) throws SavedQueryServiceDelegateException;

    /*
     * 2006-02-06 RSC just the barebones, no fields.
     */
    public abstract Collection getSimpleByUser(String userName)
            throws SavedQueryServiceDelegateException;

    public abstract Collection getByGroup(User user)
            throws SavedQueryServiceDelegateException;

    public abstract Collection getByUserAndGroup(User user)
            throws SavedQueryServiceDelegateException;

    public abstract void update(SavedQuery savedQuery)
            throws SavedQueryServiceDelegateException;

    public abstract void saveNew(SavedQuery savedQuery)
            throws SavedQueryServiceDelegateException;

    public abstract void delete(SavedQuery savedQuery)
            throws SavedQueryServiceDelegateException;

    /*
     * 2006-09-05 RSC get the templates
     */
    public abstract Collection getSimpleTemplates()
            throws SavedQueryServiceDelegateException;
}