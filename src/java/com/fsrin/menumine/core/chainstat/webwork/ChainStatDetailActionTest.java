/*
 * Created on Jan 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat.webwork;

import java.util.Collection;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * 2006-02-07 RSC Updated to AbstractNon...
 * @author Reid
 * @author Nick
 * 
 *  
 */
public class ChainStatDetailActionTest extends AbstractNonInitializingMenuMineTestCase {

    public void testViewDetailAction() throws Exception {

        ChainStatListAction action = this.getListAction();
        action.getChainStatFilterParameters().setOperationName("Apple");
        action.setSubmit("Submit");
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper());

        assertEquals(2, action.getDistinctSegments().size());
        assertEquals(2, action.getDistinctSectorNames().size());
        assertEquals(2, action.getDistinctOperationNames().size());

        assertEquals(ChainStatListAction.SUCCESS, action.execute());

        Collection colApple = action.getList();

        assertEquals(2, colApple.size());

        ChainStat chainStat = (ChainStat) colApple.toArray()[0];

        ChainStatDetailAction detailAction = this.getDetailAction();

        detailAction.setTarget(chainStat.getId());

        assertEquals(ChainStatDetailAction.SUCCESS, detailAction.execute());

        ChainStat fromAction = detailAction.getChainStat();

        assertNotNull(fromAction);
        assertEquals(fromAction.getOperationName(), chainStat.getOperationName());
        assertEquals(fromAction.getId(), chainStat.getId());

    }

//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystem();
//
//    }

    private ChainStatServiceDelegateMockImpl chainStatServiceDelegate = new ChainStatServiceDelegateMockImpl();

    public ChainStatListAction getListAction() {
        ChainStatListAction chainStatListAction = (ChainStatListAction) SpringBeanBroker
                .getBeanFactory().getBean(ChainStatListAction.SPRING_BEAN_NAME);
        chainStatListAction
                .setChainStatServiceDelegate(chainStatServiceDelegate);
        return chainStatListAction;
    }

    public ChainStatDetailAction getDetailAction() {
        ChainStatDetailAction chainStatDetailAction = (ChainStatDetailAction) SpringBeanBroker
                .getBeanFactory().getBean(
                        ChainStatDetailAction.SPRING_BEAN_NAME);
        chainStatDetailAction
                .setChainStatServiceDelegate(chainStatServiceDelegate);
        return chainStatDetailAction;
    }

}