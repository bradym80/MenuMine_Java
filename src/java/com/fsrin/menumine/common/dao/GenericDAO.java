/*
 * Created on May 14, 2005 by Reid
 */
package com.fsrin.menumine.common.dao;

import java.util.Collection;

/**
 * @author Reid
 */
public interface GenericDAO {

    public Object get(Long id);
    
    public Object get(Class clazz, Long id);

    public void save(Object target);

    public void delete(Object target);

    public void deleteAll(Collection target);

    public Collection find(CriteriaParameters parameters);
    
    public Collection find(String hql);
    
    public Collection find(String hql, Object objectWithFields);
    
    public Collection find(String hql, int limit);
    
    public int execute(String hql);
    
    public int execute(String hql, Object objectWithUpdateFields);

    
}