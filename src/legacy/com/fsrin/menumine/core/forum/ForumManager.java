/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.Collection;

import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.UserGroup;

/**
 * @author Nick
 * 
 *  
 */
public interface ForumManager extends ForumServiceDelegateAware {

    public void addPublicMessage(AuthenticatedUser user, UserGroup group,
            ForumMessage messageData) throws ForumManagerException;

    public void addPrivateMessage(AuthenticatedUser user, UserGroup group,
            ForumMessage messageData) throws ForumManagerException;

    public void addChefMessage(AuthenticatedUser user, UserGroup group,
            ForumMessage messageData, String contactInfo)
            throws ForumManagerException;

    public Collection getPublicMessages() throws ForumManagerException;

    public Collection getPrivateMessages(AuthenticatedUser user, UserGroup group)
            throws ForumManagerException;

    public Collection getChefMessages(AuthenticatedUser user, UserGroup group)
            throws ForumManagerException;

    public void deleteMessage(ForumMessage message, AuthenticatedUser user,
            UserGroup group) throws ForumManagerException;

    public void deleteMessage(Long target, AuthenticatedUser user,
            UserGroup userGroup) throws ForumManagerException;
}