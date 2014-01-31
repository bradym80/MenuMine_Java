/*
 * Created on Jun 28, 2006
 *
 */
package com.fivesticks.common.json;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class ObjectToJSONConverter {

    public JSONObject convert(Object customer) throws Exception {

        JSONObject ret = new JSONObject();

        Class c = customer.getClass();

        Method[] publicFields = c.getMethods();
        Object[] args = {};

        for (int i = 0; i < publicFields.length; i++) {

            if (publicFields[i].getName().startsWith("get")
                    || publicFields[i].getName().startsWith("is")) {
                String fieldName = publicFields[i].getName();
                if (!fieldName.equalsIgnoreCase("getClass")
                        && !fieldName.equalsIgnoreCase("getOwnerKey")) {
                    if (fieldName.startsWith("get")) {
                        fieldName = fieldName.substring(3);
                    } else {
                        fieldName = fieldName.substring(2);
                    }
                    fieldName = fieldName.substring(0,1).toLowerCase() + fieldName.substring(1);
                    ret.put(fieldName, publicFields[i].invoke(customer,args));
                }
            }

        }

        return ret;

    }
    
    public JSONArray convertCollection(Collection c) throws Exception {
        
        JSONArray ret = new JSONArray();
        
        for (Iterator iter = c.iterator(); iter.hasNext();) {
            Object element = (Object) iter.next();
            
            if (element instanceof Collection) {
                throw new RuntimeException("only simple objects, please");
            }
            
            ret.put(this.convert(element));
        }
        
        
        
        return ret;
        
    }
}
