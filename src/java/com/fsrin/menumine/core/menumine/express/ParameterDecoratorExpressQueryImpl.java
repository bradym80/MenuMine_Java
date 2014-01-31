/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.express.util.CleanedTokenCollectionBuilder;
import com.fsrin.menumine.core.menumine.express.util.FilteredTokenCollectionBuilder;
import com.fsrin.menumine.core.menumine.express.util.TokenCollectionBuilder;

public class ParameterDecoratorExpressQueryImpl extends
        AbstractParameterDecorator implements ParameterDecorator {

    public void decorate(Object expressQuery) {

        Collection c = this.getCleanTokens(expressQuery);

        this.getTargetParameters().getItemDescription().setAndValues(c);

        // this.getTargetParameters().getKeywords().setAndValues(c);

    }

    private Collection getCleanTokens(Object expressQuery) {

        String query = (String) expressQuery;

        Collection tokens = new TokenCollectionBuilder().buildTokens(query);

        Collection filtered = new FilteredTokenCollectionBuilder()
                .getFilteredTokens(tokens);

        Collection cleaned = new CleanedTokenCollectionBuilder()
                .clean(filtered);

        return cleaned;

    }

}
