/*
 * Created on Jan 23, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.util.SelectedFieldListBuilder;

/**
 * Responsible for creating MasterFood objects from ObjectArrays
 * 
 * Originally added to enable queries that didn't return the entire object.
 * 
 * @author Reid
 * 
 */
public class MasterFoodBuilder {

    private static Log log = LogFactory.getLog(MasterFoodBuilder.class);

    public Collection buildFromObjectCollection(Collection input,
            MasterFoodFilterParameters params) {

        log.debug("starting to convert object arrays to master foods.");
        
        Collection ognlFields = new SelectedFieldListBuilder()
                .getOgnlNameSet(params);

        Collection ret = null;
        
        if (ognlFields.size() < 2) {
//            throw new RuntimeException(
//                    "fails when there are less than two fields since they aren't returned as an object array.");
            ret = handleSingleFieldStrings(input, ognlFields);
        } else {
            ret = handleObjectArray(input, ognlFields);
        }



        log.debug("completed object array conversion");
        
        return ret;
    }
    
    private Collection handleObjectArray(Collection input, Collection ognlFields) {
        Collection ret = new ArrayList();

        for (Iterator iter = input.iterator(); iter.hasNext();) {

            Object[] element = (Object[]) iter.next();

            ret.add(build(element, ognlFields));
        }
        
        return ret;
    }
    
    private Collection handleSingleFieldStrings(Collection input, Collection ognlFields) {
        Collection ret = new ArrayList();

        for (Iterator iter = input.iterator(); iter.hasNext();) {

//            Object[] element = (Object[]) iter.next();
//            String e = (String) iter.next();
            Object e = iter.next();
            
            Object[] element = { e };

            ret.add(build(element, ognlFields));
        }
        
        return ret;
    }

    public MasterFood build(Object[] object, Collection fields) {
        MasterFood ret = new MasterFood();
        int i = 0;
        for (Iterator iter = fields.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            // log.info("element is " + element + ", object[i] is " +
            // object[i]);
            try {
                Ognl.setValue(element, ret, object[i]);
            } catch (OgnlException e) {
                throw new RuntimeException("how did this get mixed up");
            }

            i++;
        }

        return ret;
    }

}
