/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum.xwork;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.forum.ForumManagerException;

/**
 * @author Nick
 * 
 *  
 */
public class RecentForumActivityAction extends ForumMainAction {

    private Integer messagesToDisplay = new Integer(5);

    public Collection getRecentForumActivity() throws ForumManagerException {
        Collection col = this.getForumManager().getPublicMessages();

        ArrayList recent = new ArrayList();
        recent.addAll(col);
        Collection col2 = recent.subList(0, Math.min(messagesToDisplay
                .intValue(), recent.size()));
        return recent;
    }

    public Integer getMessagesToDisplay() {
        return messagesToDisplay;
    }

    public void setMessagesToDisplay(Integer messagesToDisplay) {
        this.messagesToDisplay = messagesToDisplay;
    }
}