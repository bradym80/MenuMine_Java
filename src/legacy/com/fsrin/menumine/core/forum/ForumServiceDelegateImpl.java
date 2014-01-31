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
public class ForumServiceDelegateImpl implements ForumServiceDelegate {

    private ForumMessageDao forumMessageDao;

    public ForumServiceDelegateImpl() {
        super();

    }

    public void save(ForumMessage forumMessage)
            throws ForumServiceDelegateException {

        forumMessageDao.save(forumMessage);

    }

    public Collection search(ForumMessageSearchParameters parameters)
            throws ForumServiceDelegateException {

        return forumMessageDao.search(parameters);

    }

    public void delete(ForumMessage message)
            throws ForumServiceDelegateException {

        this.forumMessageDao.delete(message);

    }

    public ForumMessageDao getForumMessageDao() {
        return forumMessageDao;
    }

    public void setForumMessageDao(ForumMessageDao forumMessageDao) {
        this.forumMessageDao = forumMessageDao;
    }

    public ForumMessage getById(Long target) {

        return this.getForumMessageDao().get(target);

    }
}