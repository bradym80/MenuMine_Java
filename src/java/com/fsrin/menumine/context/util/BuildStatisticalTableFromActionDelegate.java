/*
 * Created on Feb 10, 2006 by Reid
 */
package com.fsrin.menumine.context.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.mapping.Array;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.AbstractMenuMineDisplayAction;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;

public class BuildStatisticalTableFromActionDelegate {

    public StatisticalTableIF build(AbstractMenuMineDisplayAction action) {
        try {

            action.getMenuMineSessionContextWrapper().getMineFields()
                    .applyHiddenParams(
                            action.getMenuMineSessionContextWrapper()
                                    .getLastFilterWrapper()
                                    .getMasterFoodFilterParameters());

            return new StatisticalTableBuilder()
                    .buildStatisticalTable_FromAggregation(action
                            .getMenuMineSessionContextWrapper()
                            .getLastFilterWrapper()
                            .getMasterFoodFilterParameters(), action
                            .getMenuMineGraphOptions(), action
                            .getMenuMineSessionContextWrapper()
                            .getRollUpOptions());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Collection buildForDisplayedFields(
            AbstractMenuMineDisplayAction action) {

        Collection ret = new ArrayList();
        ArrayList ar1 = new ArrayList();
        ArrayList ar2 = new ArrayList();

        try {

            action.getMenuMineSessionContextWrapper().getMineFields()
                    .applyHiddenParams(
                            action.getMenuMineSessionContextWrapper()
                                    .getLastFilterWrapper()
                                    .getMasterFoodFilterParameters());

            for (Iterator iter = action.getMenuMineSessionContextWrapper()
                    .getLastFieldsToDisplay().getSelectedOgnlNames().iterator(); iter
                    .hasNext();) {
                String element = (String) iter.next();

                action.getMenuMineGraphOptions().setGraphByField(element);

                StatisticalTableBuilder stb = new StatisticalTableBuilder();
                
                MasterFoodFilterParameters param = action.getMenuMineSessionContextWrapper().getLastFilterWrapper().getMasterFoodFilterParameters();
                MenuMineGraphOptions graphOptions = action.getMenuMineGraphOptions();
                RollUpOptions rollUpOptions = action.getMenuMineSessionContextWrapper().getRollUpOptions();
                
                StatisticalTableIF current = stb.buildStatisticalTable_FromAggregation(param, graphOptions, rollUpOptions);
                
                
                //JDL 05-01-08 Added a check for the main fields
                if(isMainField(current)){
                	ar2.add(0, current);
                	//ret.add(0,current);
                }
                else{
                	ar1.add(current);
                }
                
                action.getMenuMineSessionContextWrapper().getShareTableMap()
                        .put(element, current);
            }
            for(int i = 0; i< mainFields.length; i++){
            	for(int z=0; z< ar2.size(); z++){
            		if(((StatisticalTableIF)ar2.get(z)).getFieldEnum().getName().toString() == mainFields[i]){
            			ar1.add(0,ar2.get(z));
            			break;
            		}
            	}
        		
        	}
            ret = ar1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return ret;
    }
    String[] mainFields = {"marketSegment","cuisine","itemType","menuItemClass","menuPart"};
    
    public Boolean isMainField(StatisticalTableIF current){
    	Boolean pass = false;
    	
    	for(int i = 0; i< mainFields.length; i++){
    		if(current.getFieldEnum().getName().toString() == mainFields[i]){
    			pass = true;
    			break;
    		}
    	}
    	return pass;
    }

    public StatisticalTableIF buildFromFieldCollectionAndParameters(
            MenuMineGraphOptions graphOptions,
            MasterFoodFilterParameters filterParameters,
            AbstractMenuMineSessionContextAwareAction action) throws Exception {

        Collection ret = new ArrayList();

        StatisticalTableIF current = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregationDisjunctive(
                        filterParameters, graphOptions, null);

        /*
         * need this for building a map.
         */
        action.getMenuMineSessionContextWrapper().getShareTableMap().put(
                graphOptions.getGraphByField(), current);

        return current;
    }

    public StatisticalTableIF build(
            AbstractMenuMineSessionContextAwareAction action) {
        try {

            action.getMenuMineSessionContextWrapper().getMineFields()
                    .applyHiddenParams(
                            action.getMenuMineSessionContextWrapper()
                                    .getLastFilterWrapper()
                                    .getMasterFoodFilterParameters());

            return new StatisticalTableBuilder()
                    .buildStatisticalTable_FromAggregation(action
                            .getMenuMineSessionContextWrapper()
                            .getLastFilterWrapper()
                            .getMasterFoodFilterParameters(), action
                            .getMenuMineSessionContextWrapper()
                            .getLastGraphOptions(), action
                            .getMenuMineSessionContextWrapper()
                            .getRollUpOptions());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
