/*
 * Created on Jun 2, 2005
 *
 * 
 */
package com.fsrin.menumine.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Nick
 * 
 *  
 */
public abstract class MenuMineSpringApplicationEvent extends ApplicationEvent {

    public MenuMineSpringApplicationEvent(Object arg0) {
        super(arg0);

    }

    public MenuMineSpringApplicationEvent(Object arg0,
            ApplicationEvent applicationEvent) {
        super(arg0);

    }
}