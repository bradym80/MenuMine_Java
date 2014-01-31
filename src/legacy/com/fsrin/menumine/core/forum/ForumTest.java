/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.fsrin.menumine.testutil.JunitSettings;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserRole;

/**
 * @author Nick
 * 
 *  
 */
public class ForumTest extends TestCase {
    AuthenticatedUser user;

    UserGroup group;

    UserGroup chefgroup;

    protected void setUp() throws Exception {
        super.setUp();
        JunitSettings.initilizeTestSystem();
        user = new AuthenticatedUser() {
            public String getEmail() {

                return "test@test.com";
            }

            public Long getId() {

                return new Long(1);
            }

            public String getUsername() {

                return "testUser";
            }

            public User getUser() {
                return new User("testUser", "pass", "test@test.com",
                        UserRole.ADMIN, true);
            }
        };

        group = new UserGroup();
        group.setName("MyGroup");

        chefgroup = new UserGroup();
        chefgroup.setName("chef");

    }

    public void testAddMessagePublic() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateBasicMockImpl());

        ForumMessage messageData = new ForumMessage();
        messageData.setMessage("This is my message");
        messageData.setTopic("Topic");
        forumManager.addPublicMessage(user, group, messageData);

        Collection messages = forumManager.getPublicMessages();
        assertEquals(1, messages.size());

        ForumMessage messageReLoad = (ForumMessage) messages.toArray()[0];
        assertEquals(ForumMessage.PUBLIC, messageReLoad.getForumGroup());
    }

    public void testAddMessagePrivate() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateBasicMockImpl());

        ForumMessage messageData = new ForumMessage();
        messageData.setMessage("This is my message");
        messageData.setTopic("Topic");
        forumManager.addPrivateMessage(user, group, messageData);

        Collection messages = forumManager.getPrivateMessages(user, group);
        assertEquals(1, messages.size());

        ForumMessage messageReLoad = (ForumMessage) messages.toArray()[0];
        assertEquals(ForumMessage.PRIVATE, messageReLoad.getForumGroup());
    }

    public void testAddMessageChef() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateBasicMockImpl());

        ForumMessage messageData = new ForumMessage();
        messageData.setMessage("This is my message");
        messageData.setTopic("Topic");

        forumManager.addChefMessage(user, group, messageData, "contact");

        Collection messages = forumManager.getChefMessages(user, group);
        assertEquals(1, messages.size());

        ForumMessage messageReLoad = (ForumMessage) messages.toArray()[0];
        assertEquals(ForumMessage.CHEF, messageReLoad.getForumGroup());
    }

    public void testViewMessagesPublic() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateLoadedMockImpl());
        Collection col = forumManager.getPublicMessages();
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ForumMessage element = (ForumMessage) iter.next();
            assertEquals(ForumMessage.PUBLIC, element.getForumGroup());
        }
    }

    public void testViewMessagesPrivate() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateLoadedMockImpl());
        Collection col = forumManager.getPrivateMessages(user, group);

        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ForumMessage element = (ForumMessage) iter.next();
            assertEquals(ForumMessage.PRIVATE, element.getForumGroup());
            assertEquals(group.getName(), element.getGroup());

        }
    }

    public void testViewMessagesChefWithNormalUser() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateLoadedMockImpl());
        Collection col = forumManager.getChefMessages(user, group);

        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ForumMessage element = (ForumMessage) iter.next();
            assertEquals(ForumMessage.CHEF, element.getForumGroup());
            assertEquals(user.getUsername(), element.getUser());

        }

    }

    public void testViewMessagesChefWithChefUser() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateLoadedMockImpl());
        Collection col = forumManager.getChefMessages(user, chefgroup);

        boolean ableToSeeMessagesPostedByNormalUsers = false;

        for (Iterator iter = col.iterator(); iter.hasNext();) {
            ForumMessage element = (ForumMessage) iter.next();
            assertEquals(ForumMessage.CHEF, element.getForumGroup());
            if (!element.getUser().equals(user.getUsername())) {
                /*
                 * Found one.
                 */
                ableToSeeMessagesPostedByNormalUsers = true;
            }
        }
        assertTrue(ableToSeeMessagesPostedByNormalUsers);

    }

    public void testDeleteMessage() throws Exception {
        ForumManager forumManager = this
                .getForumManager(new ForumServiceDelegateBasicMockImpl());

        ForumMessage messageData = new ForumMessage();
        messageData.setMessage("This is my message");
        messageData.setTopic("Topic");

        forumManager.addPrivateMessage(user, group, messageData);

        Collection messages = forumManager.getPrivateMessages(user, group);
        assertEquals(1, messages.size());

        ForumMessage message = (ForumMessage) messages.toArray()[0];

        forumManager.deleteMessage(message, user, group);

        messages = forumManager.getPrivateMessages(user, group);
        assertEquals(0, messages.size());
    }

    private ForumManager getForumManager() {

        return new ForumManagerImpl();
    }

    private ForumManager getForumManager(ForumServiceDelegate sd) {
        ForumManager manager = this.getForumManager();
        manager.setForumServiceDelegate(sd);
        return manager;
    }

}