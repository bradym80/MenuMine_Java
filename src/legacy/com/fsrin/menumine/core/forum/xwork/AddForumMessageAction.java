/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum.xwork;

import com.fsrin.menumine.core.forum.ForumManagerException;
import com.fsrin.menumine.core.forum.ForumMessage;

/**
 * @author Nick
 * 
 *  
 */
public class AddForumMessageAction extends ForumMainAction {

    private String submit;

    /*
     * This is a basic data holder.
     */
    private ForumMessage forumMessage = new ForumMessage();

    public String execute() {

        /*
         * Has the form been submited or are we heading to the form?
         */
        if (this.isSubmit()) {

            this.validate();

            if (this.hasErrors()) {
                return INPUT;
            }

            createMessage();
            return SUCCESS;
        }
        return INPUT;
    }

    private void createMessage() {
        try {
            if (this.getForumContext().isPublicMessages()) {
                this.getForumManager().addPublicMessage(this.getUser(),
                        this.getUserGroup(), forumMessage);
            }
            if (this.getForumContext().isPrivateMessages()) {
                this.getForumManager().addPrivateMessage(this.getUser(),
                        this.getUserGroup(), forumMessage);
            }
            if (this.getForumContext().isChefMessages()) {
                this.getForumManager().addChefMessage(this.getUser(),
                        this.getUserGroup(), forumMessage, "");
            }

        } catch (ForumManagerException e) {
            this.addActionError("Error Saving Forum Message:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean isSubmit() {
        return this.getSubmit() != null && this.getSubmit().length() > 0;
    }

    public ForumMessage getForumMessage() {
        return forumMessage;
    }

    public void setForumMessage(ForumMessage forumMessage) {
        this.forumMessage = forumMessage;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public void validate() {

        if (forumMessage.getMessage() == null
                || forumMessage.getMessage().length() == 0) {
            this.addActionError("Please enter a message");
        }

        if (forumMessage.getTopic() == null
                || forumMessage.getTopic().length() == 0) {
            this.addActionError("Please enter a topic");
        }
    }
}