/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.chain;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class ChainDaoFactory {

    public ChainDao build() {
        return (ChainDao) SpringBeanBroker.getBeanFactory().getBean(
                ChainDao.SPRING_BEAN_NAME);
    }
}