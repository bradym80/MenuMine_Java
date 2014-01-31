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
public class MasterFoodFilterParametersDaoFactory {

    public MasterFoodFilterParametersDao build() {
        return (MasterFoodFilterParametersDao) SpringBeanBroker
                .getBeanFactory().getBean(
                        MasterFoodFilterParametersDao.SPRING_BEAN_NAME);
    }
}