/*
 * Created on Jan 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat;

import java.util.Collection;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStatServiceDelegateTest extends AbstractNonInitializingMenuMineTestCase {

    public void testSearch() throws Exception {
        ChainStatFilterParameters chainStatFilterParameters = new ChainStatFilterParameters();

        chainStatFilterParameters.setOperationName("Apple");

        Collection colApple = this.getServiceDelegate().find(
                chainStatFilterParameters);

        /*
         * 2006-08-17 reid@fivesticks.com - updated to 3.  
         */
        assertEquals(3, colApple.size());

    }

//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystemDropSchema();
//
//        ChainStat stat = new ChainStat();
//        stat.setOperationName("Applebees");
//        this.getServiceDelegate().save(stat);
//
//        stat = new ChainStat();
//        stat.setOperationName("Applebees2");
//        this.getServiceDelegate().save(stat);
//
//    }

    public ChainStatServiceDelegate getServiceDelegate() {
        return (ChainStatServiceDelegate) SpringBeanBroker.getBeanFactory()
                .getBean(ChainStatServiceDelegate.SPRING_BEAN_NAME);
    }

}