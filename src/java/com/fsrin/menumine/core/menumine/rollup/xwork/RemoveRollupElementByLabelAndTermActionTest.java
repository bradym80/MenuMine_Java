/*
 * Created on Feb 10, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.rollup.xwork;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.core.menumine.rollup.RollUpElement;
import com.opensymphony.xwork.Action;

public class RemoveRollupElementByLabelAndTermActionTest extends
        AbstractRollUpTestSupport {

    public void testBasic() throws Exception {

        RemoveRollupElementByLabelAndTermAction action = (RemoveRollupElementByLabelAndTermAction) SpringBeanBroker
                .getBeanFactory()
                .getBean(
                        RemoveRollupElementByLabelAndTermAction.SPRING_BEAN_NAME);

        this.decorateWithGenericContextAndQuery(action);

        this.decorateForRollUp(action);

        this.executeAddRollUpAction(action.getMenuMineSessionContextWrapper());

        assertEquals(2, action.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements().size());

        /*
         * let's just execute it and make sure it does nothing.
         */

        assertEquals(Action.SUCCESS, action.execute());

        assertEquals(2, action.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements().size());

        /*
         * ok now lets remove one of them.
         */
        RollUpElement element = (RollUpElement) action
                .getMenuMineSessionContextWrapper().getRollUpOptions()
                .getRollUpElements().toArray()[0];

        action.setTargetLabel(element.getLabel());
        
        action.setTargetTerm(element.getTerm());
        
        assertEquals(Action.SUCCESS, action.execute());

        assertEquals(1, action.getMenuMineSessionContextWrapper()
                .getRollUpOptions().getRollUpElements().size());
        
    }
}
