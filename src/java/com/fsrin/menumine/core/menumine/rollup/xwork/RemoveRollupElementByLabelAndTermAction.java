/*
 * Created on Feb 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.Iterator;

import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.opensymphony.xwork.Action;

public class RemoveRollupElementByLabelAndTermAction extends
        AbstractRollUpAction {

    public static final String SPRING_BEAN_NAME = "rollUpRemoveElementByLabelAndTermAction";

    private String targetLabel;

    private String targetTerm;

    public String execute() throws Exception {

        super.execute();
        
        if (this.getTargetLabel() == null || this.targetTerm == null) {
            return Action.SUCCESS;
        }

        RollUpOptions options = this.getMenuMineSessionContextWrapper()
                .getRollUpOptions();

        for (Iterator iter = options.getRollUpElements().iterator(); iter
                .hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();

            if (element.getLabel().equalsIgnoreCase(this.getTargetLabel())
                    && element.getTerm().equalsIgnoreCase(this.getTargetTerm())) {
                options.getRollUpElements().remove(element);
                break;
            }

        }

        return Action.SUCCESS;
    }

    public String getTargetLabel() {
        return targetLabel;
    }

    public void setTargetLabel(String targetLabel) {
        this.targetLabel = targetLabel;
    }

    public String getTargetTerm() {
        return targetTerm;
    }

    public void setTargetTerm(String targetTerm) {
        this.targetTerm = targetTerm;
    }
}
