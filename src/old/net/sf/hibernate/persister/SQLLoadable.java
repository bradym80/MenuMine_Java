//$Id: SQLLoadable.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.persister;

import net.sf.hibernate.type.Type;

/**
 * A class persister that supports queries expressed in the platform native SQL
 * dialect
 * 
 * @see net.sf.hibernate.loader.SQLLoader
 * @author Gavin King, Max Andersen
 */
public interface SQLLoadable extends Loadable {

    /**
     * Return the column alias names used to persist/query the numbered property
     * of the class or a subclass (optional operation).
     */
    public String[] getSubclassPropertyColumnAliases(String propertyName,
            String suffix);

    /**
     * All columns to select, when loading.
     */
    public String selectFragment(String alias, String suffix);

    /**
     * Get the type
     */
    public Type getType();

}