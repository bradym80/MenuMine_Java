//$Id: SQLFunction.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

import net.sf.hibernate.QueryException;
import net.sf.hibernate.engine.Mapping;
import net.sf.hibernate.type.Type;

/**
 * Provides support routines for the HQL functions as used in the various SQL
 * Dialects
 * 
 * Provides an interface for supporting various HQL functions that are
 * translated to SQL. The Dialect and its sub-classes use this interface to
 * provide details required for processing of the function.
 * 
 * @author David Channon
 */
public interface SQLFunction {
    public Type getReturnType(Type columnType, Mapping mapping)
            throws QueryException;

    public boolean hasArguments();

    public boolean hasParenthesesIfNoArguments();
}