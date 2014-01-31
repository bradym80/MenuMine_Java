/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.Collection;

import com.fsrin.menumine.common.dao.CriteriaParameters;
import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.context.MenuMineSessionContext;

/**
 * @author Nick
 * 
 *  
 */
public class ChainStateCountServiceDelegateImpl implements
        ChainStateCountServiceDelegate {

    public Object find(Long id) {
        return this.getGenericDao().get(id);
    }

    public Collection search(CriteriaParameters parameters) {
        return this.getGenericDao().find(parameters);
    }

    public void save(Object raw) {
        this.getGenericDao().save(raw);
    }

    public void delete(Object target) {
        this.getGenericDao().delete(target);
    }

    public void setMenuMineSessionContext(
            MenuMineSessionContext menuMineSessionContext) {
    }

    public GenericDAO genericDao;

    public GenericDAO getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDAO genericDao) {
        this.genericDao = genericDao;
    }
}