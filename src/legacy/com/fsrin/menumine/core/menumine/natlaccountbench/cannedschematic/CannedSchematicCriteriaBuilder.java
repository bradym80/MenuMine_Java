/*
 * Created on Jul 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import com.fsrin.menumine.common.dao.CriteriaBuilder;
import com.fsrin.menumine.common.dao.CriteriaBuilderException;
import com.fsrin.menumine.common.dao.CriteriaParameters;

/**
 * @author Nick
 * 
 *  
 */
public class CannedSchematicCriteriaBuilder implements CriteriaBuilder {

    public Class getObjectClass() {

        return CannedSchematicImpl.class;
    }

    public void decorateCriteria(Criteria criteria,
            CriteriaParameters parameters) throws CriteriaBuilderException {

        CannedSchematicCriteriaParamerters cannedSchematicCriteriaParamerters = (CannedSchematicCriteriaParamerters) parameters;
        if (cannedSchematicCriteriaParamerters.getUserName() != null) {
            criteria.add(Expression.eq("userName",
                    cannedSchematicCriteriaParamerters.getUserName()));
        }

        if (cannedSchematicCriteriaParamerters.getGroupName() != null) {
            criteria.add(Expression.eq("groupName",
                    cannedSchematicCriteriaParamerters.getGroupName()));
        }
        if (cannedSchematicCriteriaParamerters.getMineType() != null) {
            criteria.add(Expression.eq("mineType",
                    cannedSchematicCriteriaParamerters.getMineType()));
        }
        if (cannedSchematicCriteriaParamerters.getName() != null) {
            criteria.add(Expression.eq("name",
                    cannedSchematicCriteriaParamerters.getName()));
        }
    }

}