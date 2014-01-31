/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.message.MailHost;
import com.fsrin.menumine.common.message.MailHostBroker;
import com.fsrin.menumine.messages.MailSettingsBean;

/**
 * @author Nick
 * @version 1.0.0
 */
public class MenuMineContextListener implements ServletContextListener {

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {

        System.setProperty(Settings.CONTEXT_PATH, arg0.getServletContext()
                .getRealPath("/"));

        System.setProperty(Settings.KEY_PATH, arg0.getServletContext()
                .getRealPath("/")
                + "/WEB-INF/classes");

        /*
         * 2006-01-31 RSC Don't need to call this during startup.
         */
//        LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean) SpringBeanBroker
//                .getBeanFactory().getBean("&mySessionFactory");

        /*
          Commenting this out during testing. 2005-12-22 NJH
          
        try {

            lsfb.updateDatabaseSchema();
        } catch (HibernateException e) {
            log.fatal("Schema update failed!");
        }
        */
        MailSettingsBean mailSettingsBean = (MailSettingsBean) SpringBeanBroker
                .getBeanFactory().getBean(MailSettingsBean.SPRING_BEAN_NAME);

        MailHost host = MailHost.factory.build(
                mailSettingsBean.getSmtpServer(), mailSettingsBean
                        .getUsername(), mailSettingsBean.getPassword());

        MailHostBroker.singleton.setHost(host);

    }

    public void contextDestroyed(ServletContextEvent arg0) {
        //        FileCleanUpService.singleton.stop();

    }

    protected static Log log = LogFactory.getLog(MenuMineContextListener.class
            .getName());

}