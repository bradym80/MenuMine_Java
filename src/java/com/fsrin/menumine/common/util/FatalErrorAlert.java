/*
 * Created on Oct 27, 2003
 *
 */
package com.fsrin.menumine.common.util;

import java.io.PrintWriter;
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
 * send in an email,
 * 
 * @author Reid
 * 
 */
public class FatalErrorAlert {

//    private static final String SPRING_MESSAGE_NAME = "passwordHelp";
//
//    private static final String TEXT = "Error Message:";
//
//    private static final String TEXT_SIGN = "\n\nThank you! ";

    public void sendFatalErrorAlert(String sessionId, Throwable t,
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
        
        text.append("Session Id: " + sessionId + "\n\n");
        
        text.append("Throwable: " + t.toString() + "\n\n");

//        StringWriter sw = new StringWriter();

//        StringBuffer sb = new StringBuffer();

        if (t != null) {
            

            text.append("Fullstack trace: " + ExceptionUtilities.getExceptionStackTrace(t) + "\n\n");
        } else {
            text.append("Throwable is coming back null.");
        }

        

        Sender sender = null;

        sender = Sender.factory.build("MenuMine Support",
                "menumine@fsrin.com", "menumine@fsrin.com");
      //JDL 04-24-08 Changed recipient bug #34
        //2006-07-24 reid@fivesticks.com disabled.
//        Recipient recipient = Recipient.factory.build("FiveSticks",
//                "rsc1@fivesticks.com");

        Recipient recipient2 = Recipient.factory.build("Matthew Brady",
                "matthew.brady@fsrin.com");

        Message message = Message.factory.build("MenuMine Error Alert", text
                .toString());

//        MailManager.singleton.sendSingleMessage(sender, recipient, message);

        MailManager.singleton.sendSingleMessage(sender, recipient2, message);
    }

    protected static Log log = LogFactory.getLog(FatalErrorAlert.class
            .getName());

}