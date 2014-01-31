/*
 * Created on Jan 20, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.util.GroupCounterVO;

/**
 * 2006-01-22 RSC Note the hack in getSelect
 * 
 * @author Reid
 * 
 */
public class MasterFoodQueryBuilder {

    private static Log log = LogFactory.getLog(MasterFoodQueryBuilder.class);

    public static final String DISJUNCTION = "or";

    public static final String CONJUNCTION = "and";

    public static final String HQL_INSTANCE_NAME = "m";

    public static final String HQL_TABLE_NAME = MasterFood.class.getName();

    public static final String HQL_MASTERFOOD_ID = "id";

    private Collection selectedFieldNames;

    public StringBuffer getConjunctiveQueryWithSelectedFields(
            MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");

        ret.append(getSelect(params));

        ret.append(this.getConjunctiveQueryWithAllFields(params));

        ret.append(this.getOrderPhrase(params));

        // log.info("Final query is " + ret);
        return ret;

    }
    
    public StringBuffer getDisjunctiveQueryWithSelectedFields(
            MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");

        ret.append(getSelect(params));

        ret.append(this.getQueryWithAllFields(params, DISJUNCTION));

        ret.append(this.getOrderPhrase(params));

        // log.info("Final query is " + ret);
        return ret;

    }

    public StringBuffer getQueryWithSelectedFields(
            MasterFoodFilterParameters displayParameters,
            MasterFoodFilterParameters selectParameters) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");

        ret.append(getSelect(displayParameters));

        ret.append(this.getConjunctiveQueryWithAllFields(selectParameters));

        ret.append(this.getOrderPhrase(displayParameters));

