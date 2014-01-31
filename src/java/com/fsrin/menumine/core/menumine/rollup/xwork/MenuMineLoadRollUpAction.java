/*
 * Created on 2005-5-13
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.Collection;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegateException;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineLoadRollUpAction extends AbstractRollUpAction {

    private RollUpServiceDelegate rollUpServiceDelegate;

    private String selectRollUpName;

    public String execute() throws Exception {

        super.execute();
        if (this.getSelectRollUpName() != null
                && this.getSelectRollUpName().trim().length() > 0) {

            RollUpOptions options = this.getRollUpServiceDelegate().getByName(
                    this.getSelectRollUpName(),
                    this.getMenuMineSessionContextWrapper()
                            .getMenuMineSessionContext().getAuthenticatedUser()
                            .getUsername());

            if (options == null) {
                this.getMenuMineSessionContextWrapper().getErrorContext().addError("Unable to load the selected roll up.");
                return SUCCESS;
            }

            this.getMenuMineSessionContextWrapper().setRollUpOptions(options);
            
            /*
             * 2006-02-17. RSC added 2006-03-07 RSC Testing for NPE.
             */
            MenuMineSessionContextWrapper wrapper = this
                    .getMenuMineSessionContextWrapper();

            /*
             * 2006-03-08 RSC this threw a couple of NPEs on Larry4.
             */
            MenuMineGraphOptions graphOptions = wrapper.getLastGraphOptions();
            if (graphOptions == null) {
                /*
                 * we're really just looking for a placeholder.
                 */
                graphOptions = new MenuMineGraphOptions();
                wrapper.setLastGraphOptions(graphOptions);
            }
            
            
            FieldEnum targetField = options.getTargetField();

            /*
             * 2006-03-07 RSC Problem with saving fields by name and recalling
             * them by ognlFieldName.
             */
            if (targetField == null) {
                targetField = FieldEnum.getByName(options.getTargetFieldName());
                if (targetField != null) {
                    options.setTargetFieldName(targetField.getOgnlName());
                }
            }

            if (targetField == null) {
                this
                        .getMenuMineSessionContextWrapper()
                        .getErrorContext()
                        .addError(
                                "There was a problem loading your saved roll up.  " +
                                "You should delete this roll up and rebuild it.");
            } else {
                graphOptions.setGraphByField(targetField.getOgnlName());
            }
            // this.getMenuMineSessionContextWrapper().getLastGraphOptions()
            // .setGraphByField(options.getTargetField().getOgnlName());
        }

        // for (Iterator iter = this.getSavedRollUps().iterator();
        // iter.hasNext();) {
        // RollUpOptions element = (RollUpOptions) iter.next();
        //
        // if (element.getName() != null
        // && element.getName().equals(selectRollUpName)) {
        // /*
        // * 2006-02-06 RSC Added this
        // */
        //                
        // this.getMenuMineSessionContextWrapper().setRollUpOptions(
        // element);
        // }
        //
        // }

        return SUCCESS;
    }

    private Collection savedRollUp;

    public Collection getSavedRollUps() {
        if (savedRollUp == null) {
            try {
                /*
                 * 2006-02-05 RSC Switched to simple.
                 */
                // savedRollUp = this.getRollUpServiceDelegate()
                // .getByUserAndGroup(
                // this.getMenuMineSessionContextWrapper()
                // .getMenuMineSessionContext()
                // .getAuthenticatedUser().getUser());
                savedRollUp = this.getRollUpServiceDelegate().getSimpleByUser(
                        this.getMenuMineSessionContextWrapper()
                                .getMenuMineSessionContext()
                                .getAuthenticatedUser().getUsername());
            } catch (RollUpServiceDelegateException e) {
                this.addActionError("Error Retrieving saved");
                e.printStackTrace();
            }
        }
        return savedRollUp;
    }

    public RollUpServiceDelegate getRollUpServiceDelegate() {
        return rollUpServiceDelegate;
    }

    public void setRollUpServiceDelegate(
            RollUpServiceDelegate rollUpServiceDelegate) {
        this.rollUpServiceDelegate = rollUpServiceDelegate;
    }

    public String getSelectRollUpName() {
        return selectRollUpName;
    }

    public void setSelectRollUpName(String selectRollUpName) {
        this.selectRollUpName = selectRollUpName;
    }
}