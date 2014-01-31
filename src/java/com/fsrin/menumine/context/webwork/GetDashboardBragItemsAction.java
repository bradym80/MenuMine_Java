/*
 * Created on Sep 7, 2006 by Reid
 */
package com.fsrin.menumine.context.webwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fivesticks.common.json.AbstractJSONAction;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.opensymphony.xwork.Action;

public class GetDashboardBragItemsAction extends
        AbstractJSONAction {

    
    
    public String execute() throws Exception {
        
        Collection brag = null;
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        p.getNewItemBrag().setEmpty(Boolean.FALSE);
        p.getMenuItem().setSelect(Boolean.TRUE);
        p.getItemDescription().setSelect(Boolean.TRUE);
        p.getOperationName().setSelect(Boolean.TRUE);
      //  JDL 10-5-07
      //  p.getPrice2006().setSelect(Boolean.TRUE);
        p.getPrice2011().setSelect(Boolean.TRUE);
        
        brag = MasterFoodServiceDelegateFactory.factory.build().searchMasterFoodByHQLConjunction(p);
                
        
        Collection ret = new ArrayList();
        
        String currentHeader = "";
        
        JSONArray mainList = new JSONArray();
        
        JSONArray category = null;
        
        for (Iterator iter = brag.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            
            JSONObject categoryItem = new JSONObject();
            categoryItem.put("menuItemName", element.getMenuItem());
            categoryItem.put("itemDescription", element.getItemDescription());
            categoryItem.put("operationName", element.getOperationName());
            //JDL 10-5-07
          //  categoryItem.put("price", element.getPrice2006());
            categoryItem.put("price", element.getPrice2011());
            mainList.put(categoryItem);
        }
        
        this.setJsonResult(mainList);
        
        return Action.SUCCESS;
    }



    
    
}
