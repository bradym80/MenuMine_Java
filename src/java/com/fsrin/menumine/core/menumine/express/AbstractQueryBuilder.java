/*
 * Created on Jan 20, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.common.util.MenuMineUtil;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;

/**
 * 2006-01-20 Result of a refactor.
 * 
 * @author Reid
 *
 */
public abstract class AbstractQueryBuilder {

    private String expressSearchQuery = null;
    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    protected Collection buildTokens() {
        Collection tokens = new ArrayList();
    
        String[] tokensArray = this.getExpressSearchQuery().split("[\\s]");
        for (int i = 0; i < tokensArray.length; i++) {
            String string = tokensArray[i];
            if (!MenuMineUtil.isEmpty(string)) {
                if (string.charAt(0) == '"') {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(string).append(" ");
                    i++;
                    for (; i < tokensArray.length; i++) {
                        string = tokensArray[i];
                        if (MenuMineUtil.isEmpty(string)) {
                            continue;
                        }
                        if (string.charAt(string.length() - 1) == '"') {
                            buffer.append(string).append(" ");
                            break;
                        } else {
                            buffer.append(string).append(" ");
                        }
                    }
                    String tok = buffer.toString().replace('"', ' ').trim();
    
                    tokens.add(tok);
                } else {
                    tokens.add(string);
                }
            }
        }
    
        return tokens;
    }

    protected Collection filterTokens(Collection tokens) {
    
        Collection filteredTokens = new ArrayList();
    
        for (Iterator iter = tokens.iterator(); iter.hasNext();) {
            String element = (String) iter.next();
    
            if (element.length() > 1) {
                filteredTokens.add(element);
            }
        }
    
        return filteredTokens;
    }

    protected Collection cleanTokens(Collection tokenCollection) {
    
        Collection cleanedTokens = new ArrayList();
    
        for (Iterator iter = tokenCollection.iterator(); iter.hasNext();) {
            String element = (String) iter.next();
    
            if (element.endsWith(",")) {
                int index = element.indexOf(',');
    
                element = element.replace(',', ' ');
    
            }
    
            String cleaned = element.trim();
    
            cleanedTokens.add(cleaned);
    
        }
    
        return cleanedTokens;
    }



    public String getExpressSearchQuery() {
        return expressSearchQuery;
    }

    public void setExpressSearchQuery(String expressSearchQuery) {
        if (MenuMineUtil.isEmpty(this.expressSearchQuery)) {
            this.expressSearchQuery = expressSearchQuery;
        } else {
            throw new RuntimeException(
                    "Attempting to modify Express Search Query.");
        }
    }

    // public FieldsToDisplayBean getProjectedFieldsToDisplay() {
    //
    // return this.expressFieldsToDisplayBean;
    // }
    
    public MasterFoodServiceDelegate getMasterFoodServiceDelegate() {
        return masterFoodServiceDelegate;
    }

    public void setMasterFoodServiceDelegate(
            MasterFoodServiceDelegate masterFoodServiceDelegate) {
        this.masterFoodServiceDelegate = masterFoodServiceDelegate;
    }
}
