
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * 2006-01-18 RSC
 * @author Reid
 * 
 * 
 *
 *  
 */
public class MasterFoodCriteriaBuilderExpressImpl extends AbstractMasterFoodCriteriaBuilder {



    public Criteria buildCriteria(Criteria criteria,
            MasterFoodFilterParameters params) throws HibernateException {

        /*
         * 2006-01-16 RSC this parts the same as the aggregation criteria builder.
         * 2006-01-18 RSC skilling this since we're express.
         */
        //this.handleCriteriaDecoration(criteria, params);
        for (Iterator iter = params.getItemDescription().getAndValues().iterator(); iter.hasNext();) {
            String element = (String) iter.next();
            criteria.add(Expression.like("itemDescription", "%"+element+"%"));
        }

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