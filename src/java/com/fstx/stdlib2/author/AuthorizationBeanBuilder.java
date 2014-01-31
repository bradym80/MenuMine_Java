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
 * Created on Aug 18, 2003
 *
 */
package com.fstx.stdlib2.author;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fstx.stdlib2.authen.users.DaoException;
import com.fstx.stdlib2.authen.users.GroupRight;
import com.fstx.stdlib2.authen.users.GroupRightDao;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupDao;

/**
 * @version 2004-05-27
 * @author Reid
 *         <p>
 *         Updated to include dao's delvered via factories.
 * @author Nick
 *  
 */
public class AuthorizationBeanBuilder {

    public AuthorizationBean buildAuthorizationBean(String user)
            throws DaoException {

        HashSet rightsSet = new HashSet();
        HashSet rightsStringSet = new HashSet();
        GroupRightDao grDao = GroupRightDao.factory.build();
        //Get user groups
        UserGroupDao dao = UserGroupDao.factory.build();

        List l = dao.searchUserGroups(UserGroupDao.SELECT_BY_USER, user);

        //for each group
        Iterator i = l.iterator();
        UserGroup g3 = null;
        Collection rightsList = null;
        while (i.hasNext()) {
            g3 = (UserGroup) i.next();
            //get list of rights for group
            rightsList = grDao.find(g3);

            //			add groups rights to the users list
            rightsSet.addAll(rightsList);

            //log.info("\n\nI just queried this group for rights: "+
            // g3.getGroupname());
        }
        //We only want to deal with strings, not GroupRights objs. This makes
        // the
        // seach of the hash eazily.
        //Convert GroupRights to Strings.
        Iterator i2 = rightsSet.iterator();
        GroupRight grTemp = null;
        while (i2.hasNext()) {
            grTemp = (GroupRight) i2.next();
            //log.info("\n\nAdding the right" + grTemp.getRightCode());
            rightsStringSet.add(grTemp.getRightCode());
        }

        //		add composite to the bean.
        AuthorizationBean ab = new AuthorizationBean(rightsStringSet);

        //      Return bean.
        return ab;
    }

    static Log log = LogFactory.getLog(AuthorizationBeanBuilder.class);
}