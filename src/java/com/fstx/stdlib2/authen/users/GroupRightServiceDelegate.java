/*
 * Created on Aug 13, 2004
 *
 * 
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;

import com.fstx.stdlib2.author.SecuredAction;

/**
 * @author Nick
 * 
 *  
 */
public interface GroupRightServiceDelegate {

    public static final GroupRightServiceDelegateFactory factory = new GroupRightServiceDelegateFactory();

    public static final String SPRING_BEAN_NAME = "groupRightServiceDelegate";

    public Collection getByGroup(UserGroup userGroup);

    public Collection getAll();

    public GroupRight find(Long removeTarget);

    public void delete(GroupRight gr);

    public void add(SecuredAction right, UserGroup group)
            throws GroupRightServiceDelegateException;

    public void deleteByUserGroup(UserGroup targetUserGroup);

    public GroupRight find(UserGroup userGroup, SecuredAction authorizationToken);

}