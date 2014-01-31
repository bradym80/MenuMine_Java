/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.chainmap;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class ChainStateCountServiceDelegateFactory {

    public ChainStateCountServiceDelegate build() {
        return (ChainStateCountServiceDelegate) SpringBeanBroker
                .getBeanFactory().getBean(
                        ChainStateCountServiceDelegate.SPRING_BEAN_NAME);
    }
}