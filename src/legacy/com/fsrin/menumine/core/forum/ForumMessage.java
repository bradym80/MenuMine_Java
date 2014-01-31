/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum;

import java.util.Date;

/**
 * @author Nick
 * 
 *  
 */
public class ForumMessage {

    public static String PUBLIC = "public";

    public static String PRIVATE = "private";

    public static String CHEF = "chef";

    private Long id;

    private String user;

    private String group;

    private String message;

    private String topic;

    private Date date;

    private String forumGroup;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getForumGroup() {
        return forumGroup;
    }

    public void setForumGroup(String forumGroup) {
        this.forumGroup = forumGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}