/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;

import com.fsrin.menumine.common.ServiceDelegateException;

/**
 * @author Reid
 *  
 */
public interface UserGroupServiceDelegate extends UserGroupDaoAware {

    public static final String SPRING_BEAN_NAME = "userGroupServiceDelegate";

    public static final UserGroupServiceDelegateFactory factory = new UserGroupServiceDelegateFactory();

    public abstract Collection getAll();

    public abstract UserGroup find(Long target);
    
    public abstract UserGroup find(String name);

    public abstract void save(UserGroup user);

    public abstract void join(User user, UserGroup group)
            throws UserGroupServiceDelegateException;

    public abstract void leave(User user, UserGroup group)
            throws UserGroupServiceDelegateException;

    public abstract void delete(UserGroup targetUserGroup)
            throws ServiceDelegateException;

    public abstract void leaveAll(User targetUser)
            throws ServiceDelegateException;

    public abstract Collection getGroupsByUser(User user)
            throws ServiceDelegateException;
}