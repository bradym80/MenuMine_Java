/*
 * Created on Aug 12, 2004
 *
 * 
 */
package com.fstx.stdlib2.authen.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fstx.stdlib2.author.SecuredAction;

/**
 * @author Nick
 * 
 *  
 */
public class UserGroupBusinessObject {

    public static UserGroupBusinessObjectFactory factory = new UserGroupBusinessObjectFactory();

    private UserGroup userGroup;

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    /*
     * This return raw objects not Business Objects
     */
    public Collection getMembers() {

        return UserServiceDelegate.factory.build().getByGroup(
                this.getUserGroup());
    }

    public Collection getNonMembers() {
        Collection all = null;
        try {
            all = UserServiceDelegate.factory.build().getAll();
        } catch (UserServiceDelegateException e) {

            e.printStackTrace();
        }

        Collection members = this.getMembers();

        all.removeAll(members);
        return all;
    }

    public Collection getRights() {

        return GroupRightServiceDelegate.factory.build().getByGroup(
                this.getUserGroup());
    }

    public Collection getNonRights() {

        Collection notRights = new ArrayList();
        Collection all = null;

        all = GroupRightServiceDelegate.factory.build().getAll();
        Collection rights = this.getRights();
        /*
         * Find out with rights exist in both collections.
         */
        for (Iterator iA = all.iterator(); iA.hasNext();) {
            SecuredAction sa = (SecuredAction) iA.next();
            for (Iterator iR = rights.iterator(); iR.hasNext();) {
                GroupRight gr = (GroupRight) iR.next();
                if ((sa.getActionName().equals(gr.getRightCode()))) {
                    notRights.add(sa);
                }

            }
        }

        all.removeAll(notRights);
        return all;
    }

}