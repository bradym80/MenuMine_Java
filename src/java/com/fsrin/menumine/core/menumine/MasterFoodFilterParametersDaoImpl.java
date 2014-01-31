package com.fsrin.menumine.core.menumine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Reid
 * 
 * @author Nick
 *  
 */
public class MasterFoodFilterParametersDaoImpl extends HibernateDaoSupport
        implements MasterFoodFilterParametersDao {

    public MasterFoodFilterParameters save(MasterFoodFilterParameters u) {
        this.getHibernateTemplate().saveOrUpdate(u);

        return u;
    }

    public MasterFoodFilterParameters get(Long id) {
        return (MasterFoodFilterParameters) this.getHibernateTemplate().get(
                MasterFoodFilterParametersImpl.class, id);
    }

    public void delete(MasterFoodFilterParameters u) {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    static Log log = LogFactory.getLog(MasterFoodFilterParametersDaoImpl.class
            .getName());

}