/*
 * Created on Feb 9, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public class MenuMineDisplayStatisticalTableActionTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        MenuMineDisplayStatisticalTableAction action = (MenuMineDisplayStatisticalTableAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineDisplayStatisticalTableAction.SPRING_BEAN_NAME);

        this.decorateWithGenericContextAndQuery(action);
        
        action.getMenuMineGraphOptions().setGraphByField(FieldEnum.CUISINE.getOgnlName());
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
        
        StatisticalTableIF table = action.getStatisticalTableResults();
        
        assertNotNull(table);

    }
    
    public void testBasic_NoGraphBy() throws Exception {

        MenuMineDisplayStatisticalTableAction action = (MenuMineDisplayStatisticalTableAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineDisplayStatisticalTableAction.SPRING_BEAN_NAME);

        this.decorateWithGenericContextAndQuery(action);
        
        //action.getMenuMineGraphOptions().setGraphByField(FieldEnum.CUISINE.getOgnlName());
        
        String s = action.execute();
        
        assertEquals(Action.SUCCESS,s);
        
        StatisticalTableIF table = action.getStatisticalTableResults();
        
        assertNull(table);
        
        assertTrue(action.hasErrors());

    }
}
