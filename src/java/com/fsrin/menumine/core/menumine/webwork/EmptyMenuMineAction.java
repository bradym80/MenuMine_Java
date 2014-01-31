/*
 * Created on Mar 21, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.opensymphony.xwork.Action;

public class EmptyMenuMineAction extends AbstractMenuMineDisplayAction {

    public String execute() throws Exception {
        super.execute();
        

        
        return Action.SUCCESS;
    }
}
