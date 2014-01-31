/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.natlaccountbench.xwork.NationalAccountBenchmarkWebOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;

/**
 * @author Nick
 * 
 * 
 */
public class NationalAccountBenchmarkBuilder {

    // public static NationalAccountBenchmarkBuilder singleton = new
    // NationalAccountBenchmarkBuilder();

    // public NationalAccountBenchmarkBuilder() {
    // super();
    // }

    /*
     * 2006-02-02 RSC Refactoring
     */
    public NationalAccountBenchmarkTable buildFromParameters(
            MasterFoodFilterParameters whereFields,
            MenuMineGraphOptions graphOptions, RollUpOptions rollUpOptions,
            NationalAccountBenchmarkWebOptions webOptions) {

        /*
         * 2006-02-02 RSC
         */
        // Collection results = this.getResults();
        MasterFoodFilterParameters selectFields = new MasterFoodFilterParametersImpl();

        try {
            Ognl.setValue(graphOptions.getGraphByField()
                    + ".select", selectFields, Boolean.TRUE);
        } catch (OgnlException e) {
            throw new RuntimeException("Failed miserably.", e);
        }
        selectFields.getOperationName().setSelect(true);


        FilterParameter originalOperationNames = whereFields.getOperationName();
        
        whereFields.setOperationName(new FilterParameter(FieldEnum.OPERATION_NAME));

//        whereFields.getOperationName().setInValues(new ArrayList());

        
        whereFields.getOperationName().getInValues().addAll(
                webOptions.getTargetChains());

        whereFields.getOperationName().getInValues().addAll(
                webOptions
                        .getBenchmarkChains());

        Collection results;
        try {
            results = MasterFoodServiceDelegateFactory.factory.build()
                    .searchMasterFoodByHQL(selectFields, whereFields);
        } catch (MasterFoodSearchException e) {
            throw new RuntimeException("failed with mf sd", e);
        }
        
        /*
         * reset operation names
         */
        whereFields.setOperationName(originalOperationNames);

        
        try {
            return this.buildNationalAccountBenchmarkTableFromCollection(results, graphOptions, rollUpOptions, webOptions.getTargetChains(), webOptions.getBenchmarkChains());
        } catch (OgnlException e) {
            throw new RuntimeException("failed while building.",e);
        }
    
        
    }

    /*
     * NAH This will process the results into a NationalAccountBenchmarkTable.
     * We build this by processing a query to two share tables, each with
     * different chains so we can compare the the tables.
     */
    public NationalAccountBenchmarkTable buildNationalAccountBenchmarkTableFromCollection(
            Collection results, MenuMineGraphOptions graphOptions,
            RollUpOptions rollUpOptions, Collection chainsA, Collection chainsB)
            throws OgnlException {

        NationalAccountBenchmarkOptions options = new NationalAccountBenchmarkOptions();
        options.setGroupByField(graphOptions.getGraphByField());

        options.setSimpleFilter(graphOptions.getSimpleFilter());
        options.setRollUpOptions(rollUpOptions);

        /*
         * Set some defaults.
         */
        options.setAggregationType(graphOptions.getAggregationType());
        options.setOtherItemRollUpType(graphOptions.getOtherItemRollUpType());

        options.setChainsA(chainsA);
        options.setChainsB(chainsB);

        NationalAccountBenchmarkTable table = new NationalAccountBenchmarkTable(
                options);

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            table.addMasterFood(element);
        }

        return table;

    }

    public NationalAccountBenchmarkTrendTable buildTrendFromParameters(
            MasterFoodFilterParameters whereFields,
            MenuMineGraphOptions graphOptions, RollUpOptions rollUpOptions,
            NationalAccountBenchmarkWebOptions webOptions) {

        /*
         * 2006-02-02 RSC
         */
        // Collection results = this.getResults();
        MasterFoodFilterParameters selectFields = new MasterFoodFilterParametersImpl();

        try {
            Ognl.setValue(graphOptions.getGraphByField()
                    + ".select", selectFields, Boolean.TRUE);
        } catch (OgnlException e) {
            throw new RuntimeException("Failed miserably.", e);
        }
        selectFields.getOperationName().setSelect(true);

        /*
         * 2006-02-02 RSC trend fields
         * 2006-03-10 RSC update to 2005,2002,1999
         */
        selectFields.getPrice1999().setSelect(true);
        selectFields.getPrice2002().setSelect(true);
        selectFields.getPrice2005().setSelect(true);
        
        // 2-12-2009 Add 2008
        selectFields.getPrice2008().setSelect(true);
        selectFields.getPrice2009().setSelect(true);
        

        Collection originalOperationNames = whereFields.getOperationName()
                .getInValues();

        whereFields.getOperationName().setInValues(new ArrayList());

        whereFields.getOperationName().getInValues().addAll(
                webOptions.getTargetChains());

        whereFields.getOperationName().getInValues().addAll(
                webOptions
                        .getBenchmarkChains());

        Collection results;
        try {
            results = MasterFoodServiceDelegateFactory.factory.build()
                    .searchMasterFoodByHQL(selectFields, whereFields);
        } catch (MasterFoodSearchException e) {
            throw new RuntimeException("failed with mf sd", e);
        }
        
        /*
         * reset operation names
         */
        whereFields.getOperationName().setInValues(originalOperationNames);

        
        try {
            return this.buildNationalAccountBenchmarkTrendTableFromCollection(results, graphOptions, rollUpOptions, webOptions.getTargetChains(), webOptions.getBenchmarkChains());
        } catch (OgnlException e) {
            throw new RuntimeException("failed while building.",e);
        }
    
        
    }
    
    public NationalAccountBenchmarkTrendTable buildNationalAccountBenchmarkTrendTableFromCollection(
            Collection results, MenuMineGraphOptions graphOptions,
            RollUpOptions rollUpOptions, Collection chainsA, Collection chainsB)
            throws OgnlException {

        NationalAccountBenchmarkOptions options = new NationalAccountBenchmarkOptions();
        options.setGroupByField(graphOptions.getGraphByField());

        options.setSimpleFilter(graphOptions.getSimpleFilter());
        options.setRollUpOptions(rollUpOptions);

        /*
         * Set some defaults.
         */
        options.setAggregationType(graphOptions.getAggregationType());
        options.setOtherItemRollUpType(graphOptions.getOtherItemRollUpType());

        options.setChainsA(chainsA);
        options.setChainsB(chainsB);

        NationalAccountBenchmarkTrendTable table = new NationalAccountBenchmarkTrendTable(
                options);

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            table.addMasterFood(element);
        }

        return table;

    }

}