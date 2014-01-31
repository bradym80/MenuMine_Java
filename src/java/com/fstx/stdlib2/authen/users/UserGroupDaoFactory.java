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
public class UserGroupDaoFactory {

    public UserGroupDao build() {
        return (UserGroupDao) SpringBeanBroker.getBeanFactory().getBean(
                UserGroupDao.SPRING_BEAN_NAME);
    }

}