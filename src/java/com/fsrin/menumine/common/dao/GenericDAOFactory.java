/*
 * Created on Jan 21, 2006
 *
 */
package com.fsrin.menumine.common.dao;

import com.fsrin.menumine.common.SpringBeanBroker;

public class GenericDAOFactory {

    public static final GenericDAOFactory factory = new GenericDAOFactory();
    public static final String SPRING_BEAN_NAME_DATA = "genericDaoData";
    public static final String SPRING_BEAN_NAME_ADMIN = "genericDaoAdmin";
    
    public GenericDAO buildData() {
        return (GenericDAO) SpringBeanBroker.getBeanFactory().getBean(GenericDAOFactory.SPRING_BEAN_NAME_DATA);
    }
    
    public GenericDAO buildAdmin() {
        return (GenericDAO) SpringBeanBroker.getBeanFactory().getBean(GenericDAOFactory.SPRING_BEAN_NAME_ADMIN);
    }
}
