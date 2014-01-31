/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.Collection;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplayStatisticalTableAction;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;

/**
 * @author Nick
 * @version 1
 */

public class MenuMineDisplayBuildRollUpAction extends
        MenuMineDisplayStatisticalTableAction  {

    Log log = LogFactory.getLog(MenuMineDisplayBuildRollUpAction.class
            .getName());
    
    private RollUpServiceDelegate rollUpServiceDelegate;

    public String execute() throws Exception {
        super.execute();

        this.setSpecialFunction(SPECIAL_ROLLUP);
        
        this.getMenuMineDisplayOptions().setDisplayType("Build Roll Up");

        this.getMenuMineSessionContextWrapper().setLastGraphOptions(
                this.getMenuMineGraphOptions());

        String graphByField = null;
        if (this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .getGraphByFieldEnum() != null) {
            graphByField = this.getMenuMineSessionContextWrapper()
                    .getLastGraphOptions().getGraphByFieldEnum()
                    .getFriendlyName();
            graphByField += " " + this.getSavedRollUps().size();

        }

        if (this.getMenuMineSessionContextWrapper().getRollUpOptions()
                .getName() == null
                || this.getMenuMineSessionContextWrapper().getRollUpOptions()
                        .getName().length() == 0) {
            this.getMenuMineSessionContextWrapper().getRollUpOptions().setName(
                    graphByField);
        }

        /*
         * 2006-03-07 RSC Bug.  This was setting the target field to "name" and not "ognlName".
         */
        if (this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .getGraphByFieldEnum() != null) {
            this.getMenuMineSessionContextWrapper().getRollUpOptions()
                    .setTargetFieldName(
                            this.getMenuMineSessionContextWrapper()
                                    .getLastGraphOptions()
                                    .getGraphByFieldEnum().getOgnlName());
        }
        return SUCCESS;
    }

    public Collection getSortedSummary() {
        Collection rollUpElements = new TreeSet(new MMSorter().getAscending(
                "label", "term"));

        rollUpElements.addAll(this.getRollUpOptions().getRollUpElements());
        return rollUpElements;
    }

    /*
     * The RollUpTable combines the Statistical Table with the rollUp Options to
     * help view them together on the screen.
     */
    public RollUpTable getRollUpTable() {
        return RollUpTable.builder.build(this.getRollUpOptions(),this.getStatisticalTableResults() );

    }

    public RollUpOptions getRollUpOptions() {
        return this.getMenuMineSessionContextWrapper().getRollUpOptions();
    }

   
    /*
     * We should change the JSP to use the share table directly. We are
     * circumventing the stat table so we can filter out non-matching rows.
     */
    public Collection getRows() {
        StatisticalTableIF table = super.getStatisticalTableResults();
        Collection rows = table.getRows();

        return rows;
    }



    public RollUpServiceDelegate getRollUpServiceDelegate() {
        return rollUpServiceDelegate;
    }

    public void setRollUpServiceDelegate(
            RollUpServiceDelegate rollUpServiceDelegate) {
        this.rollUpServiceDelegate = rollUpServiceDelegate;
    }

    public Collection getGroups() {
        Collection ret = null;

        ret = UserGroupServiceDelegate.factory.build().getAll();

        return ret;
    }

}