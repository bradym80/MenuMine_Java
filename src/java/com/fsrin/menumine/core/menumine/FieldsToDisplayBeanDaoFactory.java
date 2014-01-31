/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class FieldsToDisplayBeanDaoFactory {

    public FieldsToDisplayBeanDao build() {
        return (FieldsToDisplayBeanDao) SpringBeanBroker.getBeanFactory()
                .getBean(FieldsToDisplayBeanDao.SPRING_BEAN_NAME);
    }
}