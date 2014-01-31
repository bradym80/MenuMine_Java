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
 * Created on Aug 21, 2003
 *
 */
package com.fstx.stdlib2.author;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.enums.Enum;

/**
 * @author Reid
 *  
 */
public class SystemRights extends Enum {

    public static final SystemRights HOME = new SystemRights("HOME");

    public static final SystemRights TIME = new SystemRights("TIME");

    public static final SystemRights TIME_MODIFY_ALL = new SystemRights(
            "TIME_MODIFY_ALL");

    public static final SystemRights TIME_PROJECT_MODIFY = new SystemRights(
            "TIME_PROJECT_MODIFY");

    public static final SystemRights TIME_TASK_MODIFY = new SystemRights(
            "TIME_TASK_MODIFY");

    public static final SystemRights TIMECLOCK_MODIFY_SELF = new SystemRights(
            "TIMECLOCK_MODIFY_SELF");

    public static final SystemRights TIMECLOCK_MODIFY_ALL = new SystemRights(
            "TIMECLOCK_MODIFY_ALL");

    public static final SystemRights TIMECLOCK_ADD = new SystemRights(
            "TIMECLOCK_ADD");

    public static final SystemRights TIMECLOCK_LOGIN = new SystemRights(
            "TIMECLOCK_LOGIN");

    public static final SystemRights CALENDAR_VIEW_ALL = new SystemRights(
            "CALENDAR_VIEW_ALL");

    public static final SystemRights CALENDAR_MODIFY_ALL = new SystemRights(
            "CALENDAR_MODIFY_ALL");

    public static final SystemRights GENERAL_ADMINISTRATION = new SystemRights(
            "GENERAL_ADMINISTRATION");

    public static int id = 0;

    private int myId;

    /**
     * @param arg0
     */
    protected SystemRights(String name) {
        super(name);
        myId = ++id;
    }

    public static List getRights() {
        return SystemRights.getEnumList(SystemRights.class);
    }

    public static SystemRights getRight(String name) {
        return (SystemRights) SystemRights.getEnum(SystemRights.class, name);
    }

    public static SystemRights getRight(int id) {

        SystemRights ret = null;

        List l = getRights();

        Iterator i = l.iterator();

        while (i.hasNext()) {
            SystemRights r = (SystemRights) i.next();
            if (r.getMyId() == id) {
                ret = r;
                break;
            }

        }

        return ret;
    }

    /**
     * @return
     */
    public int getMyId() {
        return myId;
    }

    public String toString() {
        return this.getName();
    }

}