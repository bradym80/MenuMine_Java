//$Id: Value.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import java.util.Iterator;

import net.sf.hibernate.MappingException;
import net.sf.hibernate.engine.Mapping;
import net.sf.hibernate.type.Type;

/**
 * A value is anything that is persisted by value, instead of by reference. It
 * is essentially a Hibernate Type, together with zero or more columns. Values
 * are wrapped by things with higher level semantics, for example properties,
 * collections, classes.
 * 
 * @author Gavin King
 */
public interface Value {
    public int getColumnSpan();

    public Iterator getColumnIterator();

    public Type getType();

    public int getOuterJoinFetchSetting();

    public Table getTable();

    public Formula getFormula();

    public boolean isUnique();

    public boolean isNullable();

    public void createForeignKey();

    public boolean isSimpleValue();

    public boolean isValid(Mapping mapping) throws MappingException;
}