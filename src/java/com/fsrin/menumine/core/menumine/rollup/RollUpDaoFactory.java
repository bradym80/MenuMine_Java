/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.rollup;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class RollUpDaoFactory {

    public RollUpDao build() {
        return (RollUpDao) SpringBeanBroker.getBeanFactory().getBean(
                RollUpDao.SPRING_BEAN_NAME);
    }
}