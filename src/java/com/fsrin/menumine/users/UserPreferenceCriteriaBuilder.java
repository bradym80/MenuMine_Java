/*
 * Created on Apr 12, 2006 by Reid
 */
package com.fsrin.menumine.users;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

import com.fsrin.menumine.common.dao.CriteriaBuilder;
import com.fsrin.menumine.common.dao.CriteriaBuilderException;
import com.fsrin.menumine.common.dao.CriteriaParameters;
import com.fsrin.menumine.common.util.ValidationHelper;

public class UserPreferenceCriteriaBuilder implements CriteriaBuilder {

    public Class getObjectClass() {

        return UserPreference.class;
    }

    public void decorateCriteria(Criteria criteria,
            CriteriaParameters parameters) throws CriteriaBuilderException {
        
        if (!(parameters instanceof UserPreferenceCriteriaParameters)) {
            throw new RuntimeException("Wrong parameters type");
        }
        
        UserPreferenceCriteriaParameters params = (UserPreferenceCriteriaParameters) parameters;
        
        ValidationHelper help = new ValidationHelper();


        if (!help.isStringEmpty(params.getKey())) {
            criteria.add(Expression.eq("key", params.getKey()));
        }
        
        if (!help.isStringEmpty(params.getUsername())) {
            criteria.add(Expression.eq("username", params.getUsername()));
        }
        
     
        
    }

}
