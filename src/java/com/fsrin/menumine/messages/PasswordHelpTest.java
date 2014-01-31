/*
 * Created on Feb 15, 2005
 *
 * 
 */
package com.fsrin.menumine.messages;

import junit.framework.TestCase;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.common.message.MailHost;
import com.fsrin.menumine.common.message.MailHostBroker;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserDao;
import com.fstx.stdlib2.authen.users.UserRole;

/**
 * @author Nick
 * 
 *  
 */
public class PasswordHelpTest extends TestCase {

    User user;

    protected void setUp() throws Exception {

        super.setUp();
//        JunitSettings.initilizeTestSystem();

        MailSettingsBean mailSettingsBean = (MailSettingsBean) SpringBeanBroker
                .getBeanFactory().getBean(MailSettingsBean.SPRING_BEAN_NAME);

        MailHost host = MailHost.factory.build(
                mailSettingsBean.getSmtpServer(), mailSettingsBean
                        .getUsername(), mailSettingsBean.getPassword());

        MailHostBroker.singleton.setHost(host);

        user = new User();
        user.setUsername("menumine@fsrin.com");
        user.setEmail("menumine@fsrin.com");
        user.setPassword("5tgb6yhN");
        user.setInactive(false);
        user.setRoleName(UserRole.ADMIN.getName());
        UserDao.factory.build().saveUser(user);

    }

    //        public void testSender() throws Exception {
    //            // PasswordHelp help = new PasswordHelp();
    //            // help.sendPasswordHelp("nhruza1@fivesticks.com");
    //            Sender sender = null;
    //    
    //            sender = Sender.factory.build("MenuMine Support",
    //                    "service@fivesticks.com", "service@fivesticks.com");
    //    
    //            Recipient recipient = Recipient.factory.build(user.getUsername(), user
    //                    .getEmail());
    //    
    //            Message message = Message.factory.build("Password Help", user
    //                    .getPassword());
    //    
    //            MailSender mailSender = MailSender.factory.build(
    //                    MailHostBroker.singleton.getHost(), sender, recipient, message);
    //    
    //              assertTrue(mailSender.send());
    //           // new Thread(mailSender).start();
    //        }

    public void testSendPasswordHelpString() throws Exception {
        PasswordHelp help = new PasswordHelp();
        help.sendPasswordHelp("menumine@fsrin.com");

    }

    protected void tearDown() throws Exception {
        UserDao.factory.build().delete(user);
        super.tearDown();
    }
}