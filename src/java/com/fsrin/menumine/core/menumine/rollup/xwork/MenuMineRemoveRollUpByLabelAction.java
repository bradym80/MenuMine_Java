/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.rollup.RollUpElement;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineRemoveRollUpByLabelAction extends AbstractRollUpAction
         {

    private String target;

    public String execute() throws Exception {
        super.execute();
        Collection rollUp = this.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements();

        Collection removeList = new ArrayList();

        for (Iterator iter = rollUp.iterator(); iter.hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();
            if (element.getLabel().equals(this.getTarget())) {
                removeList.add(element);

            }
        }
        this.getMenuMineSessionContextWrapper().getRollUpOptions()
                .getRollUpElements().removeAll(removeList);

        return SUCCESS;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}