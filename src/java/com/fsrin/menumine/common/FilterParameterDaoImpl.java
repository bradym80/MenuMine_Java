package com.fsrin.menumine.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Reid
 * 
 * @author Nick
 *  
 */
public class FilterParameterDaoImpl extends HibernateDaoSupport implements
        FilterParameterDao {

    public FilterParameter save(FilterParameter u) {
        this.getHibernateTemplate().saveOrUpdate(u);

        return u;
    }

    public FilterParameter get(Long id) {
        return (FilterParameter) this.getHibernateTemplate().get(
                FilterParameter.class, id);
    }

    public void delete(FilterParameter u) {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    static Log log = LogFactory.getLog(FilterParameterDaoImpl.class.getName());

}