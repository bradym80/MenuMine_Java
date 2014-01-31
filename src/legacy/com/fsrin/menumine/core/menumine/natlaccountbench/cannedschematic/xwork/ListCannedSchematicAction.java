/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;

import com.fsrin.menumine.common.crud.xwork.ListAction;
import com.fsrin.menumine.common.dao.CriteriaParameters;
import com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.CannedSchematicCriteriaParamerters;

/**
 * @author Nick
 * 
 *  
 */
public class ListCannedSchematicAction extends ListAction implements
        CannedSchematicModifyContextAware {

    private CannedSchematicModifyContext cannedSchematicModifyContext;

    public String execute() throws Exception {

        this.getCannedSchematicModifyContext().setCountOfCannedSchematics(
                this.getList().size());
        return super.execute();
    }

    public CriteriaParameters getCriteriaParameters() {
        CannedSchematicCriteriaParamerters params = new CannedSchematicCriteriaParamerters();

        params.setUserName(this.getMenuMineSessionContextWrapper()
                .getAuthenticatedUser().getUsername());
        params.setGroupName(this.getMenuMineSessionContextWrapper()
                .getUserGroup().getName());
        params.setMineType(this.getMenuMineSessionContextWrapper()
                .getMineFields().getMineType());
        this.setCriteriaParameters(params);

        return super.getCriteriaParameters();
    }

    public CannedSchematicModifyContext getCannedSchematicModifyContext() {
        return cannedSchematicModifyContext;
    }

    public void setCannedSchematicModifyContext(
            CannedSchematicModifyContext cannedSchematicModifyContext) {
        this.cannedSchematicModifyContext = cannedSchematicModifyContext;
    }
}