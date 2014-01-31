/*
 * Created on Jun 27, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;

/**
 * @author Nick
 * 
 *  
 */
public class NationalAccountBenchmarkBuilderTest extends TestCase {

    public void testNationalAccountBenchmarkBuilder() throws Exception {
        Collection results = new MasterFoodDaoMockImpl().findUsingCriteria((MasterFoodFilterParameters)null);

        MenuMineGraphOptions options = new MenuMineGraphOptions();
        options.setGraphByField(FieldEnum.BASIC_PROTEIN.getName());

        RollUpOptions rollUpOptions = new RollUpOptions();

        Collection chainsA = new ArrayList();
        Collection chainsB = new ArrayList();

        chainsA.add("Wendy's");
        chainsB.add("Burger King");

        NationalAccountBenchmarkTable table = new NationalAccountBenchmarkBuilder()
                .buildNationalAccountBenchmarkTableFromCollection(results,
                        options, rollUpOptions, chainsA, chainsB);

        assertNotNull(table.getShareTableA());
        assertNotNull(table.getShareTableB());

        assertEquals(10, table.getShareTableA().getSizeOfSample().longValue());
        assertEquals(4, table.getShareTableA().getRows().size());

        StatisticalTableElementIF rowA0 = (StatisticalTableElementIF) table
                .getShareTableA().getRows().toArray()[0];
        StatisticalTableElementIF rowA1 = (StatisticalTableElementIF) table
                .getShareTableA().getRows().toArray()[1];
        StatisticalTableElementIF rowA2 = (StatisticalTableElementIF) table
                .getShareTableA().getRows().toArray()[2];
        StatisticalTableElementIF rowA3 = (StatisticalTableElementIF) table
                .getShareTableA().getRows().toArray()[3];

        assertEquals(4, rowA0.getNumberInSample().longValue());
        assertEquals(3, rowA1.getNumberInSample().longValue());
        assertEquals(2, rowA2.getNumberInSample().longValue());
        assertEquals(1, rowA3.getNumberInSample().longValue());

        assertEquals(10, table.getShareTableB().getSizeOfSample().longValue());
        assertEquals(4, table.getShareTableB().getRows().size());

        StatisticalTableElementIF rowB0 = (StatisticalTableElementIF) table
                .getShareTableB().getRows().toArray()[0];
        StatisticalTableElementIF rowB1 = (StatisticalTableElementIF) table
                .getShareTableB().getRows().toArray()[1];
        StatisticalTableElementIF rowB2 = (StatisticalTableElementIF) table
                .getShareTableB().getRows().toArray()[2];
        StatisticalTableElementIF rowB3 = (StatisticalTableElementIF) table
                .getShareTableB().getRows().toArray()[3];

        assertEquals(4, rowB0.getNumberInSample().longValue());
        assertEquals(3, rowB1.getNumberInSample().longValue());
        assertEquals(2, rowB2.getNumberInSample().longValue());
        assertEquals(1, rowB3.getNumberInSample().longValue());

    }
}