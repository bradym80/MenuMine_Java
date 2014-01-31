/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.util.RollUpParameters;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineAddRollUpAction extends AbstractRollUpAction {

    public static final String SPRING_BEAN_NAME = "menuMineAddRollUpAction";

    private RollUpParameters rollUpParameters;

    public String execute() throws Exception {
        super.execute();
        int i = 0;
        if (rollUpParameters.getRollUpLabel() == null
                || rollUpParameters.getRollUpLabel().length() < 1) {
            this.addActionError("Please enter a \"Roll Up As:\" label ");
        }
        if (rollUpParameters.getTerms() == null) {
            this.addActionError("Please select terms to roll up");
        }

        if (this.hasActionErrors()) {
            return INPUT;
        }

        RollUpOptions options = this.getMenuMineSessionContextWrapper().getRollUpOptions();
        
        for (int j = 0; j < rollUpParameters.getTerms().length; j++) {

            String term = rollUpParameters.getTerms()[j];
            /*
             * Delete current term useage
             */
            boolean update = updateRollUpsByLabel(term, rollUpParameters
                    .getRollUpLabel());

            if (!update) {

                Collection rollUp = options.getRollUpElements();

                Collection removeList = new ArrayList();

                for (Iterator iter = rollUp.iterator(); iter.hasNext();) {
                    RollUpElement element = (RollUpElement) iter.next();
                    if (element.getTerm().equals(term)) {
                        removeList.add(element);
                    }
                }
                options
                        .getRollUpElements().removeAll(removeList);

                /*
                 * End Delete
                 */

                RollUpElement rollUpOptions = new RollUpElement();

                rollUpOptions.setTerm(term.trim());
                rollUpOptions.setLabel(rollUpParameters.getRollUpLabel());

                options
                        .getRollUpElements().add(rollUpOptions);
            }
        }

        this.getMenuMineSessionContextWrapper().setRollUpOptions(options);
        
        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setSimpleFilter(null);

        // StringBuffer buffer = new StringBuffer();
        // for (Iterator iter = this.getMenuMineSessionContextWrapper()
        // .getRollUpOptions().getRollUpElements().iterator(); iter
        // .hasNext();) {
        // RollUpElement element = (RollUpElement) iter.next();
        // buffer.append(element.getTerm()).append(":").append(
        // element.getLabel()).append(", ");
        //
        // }
        // this.getMenuMineSessionContextWrapper().getLastGraphOptions()
        // .setRollUpTerms(buffer.toString());
        return SUCCESS;
    }

    private boolean updateRollUpsByLabel(String oldLabel, String newLabel) {
        /*
         * Since we don't know if the 'term' we are given is an existing label
         * or term from the original data, we check to see if we find an
         * existing, label with the same name, then relable it. We keep track of
         * if this is an updated lable so we don't create useless label for the
         * old lable.
         * 
         */
        boolean updated = false;

        for (Iterator iter = this.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements().iterator(); iter
                .hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();
            {
                if (element.getLabel().equals(oldLabel)) {
                    element.setLabel(newLabel);
                    updated = true;
                }
            }

        }
        return updated;
    }

    private boolean isRollUpTermALabel(String name) {
        for (Iterator iter = this.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements().iterator(); iter
                .hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();
            {
                if (element.getLabel().equals(name)) {
                    return true;
                }
            }

        }
        return false;
    }

    public RollUpParameters getRollUpParameters() {
        if (rollUpParameters == null) {
            StatisticalTableIF table = this.getMenuMineSessionContextWrapper()
                    .getLastShareTable();
            rollUpParameters = new RollUpParameters(table.getRows().size());
        }
        return rollUpParameters;
    }

    public void setRollUpParameters(RollUpParameters rollUpParameters) {
        this.rollUpParameters = rollUpParameters;
    }
}