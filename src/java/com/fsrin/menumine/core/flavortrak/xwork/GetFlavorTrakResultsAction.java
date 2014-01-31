/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak.xwork;

import org.json.JSONObject;

import com.fsrin.menumine.core.flavortrak.FlavorTrakBuilder;
import com.opensymphony.xwork.Action;

public class GetFlavorTrakResultsAction extends
        AbstractFlavorTrakContextAwareJSONAction {

    public String execute() throws Exception {
        
        FlavorTrakBuilder builder = new FlavorTrakBuilder();
        
        builder.build(this.getFlavorTrakContext());
        
        JSONObject ret = new JSONObject();
        
        ret.put("recordCount", builder.getRecordCount());
        
        //ret.put("wordCount", builder.getWordCount());
        
        this.setJsonResult(ret);
       
        return Action.SUCCESS;
    }
    
}
