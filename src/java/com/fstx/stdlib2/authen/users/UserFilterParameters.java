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
/*
 * Created on Oct 29, 2003
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Date;

/**
 * @author Nick
 * 
 */
public class UserFilterParameters {

    private static final String STATUS_ALL = "all";
    private static final String STATUS_CURRENT = "current";
    private static final String STATUS_EXPIRED = "expired";
    
    private Long id = null;

    private String companyLike = null;
    
    private String username = null;

    private String password = null;

    private String email = null;

    private String emailLike = null;
    
    private Date expiresBefore = null;

    private Date expiresOnOrAfter = null;

    private String roleName;
    
    private String sortBy;
    
    /*
     * 2006-04-04 User Status is derived from expiration date;
     */
    private String userStatus;

    // public void reset() {
    // this.id = null;
    // this.username = null;
    // this.password = null;
    // this.email = null;
    // }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String string) {
        email = string;
    }

    public void setId(Long long1) {
        id = long1;
    }

    public void setPassword(String string) {
        password = string;
    }

    public void setUsername(String string) {
        username = string;
    }

    /**
     * @return Returns the expiresBefore.
     */
    public Date getExpiresBefore() {
        return expiresBefore;
    }

    /**
     * @param expiresBefore
     *            The expiresBefore to set.
     */
    public void setExpiresBefore(Date expiresBefore) {
        this.expiresBefore = expiresBefore;
    }

    /**
     * @return Returns the expiresOnOrAfter.
     */
    public Date getExpiresOnOrAfter() {
        return expiresOnOrAfter;
    }

    /**
     * @param expiresOnOrAfter
     *            The expiresOnOrAfter to set.
     */
    public void setExpiresOnOrAfter(Date expiresOnOrAfter) {
        this.expiresOnOrAfter = expiresOnOrAfter;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        
        this.setExpiresOnOrAfter(null);
        this.setExpiresBefore(null);
        
        if (userStatus.equals(UserFilterParameters.STATUS_EXPIRED)) {
            this.setExpiresBefore(new Date());
        } else if (userStatus.equals(UserFilterParameters.STATUS_CURRENT)) {
            this.setExpiresOnOrAfter(new Date());
        } else {
 
        }
    }

    public String getEmailLike() {
        return emailLike;
    }

    public void setEmailLike(String emailLike) {
        this.emailLike = emailLike;
    }

    public String getCompanyLike() {
        return companyLike;
    }

    public void setCompanyLike(String companyLike) {
        this.companyLike = companyLike;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

}