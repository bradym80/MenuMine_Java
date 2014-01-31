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
public class ChainStatDaoTest extends AbstractNonInitializingMenuMineTestCase {

    public void testSearch() throws Exception {
        ChainStatFilterParameters chainStatFilterParameters = new ChainStatFilterParameters();

        chainStatFilterParameters.setOperationName("Apple");

        Collection colApple = this.getDao().find(chainStatFilterParameters);

        log.info("Apple size is " + colApple.size());
        
        assertTrue(2 <= colApple.size());

    }

//    protected void setUp() throws Exception {
//        super.setUp();
////        JunitSettings.initilizeTestSystemDropSchema();
//
//        ChainStat stat = new ChainStat();
//        stat.setOperationName("Applebees");
//        this.getDao().save(stat);
//
//        stat = new ChainStat();
//        stat.setOperationName("Applebees2");
//        this.getDao().save(stat);
//    }
//
    public ChainStatDao getDao() {
        return (ChainStatDao) SpringBeanBroker.getBeanFactory().getBean(
                ChainStatDao.SPRING_BEAN_NAME);

    }

}