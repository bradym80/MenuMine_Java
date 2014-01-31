/*
 * Created on Jan 16, 2006
 *
 */
package com.fsrin.menumine.common.dao;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;

/**
 * 2006-01-16 RSC a bit of a hack so I don't have to refactor all of the DAO and SD
 * @author Reid
 *
 */
public class GenericResultCounter {

    private static Log log = LogFactory.getLog(GenericResultCounter.class);
    
    public Long getCount(final Criteria criteria) {
        
        Collection c = criteria.list();

        return this.parseCountFromResults(c);
    }
    
    private Long parseCountFromResults(Collection c) {
        

        Integer count = new Integer(0);

        if (c.size() == 1) {
            count = (Integer) c.toArray()[0];
        }
        
        return new Long(count.intValue());
    }
    
    public Long getCount(final String hql) {
        
        Collection c = GenericDAOFactory.factory.buildData().find(hql);
        
        return this.parseCountFromResults(c);
    }
    
    public Integer[] getTwoCounts(final String hql) {

        Integer[] ret = {null,null};
        Collection c = GenericDAOFactory.factory.buildData().find(hql);

        if (c.size() == 1) {
            Object[] temp = (Object[]) c.toArray()[0];
            ret[0] = (Integer) temp[0];
            ret[1] = (Integer) temp[1]; 
        }
     
        return ret;
        
    }
    
    

}
