/*
 * Created on 2005-1-18
 *
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.rollup.RollUpElement;

/**
 * 2006-02-13 RSC Switched to strings. 
 * 
 * @author Nick
 * @version 1
 */

public class AddFilterEliminatorFromRollUpAction extends AbstractRollUpAction
         {

    // private RollUpServiceDelegate rollUpServiceDelegate;

    private String target;

    public String execute() throws Exception {
        super.execute();
        Collection rollUp = this.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements();

        Collection eliminatorList = new ArrayList();
        
        boolean termIsRollUp = false;
        
        for (Iterator iter = rollUp.iterator(); iter.hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();
            if (element.getLabel().equals(this.getTarget())) {
                eliminatorList.add(element.getTerm());
                termIsRollUp = true;
            }
        }
        
        /*
         * 2006-02-13 RSC
         */
        if (!termIsRollUp) {
            eliminatorList.add(this.getTarget());
        }

        MasterFoodFilterParameters filterParameters = this
                .getMenuMineSessionContextWrapper().getLastFilterWrapper()
                .getMasterFoodFilterParameters();

        String groupByField = this.getMenuMineSessionContextWrapper()
                .getLastGraphOptions().getGraphByField();

        Object o = Ognl.getValue(groupByField, filterParameters);
        FilterParameter param = (FilterParameter) o;
        for (Iterator iter = eliminatorList.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            if (element.equalsIgnoreCase("not on menu")) {
                param.setEmpty(Boolean.FALSE);
            } else {
                param.getNotValues().add(element);
            }

        }
         /*
          * Handle the raw database values.
          * 
          * 2006-02-08 RSC Doesn't seem to be working right.  We don't need
          * to add the Target value to the not list.
          */
         if (this.getTarget().equalsIgnoreCase("not on menu")) {
                param.setEmpty(Boolean.FALSE);
            } 
         /*
          * 2006-02-08
          */
//         else {
//                param.getNotValues().add("'" + this.getTarget() + "'");
//            }
        
      
        

        return SUCCESS;
    } //    public RollUpServiceDelegate getRollUpServiceDelegate() {

    //        return rollUpServiceDelegate;
    //    }
    //
    //    public void setRollUpServiceDelegate(
    //            RollUpServiceDelegate rollUpServiceDelegate) {
    //        this.rollUpServiceDelegate = rollUpServiceDelegate;
    //    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}