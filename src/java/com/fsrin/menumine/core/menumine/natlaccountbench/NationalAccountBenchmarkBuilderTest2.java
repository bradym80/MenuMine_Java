/*
 * Created on Feb 2, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class NationalAccountBenchmarkBuilderTest2 extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory.getLog(NationalAccountBenchmarkBuilderTest2.class);
    
    public void testBasicBuild() throws Exception {

        /*
         * basic
         */
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        /*
         * the group by field
         */
        p.getBasicProtein().setSelect(true);

        /*
         * chain operation name
         */
        p.getOperationName().setSelect(true);



        /*
         * make this a collection real quick.
         */
        Collection data = MasterFoodServiceDelegateFactory.factory.build()
                .searchMasterFoodByHQLConjunction(p);

        assertNotNull(data);

        /*
         * mock session context
         */

        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        
        graphOptions.setGraphByField(FieldEnum.BASIC_PROTEIN.getOgnlName());
        graphOptions.setGraphByType("pie");

        RollUpOptions rollUpOptions = new RollUpOptions();

        Collection chainsTarget = new ArrayList();
        chainsTarget.add("Jasons Deli");

        Collection chainsBenchmark = new ArrayList();
        chainsBenchmark.add("Jasons Deli");
        chainsBenchmark.add("Panera Bread");
        chainsBenchmark.add("Cosi");
        chainsBenchmark.add("Great Wraps");
        
        /*
         * chain filters
         * 2006-03-08 RSC Don't need that.
         */
//        p.getOperationName().getInValues().addAll(chainsTarget);
//        p.getOperationName().getInValues().addAll(chainsBenchmark);        

        NationalAccountBenchmarkBuilder builder = new NationalAccountBenchmarkBuilder();

        NationalAccountBenchmarkTable table = builder
                .buildNationalAccountBenchmarkTableFromCollection(data,
                        graphOptions, rollUpOptions, chainsTarget,
                        chainsBenchmark);

        assertNotNull(table);
        assertNotNull(table.getRows());
        assertTrue(table.getRows().size() > 1); //make sure something is in there.
        assertTrue(table.getRows().toArray()[0] instanceof NationalAccountBenchmarkElement);
        
        for (Iterator iter = table.getRows().iterator(); iter.hasNext();) {
            NationalAccountBenchmarkElement element = (NationalAccountBenchmarkElement) iter.next();
            
            log.info("name: " + element.getName() +", %targ " + element.getPercentOfTarget() + ", %benc " + element.getPercentOfBenchmark());
            
        }
    }
    
    /*
     * 2006-03-08 RSC Testing for a bug.
     */
    public void testBasicBuild_EnsureOperationNamesArentInFilter() throws Exception {

        /*
         * basic
         */
        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getItemDescriptionWithBacon();

        /*
         * the group by field
         */
        p.getBasicProtein().setSelect(true);

        /*
         * chain operation name
         */
        p.getOperationName().setSelect(true);



        /*
         * make this a collection real quick.
         */
        Collection data = MasterFoodServiceDelegateFactory.factory.build()
                .searchMasterFoodByHQLConjunction(p);

        assertNotNull(data);

        /*
         * mock session context
         */

        MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
        
        graphOptions.setGraphByField(FieldEnum.BASIC_PROTEIN.getOgnlName());
        graphOptions.setGraphByType("pie");

        RollUpOptions rollUpOptions = new RollUpOptions();

        Collection chainsTarget = new ArrayList();
        chainsTarget.add("Jasons Deli");

        Collection chainsBenchmark = new ArrayList();
        chainsBenchmark.add("Jasons Deli");
        chainsBenchmark.add("Panera Bread");
        chainsBenchmark.add("Cosi");
        chainsBenchmark.add("Great Wraps");
        
        /*
         * chain filters
         * 2006-03-08 RSC Shouldn't need these.
         */
//        p.getOperationName().getInValues().addAll(chainsTarget);
//        p.getOperationName().getInValues().addAll(chainsBenchmark);        

        NationalAccountBenchmarkBuilder builder = new NationalAccountBenchmarkBuilder();

        NationalAccountBenchmarkTable table = builder
                .buildNationalAccountBenchmarkTableFromCollection(data,
                        graphOptions, rollUpOptions, chainsTarget,
                        chainsBenchmark);

        assertNotNull(table);
        assertNotNull(table.getRows());
        assertTrue(table.getRows().size() > 1); //make sure something is in there.
        assertTrue(table.getRows().toArray()[0] instanceof NationalAccountBenchmarkElement);
        
        for (Iterator iter = table.getRows().iterator(); iter.hasNext();) {
            NationalAccountBenchmarkElement element = (NationalAccountBenchmarkElement) iter.next();
            
            log.info("name: " + element.getName() +", %targ " + element.getPercentOfTarget() + ", %benc " + element.getPercentOfBenchmark());
            
        }
        
        assertTrue(p.getOperationName().getInValues().size()==0);
    }
}
