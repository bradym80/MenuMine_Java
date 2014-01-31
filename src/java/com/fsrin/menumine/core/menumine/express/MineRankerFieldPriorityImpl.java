/*
 * Created on Aug 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public class MineRankerFieldPriorityImpl extends MineRankerAbstractImpl {

    public MineRankerFieldPriorityImpl() {
        super();

    }

    protected Collection handleRanking(Collection mineFieldExpressQueryCounters) {
        Collection ranks = new ArrayList();

        for (Iterator iter = mineFieldExpressQueryCounters.iterator(); iter.hasNext();) {
            MineFieldsExpressQueryCounter element =
                (MineFieldsExpressQueryCounter) iter.next();
            ranks.add(new MineRank(element, element.getRawFieldCount()));
        }
        return ranks;
    }

}