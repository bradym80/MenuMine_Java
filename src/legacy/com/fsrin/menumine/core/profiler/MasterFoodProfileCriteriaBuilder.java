/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodProfileCriteriaBuilder extends AbstractProfilerCriteriaBuilder {

    public Criteria buildCriteria(Criteria criteria,
            ProfileParameters profileParameters) {

        /*
         * We do this to keep the hydrator happy, and to load the chain, since I
         * know we will need it.
         */
        try {
            criteria.createCriteria("chain");
        } catch (HibernateException e) {

            e.printStackTrace();
        }

        Disjunction con = Expression.disjunction();

        for (Iterator iter = profileParameters.getParams().iterator(); iter
                .hasNext();) {
            String element = (String) iter.next();
            con.add(Expression.ilike(FieldEnum.TOPPING_FILLED_INGRED
                    .getShortOgnlName(), "%" + element + "%"));
        }

        for (Iterator iter = profileParameters.getParams().iterator(); iter
                .hasNext();) {
            String element = (String) iter.next();
            con.add(Expression.ilike(FieldEnum.SEASONING_BREADING
                    .getShortOgnlName(), "%" + element + "%"));
        }

        criteria.add(con);

        return criteria;
    }

    public Class getProfileClass() {
        return MasterFood.class;
    }

}