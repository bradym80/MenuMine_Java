/*
 * Created on Oct 27, 2003
 *
 */
package com.fsrin.menumine.messages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.message.MailManager;
import com.fsrin.menumine.common.message.Message;
import com.fsrin.menumine.common.message.Recipient;
import com.fsrin.menumine.common.message.Sender;
import com.fstx.stdlib2.authen.users.DaoException;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserDao;

/**
 * send in an email, find the user associated with it, then send that user their
 * password.
 * 
 * @author Reid
 *  
 */
public class PasswordHelp {

    private static final String SPRING_MESSAGE_NAME = "passwordHelp";

    private static final String TEXT = "Hello, \n\n"
            + "Someone has requested we send your password. \n\n"
            + "it is: \n\n\t\t";

    private static final String TEXT_SIGN = "\n\nThank you! ";

    public void sendPasswordHelp(String email) throws SystemMessageException {
        handleSend(email);
    }

    private void handleSend(String email) throws SystemMessageException {
        User user;
        try {

            user = UserDao.factory.build().getUserByEmail(email);

        } catch (DaoException e) {
            throw new SystemMessageException(e);
        }

        if (user == null)
            throw new SystemMessageException("unexpectedly null");

        try {
            sendPasswordHelp(user);
        } catch (PasswordHelpException e1) {

            throw new SystemMessageException(e1);
        }

    }

    public void sendPasswordHelp(User user) throws PasswordHelpException {

        Sender sender = null;

        sender = Sender.factory.build("MenuMine Support",
                "service@fivesticks.com", "service@fivesticks.com");

        Recipient recipient = Recipient.factory.build(user.getUsername(), user
                .getEmail());

        Message message = Message.factory.build("Password Help", TEXT
                + user.getPassword() + TEXT_SIGN);

        MailManager.singleton.sendSingleMessage(sender, recipient, message);
    }

    protected static Log log = LogFactory.getLog(PasswordHelp.class.getName());

}