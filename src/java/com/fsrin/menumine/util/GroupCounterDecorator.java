/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.util;

import java.util.Collection;
import java.util.Iterator;

public class GroupCounterDecorator {

    public void decorateWithShare(Collection c) {
        
        Integer total = new GroupCounterTotaller().getTotal(c);
        
        for (Iterator iter = c.iterator(); iter.hasNext();) {
            GroupCounterVO element = (GroupCounterVO) iter.next();
            
            double share = (double) element.getCount().intValue() / (double) total.intValue();
            
            element.setShare(new Double(share));
            
        }
    }
}
