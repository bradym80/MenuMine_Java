/*
 * Created on Mar 7, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegateFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class MasterFoodServiceDelegateImplTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testMultipleSelects() throws Exception {

        Collection chains = ChainServiceDelegateFactory.factory.build().search(
                new ChainFilterParameters());

        int i = 0;

        for (Iterator iter = chains.iterator(); iter.hasNext();) {
            i++;

            if (i > 10) //should be plenty.
                break;

            Chain element = (Chain) iter.next();

            log.info("current chain is " + element.getOperationName());

            MasterFoodFilterParametersImpl p = new MasterFoodFilterParametersImpl();

            p.getOperationName().getAndValues().add(element.getOperationName());

            p.getOperationName().setSelect(true);
            p.getGenMenuPart().setSelect(true);
            p.getPrice1996().setSelect(true);

            Collection food = MasterFoodServiceDelegateFactory.factory.build()
                    .searchMasterFoodByHQLConjunction(p);

        }

    }
}
