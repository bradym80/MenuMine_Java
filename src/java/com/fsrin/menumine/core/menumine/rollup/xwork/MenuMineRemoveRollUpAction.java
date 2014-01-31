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

public class MenuMineRemoveRollUpAction extends AbstractRollUpAction  {

    private String target;

    public String execute() throws Exception {
        super.execute();
        Collection rollUp = this.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements();

        String[] targets = target.split("splitme");

        Collection removeList = new ArrayList();

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            
        
        for (Iterator iter = rollUp.iterator(); iter.hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();
            if (element.getTerm().equals(target)) {
                removeList.add(element);
            }
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