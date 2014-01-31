/*
 * Created on Mar 16, 2006
 *
 */
package com.fsrin.menumine.core.menumine.util;

import java.util.Iterator;

import junit.framework.TestCase;
import ognl.Ognl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

public class MasterFoodFilterParametersComparator extends TestCase {

    private Log log = LogFactory.getLog(MasterFoodFilterParametersComparator.class);
    
    public void testForEquality(MasterFoodFilterParameters original, MasterFoodFilterParameters clone) throws Exception {
        
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {

            FieldEnum element = (FieldEnum) iter.next();

            FilterParameter originalParameter = (FilterParameter) Ognl
                    .getValue(element.getOgnlName(), original);

            FilterParameter clonesParameter = (FilterParameter) Ognl.getValue(
                    element.getOgnlName(), clone);

            
            assertEquals(originalParameter.getFieldName(), clonesParameter
                    .getFieldName());

            log.info("Field name " + originalParameter.getFieldName());
            
            for (Iterator iterator = originalParameter.getAndValues()
                    .iterator(); iterator.hasNext();) {
                Object collectionElement = (Object) iterator.next();
                assertTrue(clonesParameter.getAndValues().contains(
                        collectionElement));
            }

            for (Iterator iterator = originalParameter.getInValues().iterator(); iterator
                    .hasNext();) {
                Object collectionElement = (Object) iterator.next();
                assertTrue(clonesParameter.getInValues().contains(
                        collectionElement));
            }

            for (Iterator iterator = originalParameter.getOrValues().iterator(); iterator
                    .hasNext();) {
                Object collectionElement = (Object) iterator.next();
                assertTrue(clonesParameter.getOrValues().contains(
                        collectionElement));
            }

            for (Iterator iterator = originalParameter.getNotValues()
                    .iterator(); iterator.hasNext();) {
                Object collectionElement = (Object) iterator.next();
                assertTrue(clonesParameter.getNotValues().contains(
                        collectionElement));
            }

            assertEquals(originalParameter.isSelect(), clonesParameter
                    .isSelect());

            assertEquals(originalParameter.isFilterEmpty(), clonesParameter
                    .isFilterEmpty());

        }
    }
}
