/*
 * Created on Jul 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;

import com.fsrin.menumine.common.dao.CriteriaBuilder;
import com.fsrin.menumine.common.dao.CriteriaBuilderException;
import com.fsrin.menumine.common.dao.CriteriaParameters;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStateCountCriteriaBuilder implements CriteriaBuilder {

    public Class getObjectClass() {

        return ChainStateCount.class;
    }

    public void decorateCriteria(Criteria criteria,
            CriteriaParameters parameters) throws CriteriaBuilderException {

        ChainStateCountCriteriaParamerters chainStateCountCriteriaParamerters = (ChainStateCountCriteriaParamerters) parameters;

        if (chainStateCountCriteriaParamerters.getChain() != null) {
            criteria.add(Expression.eq("chain",
                    chainStateCountCriteriaParamerters.getChain()));
        }

        if (chainStateCountCriteriaParamerters.getChains() != null
                && chainStateCountCriteriaParamerters.getChains().size() > 0) {
            Disjunction dis = Expression.disjunction();
            for (Iterator iter = chainStateCountCriteriaParamerters.getChains()
                    .iterator(); iter.hasNext();) {
                String element = (String) iter.next();
                dis.add(Expression.eq("chain", element));

            }
            criteria.add(dis);
        }

    }

}