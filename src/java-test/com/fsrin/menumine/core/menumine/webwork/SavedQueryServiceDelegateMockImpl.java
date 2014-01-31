/*
 * Created on Aug 2, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fsrin.menumine.core.menumine.SavedQuery;
import com.fsrin.menumine.core.menumine.SavedQueryServiceDelegate;
import com.fsrin.menumine.core.menumine.SavedQueryServiceDelegateException;
import com.fstx.stdlib2.authen.users.User;

/**
 * @author Nick
 * 
 *  
 */
public class SavedQueryServiceDelegateMockImpl implements
        SavedQueryServiceDelegate, ApplicationContextAware {

    public SavedQueryServiceDelegateMockImpl() {
        super();

    }

    public Collection getByUser(User user)
            throws SavedQueryServiceDelegateException {

        return null;
    }

    public Collection getByUser(String userName)
            throws SavedQueryServiceDelegateException {

        return null;
    }

    public Collection getByGroup(User user)
            throws SavedQueryServiceDelegateException {

        return null;
    }

    public Collection getByUserAndGroup(User user)
            throws SavedQueryServiceDelegateException {

        return null;
    }

    Collection saved = new ArrayList();

    public void save(SavedQuery savedQuery)
            throws SavedQueryServiceDelegateException {
        saved.add(savedQuery);
    }

    public void delete(SavedQuery savedQuery)
            throws SavedQueryServiceDelegateException {
    }

    ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        applicationContext = arg0;

    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}