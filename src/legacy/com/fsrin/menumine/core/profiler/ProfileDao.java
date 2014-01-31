/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fsrin.menumine.common.dao.GenericResultCounter;

/**
 * @author Nick
 * 
 *  
 */
public class ProfileDao extends HibernateDaoSupport {

    private ProfileCriteriaBuilder profileCriteriaBuilder;

    private Collection targetFields;
    
    public static String SPRING_BEAN_NAME = "profileDao";



    public Collection find(final ProfileParameters profileParameters) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        final ProfileCriteriaBuilder criteriaBuilder = this
                .getProfileCriteriaBuilder();

        criteriaBuilder.setTargetFields(this.getTargetFields());
        
        List ret = (List) hibernateTemplate
                .executeFind(new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        Criteria criteria = session
                                .createCriteria(criteriaBuilder
                                        .getProfileClass());

                        criteria = criteriaBuilder.buildCriteria(criteria,
                                profileParameters);

                        //      criteria.setCacheable(true);
                        List ret = criteria.list();

                        return ret;
                    }
                });

        return ret;
    }

    public Long getCount(ProfileParameters profileParameters)
            throws ProfileException {

        Session session = this.getSession();

        Criteria criteria = session.createCriteria(this
                .getProfileCriteriaBuilder().getProfileClass());

        final ProfileCriteriaBuilder criteriaBuilder = this
                .getProfileCriteriaBuilder();

        criteria = criteriaBuilder.buildCriteria(criteria, profileParameters);

        ProjectionList projectionList = Projections.projectionList().add(
                Projections.count("count"), "id");


        criteria.setProjection(projectionList);
        
//        Long count;
//        try {
//            count = new Long(((CriteriaImpl) criteria).count());
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            throw new ProfileException(e);
//        }
//        this.closeSessionIfNecessary(session);

        return new GenericResultCounter().getCount(criteria);
    }

    static Log log = LogFactory.getLog(ProfileDao.class.getName());

    public ProfileCriteriaBuilder getProfileCriteriaBuilder() {
        return profileCriteriaBuilder;
    }

    public void setProfileCriteriaBuilder(
            ProfileCriteriaBuilder profileCriteriaBuilder) {
        this.profileCriteriaBuilder = profileCriteriaBuilder;
    }

    public Collection getTargetFields() {
        return targetFields;
    }

    public void setTargetFields(Collection targetFields) {
        this.targetFields = targetFields;
    }
}