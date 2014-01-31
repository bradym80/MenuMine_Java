/*
 * Created on Feb 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import java.util.Iterator;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.util.BuildStatisticalTableFromActionDelegate;
import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.opensymphony.xwork.Action;

public class MenuMineAddRollUpActionTest extends AbstractRollUpTestSupport {

    public void testBasic_Input() throws Exception {

        MenuMineAddRollUpAction action = (MenuMineAddRollUpAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineAddRollUpAction.SPRING_BEAN_NAME);

        this.decorateWithGenericContextAndQuery(action);

        this.decorateForRollUp(action);
        
        /*
         * this will cause it to initialize.
         */
        action.getRollUpParameters();

        String s = action.execute();

        assertEquals(Action.INPUT, s);

    }

    public void testBasic_Success() throws Exception {

        MenuMineAddRollUpAction action = (MenuMineAddRollUpAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineAddRollUpAction.SPRING_BEAN_NAME);

        this.decorateWithGenericContextAndQuery(action);

        this.decorateForRollUp(action);
        
        /*
         * this will cause it to initialize.
         */
        action.getRollUpParameters();

        String[] terms = { "Chinese", "European" };

        action.getRollUpParameters().setTerms(terms);
        action.getRollUpParameters().setRollUpLabel("test");

        String s = action.execute();

        assertEquals(Action.SUCCESS, s);

        StatisticalTableIF tableAfter = new BuildStatisticalTableFromActionDelegate()
                .build(action);

        /*
         * should roll up two terms into one.
         */
        assertTrue(action.getMenuMineSessionContextWrapper()
                .getLastShareTable().getRows().size() == tableAfter.getRows()
                .size() + 1);

        /*
         * some quick checks on the rollup
         */
        for (Iterator iter = action.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements().iterator(); iter
                .hasNext();) {
            RollUpElement element = (RollUpElement) iter.next();
            assertEquals(element.getLabel(), "test");
            assertTrue(element.getTerm().equalsIgnoreCase("chinese")
                    || element.getTerm().equalsIgnoreCase("european"));
        }

    }

}
