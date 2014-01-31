/*
 * Created on Jun 2, 2005
 *
 * 
 */
package com.fsrin.menumine.loginHistory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fstx.stdlib2.authen.LoginHistoryBD;
import com.fstx.stdlib2.authen.LoginHistoryException;

/**
 * @author Nick
 * 
 *  
 */
public class LoginHistoryBDMockImpl extends LoginHistoryBD {

    Collection usernames = new ArrayList();

    public LoginHistoryBDMockImpl() {
        super();
    }

    public void recordLogin(String username, Date timestamp)
            throws LoginHistoryException {
        usernames.add(username);
    }

    public void recordLogout(String username, Date timestamp)
            throws LoginHistoryException {
        usernames.add(username);
    }

    public Collection list() throws LoginHistoryException {
        return usernames;
    }

}