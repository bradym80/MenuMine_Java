/*
 * Created on May 14, 2005 by Reid
 */
package com.fsrin.menumine.common.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fsrin.menumine.testutil.TimerUtil;

/**
 * @author Reid
 */
public class GenericDAOImpl extends HibernateDaoSupport implements GenericDAO {

    private CriteriaBuilder criteriaBuilder;

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.time.common.dao.GenericDAO#get(java.lang.Long)
     */
    public Object get(Long id) {
//        if (id == null) {
//            return null;
//        }
//        return this.getHibernateTemplate().get(
//                this.getCriteriaBuilder().getObjectClass(), id);
        
        return this.get(this.getCriteriaBuilder().getObjectClass(), id);
    }
    
    public Object get(Class clazz, Long id) {
        if (id == null || clazz == null) {
            return null;
        }
        return this.getHibernateTemplate().get(
                clazz, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.time.common.dao.GenericDAO#save(java.lang.Object)
     */
    public void save(Object target) {

        this.getHibernateTemplate().saveOrUpdate(target);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.time.common.dao.GenericDAO#delete(java.lang.Object)
     */
    public void delete(Object target) {
        this.getHibernateTemplate().delete(target);
    }

    public void deleteAll(Collection target) {
        for (Iterator iter = target.iterator(); iter.hasNext();) {
            Object element = (Object) iter.next();
            this.getHibernateTemplate().deleteAll(target);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fivesticks.time.common.dao.GenericDAO#find(com.fivesticks.time.common.dao.GenericParameters)
     */
    public Collection find(final CriteriaParameters parameters) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        final CriteriaBuilder criteriaBuilder = this.getCriteriaBuilder();

        return (List) hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Criteria criteria = session.createCriteria(criteriaBuilder
                        .getObjectClass());

                try {
                    criteriaBuilder.decorateCriteria(criteria, parameters);
                } catch (CriteriaBuilderException e) {

                    /*
                     * If there is a problem building the criteria we don't want
                     * to send anything back.
                     */
                    e.printStackTrace();
                    return new ArrayList();
                }

                List ret = criteria.list();

                return ret;
            }
        });

    }

    /**
     * @return Returns the criteriaBuilder.
     */
    public CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilder;
    }

    /**
     * @param criteriaBuilder
     *            The criteriaBuilder to set.
     */
    public void setCriteriaBuilder(CriteriaBuilder criteriaBuilder) {
        this.criteriaBuilder = criteriaBuilder;
    }

    public Collection find(String hql) {
        
        
    	HibernateTemplate ht = this.getHibernateTemplate();
    	
        Collection ret = ht.find(hql);
        
        
        return ret;
    }
    
    public Collection find(final String hql, final Object objectWithQueryValues) {
        
        
        
        
        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        Collection ret = (Collection) hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Query query = session.createQuery(hql);
                query.setProperties(objectWithQueryValues);
                return query.list();
                
            }
        });
        
       
        
        
        
        return ret;
    }

    public Collection find(final String hql, final int limit) {
        
        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());
        
        return (List) hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {

                Query q = session.createQuery(hql);
                q.setMaxResults(limit);

                return q.list();
            }
        });
    }

    public int execute(final String hql, final Object objectWithUpdateFields) {
        
        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        Integer ret = (Integer) hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Query query = session.createQuery(hql);
                query.setProperties(objectWithUpdateFields);
                int i = query.executeUpdate();
                return new Integer(i);
            }
        });
        
        return ret.intValue();
    }
    
    public int execute(final String hql) {
        
        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        Integer ret = (Integer) hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Query query = session.createQuery(hql);
                
                int i = query.executeUpdate();
                return new Integer(i);
            }
        });
        
        return ret.intValue();
    }
}