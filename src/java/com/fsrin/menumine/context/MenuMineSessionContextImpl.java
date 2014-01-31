/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.author.Authorizer;
import com.opensymphony.webwork.util.Sorter;

/**
 * @author Nick
 *  
 */
public class MenuMineSessionContextImpl implements MenuMineSessionContext {

    private AuthenticatedUser authenticatedUser;

    private MenuMineApplicationContext menuMineApplicationContext;

    private Authorizer authorizer;

    private Set history = new TreeSet(new Sorter().getDescending("name"));

    private Collection permanentHistory;

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineSessionContext#isValid()
     */
    public boolean isValid() {
        return this.getAuthenticatedUser() != null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineSessionContext#getAuthorizer()
     */
    public Authorizer getAuthorizer() {
        if (!isValid())
            throw new RuntimeException("not a valid session");
        return this.authorizer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineSessionContext#getSessionProperties()
     */
    public MenuMineSessionProperties getSessionProperties() {
        return null;
    }

    /**
     * @param user
     */
    public void setAuthenticatedUser(AuthenticatedUser user) {
        authenticatedUser = user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineSessionContext#getAuthenticatedUser()
     */
    public AuthenticatedUser getAuthenticatedUser() {
        return this.authenticatedUser;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineApplicationContextAware#setMenuMineApplicationContext(com.fivesticks.menuMine.context.MenuMineApplicationContext)
     */
    public void setMenuMineApplicationContext(
            MenuMineApplicationContext menuMineApplicationContext) {
        this.menuMineApplicationContext = menuMineApplicationContext;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineApplicationContextReadable#getMenuMineApplicationContext()
     */
    public MenuMineApplicationContext getMenuMineApplicationContext() {
        return this.menuMineApplicationContext;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.author.AuthorizerAware#setAuthorizer(com.fstx.stdlib2.author.Authorizer)
     */
    public void setAuthorizer(Authorizer authorizer) {
        this.authorizer = authorizer;
    }

    public Collection getHistory() {
        return history;
    }

    public Collection getPermanentHistory() {
        return permanentHistory;
    }

    public void setPermanentHistory(Collection permanentHistory) {
        this.permanentHistory = permanentHistory;
    }
}