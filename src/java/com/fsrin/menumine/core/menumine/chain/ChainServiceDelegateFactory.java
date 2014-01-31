/*
 * Created on Jan 28, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.chain;

import com.fsrin.menumine.common.SpringBeanBroker;

public class ChainServiceDelegateFactory {

    public static final String SPRING_BEAN_NAME = "chainServiceDelegate";

    public static final ChainServiceDelegateFactory factory = new ChainServiceDelegateFactory();

    public ChainServiceDelegate build() {
        return (ChainServiceDelegate) SpringBeanBroker.getBeanFactory()
                .getBean(SPRING_BEAN_NAME);
    }
}
