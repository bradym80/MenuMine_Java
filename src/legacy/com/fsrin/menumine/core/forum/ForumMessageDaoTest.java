/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.Date;

import junit.framework.TestCase;

import com.fsrin.menumine.testutil.JunitSettings;

/**
 * @author Nick
 * 
 *  
 */
public class ForumMessageDaoTest extends TestCase {

    public void testFilterDAO() throws Exception {

        ForumMessage forumMessage = new ForumMessage();
        forumMessage.setDate(new Date());

        forumMessage.setForumGroup(ForumMessage.PRIVATE);
        forumMessage.setGroup("group");
        forumMessage.setMessage("My Message");
        forumMessage.setTopic("Topic");
        forumMessage.setUser("user");

        forumMessage = ForumMessageDao.factory.build().save(forumMessage);

        Long id = forumMessage.getId();
        assertNotNull(id);

        ForumMessage forumMessageReload = ForumMessageDao.factory.build().get(
                id);

        assertNotNull(forumMessageReload);

    }

    protected void setUp() throws Exception {
        super.setUp();
        JunitSettings.initilizeTestSystem();

    }
}