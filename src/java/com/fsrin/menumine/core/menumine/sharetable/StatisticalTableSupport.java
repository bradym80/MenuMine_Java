/*
 * Created on Jan 27, 2006
 *
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;
import com.fsrin.menumine.common.dao.GenericDAO;

/**
 * Helps generate the source for graphs, share tables, etc.
 * 
 * Note: you should not use this for anything outside of this package.
 * 
 * @author Reid
 * 
 */
class StatisticalTableSupport {

    public static final String TABLE_GROUPBY_NAME = "group";

    public static final String TABLE_COUNT_NAME = "count";

    public static final String TABLE_PERCENT_NAME = "percent";

    private static Log log = LogFactory.getLog(StatisticalTableSupport.class);

    public Collection getStatisticalTable(
            MenuMineSessionContextWrapper sessionContextWrapper) {

        return this.getConjunctiveStatisticalTable(sessionContextWrapper
                .getLastFilterWrapper().getMasterFoodFilterParameters(),
                sessionContextWrapper.getLastGraphOptions().getGraphByField());

    }

    public Collection getConjunctiveStatisticalTable(MasterFoodFilterParameters params,
            String graphByField) {
        
        /*
         * 2006-02-15 RSC Let's make sure graphByField is useful
         */
        if (graphByField == null || graphByField.trim().length()==0)
            throw new RuntimeException("Graph by field is null.");
        
        StringBuffer s = new MasterFoodQueryBuilder()
                .getQueryForCountWithGroupByConjunctive(params, graphByField);

        return this.handleGetTable(s);
        
//        log.info("query: " + s);
//
//        Collection items = GenericDAOFactory.factory.build().find(s.toString());
//
//        return items;
    }
    
    public Collection getDisjunctiveStatisticalTable(MasterFoodFilterParameters params,
            String graphByField) {
        
        /*
         * 2006-02-15 RSC Let's make sure graphByField is useful
         */
        if (graphByField == null || graphByField.trim().length()==0)
            throw new RuntimeException("Graph by field is null.");
        
        StringBuffer s = new MasterFoodQueryBuilder()
                .getQueryForCountWithGroupByDisjunctive(params, graphByField);

        return this.handleGetTable(s);
        
//        log.info("query: " + s);
//
//        Collection items = GenericDAOFactory.factory.build().find(s.toString());
//
//        return items;
    }
    
    public Collection getStatisticalTable(MasterFoodFilterParameters params,
            String graphByField, FilterParameter[] extraParameters) {
        StringBuffer s = new MasterFoodQueryBuilder()
                .getQueryForCountWithGroupBy(params, graphByField, extraParameters);

        return this.handleGetTable(s);

    }
    
    private Collection handleGetTable(StringBuffer query) {
//        log.info("query: " + query);
    	
    	GenericDAO genericDAO = GenericDAOFactory.factory.buildData();

        Collection items = genericDAO.find(query.toString());

        return items;
    }

}
