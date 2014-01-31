/*
 * Created on Jun 21, 2005
 *
 * 
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.common.ServiceDelegateException;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupDao;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegateException;

/**
 * @author Nick
 * 
 *  
 */
public class UserGroupServiceDelegateMockImpl implements
        UserGroupServiceDelegate {

    private Collection all;

    public UserGroupServiceDelegateMockImpl() {
        super();
        this.all = new ArrayList();
        UserGroup group1 = new UserGroup();
        group1.setName("gggggg");
        all.add(group1);

        UserGroup group2 = new UserGroup();
        group2.setName("aaaa");
        all.add(group2);

        UserGroup group3 = new UserGroup();
        group3.setName("pppp");
        all.add(group3);

        UserGroup group4 = new UserGroup();
        group4.setName("jjjjj");
        all.add(group4);

        UserGroup group5 = new UserGroup();
        group5.setName("zzzzz");
        all.add(group5);

    }

    public Collection getAll() {

        return all;
    }

    public UserGroup find(Long target) {

        return null;
    }

    public void save(UserGroup user) {
    }

    public void join(User user, UserGroup group)
            throws UserGroupServiceDelegateException {
    }

    public void leave(User user, UserGroup group)
            throws UserGroupServiceDelegateException {
    }

    public void delete(UserGroup targetUserGroup)
            throws ServiceDelegateException {
    }

    public void leaveAll(User targetUser) throws ServiceDelegateException {
    }

    public Collection getGroupsByUser(User user)
            throws ServiceDelegateException {

        return new ArrayList();
    }

    public void setUserGroupDao(UserGroupDao userGroupDao) {
    }

}