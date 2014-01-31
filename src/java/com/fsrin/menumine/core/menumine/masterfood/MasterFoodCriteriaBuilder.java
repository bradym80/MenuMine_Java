/*
 * Created on Jan 27, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodCriteriaBuilder extends AbstractMasterFoodCriteriaBuilder {



    public Criteria buildCriteria(Criteria criteria,
            MasterFoodFilterParameters params) throws HibernateException {

        /*
         * 2006-01-16 RSC this parts the same as the aggregation criteria builder.
         */
        this.handleCriteriaDecoration(criteria, params);

        /*
         * Handle the limiting and sorting.
         */
        if (params.getLimit() != null) {
            criteria.setMaxResults(params.getLimit().intValue());
        }

        if (params.getFirstResult() != null) {
            criteria.setFirstResult(params.getFirstResult().intValue());
        }

        /*
         * nick 2005-1-24 Unfortunitly we cannot order by subcriteria We will
         * have to sort the results in a treeset as a display property.
         */
        if (params.getOrderBy() != null) {
            String orderBy = params.getOrderBy();
            /*
             * 2006-01-16 RSC 
             */
            if (orderBy.startsWith("chain.")) {
//                chainCriteria = this.getChainCriteria(criteria, chainCriteria);
                orderBy = orderBy.replaceAll("chain.", "");

                if (params.isSortAsc() && orderBy != null) {

                    //   chainCriteria.addOrder(Order.asc(orderBy));

                } else if (!params.isSortAsc() && orderBy != null) {

                    //   chainCriteria.addOrder(Order.desc(orderBy));

                }

            } else {
                if (params.isSortAsc() && params.getOrderBy() != null) {
                    criteria.addOrder(Order.asc(params.getOrderBy()));

                } else if (!params.isSortAsc() && params.getOrderBy() != null) {
                    criteria.addOrder(Order.desc(params.getOrderBy()));

                }

            }

        }

        //        criteria.setFetchSize(50);
        return criteria;

    }



}