/*
 * Created on Jan 27, 2006
 *
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.Collection;
import java.util.Iterator;

import ognl.OgnlException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.filters.CombinationRecordFilter;
import com.fsrin.menumine.core.menumine.sharetable.filters.CommonTermsFilter;
import com.fsrin.menumine.core.menumine.sharetable.filters.ConsolidateByTermsFilter;
import com.fsrin.menumine.core.menumine.sharetable.filters.HighPercentageRowsFilter;
import com.fsrin.menumine.core.menumine.sharetable.filters.KeywordRowFilter;
import com.fsrin.menumine.core.menumine.sharetable.filters.LowPercentageRowsFilter;
import com.fsrin.menumine.core.menumine.sharetable.filters.RemoveEmptyRecordFilter;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;

public class StatisticalTableBuilder {

    private static Log log = LogFactory.getLog(StatisticalTableBuilder.class);

    /*
     * NAH This will process the results into a statistical table. This may be
     * display in a table or used to build the graph.
     */
    // public StatisticalTable buildStatisticalTableFromCollection(
    // Collection results, String field)
    /*
     * 2006-02-01 RSC Used by the mean and median price trend actions.
     */
    public StatisticalTableIF buildStatisticalTableFromCollection_WithoutAggregation(
            Collection results, MenuMineGraphOptions graphOptions,
            RollUpOptions rollUpOptions) throws OgnlException {

        log.debug("building without aggregation");

        StatisticalTableOptions options = new StatisticalTableOptions();
        options.setGroupByField(graphOptions.getGraphByField());

        options.setSimpleFilter(graphOptions.getSimpleFilter());
        options.setRollUpOptions(rollUpOptions);

        /*
         * Set some defaults.
         */
        options.setAggregationType(graphOptions.getAggregationType());
        options.setOtherItemRollUpType(graphOptions.getOtherItemRollUpType());

        // StatisticalTable table = new StatisticalTable(graphOptions
        // .getGraphByField(), graphOptions.getRollUpTerms());
        StatisticalTableStandardImpl table = new StatisticalTableStandardImpl(
                options);

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            table.addMasterFood(element);
        }

        log.debug("building without aggregation done");
        return table;

    }

    public StatisticalTableIF buildStatisticalTable_FromAggregation(
            MasterFoodFilterParameters params,
            MenuMineGraphOptions graphOptions, RollUpOptions rollUpOptions)
            throws Exception {

        log.debug("building from aggregation with query");
        
        StatisticalTableSupport sts = new StatisticalTableSupport();
        String field = graphOptions.getGraphByField();

        Collection items = sts.getConjunctiveStatisticalTable(params, field);

        log.debug("building from aggregation with query - query done");

        return this.buildStatisticalTable_FromAggregation(items, graphOptions,
                rollUpOptions);

    }
    
    public StatisticalTableIF buildStatisticalTable_FromAggregationDisjunctive(
            MasterFoodFilterParameters params,
            MenuMineGraphOptions graphOptions, RollUpOptions rollUpOptions)
            throws Exception {

        log.debug("building from aggregation with query");

        Collection items = new StatisticalTableSupport().getDisjunctiveStatisticalTable(
                params, graphOptions.getGraphByField());

        log.debug("building from aggregation with query - query done");

        return this.buildStatisticalTable_FromAggregation(items, graphOptions,
                rollUpOptions);

    }

    public StatisticalTableIF buildStatisticalTable_FromAggregation(
            Collection aggregatedItems, MenuMineGraphOptions graphOptions,
            RollUpOptions rollUpOptions) throws Exception {

        log.debug("building from aggregation ");
        
        StatisticalTableAggregationImpl table = new StatisticalTableAggregationImpl();
        table.setFieldEnum(graphOptions.getGraphByFieldEnum());
        table.setRawRows(aggregatedItems);

        new StatisticalTableTotalDecorator().decorateWithTotal(table);

        StatisticalTableIF table1 = this.processFilters(table, graphOptions);
        
        if (graphOptions.getSimpleFilter() != null)
            new StatisticalTableFilter().filter(table1, graphOptions
                    .getSimpleFilter());
        else
            new StatisticalTableRollUp().filter(table1, rollUpOptions);

        return table1;
        

    }

    private StatisticalTableIF processFilters(StatisticalTableIF table, MenuMineGraphOptions graphOptions) throws Exception {
        
        log.debug("starting to filter");

        StatisticalTableIF ret = table;

        if (graphOptions.isFilterKeywordRow()) {
            
            if (graphOptions.getFilterKeywordRowTermsList() == null && graphOptions.getFilterKeywordRowTermsList().trim().length() == 0) {
                //donothing
            } else {
                KeywordRowFilter filter = new KeywordRowFilter();
                filter.setKeywords(graphOptions.getFilterKeywordRowTermsList());
                filter.setEliminate(graphOptions.isFilterKeywordRowEliminate());
                filter.setCombinedName(graphOptions.getFilterKeywordRowLabel());
                filter.execute(ret);
                ret = filter.getResults();
            }
            
        }
        if (graphOptions.isFilterCommonTerms()) {
            if (graphOptions.getFilterCommonTermsList() == null || graphOptions.getFilterCommonTermsList().trim().length() == 0) {
                //donothing
            } else {
                CommonTermsFilter filter = new CommonTermsFilter();
                filter.setKeywords(graphOptions.getFilterCommonTermsList());
                filter.execute(ret);
                ret = filter.getResults();
            }
        }
        
        if (graphOptions.isFilterConsolidateByTerms()) {
            if (graphOptions.getFilterConsolidateByTermsList() == null || graphOptions.getFilterConsolidateByTermsList().trim().length() == 0) {
                //donothing
            } else {
                ConsolidateByTermsFilter filter = new ConsolidateByTermsFilter();
                filter.setKeywords(graphOptions.getFilterConsolidateByTermsList());
                filter.execute(ret);
                ret = filter.getResults();
            }
        }
        
        if (graphOptions.isFilterNone()) {
            RemoveEmptyRecordFilter filter = new RemoveEmptyRecordFilter();
            filter.execute(ret);
            ret = filter.getResults();
        }

        if (graphOptions.isFilterCombination()) {
            CombinationRecordFilter filter = new CombinationRecordFilter();
            filter.setCombinedName(graphOptions.getFilterCombinationLabel());
            filter.setEliminate(graphOptions.isFilterCombinationEliminate());
            filter.execute(ret);
            
            ret = filter.getResults();
            
        }
        if (graphOptions.isFilterBelowPercentage()) {
            if (graphOptions.getFilterBelowPercentageValue() <= 0.0
                    || graphOptions.getFilterBelowPercentageValue() > 100.0) {
                graphOptions.setFilterBelowPercentageValue(1.0);
            }
            LowPercentageRowsFilter filter = new LowPercentageRowsFilter();
            filter.setCombinationThreshhold(graphOptions
                    .getFilterBelowPercentageValue());
            filter
                    .setEliminate(graphOptions
                            .isFilterBelowPercentageEliminate());
            filter.setCombinedName(graphOptions.getFilterBelowPercentageLabel());
            
            filter.execute(ret);
            ret = filter.getResults();

        }
        
        if (graphOptions.isFilterAbovePercentage()) {
            if (graphOptions.getFilterAbovePercentageValue() <= 0.0
                    || graphOptions.getFilterAbovePercentageValue() > 100.0) {
                graphOptions.setFilterAbovePercentageValue(10.0);
            }
            HighPercentageRowsFilter filter = new HighPercentageRowsFilter();
            filter.setCombinationThreshhold(graphOptions
                    .getFilterAbovePercentageValue());
            filter
                    .setEliminate(graphOptions
                            .isFilterAbovePercentageEliminate());
            
            filter.setCombinedName(graphOptions.getFilterAbovePercentageLabel());
            filter.execute(ret);
            ret = filter.getResults();

        }
        


        log.debug("building from aggregation done");

        return ret;
        
    }
    public StatisticalTableIF buildStatisticalTable_FromAggregation_WithPriceData(
            MasterFoodFilterParameters params,
            MenuMineGraphOptions graphOptions, 
            RollUpOptions rollUpOptions)
            throws Exception {

        log.debug("building qith price data");
        GenericDAO dao = GenericDAOFactory.factory.buildData();

        /*
         * 2006-02-15 RSC Individual rows.
         */
        Collection aggregates = dao.find(new MasterFoodQueryBuilder()
                .getQueryForMeanPriceTrend(graphOptions.getGraphByFieldEnum(),
                        params).toString());

        /*
         * 2006-02-15 RSC Grand totals.
         */
        Collection aggregateSum = dao.find(new MasterFoodQueryBuilder()
                .getQueryForMeanPriceTrend(params).toString());
        Object[] sums = (Object[]) aggregateSum.toArray()[0];
        StatisticalTableElementAggregationImpl totals = new StatisticalTableElementAggregationImpl();
        totals.setPercent(new Double(100.0));
        totals.setNumberInSample(new Long(((Integer) sums[0]).longValue()));
        totals.setSizeOfSample(totals.getNumberInSample());
        totals.setName("Totals");
        totals.setPriceData(new StatisticalTablePriceDataAggregationImpl(sums));
        
        
        

        StatisticalTableAggregationWithPricesImpl table = new StatisticalTableAggregationWithPricesImpl();

        table.setFieldEnum(graphOptions.getGraphByFieldEnum());
        table.setRawRows(aggregates);
        table.setTotal(totals);
        table.setSizeOfSample(totals.getSizeOfSample());

        new StatisticalTableRollUp().filter(table, rollUpOptions);

        StatisticalTableIF ret = this.processFilters(table, graphOptions);
        
        //resetting the totals.
        ret.setTotal(totals);
        
        return ret;

    }

}
