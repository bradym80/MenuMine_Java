/*
 * Created on May 20, 2005
 *
 * 
 */
package com.fsrin.menumine.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * @author Nick
 * 
 *  
 */
public class SpringEventPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static final String SPRING_BEAN_NAME = "springEventPublisher";

    public SpringEventPublisher() {
        super();

    }

    public static SpringEventPublisher build() {
        return (SpringEventPublisher) SpringBeanBroker.getBeanFactory()
                .getBean(SpringEventPublisher.SPRING_BEAN_NAME);
    }

    public void publish(ApplicationEvent event) {
        this.getApplicationContext().publishEvent(event);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}