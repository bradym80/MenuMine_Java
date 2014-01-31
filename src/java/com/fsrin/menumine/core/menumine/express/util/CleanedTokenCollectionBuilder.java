/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CleanedTokenCollectionBuilder {

    public Collection clean(Collection tokenCollection) {
        
        Collection cleanedTokens = new ArrayList();

        for (Iterator iter = tokenCollection.iterator(); iter.hasNext();) {
            String element = (String) iter.next();

            if (element.trim().endsWith(",")) {
                int index = element.indexOf(',');

                element = element.replace(',', ' ');

            }

            String cleaned = element.trim();

            cleanedTokens.add(cleaned);

        }

        return cleanedTokens;
        
    }
}
