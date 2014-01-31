// $Id: SelectPathExpressionParser.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.hql;

import net.sf.hibernate.QueryException;

public class SelectPathExpressionParser extends PathExpressionParser {

    public void end(QueryTranslator q) throws QueryException {
        if (getCurrentProperty() != null && !q.isShallowQuery()) {
            // "finish off" the join
            token(".", q);
            token(null, q);
        }
        super.end(q);
    }

    protected void setExpectingCollectionIndex() throws QueryException {
        throw new QueryException(
                "expecting .elements or .indices after collection path expression in select");
    }

    public String getSelectName() {
        return getCurrentName();
    }
}

