package com.fsrin.menumine.core.menumine.savedquery;

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

import com.fsrin.menumine.core.menumine.masterfood.MasterFoodCriteriaBuilder;

/**
 * @author Reid
 * 
 * @author Nick
 *  
 */
public class SavedQueryDaoImpl extends HibernateDaoSupport implements
        SavedQueryDao {
    
    static Log log = LogFactory.getLog(SavedQueryDaoImpl.class.getName());
    

    public SavedQuery update(SavedQuery u) {
        
        log.info("saving queryid " + u.getId() + " mf id " + u.getMasterFoodFilterParameters().getId() + " dis id " + u.getFieldsToDisplayBean().getId());
        this.getHibernateTemplate().update(u);

        return u;
    }
    
    public SavedQuery saveNew(SavedQuery u) {
        
        if (u.getId() != null || 
                u.getMasterFoodFilterParameters().getId() != null || 
                u.getFieldsToDisplayBean().getId() != null) {
            
            StringBuffer reason = new StringBuffer();
            reason.append("u.getId() is null " + (u.getId() == null));
            reason.append("u.getMasterFoodFilterParameters().getId is null " + (u.getMasterFoodFilterParameters().getId() == null));
            reason.append("u.getFieldsToDisplayBean().getId is null " + (u.getFieldsToDisplayBean().getId() == null));
            
            throw new RuntimeException("shouldn't be in saveNew. " + reason.toString());
        }
        log.info("saving queryid " + u.getId() + " mf id " + u.getMasterFoodFilterParameters().getId() + " dis id " + u.getFieldsToDisplayBean().getId());
        this.getHibernateTemplate().save(u);

        return u;
    }

    public SavedQuery get(Long id) {
        return (SavedQuery) this.getHibernateTemplate().get(SavedQuery.class,
                id);
    }

    public void delete(SavedQuery u) {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

   

    public Collection search(final SavedQueryFilterParameters parameters) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        final MasterFoodCriteriaBuilder criteriaBuilder = new MasterFoodCriteriaBuilder();

        List ret = (List) hibernateTemplate
                .executeFind(new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        Criteria criteria = session
                                .createCriteria(SavedQuery.class);

                        if (parameters.getName() != null) {
                            criteria.add(Expression.eq("name", parameters
                                    .getName()));
                        }
                        
                        if (parameters.getUserName() != null) {
                            criteria.add(Expression.eq("userName", parameters
                                    .getUserName()));
                        }

                        if (parameters.getGroupName() != null) {
                            criteria.add(Expression.eq("groupName", parameters
                                    .getGroupName()));
                        }
                        if (parameters.getPermissionObject() != null) {
                            criteria.add(Expression.eq("permission", parameters
                                    .getPermissionObject()));
                        }

                        List ret = criteria.list();

                        return ret;
                    }
                });

        return ret;

    }
}