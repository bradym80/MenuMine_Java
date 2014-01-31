/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import java.io.Serializable;

import com.fstx.stdlib2.authen.Authenticator;
import com.fstx.stdlib2.authen.AuthenticatorAware;
import com.fstx.stdlib2.author.Authorizer;
import com.fstx.stdlib2.author.AuthorizerAware;

/**
 * <p>
 * Application context includes all application level settings. Shared between
 * multiple users.
 * 
 * @author Nick
 *  
 */
public interface MenuMineApplicationContext extends AuthenticatorAware,
        AuthorizerAware, Serializable {

    public final static String SPRING_BEAN_NAME = "menuMineApplicationContext";

    public final static MenuMineApplicationContextBroker broker = new MenuMineApplicationContextBroker();

    public boolean isValid();

    /**
     * properties that apply to the system as a whole.
     * 
     * @return
     */
    public MenuMineApplicationProperties getApplicationProperties();

    /**
     * handles all authentication.
     * 
     * @return
     */
    public Authenticator getAuthenticator();

    /**
     * handles authorization. ...
     * 
     * should this more accurately be in the session context?
     * 
     * @return
     */
    public Authorizer getAuthorizer();

}