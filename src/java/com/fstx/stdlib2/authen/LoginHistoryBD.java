/*

 Five Sticks
 6957 W. North Ave., #202
 Chicago, IL 60302
 USA
 http://www.fivesticks.com
 mailto:info@fivesticks.com

 Copyright (c) 2003-2004, Five Sticks Publications, Inc.
 All rights reserved.

 Redistribution and use in source and binary forms, 
 with or without modification, are permitted provided
 that the following conditions are met:

 * Redistributions of source code must retain 
 the above copyright notice, this list of conditions 
 and the following disclaimer.
 * Redistributions in binary form must reproduce 
 the above copyright notice, this list of conditions 
 and the following disclaimer in the documentation 
 and/or other materials provided with the distribution.
 * Neither the name of the Five Sticks Publications, Inc.,
 nor the names of its contributors may be used to 
 endorse or promote products derived from this software 
 without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND 
 CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, 
 INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
 SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE 
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF 
 SUCH DAMAGE.

 license: http://www.opensource.org/licenses/bsd-license.php

 This software uses a variety of Open Source software as
 a foundation.  See the file 

 [your install]/WEB-INF/component-acknowledgement.txt
 
 For more information.
 */

package com.fstx.stdlib2.authen;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.logging.LogFactory;

import com.fstx.stdlib.common.simpledate.SimpleDate;
import com.fstx.stdlib2.authen.users.DaoException;

/**
 * @author Nick
 *  
 */
public class LoginHistoryBD {

    private LoginHistoryDao loginHistoryDao;

    public void recordLogin(String username, Date timestamp)
            throws LoginHistoryException {
        LoginHistory lh = new LoginHistory(username, timestamp, "Login");
        try {
            this.getLoginHistoryDao().save(lh);
            LogFactory.getLog(this.getClass()).info(
                    "Login: " + username + " " + timestamp);
        } catch (DaoException e) {
            throw new LoginHistoryException("Unable to record the Login.", e);
        }
    }

    public void recordLogout(String username, Date timestamp)
            throws LoginHistoryException {
        LoginHistory lh = new LoginHistory(username, timestamp, "Logout");
        try {
            this.getLoginHistoryDao().save(lh);
            LogFactory.getLog(this.getClass()).info(
                    "Logout: " + username + " " + timestamp);
        } catch (DaoException e) {
            throw new LoginHistoryException("Unable to record the Login.", e);
        }
    }

    public Collection list() throws LoginHistoryException {
        Collection ret = null;

        LoginHistoryDao dao = this.getLoginHistoryDao();
        LoginHistoryFilterParameters params = new LoginHistoryFilterParameters();

        SimpleDate thirty = SimpleDate.factory.build();
        thirty.advanceDay(-30);
        
        params.setDateFrom(thirty.getDate());
        ret = dao.find(params);

        return ret;
    }
    
    public Collection listForUser(String username) throws LoginHistoryException {
        Collection ret = null;

        LoginHistoryDao dao = this.getLoginHistoryDao();
        LoginHistoryFilterParameters params = new LoginHistoryFilterParameters();
        
        
        SimpleDate thirty = SimpleDate.factory.build();
        thirty.advanceDay(-30);
        
        params.setDateFrom(thirty.getDate());
        
        params.setUsername(username);
        params.setMax(new Integer(10));
        
        ret = dao.find(params);

        return ret;
    }    

    public LoginHistoryDao getLoginHistoryDao() {
        return loginHistoryDao;
    }

    public void setLoginHistoryDao(LoginHistoryDao loginHistoryDao) {
        this.loginHistoryDao = loginHistoryDao;
    }
}