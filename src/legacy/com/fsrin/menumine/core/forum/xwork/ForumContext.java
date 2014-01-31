/*
 * Created on May 23, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum.xwork;

/**
 * @author Nick
 * 
 * We offer 3 type/groups for messages. We use this to keep track of which group
 * we are looking at. By storing as 3 booleans we eliminate string comparison in
 * favor of a bit more code;
 *  
 */
public class ForumContext {

    private boolean publicMessages;

    private boolean privateMessages;

    private boolean chefMessages;

    public boolean isChefMessages() {
        return chefMessages;
    }

    public void setChefMessages(boolean chefMessages) {
        this.resetMessageGroups();
        this.chefMessages = chefMessages;
    }

    /*
     * Since we only want one to be selected we set them all to false before we
     * select our group;
     */
    private void resetMessageGroups() {
        this.publicMessages = false;

        this.privateMessages = false;

        this.chefMessages = false;
    }

    public boolean isPrivateMessages() {
        return privateMessages;
    }

    public void setPrivateMessages(boolean privateMessages) {
        this.resetMessageGroups();
        this.privateMessages = privateMessages;
    }

    public boolean isPublicMessages() {
        return publicMessages;
    }

    public void setPublicMessages(boolean publicMessages) {
        this.resetMessageGroups();
        this.publicMessages = publicMessages;
    }
}