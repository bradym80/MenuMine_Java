/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.common;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class FilterParameterDaoTest extends AbstractNonInitializingMenuMineTestCase {

    public void testFilterDAO() throws Exception {
        FilterParameter filterParameter = new FilterParameter();

        filterParameter
                .setFieldName(FieldEnum.BASIC_PROTEIN.getShortOgnlName());
        filterParameter.setEmpty(Boolean.TRUE);
        filterParameter.getAndValues().add("One");
        filterParameter.getAndValues().add("two");

        filterParameter.getOrValues().add("three");
        filterParameter.getOrValues().add("four");

        filterParameter.getNotValues().add("five");
        filterParameter.getNotValues().add("six");

        filterParameter.getInValues().add("seven");
        filterParameter.getInValues().add("eight");

        filterParameter = FilterParameterDao.factory.build().save(
                filterParameter);

        Long id = filterParameter.getId();
        
        filterParameter = null;

        FilterParameter filterParameterReload = FilterParameterDao.factory
                .build().get(id);
        assertNotNull(filterParameterReload);
        assertEquals(2, filterParameterReload.getAndValues().size());

        /*
         * If we change the collection does it hold up?
         */
//        Collection col = new ArrayList();
//        col.add("param1");
//        col.add("param2");
        filterParameterReload.getAndValues().add("param3");
        filterParameterReload.getAndValues().add("param4");
        //   filterParameterReload.getAndValues().add("New Param");
//        filterParameterReload.setAndValues(col);
        filterParameterReload = FilterParameterDao.factory.build().save(
                filterParameterReload);
        
        filterParameterReload = null;
        
        filterParameterReload = FilterParameterDao.factory.build().get(id);
        assertNotNull(filterParameterReload);
        assertEquals(4, filterParameterReload.getAndValues().size());

        
        FilterParameterDao.factory.build().delete(filterParameterReload);
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();

    }
}