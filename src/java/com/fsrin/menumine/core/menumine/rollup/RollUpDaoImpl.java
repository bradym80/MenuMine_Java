package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Reid
 * 
 * @author Nick
 * 
 */
public class RollUpDaoImpl extends HibernateDaoSupport implements RollUpDao {

    static Log log = LogFactory.getLog(RollUpDaoImpl.class.getName());

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    public void delete(RollUpOptions u) {
        if (u == null || u.getId() == null) {
            return;
        }
        this.getHibernateTemplate().delete(u);
    }

    public RollUpOptions get(Long id) {
        return (RollUpOptions) this.getHibernateTemplate().get(
                RollUpOptions.class, id);
    }

    public RollUpOptions save(RollUpOptions u) {
        this.getHibernateTemplate().saveOrUpdate(u);

        return u;
    }

    public Collection search(final RollUpFilterParameters parameters) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        // final CriteriaBuilder criteriaBuilder = new CriteriaBuilder();

        List ret = (List) hibernateTemplate
                .executeFind(new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        Criteria criteria = session
                                .createCriteria(RollUpOptions.class);

                        if (parameters.getUserName() != null) {
                            criteria.add(Expression.eq("userName", parameters
                                    .getUserName()));
                        }

                        if (parameters.getGroupName() != null) {
                            criteria.add(Expression.eq("groupName", parameters
                                    .getGroupName()));
                        }
                        if (parameters.getPermission() != null) {
                            criteria.add(Expression.eq("permission", parameters
                                    .getPermission()));
                        }
                        if (parameters.getName() != null) {
                            criteria.add(Expression.eq("name", parameters
                                    .getName()));
                        }

                        List ret = criteria.list();

                        return ret;
                    }
                });

        return ret;

    }
}