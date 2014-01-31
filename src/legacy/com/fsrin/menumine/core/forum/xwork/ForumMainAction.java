/*
 * Created on May 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.forum.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.forum.ForumManager;
import com.fsrin.menumine.core.forum.ForumManagerImpl;
import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.authen.users.UserGroup;

/**
 * @author Nick
 * 
 *  
 */
public class ForumMainAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    /*
     * Defaults that can be overridden in spring!
     */
    private ForumManager forumManager = new ForumManagerImpl();

    public ForumManager getForumManager() {
        return forumManager;
    }

    public void setForumManager(ForumManager forumManager) {
        this.forumManager = forumManager;
    }

    protected AuthenticatedUser getUser() {
        return this.getMenuMineSessionContextWrapper().getAuthenticatedUser();
    }

    protected UserGroup getUserGroup() {

        return this.getMenuMineSessionContextWrapper().getUserGroup();
    }

    public ForumContext getForumContext() {
        return this.getMenuMineSessionContextWrapper().getForumContext();
        // return forumContext;
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }
}