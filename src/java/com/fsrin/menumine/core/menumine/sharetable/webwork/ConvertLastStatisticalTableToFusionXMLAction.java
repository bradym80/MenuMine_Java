/*
 * Created on Apr 14, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.webwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

public class ConvertLastStatisticalTableToFusionXMLAction extends
        AbstractMenuMineSessionContextAwareAction {

    private Collection colors;

    private Iterator colorIterator;

    private String tableKey;

    private StatisticalTableIF currentTable;

    public String execute() throws Exception {

        if (this.getTableKey() == null) {
            this.setCurrentTable(this.getMenuMineSessionContextWrapper()
                    .getLastShareTable());
        } else {
            this.setCurrentTable((StatisticalTableIF) this
                    .getMenuMineSessionContextWrapper().getShareTableMap().get(
                            this.getTableKey()));
        }

        
        colors = new ArrayList();
        colors.add("FF9966");
        colors.add("FF0000");
        colors.add("006F00");
        colors.add("0099FF");
        colors.add("CCCC00");

        return SUCCESS;
    }

    public String getNextColor() {

        if (colorIterator == null) {
            colorIterator = colors.iterator();
        }

        if (!colorIterator.hasNext()) {
            colorIterator = colors.iterator();
        }

        String ret = (String) colorIterator.next();

        return ret;
    }

    public StatisticalTableIF getCurrentTable() {
        return currentTable;
    }

    public void setCurrentTable(StatisticalTableIF currentTable) {
        this.currentTable = currentTable;
    }

    public String getTableKey() {
        return tableKey;
    }

    public void setTableKey(String tableKey) {
        this.tableKey = tableKey;
    }
}
