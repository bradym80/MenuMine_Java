/*
 * Created on Jun 15, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class CriteriaBuilderTest extends AbstractNonInitializingMenuMineTestCase {

    public void testPrices() throws Exception {

        MasterFoodCriteriaBuilder builder = new MasterFoodCriteriaBuilder();
        MasterFoodFilterParameters mf = new MasterFoodFilterParametersImpl();
        mf.getPrice2004().setEmpty(Boolean.FALSE);
        
        CriteriaMockImpl criteria = new CriteriaMockImpl();
        builder.buildCriteria(criteria, mf);
        
        log.info("criteria is: " + criteria);

        assertEquals(2, criteria.criterions.size());
    }

}