package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.common.dao.GenericResultCounter;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodBuilder;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;

/**
 * @author Reid
 * 
 * @author Nick
 * 
 */
public class MasterFoodDaoImpl extends HibernateDaoSupport implements
        MasterFoodDao {

    public MasterFood save(MasterFood u) {
        this.getHibernateTemplate().saveOrUpdate(u);
        return u;
    }

    public MasterFood get(Long id) {
        return (MasterFood) this.getHibernateTemplate().get(MasterFood.class,
                id);
    }

    public void delete(MasterFood u) {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    public Collection findUsingCriteria(final MasterFoodFilterParameters params) {

        MasterFoodCriteriaBuilder criteriaBuilder = new MasterFoodCriteriaBuilder();
        Criteria criteria = this.getSession().createCriteria(MasterFood.class);
        criteria = criteriaBuilder.buildCriteria(criteria, params);
        Collection ret = criteria.list();

        return ret;
    }
    
    public Collection findUsingHQLConjunction(final MasterFoodFilterParameters params) {

        StringBuffer q = new MasterFoodQueryBuilder().getConjunctiveQueryWithSelectedFields(params);
        
        
        
        return this.handleFindWithHQL(q,params);

    }
    
    public Collection findUsingHQLDisjunction(final MasterFoodFilterParameters params) {

        StringBuffer q = new MasterFoodQueryBuilder().getDisjunctiveQueryWithSelectedFields(params);
        
        log.info("query " + q);
        
        return this.handleFindWithHQL(q,params);

    }
    
    
    private Collection handleFindWithHQL(StringBuffer q, MasterFoodFilterParameters params) {
        GenericDAO dao = GenericDAOFactory.factory.buildData();
        
        Collection raw = null;
        
        if (params.getLimit() == null || params.getLimit().intValue() == 0)
            raw = dao.find(q.toString());
        else
            raw = dao.find(q.toString(), params.getLimit().intValue());
        
        Collection ret = new MasterFoodBuilder().buildFromObjectCollection(raw,params);
        
        return ret;
    }
    


    public CriteriaImpl criteriaImpl;

    static Log log = LogFactory.getLog(MasterFoodDaoImpl.class.getName());

    /*
     * 2006-01-16 RSC Need to have the count, but this should probably be
     * something with an aggregation function rather than a regular select.
     * 
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao#getCount(com.fsrin.menumine.core.menumine.MasterFoodFilterParameters)
     */
    public Long getCount(MasterFoodFilterParameters masterFood)
            throws Exception {

        
        StringBuffer c = new MasterFoodQueryBuilder().getQueryForCount(masterFood);
        
        return new GenericResultCounter().getCount(c.toString());
    }

    public Collection getDistinct(String query) {
        return this.getHibernateTemplate().find(query);

    }

    public int execute(final String hql) throws Exception {
     
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
    public static final String SELECT_OPERATION_NAME_BY_DISTINCT = "select DISTINCT masterFood.chain.chain from   com.fsrin.menumine.core.menumine.MasterFood as masterFood where masterFood.chain.chain is not null ORDER BY masterFood.chain.chain ASC";

//    public Collection getPageableResults(MasterFoodFilterParametersImpl params) {
//
//        return new MasterFoodPageableResults(params, this);
//    }

    
}