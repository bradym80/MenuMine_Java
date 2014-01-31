/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */
public interface ForumServiceDelegate {

    public void save(ForumMessage forumMessage)
            throws ForumServiceDelegateException;

    public Collection search(ForumMessageSearchParameters parameters)
            throws ForumServiceDelegateException;

    public void delete(ForumMessage message)
            throws ForumServiceDelegateException;

    public ForumMessage getById(Long target);

}