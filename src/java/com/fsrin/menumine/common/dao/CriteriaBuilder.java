/*
 * Created on May 17, 2005 by Reid
 */
package com.fsrin.menumine.common.dao;

import org.hibernate.Criteria;

/**
 * @author Reid
 */
public interface CriteriaBuilder {

    public Class getObjectClass();

    public void decorateCriteria(Criteria criteria,
            CriteriaParameters parameters) throws CriteriaBuilderException;

}