/*
 * Created on Mar 2, 2006 by Reid
 */
package com.fsrin.menumine.common.util;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.common.message.MailHost;
import com.fsrin.menumine.common.message.MailHostBroker;
import com.fsrin.menumine.context.MenuMineSessionContext;
import com.fsrin.menumine.context.MenuMineSessionContextFactory;
import com.fsrin.menumine.messages.MailSettingsBean;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class FatalErrorAlertTest extends
        AbstractNonInitializingMenuMineTestCase {

    protected void setUp() throws Exception {

        super.setUp();

        MailSettingsBean mailSettingsBean = (MailSettingsBean) SpringBeanBroker
                .getBeanFactory().getBean(MailSettingsBean.SPRING_BEAN_NAME);

        MailHost host = MailHost.factory.build(
                mailSettingsBean.getSmtpServer(), mailSettingsBean
                        .getUsername(), mailSettingsBean.getPassword());

        MailHostBroker.singleton.setHost(host);
    }

    public void testSendAlert() throws Exception {

        FatalErrorAlert alert = new FatalErrorAlert();

        MenuMineSessionContext context = MenuMineSessionContextFactory
                .getMock("fatalErrorUser");

        Throwable t = new RuntimeException("here's a runtime exception");

        alert.sendFatalErrorAlert("session1", t, context);

    }
}
