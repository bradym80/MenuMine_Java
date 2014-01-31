//$Id: QueryParameters.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.engine;

import java.util.Map;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.impl.Printer;
import net.sf.hibernate.type.Type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Gavin King
 */
public final class QueryParameters {

    private static final Log log = LogFactory.getLog(QueryParameters.class);

    private Type[] positionalParameterTypes;

    private Object[] positionalParameterValues;

    private Map namedParameters;

    private Map lockModes;

    private RowSelection rowSelection;

    private boolean cacheable;

    private String cacheRegion;

    public QueryParameters(Type[] positionalParameterTypes,
            Object[] postionalParameterValues) {
        this(positionalParameterTypes, postionalParameterValues, null, null);
    }

    public QueryParameters(final Type[] positionalParameterTypes,
            final Object[] positionalParameterValues, final Map lockModes,
            final RowSelection rowSelection) {
        this(positionalParameterTypes, positionalParameterValues, null,
                lockModes, rowSelection, false, null);
    }

    public QueryParameters(final Type[] positionalParameterTypes,
            final Object[] positionalParameterValues,
            final Map namedParameters, final Map lockModes,
            final RowSelection rowSelection, final boolean cacheable,
            final String cacheRegion) {
        this.positionalParameterTypes = positionalParameterTypes;
        this.positionalParameterValues = positionalParameterValues;
        this.namedParameters = namedParameters;
        this.lockModes = lockModes;
        this.rowSelection = rowSelection;
        this.cacheable = cacheable;
        this.cacheRegion = cacheRegion;
    }

    public boolean hasRowSelection() {
        return rowSelection != null;
    }

    public Map getNamedParameters() {
        return namedParameters;
    }

    public Type[] getPositionalParameterTypes() {
        return positionalParameterTypes;
    }

    public Object[] getPositionalParameterValues() {
        return positionalParameterValues;
    }

    public RowSelection getRowSelection() {
        return rowSelection;
    }

    public void setNamedParameters(Map map) {
        namedParameters = map;
    }

    public void setPositionalParameterTypes(Type[] types) {
        positionalParameterTypes = types;
    }

    public void setPositionalParameterValues(Object[] objects) {
        positionalParameterValues = objects;
    }

    public void setRowSelection(RowSelection selection) {
        rowSelection = selection;
    }

    public Map getLockModes() {
        return lockModes;
    }

    public void setLockModes(Map map) {
        lockModes = map;
    }

    public void traceParameters(SessionFactoryImplementor factory)
            throws HibernateException {
        Printer print = new Printer(factory);
        if (positionalParameterValues.length != 0)
            log.trace("parameters: "
                    + print.toString(positionalParameterTypes,
                            positionalParameterValues));
        if (namedParameters != null)
            log.trace("named parameters: " + print.toString(namedParameters));
    }

    public boolean isCacheable() {
        return cacheable;
    }

    public void setCacheable(boolean b) {
        cacheable = b;
    }

    public String getCacheRegion() {
        return cacheRegion;
    }

    public void setCacheRegion(String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

}