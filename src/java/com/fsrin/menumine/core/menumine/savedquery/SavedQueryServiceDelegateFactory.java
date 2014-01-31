/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.savedquery;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class SavedQueryServiceDelegateFactory {

    public SavedQueryServiceDelegate build() {
        return (SavedQueryServiceDelegate) SpringBeanBroker.getBeanFactory()
                .getBean(SavedQueryServiceDelegate.SPRING_BEAN_NAME);
    }
}