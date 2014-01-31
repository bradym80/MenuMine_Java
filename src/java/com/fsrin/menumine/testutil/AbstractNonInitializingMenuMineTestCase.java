/*
 * Created on Jan 16, 2006
 *
 */
package com.fsrin.menumine.testutil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractSpringContextTests;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.common.message.MailHost;
import com.fsrin.menumine.common.message.MailHostBroker;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.masterfood.DistinctQueryBuilderBypassManager;
import com.fsrin.menumine.messages.MailSettingsBean;

/**
 * 2006-01-16 RSC Use with test data from 2006-01-12.
 * 
 * Designed for use with MySQL connection, not HQL.
 * 
 * @author Reid
 * 
 */
public abstract class AbstractNonInitializingMenuMineTestCase extends
        AbstractSpringContextTests {

    TimerUtil testTimer;

    protected static Log log = LogFactory
            .getLog(AbstractNonInitializingMenuMineTestCase.class);

    public static final String SAMPLE_USERNAME = "mbrady";

    public static final String SAMPLE_GROUPNAME = "FSRIN";

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {

        TimerUtil setup = TimerUtil.getInstanceAndStart("setup");

        /*
         * 2006-01-22 so I can avoid setting up the distinct for now. takes
         * individual test setup time from ~1m to 3 seconds.
         */
        DistinctQueryBuilderBypassManager.setBypass(true);

        super.setUp();

        // LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean)
        // SpringBeanBroker
        // .getBeanFactory().getBean("&mySessionFactory");
        // lsfb.updateDatabaseSchema();

        setup.stop();

        testTimer = TimerUtil.getInstanceAndStart("test method");
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {

        super.tearDown();

        testTimer.stop();
    }

    /*
     * 2006-02-10 RSC basically sets up an action with everything it needs for a
     * standard query.
     */
    public void decorateWithGenericContextAndQuery(
            AbstractMenuMineSessionContextAwareAction action) {

        action.setMenuMineSessionContextWrapper(MenuMineSessionContextFactory
                .getMockWrapper());

        action.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                MasterFoodFilterParametersTestFactory
                        .getItemDescriptionWithBaconInWrapper());

        action.getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters().getBasicProtein().setSelect(
                        true);

        action.getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters().getCuisine().setSelect(true);

        action.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                new FieldsToDisplayBeanBuilder()
                        .build(action.getMenuMineSessionContextWrapper()
                                .getLastFilterWrapper()
                                .getMasterFoodFilterParameters()));

    }

    public void initializeMailSendingSystem() throws Exception {
        MailSettingsBean mailSettingsBean = (MailSettingsBean) SpringBeanBroker
                .getBeanFactory().getBean(MailSettingsBean.SPRING_BEAN_NAME);

        MailHost host = MailHost.factory.build(
                mailSettingsBean.getSmtpServer(), mailSettingsBean
                        .getUsername(), mailSettingsBean.getPassword());

        MailHostBroker.singleton.setHost(host);
    }
}
