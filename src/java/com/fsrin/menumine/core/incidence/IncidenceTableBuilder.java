/*
 * Created on Jan 30, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.chain.ChainQueryBuilder;
import com.fsrin.menumine.core.menumine.marketsize.IncidenceTableDecoratorMarketSizeImpl;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeDecorator;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceTable;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceTotals;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeOptions;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDaoFactory;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;

public class IncidenceTableBuilder {

    private static Log log = LogFactory.getLog(IncidenceTableBuilder.class);

    public IncidenceTable buildItemsPerChainIncidence(
            IncidenceTableBuildOptions options) {

        if (options.getYear() == null || options.getParams() == null) {
            throw new RuntimeException("need more incidence options");
        }

        StringBuffer q = new MasterFoodQueryBuilder()
                .getQueryForItemsPerChainCount(options.getParams(), options
                        .getYear());

        Collection rawData = GenericDAOFactory.factory.buildData().find(
                q.toString());

        String sector = "";

        IncidenceTableAggregationImpl ret = new IncidenceTableAggregationImpl();
        ret.setIncidenceSectors(new ArrayList());

        IncidenceSectorAggregationImpl current = null;

        IncidenceTotalsAggregationImpl totals = new IncidenceTotalsAggregationImpl();
        ret.setTotals(totals);
        
        for (Iterator iter = rawData.iterator(); iter.hasNext();) {
            Object[] element = (Object[]) iter.next();

            if (element[0] == null) {
                element[0] = "N/A";
            }
            if (element[1] == null) {
                element[1] = "N/A";
            }

            log.info("sector: " + (String) element[0]);

            if (!((String) element[0]).equals(sector)) {
                current = new IncidenceSectorAggregationImpl();
                sector = (String) element[0];
                current.setName(sector);
                current.setIncidenceSegments(new ArrayList());
                ret.getIncidenceSectors().add(current);
            }

            if (current == null)
                throw new RuntimeException(
                        "don't have a current sector to put data in.");

            IncidenceSegmentAggregationImpl segment = new IncidenceSegmentAggregationImpl();

            segment.setName((String) element[1]);
            segment.setNumberOfItemsBeingMenued(((Integer) element[2])
                    .intValue());
            segment.setNumberOfChainsMenuingItems(((Integer) element[3])
                    .intValue());
            
            // DBB 1-20-2009 Items per menu chaining is always 0 for total
            segment.setNumberOfChains(((Integer) element[3]).intValue());
            
            current.getIncidenceSegments().add(segment);

            current.setNumberOfChainsMenuingItems(current
                    .getNumberOfChainsMenuingItems()
                    + segment.getNumberOfChainsMenuingItems());
            current.setNumberOfItemsBeingMenued(current
                    .getNumberOfItemsBeingMenued()
                    + segment.getNumberOfItemsBeingMenued());

            totals.setNumberOfChainsInSector(totals.getNumberOfChainsInSector() + segment.getNumberOfChains());
            totals.setNumberOfChainsMenuingItems(totals.getNumberOfChainsMenuingItems() + segment.getNumberOfChainsMenuingItems());
            totals.setNumberOfItemsBeingMenued(totals.getNumberOfItemsBeingMenued() + segment.getNumberOfItemsBeingMenued());
        }

        return ret;

    }

    public MarketSizeIncidenceTable buildMarketSizeProjectorTable(IncidenceTableBuildOptions options, MarketSizeOptions marketSizeOptions) {
        MarketSizeIncidenceTable ret = new MarketSizeIncidenceTable();
        
        MarketSizeIncidenceTotals totals = new MarketSizeIncidenceTotals();
        
        this.decorateIncidenceTable(options, ret, totals, new IncidenceTableDecoratorMarketSizeImpl());
        
        new MarketSizeDecorator().decorate(ret, marketSizeOptions);
        
        return ret;
    }
    public IncidenceTable buildCategoryIncidenceTable(
            IncidenceTableBuildOptions options) {

        IncidenceTableAggregationImpl ret = new IncidenceTableAggregationImpl();
        
        IncidenceTotalsAggregationImpl totals = new IncidenceTotalsAggregationImpl();
        
        this.decorateIncidenceTable(options, ret, totals, new IncidenceTableDecoratorAggregationImpl());

  
        return ret;
    }
    
    public void decorateIncidenceTable(IncidenceTableBuildOptions options, IncidenceTableAggregationImpl ret, IncidenceTotalsAggregationImpl totals, AbstractIncidenceTableDecorator decorator) {

        /*
         * 2006-07-25
         * common setup
         */
        ret.setIncidenceSectors(new ArrayList());
        ret.setTotals(totals);
        
        /*
         * get the chains
         * 2006-03-09 RSC Should be by first year in database.
         */
//        Collection chains = GenericDAOFactory.factory.buildData().find(
//                new ChainQueryBuilder().buildCountsBySegmentQuery().toString());

        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        
        Collection chains = dao.find(
                new ChainQueryBuilder().buildCountsBySegmentQuery(options.getYear()).toString());

        
        /*
         * get the results from tblmasterfood.
         */
        Collection food = dao.find(
                new MasterFoodQueryBuilder().getQueryForItemsPerChainCount(
                        options.getParams(), options.getYear()).toString());

        
        /*
         * let's throw the food into a hash table and use it
         */
        HashMap segmentsInFood = new HashMap();
        for (Iterator iter = food.iterator(); iter.hasNext();) {
            Object[] element = (Object[]) iter.next();
            segmentsInFood.put((String)element[1],element);
        }
        
        /*
         * now cycle through
         */
        decorator.handleDecorate(chains,segmentsInFood, ret, totals);
        
        /*
         * get a quick record count
         */
        try {
            totals.setRecordCount(MasterFoodDao.factory.build().getCount(options.getParams()).intValue());
        } catch (Exception e) {
            totals.setRecordCount(-1);
        }
        
    }
}
