/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FilteredTokenCollectionBuilder {

    public Collection getFilteredTokens(Collection tokens) {
        Collection filteredTokens = new ArrayList();

        for (Iterator iter = tokens.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            if (element.length() > 1) {
                filteredTokens.add(element);
            }
        }

        return filteredTokens;
    }
}
