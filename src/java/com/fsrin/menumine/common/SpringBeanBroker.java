/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Nick
 *  
 */
public class SpringBeanBroker {

    private static BeanFactory factory;

    private static String SPRING_BEAN_FILE = "menumineSpringBeansV2.xml";

    public static BeanFactory getBeanFactory() {

        //double i = 10/0;

        if (factory == null) {

            factory = new ClassPathXmlApplicationContext(SPRING_BEAN_FILE);

            //            factory = new XmlBeanFactory(new FileSystemResource(System
            //                    .getProperty(Settings.KEY_PATH)
            //                    + "/menumineSpringBeansV2.xml"));
        }

        return factory;
    }

}