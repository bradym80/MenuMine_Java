/*
 * Created on Jan 28, 2006 by Reid
 */
package com.fsrin.menumine.common;


public abstract class AbstractSpringObjectFactory {

    protected Object build(String springBeanName) {
        return SpringBeanBroker.getBeanFactory().getBean(
                springBeanName);
    }
}
