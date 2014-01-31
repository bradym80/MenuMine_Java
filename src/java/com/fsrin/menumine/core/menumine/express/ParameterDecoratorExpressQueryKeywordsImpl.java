/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.express.util.SearchableTokenBuilder;

public class ParameterDecoratorExpressQueryKeywordsImpl extends
        AbstractParameterDecorator implements ParameterDecorator {

    public void decorate(Object expressQuery) {

        Collection c = this.getCleanTokens(expressQuery);

        // this.getTargetParameters().getItemDescription().setAndValues(c);

        this.getTargetParameters().getKeywords().setAndValues(c);

    }

    private Collection getCleanTokens(Object expressQuery) {

        return new SearchableTokenBuilder()
                .buildSearchableToken((String) expressQuery);

    }

}
