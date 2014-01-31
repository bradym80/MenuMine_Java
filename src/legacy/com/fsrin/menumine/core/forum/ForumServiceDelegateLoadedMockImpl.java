/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Nick We want this to look at the parameters are return a collection
 *         of data.
 *  
 */
public class ForumServiceDelegateLoadedMockImpl implements ForumServiceDelegate {

    private Collection publicMessages;

    private Collection privateMessages;

    private Collection chefForChefMessages;

    private Collection chefForNormalUserMessages;

    public ForumServiceDelegateLoadedMockImpl() {
        super();

        this.initPublic();
        this.initPrivate();
        this.initChefForChef();
        this.initChefForNormalUser();

    }

    private void initChefForNormalUser() {
        this.chefForNormalUserMessages = new ArrayList();

        ForumMessage message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        chefForNormalUserMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        chefForNormalUserMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        chefForNormalUserMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        chefForNormalUserMessages.add(message);
    }

    private void initChefForChef() {
        this.chefForChefMessages = new ArrayList();

        ForumMessage message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("a");
        message.setMessage("test1");
        chefForChefMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("b");
        message.setMessage("test1");
        chefForChefMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("c");
        message.setMessage("test1");
        chefForChefMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.CHEF);
        message.setGroup("MyGroup");
        message.setUser("d");
        message.setMessage("test1");
        chefForChefMessages.add(message);
    }

    private void initPrivate() {
        this.privateMessages = new ArrayList();

        ForumMessage message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PRIVATE);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        privateMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PRIVATE);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        privateMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PRIVATE);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        privateMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PRIVATE);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        privateMessages.add(message);
    }

    private void initPublic() {
        this.publicMessages = new ArrayList();

        ForumMessage message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PUBLIC);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        publicMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PUBLIC);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        publicMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PUBLIC);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        publicMessages.add(message);

        message = new ForumMessage();
        message.setDate(new Date());
        message.setForumGroup(ForumMessage.PUBLIC);
        message.setGroup("MyGroup");
        message.setUser("testUser");
        message.setMessage("test1");
        publicMessages.add(message);

    }

    public void save(ForumMessage forumMessage) {
    }

    public Collection search(ForumMessageSearchParameters parameters) {

        if (parameters.getForumGroup().equals(ForumMessage.PUBLIC)) {
            return publicMessages;
        }
        if (parameters.getForumGroup().equals(ForumMessage.PRIVATE)) {
            return privateMessages;
        }
        if (parameters.getForumGroup().equals(ForumMessage.CHEF)) {
            if (parameters.getUser() != null) {
                return chefForNormalUserMessages;

            } else {
                return chefForChefMessages;
            }

        }
        return null;
    }

    public void delete(ForumMessage message) {
    }

    public ForumMessage getById(Long target) {

        return null;
    }

}