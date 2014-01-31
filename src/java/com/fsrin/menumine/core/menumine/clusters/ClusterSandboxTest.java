/*
 * Created on Mar 29, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.clusters;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * 2006-03-29 Just want to get a handle on how some of these data manipulations
 * might work.
 * 
 * @author Reid
 */
public class ClusterSandboxTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasic() throws Exception {

        // start with some basic queries.

        ClusterBuilder cb = new ClusterBuilder(FieldEnum.SAUCE_OR_CONDIMENT);

        cb.getExcludedTerms().add("dressing");
        cb.getExcludedTerms().add("marinade");
        cb.reduceToClusters();

        Collection terms = cb.getCommonTerms().keySet();

        for (Iterator iter = terms.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            // log.info("term " + element + " count " +
            // cb.getCommonTerms().get(element));

        }

        log.info("total element count " + terms.size());

        log.info("sorted size: " + cb.getSortedTerms().size());
        
//        for (Iterator iter = cb.getSortedTerms().iterator(); iter.hasNext();) {
//            AutoRollUpWordCountVO element = (AutoRollUpWordCountVO) iter.next();
//            if (element.getCount() > 1) {
//                log.info(element.getName() + ": " + element.getCount());
//            }
//        }

        log.info("orphan count: " + cb.getOrphans().size());
//        for (Iterator iterator = cb.getOrphans().iterator(); iterator.hasNext();) {
//            StatisticalTableElementIF element = (StatisticalTableElementIF) iterator.next();
////            log.info(element.getName());
//            
//        }
        
    }
}
