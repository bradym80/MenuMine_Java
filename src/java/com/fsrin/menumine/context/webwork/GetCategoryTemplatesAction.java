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
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.opensymphony.xwork.Action;

public class GetCategoryTemplatesAction extends
        AbstractJSONAction {

    
    
    public String execute() throws Exception {
        
        SavedQueryServiceDelegate sqsd = SavedQueryServiceDelegate.factory.build();
        
        Collection queries = sqsd.getSimpleTemplates();
        
        
        Collection ret = new ArrayList();
        
        String currentHeader = "";
        
        JSONArray mainList = new JSONArray();
        
        
        
        JSONArray category = null;
        
        for (Iterator iter = queries.iterator(); iter.hasNext();) {
            SavedQuery element = (SavedQuery) iter.next();
            
            if (!currentHeader.equals(element.getTemplateGroup())) {
                if (category != null && category.length() > 0) {
                    JSONObject categoryItem = new JSONObject();
                    categoryItem.put("templateGroup", currentHeader);
                    categoryItem.put("templates", category);
                    mainList.put(categoryItem);
                }
                currentHeader = element.getTemplateGroup();
                category = new JSONArray();
            }
        
            JSONObject keyValue = new JSONObject();
            keyValue.put("id", element.getId());
            keyValue.put("name", element.getName());
            category.put(keyValue);

        }
        
        JSONObject categoryItem = new JSONObject();
        categoryItem.put("templateGroup", currentHeader);
        categoryItem.put("templates", category);
        mainList.put(categoryItem);
        
        this.setJsonResult(mainList);
        
        return Action.SUCCESS;
    }



    
    
}
