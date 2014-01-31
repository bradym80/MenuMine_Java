//$Id: QueryKey.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.QueryParameters;
import net.sf.hibernate.engine.RowSelection;
import net.sf.hibernate.engine.TypedValue;
import net.sf.hibernate.type.Type;
import net.sf.hibernate.util.EqualsHelper;

/**
 * A key that identifies a particular query with bound parameter values
 * 
 * @author Gavin King
 */
public class QueryKey implements Serializable {
    private final String sqlQueryString;

    private final Type[] types;

    private final Object[] values;

    private final Integer firstRow;

    private final Integer maxRows;

    private final Map namedParameters;

    public QueryKey(String queryString, QueryParameters queryParameters) {
        this.sqlQueryString = queryString;
        this.types = queryParameters.getPositionalParameterTypes();
        this.values = queryParameters.getPositionalParameterValues();
        RowSelection selection = queryParameters.getRowSelection();
        if (selection != null) {
            firstRow = selection.getFirstRow();
            maxRows = selection.getMaxRows();
        } else {
            firstRow = null;
            maxRows = null;
        }
        this.namedParameters = queryParameters.getNamedParameters();
    }

    public boolean equals(Object other) {
        QueryKey that = (QueryKey) other;
        if (!sqlQueryString.equals(that.sqlQueryString))
            return false;
        if (!EqualsHelper.equals(firstRow, that.firstRow)
                || !EqualsHelper.equals(maxRows, that.maxRows))
            return false;
        if (types == null) {
            if (that.types != null)
                return false;
        } else {
            if (that.types == null)
                return false;
            if (types.length != that.types.length)
                return false;
            for (int i = 0; i < types.length; i++) {
                if (!types[i].equals(that.types[i]))
                    return false;
                try {
                    if (!types[i].equals(values[i], that.values[i]))
                        return false;
                } catch (HibernateException he) {
                    return false;
                }
            }
        }
        if (namedParameters == null) {
            if (that.namedParameters != null)
                return false;
        } else {
            if (that.namedParameters == null)
                return false;
            if (namedParameters.size() != that.namedParameters.size())
                return false;
            Iterator iter = namedParameters.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry me = (Map.Entry) iter.next();
                TypedValue thisTv = (TypedValue) me.getValue();
                TypedValue thatTv = (TypedValue) that.namedParameters.get(me
                        .getKey());
                if (thatTv == null)
                    return false;
                if (!thatTv.getType().equals(thisTv.getType()))
                    return false;
                try {
                    if (!thisTv.getType().equals(thisTv.getValue(),
                            thatTv.getValue()))
                        return false;
                } catch (HibernateException he) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        return sqlQueryString.hashCode(); //TODO: VERY inefficient!!!!
    }
}