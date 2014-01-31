/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Nick
 *  
 */
public class MenuMineApplicationContextBroker {

    public MenuMineApplicationContext find() {
        return (MenuMineApplicationContext) SpringBeanBroker.getBeanFactory()
                .getBean(MenuMineApplicationContext.SPRING_BEAN_NAME);
    }

}