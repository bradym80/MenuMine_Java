/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.testutil;

import com.fsrin.menumine.common.Settings;

/**
 * @author Nick
 *  
 */
public class JunitSettings {

    public static final String TEST_FILEPATH = "c:/java/eclipse3Data/menumine/WEB-INF/classes";

    public static void initilizeTestSystem() throws Exception {

        System.setProperty(Settings.KEY_PATH, TEST_FILEPATH);

    }

    public static void initilizeTestSystemDropSchema() throws Exception {
        //		new DatabaseInitializer().initializeTables();
        
        throw new RuntimeException("shouldn't ever be here!");
        
//        System.setProperty(Settings.KEY_PATH, TEST_FILEPATH);
//
//        LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean) SpringBeanBroker
//                .getBeanFactory().getBean("&mySessionFactory");
        // lsfb.updateDatabaseSchema();
       // lsfb.dropDatabaseSchema();
       // lsfb.createDatabaseSchema();
       // lsfb.updateDatabaseSchema();
    }
}