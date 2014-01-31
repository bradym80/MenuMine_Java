/*
 * Created on Aug 12, 2004
 *
 * 
 */
package com.fstx.stdlib2.authen.users;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Nick
 * 
 *  
 */
public class UserGroupServiceDelegateFactory {
    public UserGroupServiceDelegate build() {
        return (UserGroupServiceDelegate) SpringBeanBroker.getBeanFactory()
                .getBean(UserGroupServiceDelegate.SPRING_BEAN_NAME);
    }

}