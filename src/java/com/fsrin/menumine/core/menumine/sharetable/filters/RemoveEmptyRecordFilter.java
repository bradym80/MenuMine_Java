/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.AbstractStatisticalTableElement;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * have to remove anything with a key of "none" and then adjust the total size
 * of the sample.
 * 
 * @author Reid
 */
public class RemoveEmptyRecordFilter extends AbstractFilter {

    public void execute(StatisticalTableIF input) throws Exception {
        Collection c = new ArrayList();

        StatisticalTableElementIF none = null;

        for (Iterator iter = input.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            if (element.getName().equals(AbstractStatisticalTableElement.NONE)
                    || element.getName().equals(
                            AbstractStatisticalTableElement.NOT_ON_MENU)) {
                log.debug("found a none record " + element.getNumberInSample());
                none = element;
            } else {
                c.add(element);
            }

        }

        this.handleBuildResults(input,c);
//        FilteredTable table = new FilteredTable();
//
//        table.setRows(c);
//        
//        table.setFieldEnum(input.getFieldEnum());
//
//        this.postFilterDecoration(table);
//
//        this.setResults(table);

    }

}