        log.info("Final query is " + ret);
        return ret;

    }

    public StringBuffer getQueryForCrossTab(
            MasterFoodFilterParameters selectParams,
            MasterFoodFilterParameters whereParams) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");

        ret.append(getSelect(selectParams));

        ret.append(this.getConjunctiveQueryWithAllFields(whereParams));

        ret.append(this.getOrderPhrase(selectParams));

        log.info("Final query is " + ret);
        return ret;

    }

    /**
     * 
     * @param whereParams
     * @return
     */
    public StringBuffer getQueryForMeanPriceTrend(FieldEnum groupByField,
            MasterFoodFilterParameters whereParams) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");

        ret.append(" count (" + getInstanceField("id") + "), ");
        ret.append(getInstanceField(groupByField.getOgnlName()) + ", ");

        ret.append(getAveragePriceFields());

        ret.append(this.getConjunctiveQueryWithAllFields(whereParams));
        ret.append(" GROUP BY "
                + this.getInstanceField(groupByField.getOgnlName()));
        ret.append(" ORDER BY count( id ) DESC");

        log.info("Final query is " + ret);
        return ret;

    }

    public StringBuffer getQueryForMeanPriceTrend(
            MasterFoodFilterParameters whereParams) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");

        ret.append(" count (" + getInstanceField("id") + "), ");

        ret.append(getAveragePriceFields());

        ret.append(this.getConjunctiveQueryWithAllFields(whereParams));

        log.info("Final query is " + ret);
        return ret;

    }

    private StringBuffer getAveragePriceFields() {

        StringBuffer ret = new StringBuffer();

        ret.append(getAverageForField(FieldEnum.PRICE_1996) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_1997) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_1998) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_1999) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2000) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2001) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2002) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2003) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2004) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2005) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2006) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2007) + ", ");
        
        // DBB 1-20-2009 Add 2008, 2009
        ret.append(getAverageForField(FieldEnum.PRICE_2008) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2009) + ", ");
        // MJB 11-12-2009 Added 2010
        ret.append(getAverageForField(FieldEnum.PRICE_2010) + ", ");
        ret.append(getAverageForField(FieldEnum.PRICE_2011) + " ");
        //JDL 10-5-07
        return ret;
    }

    private String getAverageForField(FieldEnum fieldEnum) {

        String ret = " avg (" + HQL_INSTANCE_NAME + "."
                + fieldEnum.getOgnlName() + ")";

        return ret;
    }

    private String getInstanceField(String name) {
        return HQL_INSTANCE_NAME + "." + name;
    }

    public StringBuffer getOrderPhrase(MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        if (params.getOrderBy() != null
                && this.selectedFieldNames.contains(params.getOrderBy())) {
            ret.append(" ");
            ret.append(" ORDER BY ");
            ret.append(HQL_INSTANCE_NAME + "." + params.getOrderBy());
            if (!params.isSortAsc())
                ret.append(" DESC ");
            else
                ret.append(" ASC ");
        }

        return ret;
    }

    public StringBuffer getQueryForCount(MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") ");

        ret.append(this.getConjunctiveQueryWithAllFields(params));

        return ret;
    }
    
    public StringBuffer getQueryForProfileApplicationsCount(MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + "), count( distinct " + HQL_INSTANCE_NAME + "." + FieldEnum.OPERATION_NAME.getOgnlName()
                + ") ");

        ret.append(this.getQueryWithAllFields(params, DISJUNCTION));

        return ret;
    }    
    
    public StringBuffer getQueryForProfileOperatorShareCount(
            MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + "), " +  HQL_INSTANCE_NAME + "." + FieldEnum.OPERATION_NAME.getOgnlName() + " ");

        ret.append(this.getQueryWithAllFields(params, DISJUNCTION));

        ret
                .append(" GROUP BY " + HQL_INSTANCE_NAME + "." + FieldEnum.OPERATION_NAME.getOgnlName()
                        + "  ");

        ret.append(" ORDER BY ");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") DESC ");

        log.info("Find query: " + ret.toString());

        return ret;
    }
    
    public StringBuffer getQueryForProfileSegmentShareCount(
            MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + "), count( distinct " + HQL_INSTANCE_NAME + "." + FieldEnum.OPERATION_NAME.getOgnlName()
                + "), " +  HQL_INSTANCE_NAME + "." + FieldEnum.MARKET_SEGMENT.getOgnlName() + " ");

        ret.append(this.getQueryWithAllFields(params, DISJUNCTION));

        ret
                .append(" GROUP BY " + HQL_INSTANCE_NAME + "." + FieldEnum.MARKET_SEGMENT.getOgnlName()
                        + "  ");

        ret.append(" ORDER BY ");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") DESC ");

        log.info("Find query: " + ret.toString());

        return ret;
    }
    
    public StringBuffer getQueryForProfileSectorShareCount(
            MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + "), count( distinct " + HQL_INSTANCE_NAME + "." + FieldEnum.OPERATION_NAME.getOgnlName()
                + "), " +  HQL_INSTANCE_NAME + "." + FieldEnum.MARKET_SECTOR.getOgnlName() + " ");

        ret.append(this.getQueryWithAllFields(params, DISJUNCTION));

        ret
                .append(" GROUP BY " + HQL_INSTANCE_NAME + "." + FieldEnum.MARKET_SECTOR.getOgnlName()
                        + "  ");

        ret.append(" ORDER BY ");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") DESC ");

        log.info("Find query: " + ret.toString());

        return ret;
    }
    
    public StringBuffer getQueryForCountDistinctChain(MasterFoodFilterParameters params) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" count( distinct " + HQL_INSTANCE_NAME + "." + FieldEnum.OPERATION_NAME.getOgnlName()
                + ") ");

        ret.append(this.getConjunctiveQueryWithAllFields(params));

        return ret;
    }

    public StringBuffer getQueryForItemsPerChainCount(
            MasterFoodFilterParameters params, Integer firstYearInDatabase) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");

        ret.append(HQL_INSTANCE_NAME + "."
                + FieldEnum.MARKET_SECTOR.getOgnlName() + ", ");
        ret.append(HQL_INSTANCE_NAME + "."
                + FieldEnum.MARKET_SEGMENT.getOgnlName() + ", ");
        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + "), ");
        ret.append(" count(distinct " + HQL_INSTANCE_NAME + "."
                + FieldEnum.OPERATION_CHAIN_ID.getOgnlName() + ") ");

        ret.append(this.getConjunctiveQueryWithAllFields(params));

        if (ret.indexOf(" where ") > -1)
            ret.append(" and ");

        ret.append(HQL_INSTANCE_NAME + "."
                + FieldEnum.YEAR_PUT_IN_DATABASE.getOgnlName() + " <= "
                + firstYearInDatabase);

        ret.append(" GROUP BY ");
        ret.append(HQL_INSTANCE_NAME + "."
                + FieldEnum.MARKET_SECTOR.getOgnlName() + ", ");
        ret.append(HQL_INSTANCE_NAME + "."
                + FieldEnum.MARKET_SEGMENT.getOgnlName() + " ");

        return ret;
    }

    private StringBuffer handleGetSelectAndGroupForCount(String groupByField) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" new " + GroupCounterVO.class.getName() + " (");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") ");
        ret.append(" , " + HQL_INSTANCE_NAME + "." + groupByField + "  ");

        ret.append(") ");

        return ret;
    }

    private StringBuffer handleGetSelectAndGroupForCount(String groupByField,
            FieldEnum countDistinctWithinGroup) {

        StringBuffer ret = new StringBuffer();

        ret.append("select ");
        ret.append(" new " + GroupCounterVO.class.getName() + " (");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") ");
        ret.append(" , " + HQL_INSTANCE_NAME + "." + groupByField + "  ");

        ret.append(", count(distinct " + HQL_INSTANCE_NAME + ".chainID )");

        ret.append(") ");

        return ret;
    }

    public StringBuffer getQueryForCountWithGroupBy(
            MasterFoodFilterParameters params, String groupByField,
            FilterParameter[] extraParameters) {

        StringBuffer ret = new StringBuffer();

        ret.append(this.handleGetSelectAndGroupForCount(groupByField));

        ret.append(this.getQueryWithAllFields(params, extraParameters));

        ret
                .append(" GROUP BY " + HQL_INSTANCE_NAME + "." + groupByField
                        + "  ");

        ret.append(" ORDER BY ");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") DESC ");

        return ret;
    }

    public StringBuffer getQueryForCountWithGroupBy(
            MasterFoodFilterParameters params, String groupByField,
            FilterParameter[] extraParameters,
            FieldEnum countDistinctWithinGroup) {

        StringBuffer ret = new StringBuffer();

        ret.append(this.handleGetSelectAndGroupForCount(groupByField,
                countDistinctWithinGroup));

        ret.append(this.getQueryWithAllFields(params, extraParameters));

        ret
                .append(" GROUP BY " + HQL_INSTANCE_NAME + "." + groupByField
                        + "  ");

        ret.append(" ORDER BY ");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") DESC ");

        return ret;
    }

    public StringBuffer getQueryForCountWithGroupByConjunctive(
            MasterFoodFilterParameters params, String groupByField) {

        StringBuffer ret = new StringBuffer();

        ret.append(this.handleGetSelectAndGroupForCount(groupByField));

        ret.append(this.getConjunctiveQueryWithAllFields(params));

        ret
                .append(" GROUP BY " + HQL_INSTANCE_NAME + "." + groupByField
                        + "  ");

        ret.append(" ORDER BY ");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") DESC ");

