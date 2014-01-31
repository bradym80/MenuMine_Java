/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum.xwork;

import java.util.Collection;
import java.util.TreeSet;

import com.fsrin.menumine.core.forum.ForumManagerException;
import com.opensymphony.webwork.util.Sorter;

/**
 * @author Nick
 * 
 *  
 */
public class ViewForumGroupAction extends ForumMainAction {

    //   private ForumContext forumContext;

    public Collection getMessages() throws ForumManagerException {

        TreeSet sorted = new TreeSet(new Sorter().getDescending("date"));
        Collection messages = null;

        if (this.isPublicMessages()) {
            messages = this.getForumManager().getPublicMessages();
        }
        if (this.isPrivateMessages()) {
            messages = this.getForumManager().getPrivateMessages(
                    this.getUser(), this.getUserGroup());
        }
        if (this.isChefMessages()) {
            messages = this.getForumManager().getChefMessages(this.getUser(),
                    this.getUserGroup());
        }

        sorted.addAll(messages);
        return sorted;
    }

    public boolean isChefMessages() {
        return this.getForumContext().isChefMessages();
    }

    public boolean isPrivateMessages() {
        return this.getForumContext().isPrivateMessages();
    }

    public boolean isPublicMessages() {
        return this.getForumContext().isPublicMessages();
    }

    public void setChefMessages(boolean chefMessages) {
        this.getForumContext().setChefMessages(chefMessages);
    }

    public void setPrivateMessages(boolean privateMessages) {
        this.getForumContext().setPrivateMessages(privateMessages);
    }

    public void setPublicMessages(boolean publicMessages) {
        this.getForumContext().setPublicMessages(publicMessages);
    }

    //    public void setForumContext(ForumContext forumContext) {
    //        this.forumContext = forumContext;
    //    }
}