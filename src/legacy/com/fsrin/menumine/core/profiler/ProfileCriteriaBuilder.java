/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;

import org.hibernate.Criteria;

/**
 * @author Nick
 * 
 *  
 */
public interface ProfileCriteriaBuilder {

    public Criteria buildCriteria(Criteria criteria,
            ProfileParameters profileParameters);

    public Class getProfileClass();

    public void setTargetFields(Collection targetFields);
}