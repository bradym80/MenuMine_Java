/*
 * Created on July 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.common.crud.xwork.EditAction;
import com.fsrin.menumine.common.crud.xwork.WebParameters;
import com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.CannedSchematic;
import com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.CannedSchematicCriteriaParamerters;

/**
 * @author Nick
 * 
 *  
 */
public class EditCannedSchematicAction extends EditAction {

    private CannedSchematicWebParameters cannedSchematicWebParameters = new CannedSchematicWebParameters();

    public String execute() throws Exception {

        if (this.hasActionErrors()) {
            this.getMenuMineSessionContextWrapper().getErrorContext()
                    .addErrors(this.getActionErrors());
            return INPUT;
        }
        return SUCCESS;
    }

    public void validate() {
        if (!(this.getTargetInstance() instanceof CannedSchematic)) {
            this.addActionError("Target in not a Canned Schematic");
        }

        if (!this.isNameUnique()) {
            this.addActionError("Please enter a unique name.");
        }
    }

    private boolean isNameUnique() {

        CannedSchematic cs = (CannedSchematic) this.getTargetInstance();
        CannedSchematicCriteriaParamerters params = new CannedSchematicCriteriaParamerters();
        params.setUserName(this.getMenuMineSessionContextWrapper()
                .getAuthenticatedUser().getUsername());
        params.setName(cs.getName());
        params.setGroupName(this.getMenuMineSessionContextWrapper()
                .getUserGroup().getName());

        Collection col = this.getServiceDelegate().search(params);
        if (col.size() > 0) {
            /*
             * It i just found myself that is fine.
             */
            for (Iterator iter = col.iterator(); iter.hasNext();) {
                CannedSchematic element = (CannedSchematic) iter.next();
                {
                    if (element.getId().equals(cs.getId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public WebParameters getWebParameters() {
        return cannedSchematicWebParameters;
    }

    //        public void setWebParameters(
    //                CannedSchematicWebParameters cannedSchematicWebParameters) {
    //            this.cannedSchematicWebParameters = cannedSchematicWebParameters;
    //        }

    public void applyWebParameters() {

        CannedSchematic cs = (CannedSchematic) this.getTargetInstance();
        CannedSchematicWebParameters params = (CannedSchematicWebParameters) this
                .getWebParameters();

        cs.setIncludeBenchmark(params.getIncludeBenchmark());
        cs.setIncludeBenchmarkTrend(params.getIncludeBenchmarkTrend());
        cs.setIncludeBenchmarkGraph(params.getIncludeBenchmarkGraph());

    }
}