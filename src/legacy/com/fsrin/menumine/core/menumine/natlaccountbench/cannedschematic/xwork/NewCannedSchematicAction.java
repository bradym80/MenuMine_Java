/*
 * Created on July 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.CannedSchematicImpl;
import com.fsrin.menumine.core.minefields.MineField;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * 
 *  
 */
public class NewCannedSchematicAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware, CannedSchematicModifyContextAware {

    public String execute() throws Exception {

        CannedSchematicImpl cs = new CannedSchematicImpl();
        cs.setName("My Canned Report "
                + (this.getCannedSchematicModifyContext()
                        .getCountOfCannedSchematics() + 1));
        cs.setMineFields(this.getMenuMineSessionContextWrapper()
                .getMineFields());
        cs.setUserName(this.getMenuMineSessionContextWrapper()
                .getAuthenticatedUser().getUsername());
        cs.setGroupName(this.getMenuMineSessionContextWrapper().getUserGroup()
                .getName());

        cs.setIncludeBenchmark(Boolean.TRUE);
        cs.setIncludeBenchmarkTrend(Boolean.TRUE);
        List l = new ArrayList();
        for (Iterator iter = this.getMenuMineSessionContextWrapper()
                .getMineFields().getPrimaryFields().iterator(); iter.hasNext();) {
            MineField element = (MineField) iter.next();
            l.add(element.getOgnlName());

        }
        cs.setFieldKeys(l);
        this.getCannedSchematicModifyContext().setCannedSchematic(cs);

        return SUCCESS;
    }

    private CannedSchematicModifyContext cannedSchematicModifyContext;

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }

    public CannedSchematicModifyContext getCannedSchematicModifyContext() {
        return cannedSchematicModifyContext;
    }

    public void setCannedSchematicModifyContext(
            CannedSchematicModifyContext cannedSchematicModifyContext) {
        this.cannedSchematicModifyContext = cannedSchematicModifyContext;
    }
}