/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.protein;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.profiler.AbstractProfilerCriteriaBuilder;

/**
 * @author Nick
 * 
 *  
 */
public class ProteinProfileBeanCriteriaBuilder extends AbstractProfilerCriteriaBuilder {

    private static Log log = LogFactory.getLog(ProteinProfileBeanCriteriaBuilder.class);
    
    private String fields[] = { "proteinTypeCut", "proteinTopName",
            "proteinAccompName", "stuffName" };

//    public Criteria buildCriteria(Criteria criteria,
//            ProfileParameters profileParameters) {
//
//        /*
//         * We do this to keep the hydrator happy, and to load the chain, since I
//         * know we will need it.
//         */
//        /*
//         * 2006-02-07 RSC Not using for right now.
//         */
////        try {
////            criteria.createCriteria("chain");
////        } catch (HibernateException e) {
////
////            e.printStackTrace();
////        }
//
//        Disjunction dis = Expression.disjunction();
//
//        /*
//         * For each field we handle each param.
//         */
//        for (int i = 0; i < fields.length; i++) {
//            String field = fields[i];
//
//            for (Iterator iter = profileParameters.getParams().iterator(); iter
//                    .hasNext();) {
//                String element = (String) iter.next();
//                dis.add(Expression.ilike(field, "%" + element + "%"));
//            }
//
//        }
//
//
//        criteria.add(dis);
//
//        log.info("criteria is " + criteria);
//        return criteria;
//    }

    public Class getProfileClass() {
        return ProteinProfileBean.class;
    }

}