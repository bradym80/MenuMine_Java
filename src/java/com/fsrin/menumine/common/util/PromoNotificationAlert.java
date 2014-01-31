/*
 * Created on Oct 27, 2003
 *
 */
package com.fsrin.menumine.common.util;

import java.io.StringWriter;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.message.MailManager;
import com.fsrin.menumine.common.message.Message;
import com.fsrin.menumine.common.message.Recipient;
import com.fsrin.menumine.common.message.Sender;
import com.fsrin.menumine.context.MenuMineSessionContext;

/**
 * 2006-05-16 RSC When someone with a role of PROMO logs in, notify matt.
 * events.
 * 
 * @author Reid
 * 
 */
public class PromoNotificationAlert {

    // private static final String SPRING_MESSAGE_NAME = "passwordHelp";
    //
    // private static final String TEXT = "Error Message:";
    //
    // private static final String TEXT_SIGN = "\n\nThank you! ";

    public void sendAlert(String information) {
        sendAlert(information, null);
    }

    public void sendAlert(String information,
            MenuMineSessionContext sessionContext) {

        StringBuffer text = new StringBuffer();

        text.append("Menumine Error: \n\n");

        if (sessionContext == null) {
            text.append("User: Session context is null!");
        } else if (sessionContext.getAuthenticatedUser() == null) {
            text.append("User: Session context exists but user is null!");
        } else {
            text.append("User: "
                    + sessionContext.getAuthenticatedUser().getEmail()
                    + ", Username: "
                    + sessionContext.getAuthenticatedUser().getUsername()
                    + "\n\n");
        }
        text.append("Timestamp: " + new Date() + "\n\n");

        text.append("Message: " + information + "\n\n");

        // text.append("Throwable: " + t.toString() + "\n\n");

        StringWriter sw = new StringWriter();

        StringBuffer sb = new StringBuffer();

        // if (t != null) {
        // t.printStackTrace(new PrintWriter(sw));
        //
        // text.append("Fullstack trace: " + sw.toString() + "\n\n");
        // } else {
        // text.append("Throwable is coming back null.");
        // }

        Sender sender = null;

        sender = Sender.factory.build("MenuMine Support",
                "menumine@fsrin.com", "menumine@fsrin.com");
        	//JDL 04-24-08 Changed recipient bug #34
     //   Recipient recipient = Recipient.factory.build("FiveSticks",
    //            "rsc1@fivesticks.com");

         Recipient recipient = Recipient.factory.build("Matthew Brady",
         "matthew.brady@fsrin.com");

        Message message = Message.factory.build("MenuMine Promo User Alert", text
                .toString());

        MailManager.singleton.sendSingleMessage(sender, recipient, message);

    //     MailManager.singleton.sendSingleMessage(sender, recipient2, message);
    }

    protected static Log log = LogFactory
            .getLog(PromoNotificationAlert.class.getName());

}