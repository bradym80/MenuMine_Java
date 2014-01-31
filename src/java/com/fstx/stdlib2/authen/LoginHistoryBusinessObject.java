/*
 * 
 * Five Sticks 6957 W. North Ave., #202 Chicago, IL 60302 USA
 * http://www.fivesticks.com mailto:info@fivesticks.com
 * 
 * Copyright (c) 2003-2005, Five Sticks Publications, Inc. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. Neither the name of the Five Sticks Publications,
 * Inc., nor the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * license: http://www.opensource.org/licenses/bsd-license.php
 * 
 * This software uses a variety of Open Source software as a foundation. See the
 * file
 * 
 * [your install]/WEB-INF/component-acknowledgement.txt
 * 
 * For more information.
 */
package com.fstx.stdlib2.authen;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;
import com.fstx.stdlib2.authen.users.UserServiceDelegateException;

/*
 * 2005-9-23
 * @author Nick
 *
 *This wrap the LoginHistory to let it find the group it belongs to.
 *
 */
public class LoginHistoryBusinessObject implements Serializable {

    private Log log = LogFactory.getLog(LoginHistoryBusinessObject.class);
    
    private LoginHistory loginHistory;

    public LoginHistoryBusinessObject(LoginHistory loginHistory) {
        super();
        this.loginHistory = loginHistory;
    }

    public String getUserGroup() {
        User u = null;
        try {
            u = UserServiceDelegate.factory.build().getByUsername(
                    this.getUsername());
        } catch (UserServiceDelegateException e) {

            e.printStackTrace();
           log.error(
                    "Error determining group for user: " + this.getUsername()
                            + ".  " + e.getMessage());

            return null;
        }
        
        return u.getCompany();
        
//        Collection col = null;
//        try {
//            col = UserGroupServiceDelegate.factory.build().getGroupsByUser(u);
//        } catch (ServiceDelegateException e1) {
//            e1.printStackTrace();
//            log.error(
//                    "Error determining group for user: " + this.getUsername()
//                            + ".  " + e1.getMessage());
//            return null;
//        }
//
//        /*
//         * We expect that there is exactly one group, if not re have an error
//         * and return null;
//         */
//        if (this.getUsername().equalsIgnoreCase("cmann")) {
//            
//        }
//        if (col != null && col.size() == 1) {
//            return (UserGroup) col.toArray()[0];
//        } else {
//            log.error(
//                    "Error determining group for user: " + this.getUsername()
//                            + ".  " + col.size() + " groups found.");
//        }
//
//        
//        return null;

    }

    public boolean equals(Object obj) {
        return loginHistory.equals(obj);
    }

    public Long getId() {
        return loginHistory.getId();
    }

    public Date getTimestamp() {
        return loginHistory.getTimestamp();
    }

    public String getType() {
        return loginHistory.getType();
    }

    public String getUsername() {
        return loginHistory.getUsername();
    }

    public int hashCode() {
        return loginHistory.hashCode();
    }

    public String toString() {
        return loginHistory.toString();
    }
}