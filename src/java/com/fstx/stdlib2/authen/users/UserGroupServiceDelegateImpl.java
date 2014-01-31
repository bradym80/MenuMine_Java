/*
 * Created on Oct 29, 2003
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.common.ServiceDelegateException;
import com.fsrin.menumine.common.dao.GenericDAOFactory;

/**
 * @author Nick
 * 
 */
public class UserGroupServiceDelegateImpl implements UserGroupServiceDelegate {

    private UserGroupDao userGroupDao;

    private GroupMembershipDao groupMembershipDao;

    public Collection getAll() {
        UserGroupFilterParameters params = new UserGroupFilterParameters();
        return this.getUserGroupDao().find(params);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserDaoAware#getUserDAP()
     */
    public void setUserGroupDao(UserGroupDao userGroupDao) {
        this.userGroupDao = userGroupDao;
    }

    /**
     * @return
     */
    public UserGroupDao getUserGroupDao() {
        return userGroupDao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserServiceDelegate#find(java.lang.Long)
     */
    public UserGroup find(Long target) {

        return this.getUserGroupDao().find(target);

    }

    public UserGroup find(String target) {

        UserGroupFilterParameters p = new UserGroupFilterParameters();
        p.setName(target);

        Collection t = this.getUserGroupDao().find(p);

        UserGroup ret = null;

        if (t.size() == 1)
            ret = (UserGroup) t.toArray()[0];

        return ret;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserServiceDelegate#save(com.fstx.stdlib2.authen.users.User)
     */
    public void save(UserGroup userGroup) {
        this.getUserGroupDao().save(userGroup);
    }

    public GroupMembershipDao getGroupMembershipDao() {
        return groupMembershipDao;
    }

    public void setGroupMembershipDao(GroupMembershipDao groupMembershipDao) {
        this.groupMembershipDao = groupMembershipDao;
    }

    public void join(User user, UserGroup group)
            throws UserGroupServiceDelegateException {
        // be sure its not already a member
        String[] data = { group.getId().toString(), user.getId().toString() };
        Collection test = null;
        // try {
        // test = this.getGroupMembershipDao().find(
        // GroupMembershipDao.SELECT_BY_GROUP_AND_USER, data);

        GroupMembership m = new GroupMembership();
        m.setGroupId(group.getId());
        m.setUserId(user.getId());

        test = GenericDAOFactory.factory.buildAdmin().find(
                GroupMembershipDao.SELECT_BY_GROUP_AND_USER, m);

        // } catch (DaoException e1) {
        // throw new UserGroupServiceDelegateException("already a member", e1);
        // }

        if (test != null && test.size() > 0) {

        } else {
            // add it to the group
            GroupMembership gm = new GroupMembership(group.getId(), user
                    .getId());

            try {
                this.getGroupMembershipDao().save(gm);
            } catch (DaoException e2) {
                throw new UserGroupServiceDelegateException(e2);
            }
        }

    }

    public void leave(User user, UserGroup group)
            throws UserGroupServiceDelegateException {
        // be sure its not already a member
        // String[] data = { group.getId().toString(), user.getId().toString()
        // };
        GroupMembership data = new GroupMembership();
        data.setUserId(user.getId());
        data.setGroupId(group.getId());

        Collection test = GenericDAOFactory.factory.buildAdmin().find(
                GroupMembershipDao.SELECT_BY_GROUP_AND_USER, data);

        if (test == null || test.size() == 0) {

        } else {
            // add it to the group
            GroupMembership gm = (GroupMembership) test.toArray()[0];

            try {
                this.getGroupMembershipDao().delete(gm);
            } catch (DaoException e2) {
                throw new UserGroupServiceDelegateException(e2);
            }
        }

    }

    public void delete(UserGroup targetUserGroup)
            throws ServiceDelegateException {

        GroupRightServiceDelegate.factory.build().deleteByUserGroup(
                targetUserGroup);

        try {
            this.leaveAll(targetUserGroup);
        } catch (UserGroupServiceDelegateException e) {
            throw new ServiceDelegateException(e);
        }

        try {
            this.getUserGroupDao().delete(targetUserGroup);
        } catch (DaoException e1) {
            throw new ServiceDelegateException(e1);
        }

    }

    /*
     * Remove all users from this group. Used for deleting a group.
     */
    public void leaveAll(UserGroup targetUserGroup)
            throws UserGroupServiceDelegateException {
        UserGroupBusinessObject userGroup = UserGroupBusinessObject.factory
                .build(targetUserGroup);

        for (Iterator iter = userGroup.getMembers().iterator(); iter.hasNext();) {
            User element = (User) iter.next();
            this.leave(element, targetUserGroup);

        }

    }

    public void leaveAll(User targetUser) throws ServiceDelegateException {

        Collection groupMemberships;
        try {
            groupMemberships = this.getGroupMembershipDao().find(targetUser);
        } catch (DaoException e) {
            throw new ServiceDelegateException(e);
        }
        try {
            for (Iterator iter = groupMemberships.iterator(); iter.hasNext();) {
                GroupMembership element = (GroupMembership) iter.next();
                this.getGroupMembershipDao().delete(element.getId());
            }
        } catch (DaoException e1) {
            throw new ServiceDelegateException(e1);

        }
    }

    public Collection getGroupsByUser(User user)
            throws ServiceDelegateException {

        Collection groupMemberships;
        try {
            groupMemberships = this.getGroupMembershipDao().find(user);
        } catch (DaoException e) {
            throw new ServiceDelegateException(e);
        }

        Collection groups = new ArrayList();

        for (Iterator iter = groupMemberships.iterator(); iter.hasNext();) {
            GroupMembership element = (GroupMembership) iter.next();
            UserGroup group = this.getUserGroupDao().find(element.getGroupId());
            groups.add(group);
        }

        return groups;
    }

}