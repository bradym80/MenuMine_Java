/*
 * Created on Oct 1, 2004 by Reid
 */
package com.fstx.stdlib2.authen.webwork;

import com.fsrin.menumine.common.util.ValidationHelper;
import com.fsrin.menumine.messages.PasswordHelp;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserDao;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Reid
 */
public class PasswordHelpAction extends ActionSupport {

    // private SessionContext sessionContext;

    private String targetEmail;

    private String submitPasswordHelp;

    public String execute() throws Exception {

        if (this.getSubmitPasswordHelp() == null)
            return INPUT;

        ValidationHelper helper = new ValidationHelper();

        if (helper.isStringEmpty(this.getTargetEmail())) {
            this.addFieldError("targetEmail",
                    "Email address is required to receive password help.");
            return INPUT;
        }

        UserDao bd = UserDao.factory.build();

        User foundUser = null;

        try {
            foundUser = bd.getUserByEmail(this.getTargetEmail());
        } catch (Exception e) {
            this.addFieldError("targetEmail", "That email is not valid.");
            return INPUT;
        }

        PasswordHelp ph = new PasswordHelp();
        ph.sendPasswordHelp(this.getTargetEmail());

        return SUCCESS;
    }

    //    /**
    //     * @return Returns the sessionContext.
    //     */
    //    public SessionContext getSessionContext() {
    //        return sessionContext;
    //    }
    //
    //    /**
    //     * @param sessionContext
    //     * The sessionContext to set.
    //     */
    //    public void setSessionContext(SessionContext sessionContext) {
    //        this.sessionContext = sessionContext;
    //    }

    /**
     * @return Returns the targetEmail.
     */
    public String getTargetEmail() {
        return targetEmail;
    }

    /**
     * @param targetEmail
     *            The targetEmail to set.
     */
    public void setTargetEmail(String targetEmail) {
        this.targetEmail = targetEmail;
    }

    /**
     * @return Returns the submitPasswordHelp.
     */
    public String getSubmitPasswordHelp() {
        return submitPasswordHelp;
    }

    /**
     * @param submitPasswordHelp
     *            The submitPasswordHelp to set.
     */
    public void setSubmitPasswordHelp(String submitPasswordHelp) {
        this.submitPasswordHelp = submitPasswordHelp;
    }
}