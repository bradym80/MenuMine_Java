package com.fsrin.menumine.core.chainstat;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
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
public class ChainStatDaoImpl extends HibernateDaoSupport implements
        ChainStatDao {

    public ChainStat save(ChainStat chain) {
        this.getHibernateTemplate().saveOrUpdate(chain);
        return chain;
    }

    public ChainStat get(Long id) {
        return (ChainStat) this.getHibernateTemplate().get(ChainStat.class, id);
    }

    public void delete(ChainStat chain) {
        this.getHibernateTemplate().delete(chain);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    public Collection find(final ChainStatFilterParameters params) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        return (List) hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Criteria criteria = session.createCriteria(ChainStat.class);

                if (params.getOperationName() != null) {
                    criteria.add(Expression.ilike("operationName", "%"
                            + params.getOperationName() + "%"));
                }

                if (params.getSectorName() != null
                        && isNotEmpty(params.getSectorName())) {
                    criteria.add(Expression.eq("sectorName", params
                            .getSectorName()));
                }

                if (params.getSegment() != null
                        && isNotEmpty(params.getSegment())) {
                    criteria.add(Expression.eq("segment", params.getSegment()));
                }

                //               if (params.getIncludeChainStateCount() != null
                //                        && params.getIncludeChainStateCount() == Boolean.TRUE) {
                //                    criteria.add(Expression.isNotNull("chainStateCount"));
                //                }

                criteria.addOrder(Order.asc("operationName"));
                List ret = criteria.list();

                return ret;
            }

            private boolean isNotEmpty(String string) {

                if (string.trim().length() > 0) {
                    return true;
                }

                return false;
            }
        });

    }

    static Log log = LogFactory.getLog(ChainStatDaoImpl.class.getName());

    public Collection getDistinct(String query) {
        return this.getHibernateTemplate().find(query);
    }

    public static final String SELECT_MARKET_SECTOR_BY_DISTINCT = "select DISTINCT chainstat.sectorName from   com.fsrin.menumine.core.chainstat.ChainStat as chainstat where chainstat.sectorName is not null ORDER BY chainstat.sectorName ASC";

    public static final String SELECT_MARKET_SEGMENT_BY_DISTINCT = "select DISTINCT chainstat.segment from   com.fsrin.menumine.core.chainstat.ChainStat as chainstat where chainstat.segment is not null ORDER BY chainstat.segment ASC";

    public static final String SELECT_OPERATION_NAME_BY_DISTINCT = "select DISTINCT chainstat.chain from   com.fsrin.menumine.core.chainstat.ChainStat as chainstat where chainstat.chain is not null ORDER BY chainstat.chain ASC";

}

