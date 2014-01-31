/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.test;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.core.incidence.IncidenceSector;
import com.fsrin.menumine.core.incidence.IncidenceSegment;
import com.fsrin.menumine.core.incidence.IncidenceTable;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptions;
import com.fsrin.menumine.core.incidence.IncidenceTableBuildOptionsWithChains;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.chain.ChainDao;
import com.fsrin.menumine.core.menumine.chain.ChainFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;
import com.fsrin.menumine.core.menumine.webwork.util.MenuMineResultsDisplayWrapperBuilder;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 */
public class BuildIncidenceTableTest_Legacy extends AbstractNonInitializingMenuMineTestCase {

    private Collection results;

    private Collection chainsCollection;

    public MasterFoodDao getDao() {
        return (MasterFoodDao) SpringBeanBroker.getBeanFactory().getBean(
                MasterFoodDao.SPRING_BEAN_NAME);
    }

    public ChainDao getChainDao() {
        return (ChainDao) SpringBeanBroker.getBeanFactory().getBean(
                ChainDao.SPRING_BEAN_NAME);
    }

    protected void setUp() throws Exception {
        super.setUp();
        Chain[] chains = new Chain[4];
        Chain chainTemp = new Chain();

        /*
         * 
         * 
         * 
         * 
         * 
         * Sector1 500
         * 
         * *Segment1 500
         * 
         * **Chain0 250
         * 
         * **Chain1 250
         * 
         * 
         * 
         * 
         * 
         * Sector2 500
         * 
         * 
         * *Segment2 250
         * 
         * 
         * **Chain2 250
         * 
         * 
         * *Segment3 250
         * 
         * 
         * **Chain3 250
         */

        chainTemp.setOperationName("Chain0");
        chainTemp.setSectorName("Sector1");
        chainTemp.setSegment("Segment1");
        this.getChainDao().save(chainTemp);
        chains[0] = chainTemp;

        chainTemp = new Chain();

        chainTemp.setOperationName("Chain1");
        chainTemp.setSectorName("Sector1");
        chainTemp.setSegment("Segment1");
        this.getChainDao().save(chainTemp);
        chains[1] = chainTemp;

        chainTemp = new Chain();

        chainTemp.setOperationName("Chain2");
        chainTemp.setSectorName("Sector2");
        chainTemp.setSegment("Segment2");
        this.getChainDao().save(chainTemp);
        chains[2] = chainTemp;
        chainTemp = new Chain();

        chainTemp.setOperationName("Chain3");
        chainTemp.setSectorName("Sector2");
        chainTemp.setSegment("Segment3");
        this.getChainDao().save(chainTemp);
        chains[3] = chainTemp;

        String[] basicProtein = new String[8];
        basicProtein[0] = "basicProtein0";
        basicProtein[1] = "basicProtein1";
        basicProtein[2] = "basicProtein2";
        basicProtein[3] = "basicProtein3";
        basicProtein[4] = "basicProtein4";
        basicProtein[5] = "basicProtein5";
        basicProtein[6] = "basicProtein6";
        basicProtein[7] = "basicProtein7";

        for (int i = 0; i < 1000; ++i) {
            MasterFood temp = new MasterFood();
            temp.setItemDescription("sfasfd");
            temp.setBasicProtein(basicProtein[i % 8]);

            temp.setChain(chains[i % 4]);

            this.getDao().save(temp);
        }

        MasterFood temp = new MasterFood();
        temp.setItemDescription("sfasfd");
        temp.setBasicProtein(basicProtein[1]);
        this.getDao().save(temp);

        MasterFoodFilterParameters masterFood = new MasterFoodFilterParametersImpl();

        // masterFood.getCuisineIn().add("Italian");
        // masterFood.getCuisine().getAndValues().add("Dessert");
        masterFood.setOrderBy("itemDescription");
        // masterFood.setLimit(new Long(100));
        masterFood.getOperationName().getInValues().add("Chain0");
        masterFood.getOperationName().getInValues().add("Chain1");
        masterFood.getOperationName().getInValues().add("Chain2");
        masterFood.getOperationName().getInValues().add("Chain3");

        Collection col = this.getDao().findUsingCriteria(masterFood);

        results = col;
         chainsCollection = this.getChainDao().find(new ChainFilterParameters());
       
    }

    public void testIncidenceBuildTable() throws Exception {

        IncidenceTableBuildOptionsWithChains options = new IncidenceTableBuildOptionsWithChains();
        
        options.setResults(results);
        options.setBaseChains(chainsCollection);
        options.setYear(new Integer(2005));
        
        IncidenceTable table = MenuMineResultsDisplayWrapperBuilder.singleton
                .buildIncidenceTable(options);

        assertEquals(2, table.getIncidenceSectors().size());
        for (Iterator iter = table.getIncidenceSectors().iterator(); iter
                .hasNext();) {

            IncidenceSector element = (IncidenceSector) iter.next();

            for (Iterator iterator = element.getIncidenceSegments().iterator(); iterator
                    .hasNext();) {
                IncidenceSegment segmentEle = (IncidenceSegment) iterator
                        .next();

            }
        }
    }

}