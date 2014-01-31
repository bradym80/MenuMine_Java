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
public class FieldsToDisplayBeanDaoImpl extends HibernateDaoSupport implements
        FieldsToDisplayBeanDao {

    public FieldsToDisplayBean save(FieldsToDisplayBean u) {
        this.getHibernateTemplate().saveOrUpdate(u);

        return u;
    }

    public FieldsToDisplayBean get(Long id) {
        return (FieldsToDisplayBean) this.getHibernateTemplate().get(
                FieldsToDisplayBean.class, id);
    }

    public void delete(FieldsToDisplayBean u) {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    static Log log = LogFactory.getLog(FieldsToDisplayBeanDaoImpl.class
            .getName());

}