/*
 * Created on Aug 13, 2004
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
public class GroupRightServiceDelegateFactory {

    public GroupRightServiceDelegate build() {
        return (GroupRightServiceDelegate) SpringBeanBroker.getBeanFactory()
                .getBean(GroupRightServiceDelegate.SPRING_BEAN_NAME);
    }

}