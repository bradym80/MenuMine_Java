/*
 * Created on 2005-6-2
 *
 * 
 */
package com.fsrin.menumine.common.event;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 2006-01-16 RSC Was spitting out warning messages for events of the wrong class.
 *  
 *  Removed them.
 * 
 * @author Reid
 * @author Nick
 * 
 * This class listens for Application Events from the Spring Context. When it
 * sees a LoginEvent we log it in the login history.
 *  
 */
public abstract class MenuMineGenericSpringEventListener implements
        ApplicationListener {

    /*
     * 6-2-2005 Nick
     * 
     * This method responds to Events from the Spring Application Context.
     * 
     * When we check for handleEvent methods that take the given subclass of
     * applicationEvent; (non-Javadoc)
     * 
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        if (applicationEvent instanceof MenuMineSpringApplicationEvent) {

            Method[] m = this.getClass().getMethods();

            for (int i = 0; i < m.length; i++) {
                Method method = m[i];

                if (method.getName().equals("handleEvent")) {
                    Class[] types = m[i].getParameterTypes();
                    if (types.length > 1) {
                        LogFactory.getLog(this.getClass()).error(
                                "handleEvent should only have one parameter");
                        continue;
                    }
                    if (types[0].isInstance(applicationEvent)) {
                        try {
                            //Object arg = types[0].newInstance();
                            Constructor[] constructors = types[0]
                                    .getConstructors();

                            Object constructArgs[] = { this, applicationEvent };
                            Constructor constructor = null;

                            for (int j = 0; j < constructors.length; j++) {
                                Constructor tempConstructor = constructors[j];
                                Class params[] = tempConstructor
                                        .getParameterTypes();
                                if (params.length == 2
                                        && params[1]
                                                .isAssignableFrom(ApplicationEvent.class)) {
                                    constructor = tempConstructor;
                                }
                            }

                            Object arg = constructor.newInstance(constructArgs);

                            Object args[] = { arg };

                            method.invoke(this, args);

                        } catch (Exception e) {
                            e.printStackTrace();
                            LogFactory.getLog(this.getClass()).error(
                                    "handleEvent Error: " + e.getMessage());
                            continue;
                        }

                    }

                }

            }
        } 

    }

}