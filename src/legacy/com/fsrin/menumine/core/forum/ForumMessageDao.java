/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.forum;

import java.util.Collection;

/**
 * @author Reid
 *  
 */
public interface ForumMessageDao {

    public static final String SPRING_BEAN_NAME = "forumMessageDao";

    public static final ForumMessageDaoFactory factory = new ForumMessageDaoFactory();

    public abstract ForumMessage save(ForumMessage forumMessage);

    public abstract ForumMessage get(Long id);

    public abstract Collection search(
            final ForumMessageSearchParameters forumMessageSearchParameters);

    public abstract void delete(ForumMessage forumMessage);

    public abstract void delete(Long id);

    //    public abstract Collection find(MasterFoodFilterParameters params)
    //            throws DAOException;

}