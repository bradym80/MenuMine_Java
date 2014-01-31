/*

 Five Sticks
 6957 W. North Ave., #202
 Chicago, IL 60302
 USA
 http://www.fivesticks.com
 mailto:info@fivesticks.com

 Copyright (c) 2003-2005, Five Sticks Publications, Inc.
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
 * Created on 2005-1-17
 *
 */
package com.fsrin.menumine.core.menumine.chain;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 *  
 */
public class ChainTest extends AbstractNonInitializingMenuMineTestCase {

//    /**
//     * Constructor for UserTest.
//     * 
//     * @param arg0
//     */
//    public ChainTest(String arg0) {
//        super(arg0);
//    }

    public ChainDao getDao() {
        return (ChainDao) SpringBeanBroker.getBeanFactory().getBean(
                ChainDao.SPRING_BEAN_NAME);
    }

    /*
     * 2006-02-08 RSC Based on current DB.
     */
    private Long id = new Long(7);
    
    public void testUserBasic() throws Exception {
        Chain chain = this.getDao().get(id);
        assertNotNull(chain);
        assertEquals("Hungry Howies Pizza & Subs", chain.getOperationName());
        assertEquals("MI", chain.getHqState());
        assertEquals("QSR Chain- Pizza", chain.getSegment());
        assertEquals("QSR Chain Sector", chain.getSectorName());
    }

//    private Long id;
//
//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystemDropSchema();
//        Chain chain = new Chain();
//        chain.setOperationName("Hungry Howie's Pizza & Subs");
//        chain.setHqState("MI");
//        chain.setSegment("Pizza QSR");
//        chain.setSectorName("QSR Chain Sector");
//        chain = this.getDao().save(chain);
//        id = chain.getId();
//    }

}