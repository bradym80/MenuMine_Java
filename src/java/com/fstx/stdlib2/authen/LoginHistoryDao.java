package com.fstx.stdlib2.authen;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fstx.stdlib2.authen.users.DaoException;

/**
 * 
 * <p>
 * Adapted from the original.
 * 
 * @version 2004-05-26
 * @author Reid
 * @author Nick
 *  
 */
public class LoginHistoryDao extends HibernateDaoSupport {

    public Collection find(final LoginHistoryFilterParameters params) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        return (List) hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Criteria criteria = session.createCriteria(LoginHistory.class);

                if (params.getUsername() != null) {
                    criteria.add(Expression
                            .eq("username", params.getUsername()));
                }
                if (params.getType() != null) {
                    criteria.add(Expression.eq("type", params.getType()));
                }
                if (params.getDateFrom() != null && params.getDateTo() != null) {
                    criteria.add(Expression.between("timestamp", params
                            .getDateFrom(), params.getDateTo()));
                    //log.info("Using a between!");
                } else {
                    //log.info("Not Using a between!");
                    if (params.getDateFrom() != null) {
                        criteria.add(Expression.ge("timestamp", params
                                .getDateFrom()));
                    }
                    if (params.getDateTo() != null) {
                        criteria.add(Expression.le("timestamp", params
                                .getDateTo()));

                    }
                }
                
                if (params.getMax() != null) {
                    criteria.setMaxResults(params.getMax());
                }
                criteria.addOrder(Order.desc("timestamp"));
                List ret = criteria.list();

                return ret;
            }
        });

    }

    /**
     * @param lh
     */
    public LoginHistory save(LoginHistory target) throws DaoException {

        this.getHibernateTemplate().saveOrUpdate(
                target);
        return target;

    }

}