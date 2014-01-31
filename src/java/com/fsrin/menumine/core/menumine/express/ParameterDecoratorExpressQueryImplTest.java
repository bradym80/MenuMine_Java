/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class ParameterDecoratorExpressQueryImplTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {
        
        String query = "chicken";
        
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();
        
        ParameterDecorator dec = ParameterDecoratorFactory.factory.buildExpressItemDescription(params);
        
        assertTrue(!params.getItemDescription().hasAnds());
        
        dec.decorate(query);
        
        assertTrue(params.getItemDescription().hasAnds());
        
        assertTrue(params.getItemDescription().getAndValues().size() == 1);
    }
    
    public void testBasic_MoreItems() throws Exception {
        
        String query = "chicken shrimp cheese tarragon";
        
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();
        
        ParameterDecorator dec = ParameterDecoratorFactory.factory.buildExpressItemDescription(params);
        
        assertTrue(!params.getItemDescription().hasAnds());
        
        dec.decorate(query);
        
        assertTrue(params.getItemDescription().hasAnds());
        
        assertTrue(params.getItemDescription().getAndValues().size() == 4);
    }
    
    public void testBasic_MoreItems_filtering() throws Exception {
        
        String query = "chicken a shrimp cheese tarragon";
        
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();
        
        ParameterDecorator dec = ParameterDecoratorFactory.factory.buildExpressItemDescription(params);
        
        assertTrue(!params.getItemDescription().hasAnds());
        
        dec.decorate(query);
        
        assertTrue(params.getItemDescription().hasAnds());
        
        assertTrue(params.getItemDescription().getAndValues().size() == 4);
    }
}
