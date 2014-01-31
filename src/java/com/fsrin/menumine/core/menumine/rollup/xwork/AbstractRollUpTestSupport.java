/*
 * Created on Feb 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.util.BuildStatisticalTableFromActionDelegate;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.webwork.AbstractMenuMineDisplayAction;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.opensymphony.xwork.Action;

public abstract class AbstractRollUpTestSupport extends
        AbstractNonInitializingMenuMineTestCase {

    protected void decorateForRollUp(AbstractMenuMineDisplayAction action)
            throws Exception {
        action.getMenuMineGraphOptions().setGraphByField(
                FieldEnum.CUISINE.getOgnlName());
        
        action.getMenuMineGraphOptions().setFilterBelowPercentage(false);

        action.setSubmitOptions("submit");

        action.getMenuMineSessionContextWrapper().setLastShareTable(
                new BuildStatisticalTableFromActionDelegate().build(action));

    }

    protected void executeAddRollUpAction(MenuMineSessionContextWrapper context)
            throws Exception {

        MenuMineAddRollUpAction action = (MenuMineAddRollUpAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineAddRollUpAction.SPRING_BEAN_NAME);

        action.setMenuMineSessionContextWrapper(context);

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

    }
}
