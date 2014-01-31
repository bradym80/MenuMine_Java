/*
 * Created on Jan 16, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

public abstract class AbstractMasterFoodCriteriaBuilder {

    public abstract Criteria buildCriteria(Criteria criteria,
            MasterFoodFilterParameters params) throws HibernateException;
            
    protected void handleCriteriaDecoration(Criteria criteria,
            MasterFoodFilterParameters params) {
        
        
        Collection paramsList = params.getAll();
        for (Iterator iter = paramsList.iterator(); iter.hasNext();) {
            FilterParameter current = (FilterParameter) iter.next();
            /*
             * We handle the price fields slightly differnt. We need to accout
             * for the fact that the is Empty requires a double.
             *  
             */
            if (current.getFieldName().indexOf("price") > -1) {
                continue;
            }
            this.handleSingleFilterParameter(criteria, current);
        }

        Collection pricingParamsList = params.getAllPricing();
        for (Iterator iter = pricingParamsList.iterator(); iter.hasNext();) {
            FilterParameter current = (FilterParameter) iter.next();
            this.handleSinglePricingFilterParameter(criteria, current);
        }

        /*
         * We need to handle the filter params
         * 
         * 2006-02-06 RSC Removed.
         */
//        Criteria chainCriteria = null;
//        Collection chainParamsList = params.getChain().getAll();
//        for (Iterator iter = chainParamsList.iterator(); iter.hasNext();) {
//            FilterParameter current = (FilterParameter) iter.next();
//            chainCriteria = this.getChainCriteria(criteria, chainCriteria);
//            this.handleSingleFilterParameter(chainCriteria, current);
//        }

        /*
         * 9/19/2005 This is to be handled a bit differently than other
         * parameters. As of now we only worry about if the data is less than
         * the given.
         * 
         * 2006-02-06 RSC Removed.
         */
