/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

/**
 * @author Nick
 * 
 *  
 */
public interface ForumServiceDelegateAware {

    public ForumServiceDelegate getForumServiceDelegate();

    public void setForumServiceDelegate(
            ForumServiceDelegate forumServiceDelegate);
}