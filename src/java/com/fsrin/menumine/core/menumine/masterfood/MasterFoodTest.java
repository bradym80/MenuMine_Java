/*
 * Created on Aug 15, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Iterator;

import ognl.Ognl;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */

/*
 * When adding fields add to hbm, MineFields, Field Enum
 * MenuMineFilterParameters add fields, update
 * MasterFoodFilterParametersImpl.applyFields, interface, wrapperImpl and
 * interface and the custom Hibernate Hydrator, fields to display bean including
 * countTotalSelected, keyFinder
 *  
 */
public class MasterFoodTest extends AbstractNonInitializingMenuMineTestCase {

//    public MasterFoodTest() {
//        super();
//
//    }
//
//    public MasterFoodTest(String arg0) {
//        super(arg0);
//
//    }

    public void testMasterFood() throws Exception {

        MasterFood food = new MasterFood();
//        food.setChain(new Chain());
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            String ognlName = element.getOgnlName();
            Ognl.getValue(ognlName, food);
        }
    }

    public void testFilterParams() throws Exception {
        MasterFoodFilterParameters food = new MasterFoodFilterParametersImpl();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            Ognl.getValue(element.getOgnlName(), food);
        }
    }

    public void testFilterParamsWrapper() throws Exception {
        MasterFoodFilterParametersWrapper food = new MasterFoodFilterParametersWrapperImpl();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            Ognl.getValue(element.getOgnlName(), food);
        }
    }

    public void testFilterParamsUpdate() throws Exception {
        MasterFoodFilterParameters food1 = new MasterFoodFilterParametersImpl();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            FilterParameter p = (FilterParameter) Ognl.getValue(element
                    .getOgnlName(), food1);
            p.getAndValues().add("Value1");
        }

        MasterFoodFilterParameters food2 = new MasterFoodFilterParametersImpl();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            FilterParameter p = (FilterParameter) Ognl.getValue(element
                    .getOgnlName(), food2);
            p.getAndValues().add("Value2");
        }

        food1.applyMasterFoodFilterParameters(food2);

        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            FilterParameter p = (FilterParameter) Ognl.getValue(element
                    .getOgnlName(), food1);
            assertEquals("Value2", p.getAndValues().toArray()[0]);

        }

    }

//    public void testKeyFinder() throws Exception {
//
//        StatisticalTableKeyFinderFactory finder = new StatisticalTableKeyFinderFactory();
//        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
//            FieldEnum element = (FieldEnum) iter.next();
//            Ognl.getValue(element.getShortOgnlName(), finder);
//        }
//
//    }

    public void testHydrator() throws Exception {

        //        Collection valuesCol = new TreeSet();
        //        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();)
        // {
        //            FieldEnum element = (FieldEnum) iter.next();
        //            /*
        //             * Excludes Chain params.
        //             */
        //            if (element.getOgnlName().equals(element.getShortOgnlName())) {
        //
        //                valuesCol.add(element.getFriendlyName());
        //            }
        //        }
        //
        //        Object values[] = valuesCol.toArray();
        //
        //        MasterFood food = new MasterFood();
        //
        //        FiveSticksMasterFoodHydrator hydrator = new
        // FiveSticksMasterFoodHydrator();
        //        hydrator.hydrate(food, values);
    }

    public void testFieldsToDisplayBean() throws Exception {
        FieldsToDisplayBean bean = new FieldsToDisplayBean();
        for (Iterator iter = FieldEnum.getAll().iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            Ognl.getValue(element.getShortOgnlName(), bean);
        }

    }

}