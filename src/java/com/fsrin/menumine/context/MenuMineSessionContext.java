/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import java.io.Serializable;
import java.util.Collection;

import com.fstx.stdlib2.authen.AuthenticatedUser;
import com.fstx.stdlib2.author.Authorizer;
import com.fstx.stdlib2.author.AuthorizerAware;

/**
 * <p>
 * Session context is unique to every system user. It also provides a gateway to
 * the application context.
 * 
 * @author Nick
 *  
 */
public interface MenuMineSessionContext extends
        MenuMineApplicationContextReadable, AuthorizerAware, Serializable {

    public static final String SPRING_BEAN_NAME = "menuMineSessionContext";

    public static final MenuMineSessionContextFactory factory = new MenuMineSessionContextFactory();

    /**
     * <p>
     * an easy way to see if this session is valid;
     * 
     * @return
     */
    public boolean isValid();

    /**
     * <p>
     * Authorization is handled here. The original idea was to put it in the
     * applicationContext, but this makes more sense as it is closer to the
     * user.
     */
    public Authorizer getAuthorizer();

    /**
     * <p>
     * anything that might be interesting that we don't necessarily need ready
     * access to for every action. Example would be client type (web, web
     * services), sorce location (IP Address or something else...you never know)
     * 
     * @return
     */
    public MenuMineSessionProperties getSessionProperties();

    /**
     * <p>
     * need to keep track of which user this is for.
     */
    public AuthenticatedUser getAuthenticatedUser();

    public void setAuthenticatedUser(AuthenticatedUser authenticatedUser);

    public Collection getHistory();

    public Collection getPermanentHistory();

    public void setPermanentHistory(Collection permanentHistory);

}