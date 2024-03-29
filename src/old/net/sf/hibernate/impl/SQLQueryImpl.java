//$Id: SQLQueryImpl.java,v 1.3 2005/08/24 04:33:25 nick Exp $
package net.sf.hibernate.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.ScrollableResults;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.type.Type;

/**
 * Implements SQL query passthrough.
 * 
 * <pre>
 * 
 *  
 *   &lt;sql-query name=&quot;mySqlQuery&quot;&gt;
 *   &lt;return alias=&quot;person&quot; class=&quot;eg.Person&quot;/&gt;
 *     SELECT {person}.NAME AS {person.name}, {person}.AGE AS {person.age}, {person}.SEX AS {person.sex}
 *     FROM PERSON {person} WHERE {person}.NAME LIKE 'Hiber%'
 *   &lt;/sql-query&gt;
 *   
 *  
 * </pre>
 * 
 * @author Max Andersen
 */
public class SQLQueryImpl extends AbstractQueryImpl {

    private Class returnClasses[];

    private String returnAliases[];

    private Collection querySpaces;

    SQLQueryImpl(String sql, String returnAliases[], Class returnClasses[],
            SessionImplementor session, Collection querySpaces) {
        super(sql, session);
        this.returnClasses = returnClasses;
        this.returnAliases = returnAliases;
        this.querySpaces = querySpaces;
    }

    public String[] getReturnAliases() {
        return returnAliases;
    }

    public Class[] getReturnClasses() {
        return returnClasses;
    }

    public List list() throws HibernateException {
        verifyParameters();
        Map namedParams = getNamedParams();
        return getSession().findBySQL(bindParameterLists(namedParams),
                returnAliases, returnClasses, getQueryParameters(namedParams),
                querySpaces);
    }

    public Iterator iterate() throws HibernateException {
        throw new UnsupportedOperationException(
                "SQL queries do not currently support iteration");
    }

    public ScrollableResults scroll() throws HibernateException {
        throw new UnsupportedOperationException(
                "SQL queries do not currently support iteration");
    }

    public Type[] getReturnTypes() throws HibernateException {
        Type[] types = new Type[returnClasses.length];
        for (int i = 0; i < returnClasses.length; i++) {
            types[i] = Hibernate.entity(returnClasses[i]);
        }

        return types;
    }
}