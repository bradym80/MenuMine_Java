/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import com.fstx.stdlib2.authen.Authenticator;
import com.fstx.stdlib2.author.Authorizer;

/**
 * @author Nick
 *  
 */
public class MenuMineApplicationContextImpl implements
        MenuMineApplicationContext {

    private Authenticator authenticator;

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineApplicationContext#isValid()
     */
    public boolean isValid() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineApplicationContext#getApplicationProperties()
     */
    public MenuMineApplicationProperties getApplicationProperties() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineApplicationContext#getAuthenticator()
     */
    public Authenticator getAuthenticator() {
        return authenticator;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.menuMine.context.MenuMineApplicationContext#getAuthorizer()
     */
    public Authorizer getAuthorizer() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.AuthenticatorAware#setAuthenticator(com.fstx.stdlib2.authen.Authenticator)
     */
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.author.AuthorizerAware#setAuthorizer(com.fstx.stdlib2.author.Authorizer)
     */
    public void setAuthorizer(Authorizer authorizer) {

    }

}