/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.carbo;

import com.fsrin.menumine.core.profiler.AbstractProfilerCriteriaBuilder;

/**
 * @author Nick
 * 
 *  
 */
public class CarboProfileBeanCriteriaBuilder extends AbstractProfilerCriteriaBuilder {

    private String fields[] = { "carboType", "carboAccompName", "carboTopName",
            "otherAccompaniments", "otherIngredName", "otherToppings",
            "stuffName" };

//    public Criteria buildCriteria(Criteria criteria,
//            ProfileParameters profileParameters) {
//
//        /*
//         * We do this to keep the hydrator happy, and to load the chain, since I
//         * know we will need it.
//         * 
//         * 2006-02-07 RSC Eliminated
//         */
////        try {
////            criteria.createCriteria("chain");
////        } catch (HibernateException e) {
////
////            e.printStackTrace();
////        }
//
//        Disjunction con = Expression.disjunction();
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
//                con.add(Expression.ilike(field, "%" + element + "%"));
//            }
//
//        }
//        //        for (Iterator iter = profileParameters.getParams().iterator(); iter
//        //                .hasNext();) {
//        //            String element = (String) iter.next();
//        //            con.add(Expression.ilike("itemDescription", "%" + element + "%"));
//        //        }
//
//        criteria.add(con);
//
//        return criteria;
//    }

    public Class getProfileClass() {
        return CarboProfileBean.class;
    }

}