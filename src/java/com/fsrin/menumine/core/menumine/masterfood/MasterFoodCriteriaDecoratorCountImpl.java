/*
 * Created on Nov 28, 2005 by Reid
 */
package com.fsrin.menumine.core.menumine.masterfood;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

public class MasterFoodCriteriaDecoratorCountImpl extends
        AbstractMasterFoodCriteriaBuilder {


    public Criteria buildCriteria(Criteria criteria,
            MasterFoodFilterParameters params) throws HibernateException {


        ProjectionList projectionList = Projections.projectionList().add(
                Projections.count("id"), "id");


        criteria.setProjection(projectionList);

        /*
         * 2006-01-16 RSC OK now we can decorate with whatever filters are there.
         */
        this.handleCriteriaDecoration(criteria, params);
        
        return criteria;
    }

}
