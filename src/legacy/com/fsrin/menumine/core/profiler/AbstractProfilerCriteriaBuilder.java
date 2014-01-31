/*
 * Created on Apr 19, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;

import com.fsrin.menumine.core.menumine.FieldEnum;

public abstract class AbstractProfilerCriteriaBuilder implements ProfileCriteriaBuilder {

    private Collection targetFields;

    public Collection getTargetFields() {
        return targetFields;
    }

    public void setTargetFields(Collection targetFields) {
        this.targetFields = targetFields;
    }
    
    public Criteria buildCriteria(Criteria criteria,
            ProfileParameters profileParameters) {

        /*
         * We do this to keep the hydrator happy, and to load the chain, since I
         * know we will need it.
         * 
         * 2006-02-07 RSC Eliminated
         */
//        try {
//            criteria.createCriteria("chain");
//        } catch (HibernateException e) {
//
//            e.printStackTrace();
//        }

        Disjunction con = Expression.disjunction();

        /*
         * For each field we handle each param.
         */
//        for (int i = 0; i < fields.length; i++) {
//            String field = fields[i];

        for (Iterator iter = this.getTargetFields().iterator(); iter.hasNext();) {
            FieldEnum field = (FieldEnum) iter.next();
            

            for (Iterator iterParam = profileParameters.getParams().iterator(); iterParam
                    .hasNext();) {
                String element = (String) iterParam.next();
                con.add(Expression.ilike(field.getOgnlName(), "%" + element + "%"));
            }
        }
//        }
        //        for (Iterator iter = profileParameters.getParams().iterator(); iter
        //                .hasNext();) {
        //            String element = (String) iter.next();
        //            con.add(Expression.ilike("itemDescription", "%" + element + "%"));
        //        }

        criteria.add(con);

        return criteria;
    }
    
    
}
