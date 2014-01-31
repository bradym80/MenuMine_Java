/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineSaveRollUpAction extends AbstractRollUpAction {

    private RollUpServiceDelegate rollUpServiceDelegate;

    private String saveName;

    private String groupName;

    private String submitUpdate;

    private String submitSave;

    public String execute() throws Exception {
        super.execute();
        String username = this.getMenuMineSessionContextWrapper()
                .getMenuMineSessionContext().getAuthenticatedUser()
                .getUsername();

        if (submitSave != null && submitSave.length() > 0) {

            RollUpOptions rollUp = this.getMenuMineSessionContextWrapper()
                    .getRollUpOptions();

            /*
             * We should make sure this name has not been used by the user.
             */
            RollUpOptions testRollUp = this.getRollUpServiceDelegate()
                    .getByName(this.saveName, username);
            if (testRollUp != null) {
                this
                        .getMenuMineSessionContextWrapper()
                        .getErrorContext()
                        .addError("Name already used.  Cannot save new Roll Up");

                return INPUT;
            }

            /*
             * If we are saving a new copy, we just set the ID to null.
             */

            if (rollUp.getId() != null) {
                rollUp = this.copy(rollUp);
            }

            rollUp.setName(this.saveName);
            rollUp.setUserName(username);
            rollUp.setGroupName(this.getGroupName());
            rollUp.setPermission(RollUpOptions.GROUP_QUERY_PERMISSION
                    .intValue());

            this.getRollUpServiceDelegate().save(rollUp);
            this.getMenuMineSessionContextWrapper().setRollUpOptions(rollUp);
        }

        if (submitUpdate != null && submitUpdate.length() > 0) {

            RollUpOptions rollUp = this.getMenuMineSessionContextWrapper()
                    .getRollUpOptions();

            if (rollUp.getId() == null) {
                this.addActionError("Cannot update an unsaved Roll Up");
                return INPUT;
            }
            //           
            rollUp.setName(this.saveName);
            /*
             * When we update we don't want to change the username. This would
             * allow other users to "steal" a rollup.
             */
            // rollUp.setUserName(username);
            rollUp.setGroupName(this.getGroupName());
            rollUp.setPermission(RollUpOptions.GROUP_QUERY_PERMISSION
                    .intValue());

            // rollUp.setUserName(username);
            // rollUp.setPermission(1);

            this.getRollUpServiceDelegate().save(rollUp);

        }

        return SUCCESS;
    }

    private RollUpOptions copy(RollUpOptions rollUp) {
        RollUpOptions options = new RollUpOptions();
        options.setGroupName(rollUp.getGroupName());
        options.setName(rollUp.getName());
        options.setPermission(rollUp.getPermission());
        options.setUserName(rollUp.getUserName());
        options.setTargetFieldName(rollUp.getTargetFieldName());
        options.setOtherItemRollUpType(rollUp.getOtherItemRollUpType());

        for (Iterator iter = rollUp.getRollUpElements().iterator(); iter
                .hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();
            RollUpElement copyElement = new RollUpElement();
            copyElement.setLabel(element.getLabel());
            copyElement.setTerm(element.getTerm());
            options.getRollUpElements().add(copyElement);
        }

        return options;
    }

    public RollUpServiceDelegate getRollUpServiceDelegate() {
        return rollUpServiceDelegate;
    }

    public void setRollUpServiceDelegate(
            RollUpServiceDelegate rollUpServiceDelegate) {
        this.rollUpServiceDelegate = rollUpServiceDelegate;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getSubmitSave() {
        return submitSave;
    }

    public void setSubmitSave(String submitSave) {
        this.submitSave = submitSave;
    }

    public String getSubmitUpdate() {
        return submitUpdate;
    }

    public void setSubmitUpdate(String submitUpdate) {
        this.submitUpdate = submitUpdate;
    }

    public String getGroupName() {

        String myGroupName = this.getMenuMineSessionContextWrapper()
                .getUserGroup().getName();

        /*
         * Only admins can change the group a roll up belongs to. If this user
         * is not admin we make sure the group belongs to the user.
         */
        if (!this.getMenuMineSessionContextWrapper().isAdminRights()) {
            this.setGroupName(myGroupName);
        } else {
            /*
             * Even if we are an admin we may not have chosen a group.
             */
            if (groupName == null || groupName.length() == 0) {
                this.setGroupName(myGroupName);
            }
        }

        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}