/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.common;

import java.util.Collection;

import com.fsrin.menumine.common.dao.CriteriaParameters;
import com.fsrin.menumine.context.MenuMineSessionContextAware;

/**
 * 2006-01-17 RSC Why does this extend MenuMineSessionContextAware?
 * 
 * @author Reid
 * @author Nick
 * 
 *  
 */
public interface ServiceDelegate extends MenuMineSessionContextAware {

    public Object find(Long id) throws ServiceDelegateException;

    public Collection search(CriteriaParameters parameters);

    public void save(Object raw);

    public void delete(Object target);

}