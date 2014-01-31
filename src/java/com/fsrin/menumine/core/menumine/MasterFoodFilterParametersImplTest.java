/*
 * Created on Jan 21, 2006
 *
 */
package com.fsrin.menumine.core.menumine;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.util.MasterFoodFilterParametersComparator;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * 2006-01-21 Goal is to check and verify how the system works. added a method
 * to parameters to get a more limited list of what I'm interested in.
 * 
 * @author Reid
 * 
 */
public class MasterFoodFilterParametersImplTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        MasterFoodFilterParametersImpl p = new MasterFoodFilterParametersImpl();

        Collection and = new ArrayList();
        and.add("one");

        /*
         * populate with just two.
         */
        p.getBrand().setAndValues(and);
        p.getBevSize().setAndValues(and);

        /*
         * always returns everything
         * 
         * 2006-02-08 was 88 but is 97 dues to chain field adds.
         * 2006-04-06 RSC 98 due to keywords add.
         * 2006-08-17 reid@fivesticks.com added a bunch of new ones.
         */
        log.info("All size is " + p.getAll().size());
        assertEquals(135, p.getAll().size());

        /*
         * should on
         */
        log.info("All with criteria size " + p.getAllWithCriteria().size());
        assertEquals(2, p.getAllWithCriteria().size());
    }

    public void testClone() throws Exception {

        MasterFoodFilterParameters original = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();
        
        original.getBasicProtein().getAndValues().add("Beef");
        original.getBatterBreadingCoating().getAndValues().add("Bread");
        original.getButterApplication().getInValues().add("Sauce");
        original.getCarboAccompName().getOrValues().add("Pasta");

        MasterFoodFilterParameters clone = original.clone();

        assertTrue(original.getItemDescription().isSelect());
        assertTrue(clone.getItemDescription().isSelect());

        log.info("original " + original);
        log.info("clone " + clone);

        assertNotSame(original, clone);

        log.info("original " + original.getItemDescription());

        log.info("clone " + clone.getItemDescription());

        assertNotSame(original.getItemDescription(), clone.getItemDescription());

        new MasterFoodFilterParametersComparator().testForEquality(original,clone);
        
//        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
//
//            FieldEnum element = (FieldEnum) iter.next();
//
//            FilterParameter originalParameter = (FilterParameter) Ognl
//                    .getValue(element.getOgnlName(), original);
//
//            FilterParameter clonesParameter = (FilterParameter) Ognl.getValue(
//                    element.getOgnlName(), clone);
//
//            assertEquals(originalParameter.getFieldName(), clonesParameter
//                    .getFieldName());
//
//            for (Iterator iterator = originalParameter.getAndValues()
//                    .iterator(); iterator.hasNext();) {
//                Object collectionElement = (Object) iterator.next();
//                assertTrue(clonesParameter.getAndValues().contains(
//                        collectionElement));
//            }
//
//            for (Iterator iterator = originalParameter.getInValues().iterator(); iterator
//                    .hasNext();) {
//                Object collectionElement = (Object) iterator.next();
//                assertTrue(clonesParameter.getInValues().contains(
//                        collectionElement));
//            }
//
//            for (Iterator iterator = originalParameter.getOrValues().iterator(); iterator
//                    .hasNext();) {
//                Object collectionElement = (Object) iterator.next();
//                assertTrue(clonesParameter.getOrValues().contains(
//                        collectionElement));
//            }
//
//            for (Iterator iterator = originalParameter.getNotValues()
//                    .iterator(); iterator.hasNext();) {
//                Object collectionElement = (Object) iterator.next();
//                assertTrue(clonesParameter.getNotValues().contains(
//                        collectionElement));
//            }
//
//            assertEquals(originalParameter.isSelect(), clonesParameter
//                    .isSelect());
//
//            assertEquals(originalParameter.isFilterEmpty(), clonesParameter
//                    .isFilterEmpty());
//
//        }

    }

}
