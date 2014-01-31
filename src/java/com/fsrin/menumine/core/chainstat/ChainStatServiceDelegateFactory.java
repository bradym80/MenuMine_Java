/*
 * Created on Jul 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStatServiceDelegateFactory {

    public ChainStatServiceDelegateFactory() {
        super();

    }

    public ChainStatServiceDelegate build() {
        return (ChainStatServiceDelegate) SpringBeanBroker.getBeanFactory()
                .getBean(ChainStatServiceDelegate.SPRING_BEAN_NAME);
    }

}