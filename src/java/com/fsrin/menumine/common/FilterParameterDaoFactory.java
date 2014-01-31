/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.common;

/**
 * @author Reid
 *  
 */
public class FilterParameterDaoFactory {

    public FilterParameterDao build() {
        return (FilterParameterDao) SpringBeanBroker.getBeanFactory().getBean(
                FilterParameterDao.SPRING_BEAN_NAME);
    }
}