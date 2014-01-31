package com.fsrin.menumine.core.menumine.chain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Reid
 * 
 * @author Nick
 *  
 */
public class ChainFilterParametersDaoImpl extends HibernateDaoSupport implements
        ChainFilterParametersDao {

    public ChainFilterParameters save(ChainFilterParameters u) {
        this.getHibernateTemplate().saveOrUpdate(u);

        return u;
    }

    public ChainFilterParameters get(Long id) {
        return (ChainFilterParameters) this.getHibernateTemplate().get(
                ChainFilterParameters.class, id);
    }

    public void delete(ChainFilterParameters u) {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    static Log log = LogFactory.getLog(ChainFilterParametersDaoImpl.class
            .getName());

}