package com.fsrin.menumine.core.menumine.chain;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * @author Reid
 * 
 * @author Nick
 *  
 */
public class ChainDaoImpl extends HibernateDaoSupport implements ChainDao {

    public Chain save(Chain chain) {
        this.getHibernateTemplate().saveOrUpdate(chain);
        return chain;
    }

    public Chain get(Long id) {
        return (Chain) this.getHibernateTemplate().get(Chain.class, id);
    }

    public void delete(Chain chain) {
        this.getHibernateTemplate().delete(chain);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    public Collection find(final ChainFilterParameters params) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        return (List) hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Criteria criteria = session.createCriteria(Chain.class);

                
                criteria.addOrder(Order.asc("operationName"));
                List ret = criteria.list();

                return ret;
            }
        });

    }

    static Log log = LogFactory.getLog(ChainDaoImpl.class.getName());
}