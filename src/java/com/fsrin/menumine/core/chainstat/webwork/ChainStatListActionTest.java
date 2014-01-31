/*
 * Created on Jan 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat.webwork;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.chainstat.ChainStat;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStatListActionTest extends TestCase {

    public void testSearch() throws Exception {

        ChainStatListAction action = this.getListAction();
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper());

        action.getChainStatFilterParameters().setOperationName("Apple");
        //Empty Options
        action.getChainStatFilterParameters().setSectorName("");
        action.getChainStatFilterParameters().setSegment("");
        action.setSubmit("submit");

        assertEquals(2, action.getDistinctSegments().size());
        assertEquals(2, action.getDistinctSectorNames().size());
        assertEquals(2, action.getDistinctOperationNames().size());

        assertEquals(ChainStatListAction.SUCCESS, action.execute());

        Collection colApple = action.getList();

        assertEquals(2, colApple.size());

        action = this.getListAction();
        action
                .setMenuMineSessionContextWrapper(new MenuMineSessionContextWrapper());

        //Empty Options
        action.getChainStatFilterParameters().setSectorName("");
        action.getChainStatFilterParameters().setSegment("");
        action.setSubmit("submit");

        assertEquals(ChainStatListAction.SUCCESS, action.execute());

        Collection colAll = action.getList();

        assertEquals(2, colAll.size());

        int i = 0;
        for (Iterator iter = colAll.iterator(); iter.hasNext();) {
            ChainStat element = (ChainStat) iter.next();

            if (element.getOperationName().indexOf("Apple") >= 0) {
                i++;
            }
        }

        assertEquals(i, colApple.size());
    }

    protected void setUp() throws Exception {
        super.setUp();
//        JunitSettings.initilizeTestSystem();

    }

    private ChainStatServiceDelegateMockImpl chainStatServiceDelegate = new ChainStatServiceDelegateMockImpl();

    public ChainStatListAction getListAction() {
        ChainStatListAction chainStatListAction = (ChainStatListAction) SpringBeanBroker
                .getBeanFactory().getBean(ChainStatListAction.SPRING_BEAN_NAME);

        chainStatListAction
                .setChainStatServiceDelegate(chainStatServiceDelegate);
        return chainStatListAction;
    }

}