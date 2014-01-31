//$Id: Parser.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.hql;

import net.sf.hibernate.QueryException;

/**
 * A parser is a state machine that accepts a string of tokens, bounded by
 * start() and end() and modifies a QueryTranslator. Parsers are NOT intended to
 * be threadsafe. They SHOULD be reuseable for more than one token stream.
 */

public interface Parser {
    public void token(String token, QueryTranslator q) throws QueryException;

    public void start(QueryTranslator q) throws QueryException;

    public void end(QueryTranslator q) throws QueryException;
}