//        log.info("Find query: " + ret.toString());

        return ret;
    }

    public StringBuffer getQueryForCountWithGroupByDisjunctive(
            MasterFoodFilterParameters params, String groupByField) {

        StringBuffer ret = new StringBuffer();

        ret.append(this.handleGetSelectAndGroupForCount(groupByField));

        ret.append(this.getQueryWithAllFields(params, DISJUNCTION));

        ret
                .append(" GROUP BY " + HQL_INSTANCE_NAME + "." + groupByField
                        + "  ");

        ret.append(" ORDER BY ");

        ret.append(" count(" + HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID
                + ") DESC ");

//        log.info("Find query: " + ret.toString());

        return ret;
    }
    
    public StringBuffer getConjunctiveQueryWithAllFields(MasterFoodFilterParameters params) {

        // StringBuffer ret = new StringBuffer();
        //
        // ret.append(" from " + HQL_TABLE_NAME + " as " + HQL_INSTANCE_NAME);
        // ret.append(" where ");
        // ret.append(this.getConjunctiveStatement(params));
        //
        // return ret;

        return getQueryWithAllFields(params, CONJUNCTION);
    }

    public StringBuffer getQueryWithAllFields(
            MasterFoodFilterParameters params, String type) {

        StringBuffer ret = new StringBuffer();

        ret.append(" from " + HQL_TABLE_NAME + " as " + HQL_INSTANCE_NAME);
        ret.append(" where ");
        if (type == CONJUNCTION) {
            ret.append(this.getConjunctiveStatement(params));
        } else {
            ret.append(this.getDisjunctiveStatement(params));
        }

        return ret;

    }

    public StringBuffer getQueryWithAllFields(
            MasterFoodFilterParameters params, FilterParameter[] extraParameters) {

        StringBuffer ret = new StringBuffer();

        ret.append(" from " + HQL_TABLE_NAME + " as " + HQL_INSTANCE_NAME);
        ret.append(" where ");
        ret.append(this.getConjunctiveStatement(params, extraParameters));

        return ret;

    }

    public StringBuffer getSelect(MasterFoodFilterParameters params) {

        selectedFieldNames = new ArrayList();

        StringBuffer ret = new StringBuffer();

        for (Iterator iter = params.getAll().iterator(); iter.hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();
            if (element.isSelect()) {

                selectedFieldNames.add(element.getFieldName());

                String token = HQL_INSTANCE_NAME + "." + element.getFieldName()
                        + " ";
                /*
                 * 2006-01-22 RSC This is an ugly little hack since params will
                 * return multiple instances of genMenuPart due to having
                 * multiple FieldEnums that use the field.
                 */
                if (ret.indexOf(token) < 0) {
                    /*
                     * just make sure it's not already in the mix.
                     */
                    if (ret.length() > 0)
                        ret.append(", ");

                    ret.append(token);
                }

            }
        }

        if (ret.length() == 0) {
            /*
             * nothing is selected, send id
             */
            ret.append(HQL_INSTANCE_NAME + "." + HQL_MASTERFOOD_ID);
        }

        return ret;
    }

    /*
     * 2006-04-20 RSC Generally useful for all queries where terms should be put
     * together with "and". Most MenuMine queries use this.
     */
    public StringBuffer getConjunctiveStatement(
            MasterFoodFilterParameters params) {

        return this.getWhereStatement(params, "and");

    }

    /*
     * 2006-04-20 RSC for queries with "or" Most profiler queries use this.
     */
    public StringBuffer getDisjunctiveStatement(
            MasterFoodFilterParameters params) {

        return this.getWhereStatement(params, "or");

    }

    /*
     * 2006-04-20 RSC Conjunction here is the English grammatical conjunction --
     * "and" or "or"
     */
    private StringBuffer getWhereStatement(MasterFoodFilterParameters params,
            String conjunction) {

        boolean requiresConjunction = false;

        StringBuffer ret = new StringBuffer();

        for (Iterator iter = params.getAllWithCriteria().iterator(); iter
                .hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();

            if (requiresConjunction) {
                ret.append(" " + conjunction + " ");
            }

            if (element.getField() == FieldEnum.YEAR_PUT_IN_DATABASE_SAME_STORE) {
                ret.append(this.getSameStoreStatement(element));
            } else {
                ret.append(this.getStatement(element));
            }
            requiresConjunction = true;

        }

        return ret;

    }

    public StringBuffer getConjunctiveStatement(
            MasterFoodFilterParameters params, FilterParameter[] extraParameters) {

        boolean requiresAnd = false;

        StringBuffer ret = getConjunctiveStatement(params);

        if (ret.length() > 0)
            requiresAnd = true;

        for (int i = 0; i < extraParameters.length; i++) {

            FilterParameter element = extraParameters[i];

            if (requiresAnd) {
                ret.append(" and ");
            }

            ret.append(this.getStatement(element));
            requiresAnd = true;

        }

        return ret;

    }

    public StringBuffer getSameStoreStatement(FilterParameter fp) {
        StringBuffer statement = new StringBuffer();

        /*
         * same store goes straight into and values, so we have to check that.
         */
        if (!fp.hasAnds()) {
            return statement;
        }

        String firstAnd = (String) fp.getAndValues().toArray()[0];

        if (!fp.isFilterEmpty()) {
            statement.append("(");
        }

        /*
         * 2006-04-18 RSC
         * 
         * This is less than or equal to because the stores had to be there the
         * entire period.
         * 
         * So, if the user selectes 2001, then they could have been added
         * anytime 2001 or earlier,
         * 
         * as long as they were there the whole time.
         */
        statement.append(HQL_INSTANCE_NAME + "." + fp.getFieldName() + " <= "
                + firstAnd);

        if (!fp.isFilterEmpty()) {
            statement.append(")");
        }

        return statement;

    }

    public StringBuffer getStatement(FilterParameter fp) {

        StringBuffer statement = new StringBuffer();

        if (!fp.isFilterEmpty()) {
            statement.append("(");
        }

        this.decorateForAnd(statement, fp);

        if (fp.hasAnds() && fp.hasOrs()) {
            statement.append(" and ");
        }

        this.decorateForOr(statement, fp);

        if ((fp.hasAnds() || fp.hasOrs()) && fp.hasNots()) {
            statement.append(" and ");
        }

        this.decorateForNot(statement, fp);

        if ((fp.hasAnds() || fp.hasOrs() || fp.hasNots()) && fp.hasIns()) {
            statement.append(" and ");
        }

        this.decorateForIn(statement, fp);

        if ((fp.hasAnds() || fp.hasOrs() || fp.hasNots() || fp.hasIns())
                && fp.getEmpty() != null) {
            statement.append(" and ");
        }

        if (fp.getEmpty() != null) {
            statement.append(HQL_INSTANCE_NAME + "." + fp.getFieldName());

            if (fp.getEmpty().booleanValue())
                statement.append(" IS NULL ");
            else
                statement.append(" IS NOT NULL ");
        }

        if (!fp.isFilterEmpty()) {
            statement.append(")");
        }

        return statement;

    }

    public void decorateForAnd(StringBuffer statement, FilterParameter fp) {
        this.getStatement(statement, "and", "like", fp.getFieldName(), fp
                .getAndValues());
    }

    public void decorateForOr(StringBuffer statement, FilterParameter fp) {
        this.getStatement(statement, "or", "like", fp.getFieldName(), fp
                .getOrValues());
    }

    public void decorateForNot(StringBuffer statement, FilterParameter fp) {
        this.getStatement(statement, "and", "not like", fp.getFieldName(), fp
                .getNotValues());
    }

    public void decorateForIn(StringBuffer statement, FilterParameter fp) {
        if (fp.hasIns()) {
            statement.append("(");
            statement.append(HQL_INSTANCE_NAME + "." + fp.getFieldName()
                    + " IN (");
            boolean found = false;
            for (Iterator iter = fp.getInValues().iterator(); iter.hasNext();) {
                String element = (String) iter.next();

                if (found) {
                    statement.append(",");
                }

                statement.append(" '" + getEscaped(element) + "'");
                found = true;
            }
            statement.append("))");

        }
    }

    public void getStatement(StringBuffer statement, String joinOperator,
            String comparisonOperator, String fieldName, Collection values) {

        if (values.size() > 0) {
            statement.append("(");
            boolean found = false;
            for (Iterator iter = values.iterator(); iter.hasNext();) {
                String element = (String) iter.next();
                if (found) {
                    statement.append(" " + joinOperator + " ");
                }

                statement.append(HQL_INSTANCE_NAME + "." + fieldName);
                statement.append(" " + comparisonOperator + " '%"
                        + getEscaped(element) + "%'");
                found = true;
            }
            statement.append(")");

        }

    }

    public String getEscaped(String input) {

        if (input.startsWith("Me 'N")) {
            log.info("escaping " + input);
        }
        String ret = input;

        // replaced single quotes with \'
        ret = ret.replaceAll("'", "''");

        // log.info("Escaped version " + ret);

        return ret;
    }

}
