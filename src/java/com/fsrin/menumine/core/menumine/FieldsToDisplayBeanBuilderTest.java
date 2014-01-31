/*
 * Created on Jan 23, 2006
 *
 */
package com.fsrin.menumine.core.menumine;

import junit.framework.TestCase;

/**
 * basic testing, not exhaustive.  Should generally work fine.
 * 
 * @author Reid
 *
 */
public class FieldsToDisplayBeanBuilderTest extends TestCase {

    public void testBasic() throws Exception {
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        
        p.getItemDescription().setSelect(true);
        p.getBasicProtein().setSelect(true);
        p.getBatterBreadingCoating().setSelect(true);
        
        FieldsToDisplayBean display = new FieldsToDisplayBeanBuilder().build(p);
        
        assertTrue(display.getItemDescription().booleanValue());
        assertTrue(display.getBasicProtein().booleanValue());
        assertTrue(display.getBatterBreadingCoating().booleanValue());
        
        assertTrue(!display.getBevSize().booleanValue());
        assertTrue(!display.getBrand().booleanValue());
        
        
    }
    
    public void testDisplayToFilterParams() throws Exception {
        
        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
        
        FieldsToDisplayBean display = new FieldsToDisplayBean();
        
        display.setItemDescription(Boolean.TRUE);
        
        display.setGenMenuPart(Boolean.TRUE);
        
        display.setBreadUse(Boolean.TRUE);
        
        assertTrue(!p.getItemDescription().isSelect());
        assertTrue(!p.getGenMenuPart().isSelect());
        assertTrue(!p.getBreadUse().isSelect());
        
        new FieldsToDisplayBeanBuilder().decorateParams(display,p);
        
        assertTrue(p.getItemDescription().isSelect());
        assertTrue(p.getGenMenuPart().isSelect());
        assertTrue(p.getBreadUse().isSelect());        
        
        /*
         * do some double check about other fields.--make sure nothing
         * interesting has happened to them.
         */
        assertTrue(!p.getCheeseMM().isSelect());
        assertTrue(!p.getCuisine().isSelect());
    }
}
