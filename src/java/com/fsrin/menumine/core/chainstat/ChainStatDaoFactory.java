/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.chainstat;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class ChainStatDaoFactory {

    public ChainStatDao build() {
        return (ChainStatDao) SpringBeanBroker.getBeanFactory().getBean(
                ChainStatDao.SPRING_BEAN_NAME);
    }
}