/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.rollup;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class RollUpServiceDelegateFactory {

    public RollUpServiceDelegate build() {
        return (RollUpServiceDelegate) SpringBeanBroker.getBeanFactory()
                .getBean(RollUpServiceDelegate.SPRING_BEAN_NAME);
    }
}