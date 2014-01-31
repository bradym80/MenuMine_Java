/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fstx.stdlib2.authen.users.GroupRight;
import com.fstx.stdlib2.authen.users.GroupRightServiceDelegate;
import com.fstx.stdlib2.authen.users.GroupRightServiceDelegateException;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.author.SecuredAction;

/**
 * @author Nick
 * 
 *  
 */
public class GroupRightServiceDelegateMockImpl implements
        GroupRightServiceDelegate {

    Collection<GroupRight> tokens = new ArrayList<GroupRight>();

    public GroupRightServiceDelegateMockImpl() {
        super();

    }

    public Collection getByGroup(UserGroup userGroup) {
        Collection<GroupRight> ret = new ArrayList<GroupRight>();

        for (Iterator iter = tokens.iterator(); iter.hasNext();) {
            GroupRight element = (GroupRight) iter.next();
            if (element.getGroupId().equals(userGroup.getId())) {
                ret.add(element);
            }
        }

        return ret;
    }

    public Collection getAll() {

        return tokens;
    }

    public GroupRight find(Long removeTarget) {

        return null;
    }

    public void delete(GroupRight gr) {
        tokens.remove(gr);
    }

    public void add(SecuredAction right, UserGroup group)
            throws GroupRightServiceDelegateException {
        GroupRight r = new GroupRight();
        r.setGroupId(group.getId());
        r.setRightCode(right.getActionName());

        tokens.add(r);
    }

    public void deleteByUserGroup(UserGroup targetUserGroup) {
    }

    public GroupRight find(UserGroup userGroup, SecuredAction authorizationToken) {
        for (Iterator iter = this.getAll().iterator(); iter.hasNext();) {
            GroupRight element = (GroupRight) iter.next();
            if (userGroup.getId().equals(element.getGroupId())
                    && element.getRightCode().equals(
                            authorizationToken.getActionName())) {
                return element;
            }
        }
        return null;
    }

}