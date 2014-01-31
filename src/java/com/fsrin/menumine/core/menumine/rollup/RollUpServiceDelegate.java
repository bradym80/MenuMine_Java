/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;

import com.fstx.stdlib2.authen.users.User;

/**
 * @author Nick
 * 
 *  
 */
public interface RollUpServiceDelegate {
    String SPRING_BEAN_NAME = "rollUpServiceDelegate";

    RollUpServiceDelegateFactory factory = new RollUpServiceDelegateFactory();

    public abstract Collection getByUser(User user)
            throws RollUpServiceDelegateException;

    public abstract Collection getSimpleByUser(String userName)
            throws RollUpServiceDelegateException;
    
    public abstract Collection getByUser(String userName)
    throws RollUpServiceDelegateException;

    public abstract Collection getByGroup(User user)
            throws RollUpServiceDelegateException;

    public abstract Collection getByUserAndGroup(User user)
            throws RollUpServiceDelegateException;

    public abstract void save(RollUpOptions rollUpOptions)
            throws RollUpServiceDelegateException;

    public abstract RollUpOptions getByName(String name, String userName)
            throws RollUpServiceDelegateException;

    public abstract void delete(RollUpOptions rollUp)
            throws RollUpServiceDelegateException;
}