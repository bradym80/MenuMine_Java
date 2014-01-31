/*
 * Created on Jun 14, 2004
 *
 */
package com.fstx.stdlib2.authen.users;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class UserBDFactory {

    public UserBD build() {
        return (UserBD) SpringBeanBroker.getBeanFactory().getBean(
                UserBD.SPRING_BEAN_NAME);
    }
}