//        if (params.getChain().getYearPutInDatabase().getAndValues().size() > 0) {
//            String year = (String) params.getChain().getYearPutInDatabase()
//                    .getAndValues().toArray()[0];
//            chainCriteria = this.getChainCriteria(criteria, chainCriteria);
//
//
//            Integer i = Integer.valueOf(year);
//
//            chainCriteria.add(Expression.le(params.getChain()
//                    .getYearPutInDatabase().getFieldName(), i));
//        }
//
//        if (params.getChain().getYearPutInDatabase().getAndValues().size() > 1) {
//            LogFactory.getLog(this.getClass()).info(
//                    "More then one year set for same store!");
//        }
        
    }
    
    private void handleSingleFilterParameter(Criteria criteria,
            FilterParameter current) {

        if (current.getField().getName().equals(FieldEnum.DESCRIPTION.getName())) {
            Conjunction con = Expression.conjunction();

            for (Iterator iterAnd = current.getAndValues().iterator(); iterAnd
                    .hasNext();) {
                String tok = (String) iterAnd.next();
                Disjunction dis = Expression.disjunction();

                for (Iterator iter = FieldEnum.getAll().iterator(); iter
                        .hasNext();) {
                    FieldEnum element = (FieldEnum) iter.next();

                    if (element.getOgnlName().indexOf("chain") > -1) {

                        continue;
                    }
                    if (element.getOgnlName().indexOf("price") > -1) {
                        continue;
                    }

                    dis.add(Expression.ilike(element.getShortOgnlName(), "%"
                            + tok + "%"));

                    //     System.out.println(element.getShortOgnlName() + ": " +
                    // tok);
                }
                con.add(dis);

            }
            criteria.add(con);

            return;
        }

        /*
         * Test to see if there is anything we need to filter by.
         */
        if (current.isFilterEmpty()) {
            return;
        }

        /*
         * We need to preprocess the parameter to look for terms like Poultry
         * and BBQ, where we may want to look at other terms, Chicken and Duck or
         * B-B-Q.
         */

        //        if (current.getField() == FieldEnum.DESCRIPTION) {
        //            System.out.println("DESCRIPTION");
        //        }
        this.preProcessParameters(current);

        String currentFieldName = current.getFieldName();
        /*
         * By placing the 'in' and the 'and' in a conjunction we make this super
         * slow!
         */
        //           Conjunction conjunctionInAnd = Expression.conjunction();
        //                if (current.getInValues().size() > 0) {
        //                    criteria
        //                            .add(Expression.in(currentFieldName, current.getInValues()));
        //                  
        //                }
        if (current.getInValues().size() > 0) {
            Disjunction con = Expression.disjunction();
            for (Iterator iter = current.getInValues().iterator(); iter
                    .hasNext();) {
                String element = (String) iter.next();
                con.add(Expression.eq(currentFieldName, element));

            }
            criteria.add(con);
        }

        //   Conjunction conjunction = Expression.conjunction();

        Disjunction disjunction = Expression.disjunction();

        boolean orHandled = false;

        if (current.getAndValues().size() > 0) {
            // Disjunction dis = Expression.disjunction();
            Conjunction con = Expression.conjunction();
            for (Iterator iter = current.getAndValues().iterator(); iter
                    .hasNext();) {
                String element = (String) iter.next();
                con
                        .add(Expression.ilike(currentFieldName, "%" + element
                                + "%"));
            }
            /* Add the or to the conjunction */
            if (current.getOrValues().size() > 0) {
                Disjunction dis = Expression.disjunction();
                orHandled = true;

                for (Iterator iter = current.getOrValues().iterator(); iter
                        .hasNext();) {
                    String element = (String) iter.next();
                    dis.add(Expression.ilike(currentFieldName, "%" + element
                            + "%"));
                }

                con.add(dis);

            }
            /* Add the or to the conjunction END */

            //     conjunctionInAnd.add(con);
            if (current.getAndValues().size() > 0
                    && current.getOrValues().size() > 0) {
                disjunction.add(con);
            } else {
                criteria.add(con);
            }

        }
        //  disjunction.add(conjunctionInAnd);
        if (!orHandled) {
            if (current.getOrValues().size() > 0) {
                Disjunction dis = Expression.disjunction();

                for (Iterator iter = current.getOrValues().iterator(); iter
                        .hasNext();) {
                    String element = (String) iter.next();
                    dis.add(Expression.ilike(currentFieldName, "%" + element
                            + "%"));
                }

                if (current.getAndValues().size() > 0
                        && current.getOrValues().size() > 0) {
                    disjunction.add(dis);
                } else {
                    criteria.add(dis);
                }

            }
        }
        if (current.getAndValues().size() > 0
                && current.getOrValues().size() > 0) {
            criteria.add(disjunction);
        }

        if (current.getNotValues().size() > 0) {
            Conjunction dis = Expression.conjunction();

            for (Iterator iter = current.getNotValues().iterator(); iter
                    .hasNext();) {
                String element = (String) iter.next();
                if (element.endsWith("'") || element.startsWith("'")) {
                    //Trim off single quotes.
                    element = element.substring(1, element.length() - 1);
                    dis.add(Expression.or(Expression.not(Expression.eq(
                            currentFieldName, element)), Expression
                            .isNull(currentFieldName)));
                } else {
                    dis.add(Expression.or(Expression.not(Expression.ilike(
                            currentFieldName, "%" + element + "%")), Expression
                            .isNull(currentFieldName)));
                }
            }
            criteria.add(dis);
        }

        if (current.getEmpty() != null && current.getEmpty().booleanValue()) {
            Disjunction dis = Expression.disjunction();
            dis.add(Expression.isNull(currentFieldName));
            dis.add(Expression.eq(currentFieldName, ""));
            criteria.add(dis);
        }

        if (current.getEmpty() != null && !current.getEmpty().booleanValue()) {
            Disjunction dis = Expression.disjunction();
            //Conjunction con = Expression.conjunction();
            dis.add(Expression.isNotNull(currentFieldName));
            dis.add(Expression.not(Expression.eq(currentFieldName, "")));
            criteria.add(dis);
        }

    }

    /*
     * We need to preprocess the parameter to look for terms like Poultry and
     * BBQ, where we may want to look at other terms, Chickenand Duck or B-B-Q.
     */
    private void preProcessParameters(FilterParameter current) {

        Collection applicableContexts = new ArrayList();

        Collection ands = current.getAndValues();
        for (Iterator iter = ands.iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            SearchTermContext context = SearchTermContextMapper.singleton
                    .find(element);
            if (context != null) {
                applicableContexts.add(context);

            }
        }

        for (Iterator iter = applicableContexts.iterator(); iter.hasNext();) {
            SearchTermContext element = (SearchTermContext) iter.next();
            element.applyTpParameter(current);
        }

        //        Collection ors = current.getOrValues();
        //        for (Iterator iter = ors.iterator(); iter.hasNext();) {
        //            String element = (String) iter.next();
        //            SearchTermContext context = SearchTermContextMapper.singleton
        //                    .find(element);
        //            if(context!= null){
        //            context.applyTpParameter(current);
        //            }
        //        }

    }

    protected Criteria getChainCriteria(Criteria criteria, Criteria chainCriteria)
            throws HibernateException {
        if (chainCriteria == null) {
            return criteria.createCriteria("chain");
        }
        return chainCriteria;
    }

    private void handleSinglePricingFilterParameter(Criteria criteria,
            FilterParameter current) {

        String currentFieldName = current.getFieldName();

        if (current.getEmpty() != null && current.getEmpty().booleanValue()) {
            Disjunction dis = Expression.disjunction();
            dis.add(Expression.isNull(currentFieldName));
            dis.add(Expression.eq(currentFieldName, new Double(0.0)));
            criteria.add(dis);
        }

        if (current.getEmpty() != null && !current.getEmpty().booleanValue()) {
            Conjunction con = Expression.conjunction();
            con.add(Expression.isNotNull(currentFieldName));
            con.add(Expression.not(Expression.eq(currentFieldName, new Double(
                    0.0))));
            criteria.add(con);
        }

    }
}
