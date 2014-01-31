/*
 * Created on Aug 13, 2004
 *
 * 
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;
import java.util.Iterator;

import com.fstx.stdlib2.author.SecuredAction;
import com.fstx.stdlib2.author.SecuredActionEnum;

/**
 * @author Nick
 * 
 *  
 */
public class GroupRightServiceDelegateImpl implements
        GroupRightServiceDelegate, GroupRightDaoAware {

    private GroupRightDao groupRightDao;

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.GroupRightServiceDelegate#getByGroup(com.fstx.stdlib2.authen.users.UserGroup)
     */
    public Collection getByGroup(UserGroup userGroup) {
        return this.getGroupRightDao().find(userGroup);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.GroupRightDaoAware#setGroupRightDao(com.fstx.stdlib2.authen.users.GroupRightDao)
     */
    public void setGroupRightDao(GroupRightDao groupRightDao) {
        this.groupRightDao = groupRightDao;
    }

    private GroupRightDao getGroupRightDao() {
        return groupRightDao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.GroupRightServiceDelegate#getAll()
     */
    public Collection getAll() {
        Collection all = SecuredActionEnum.getAll();

        return all;
    }

    public void add(SecuredAction right, UserGroup group)
            throws GroupRightServiceDelegateException {
        //be sure its not already a member
        Collection currentRights;

        currentRights = this.getGroupRightDao().find(group);

        Iterator i = currentRights.iterator();
        while (i.hasNext()) {
            GroupRight gr = (GroupRight) i.next();
            if (gr.getRightCode().equals(right.getActionName())) {
                throw new GroupRightServiceDelegateException("already exists");
            }
        }

        //add it to the group
        GroupRight gr = new GroupRight();
        gr.setGroupId(group.getId());
        gr.setRightCode(right.getActionName());

        try {
            this.getGroupRightDao().save(gr);
        } catch (DaoException e1) {
            throw new GroupRightServiceDelegateException(e1);
        }

    }

    public GroupRight find(Long target) {
        return this.getGroupRightDao().find(target);

    }

    public void delete(GroupRight groupRight) {
        this.getGroupRightDao().delete(groupRight);
    }

    public void deleteByUserGroup(UserGroup targetUserGroup) {

        Collection rights = this.getByGroup(targetUserGroup);

        for (Iterator iter = rights.iterator(); iter.hasNext();) {
            GroupRight element = (GroupRight) iter.next();
            this.delete(element);
        }

    }

    public GroupRight find(UserGroup userGroup, SecuredAction authorizationToken) {
        Collection col = this.getByGroup(userGroup);
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            GroupRight element = (GroupRight) iter.next();
            if (element.getRightCode().equals(
                    authorizationToken.getActionName())) {
                return element;
            }
        }
        return null;
    }

}