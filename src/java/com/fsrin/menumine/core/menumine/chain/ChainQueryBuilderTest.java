/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.chain;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class ChainQueryBuilderTest extends
        AbstractNonInitializingMenuMineTestCase {

    private static final Log log = LogFactory.getLog(ChainQueryBuilderTest.class);
    
    public void testBasic() throws Exception {
        
        StringBuffer s = new ChainQueryBuilder().buildCountsBySegmentQuery();

        log.info("Query: " + s);
        
        Collection c = GenericDAOFactory.factory.buildData().find(s.toString());
        
        assertTrue( c != null);
        

        assertTrue(c.size() > 50);
        
        assertTrue(c.toArray()[0] instanceof Object[]);
        
    }
    
    public void testBasic_SegmentCountMatches2006DB() throws Exception {
        
        StringBuffer s = new ChainQueryBuilder().buildCountsBySegmentQuery();

        log.info("Query: " + s);
        
        Collection c = GenericDAOFactory.factory.buildData().find(s.toString());
        
        assertTrue( c != null);
        
        log.info("segment size is " + c.size());

        /*
         * 2006-03-11 RSC changing to a range since these numbers swing.
         * Original was 91
         */
        assertTrue(c.size() >=85 && c.size() <= 95);
        
        assertTrue(c.toArray()[0] instanceof Object[]);
        
    }
}
