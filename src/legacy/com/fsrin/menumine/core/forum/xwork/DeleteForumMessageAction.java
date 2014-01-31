/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum.xwork;

/**
 * @author Nick
 * 
 *  
 */
public class DeleteForumMessageAction extends ForumMainAction {

    private Long target;

    public String execute() throws Exception {

        this.getForumManager().deleteMessage(this.getTarget(), this.getUser(),
                this.getUserGroup());

        return SUCCESS;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }
}