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
public class UserServiceDelegateFactory {

    public UserServiceDelegate build() {
        return (UserServiceDelegate) SpringBeanBroker.getBeanFactory().getBean(
                UserServiceDelegate.SPRING_BEAN_NAME);
    }

}