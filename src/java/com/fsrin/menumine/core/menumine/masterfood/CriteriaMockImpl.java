/*
 * Created on Jun 15, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.transform.ResultTransformer;

/**
 * @author Nick
 * 
 *  
 */
public class CriteriaMockImpl implements Criteria {

    public CriteriaMockImpl() {
        super();

    }

    public Criteria setMaxResults(int maxResults) {

        return null;
    }

    public Criteria setFirstResult(int firstResult) {

        return null;
    }

    public Criteria setTimeout(int timeout) {

        return null;
    }

    Collection criterions = new ArrayList();

    public Criteria add(Criterion criterion) {

        criterions.add(criterion);

        return this;
    }

    public Criteria addOrder(Order order) {

        return null;
    }

    public List list() throws HibernateException {

        return null;
    }

    public long count() throws HibernateException {

        return 0;
    }

    public Object uniqueResult() throws HibernateException {

        return null;
    }

    public Criteria setFetchMode(String associationPath, FetchMode mode)
            throws HibernateException {

        return null;
    }

    public Criteria createAlias(String associationPath, String alias)
            throws HibernateException {

        return null;
    }

    public Criteria createCriteria(String associationPath)
            throws HibernateException {

        return null;
    }

    public Criteria createCriteria(String associationPath, String alias)
            throws HibernateException {

        return null;
    }

    public Class getCriteriaClass() {

        return null;
    }

    public Class getCriteriaClass(String alias) {

        return null;
    }

    public Criteria returnMaps() {

        return null;
    }

    public Criteria returnRootEntities() {

        return null;
    }

    public Criteria setLockMode(LockMode lockMode) {

        return null;
    }

    public Criteria setLockMode(String alias, LockMode lockMode) {

        return null;
    }

    public Criteria setProjection(Projection arg0) {
        
        return null;
    }

    public String getAlias() {
        
        return null;
    }

    public Criteria setResultTransformer(ResultTransformer arg0) {
        
        return null;
    }

    public Criteria setFetchSize(int arg0) {
        
        return null;
    }

    public Criteria setCacheable(boolean arg0) {
        
        return null;
    }

    public Criteria setCacheRegion(String arg0) {
        
        return null;
    }

    public ScrollableResults scroll() throws HibernateException {
        
        return null;
    }

    public ScrollableResults scroll(ScrollMode arg0) throws HibernateException {
        
        return null;
    }

    public Criteria setComment(String arg0) {
        
        return null;
    }

    public Criteria setFlushMode(FlushMode arg0) {
        
        return null;
    }

    public Criteria setCacheMode(CacheMode arg0) {
        
        return null;
    }

}