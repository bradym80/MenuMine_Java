/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.express.util;

import java.util.Collection;

/**
 * 2006-04-20 Refactored out since it's also used by the profiler.
 * @author Reid
 */
public class SearchableTokenBuilder {

    public Collection buildSearchableToken(String searchString) {
        String query = searchString;

        Collection tokens = new TokenCollectionBuilder().buildTokens(query);

        Collection filtered = new FilteredTokenCollectionBuilder()
                .getFilteredTokens(tokens);

        Collection cleaned = new CleanedTokenCollectionBuilder()
                .clean(filtered);

        return cleaned;
    }
}
