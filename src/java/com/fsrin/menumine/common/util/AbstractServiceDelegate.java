/*
 * Created on Jun 5, 2005
 *
 */
package com.fsrin.menumine.common.util;

import com.fsrin.menumine.common.dao.GenericDAO;

/**
 * <p>Based on a standard FiveSticks.com tool.  Imported to MM 2006-04-13 
 * 
 * @author Reid
 * 
 */
public abstract class AbstractServiceDelegate  {

    private GenericDAO dao;


    /**
     * @return Returns the dao.
     */
    public GenericDAO getDao() {
        return dao;
    }

    /**
     * @param dao
     *            The dao to set.
     */
    public void setDao(GenericDAO dao) {
        this.dao = dao;
    }


}
