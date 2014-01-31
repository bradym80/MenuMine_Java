/*
 * Created on July 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;

import com.fsrin.menumine.common.crud.xwork.SelectAction;
import com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.CannedSchematic;

/**
 * @author Nick
 * 
 *  
 */
public class SelectCannedSchematicAction extends SelectAction implements
        CannedSchematicModifyContextAware {

    public String execute() throws Exception {

        this.getCannedSchematicModifyContext().setCannedSchematic(
                (CannedSchematic) this.getTargetInstance());

        return SUCCESS;
    }

    private CannedSchematicModifyContext cannedSchematicModifyContext;

    public CannedSchematicModifyContext getCannedSchematicModifyContext() {
        return cannedSchematicModifyContext;
    }

    public void setCannedSchematicModifyContext(
            CannedSchematicModifyContext cannedSchematicModifyContext) {
        this.cannedSchematicModifyContext = cannedSchematicModifyContext;
    }

}