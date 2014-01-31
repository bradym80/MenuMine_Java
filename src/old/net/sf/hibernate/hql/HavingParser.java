//$Id: HavingParser.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.hql;

/**
 * Parses the having clause of a hibernate query and translates it to an SQL
 * having clause.
 */
public class HavingParser extends WhereParser {

    void appendToken(QueryTranslator q, String token) {
        q.appendHavingToken(token);
    }

}