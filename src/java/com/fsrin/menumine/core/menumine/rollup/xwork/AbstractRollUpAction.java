/*
 * Created on Mar 11, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import com.fsrin.menumine.core.menumine.webwork.AbstractMenuMineDisplayAction;
import com.opensymphony.xwork.Action;

public abstract class AbstractRollUpAction extends
        AbstractMenuMineDisplayAction {

    public String execute() throws Exception {
        this.setSpecialFunction(AbstractMenuMineDisplayAction.SPECIAL_ROLLUP);
        return Action.SUCCESS;
    }
}
