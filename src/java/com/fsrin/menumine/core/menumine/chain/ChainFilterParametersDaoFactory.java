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
public class ChainFilterParametersDaoFactory {

    public ChainFilterParametersDao build() {
        return (ChainFilterParametersDao) SpringBeanBroker.getBeanFactory()
                .getBean(ChainFilterParametersDao.SPRING_BEAN_NAME);
    }
}