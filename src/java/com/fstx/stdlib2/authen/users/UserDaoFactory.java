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
public class UserDaoFactory {

    public UserDao build() {
        return (UserDao) SpringBeanBroker.getBeanFactory().getBean(
                "userLiveDao");
    }
}