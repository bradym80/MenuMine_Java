/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.authen.users;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class GroupRightDaoFactory {

    public GroupRightDao build() {
        return (GroupRightDao) SpringBeanBroker.getBeanFactory().getBean(
                GroupRightDao.SPRING_BEAN_NAME);
    }
}