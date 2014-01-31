/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.util;

import java.util.Collection;
import java.util.Iterator;

public class GroupCounterTotaller {

//    private Log log = LogFactory.getLog(GroupCounterTotaller.class);
    
    public Integer getTotal(Collection c) {
        
        int ret = 0;
        
        for (Iterator iter = c.iterator(); iter.hasNext();) {
            ItemCountAwareIF element = (ItemCountAwareIF) iter.next();
            if (element.getCount() != null) {
                ret+=element.getCount().intValue();
            }
        }
        
//        log.info ("total for current rows is " + ret);
        return new Integer(ret);
    }
}
