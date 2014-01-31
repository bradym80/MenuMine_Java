//$Id: Joinable.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.persister;

/**
 * Anything that can be loaded by outer join - namely persisters for classes or
 * collections.
 * 
 * @author Gavin King
 */
public interface Joinable {
    //should this interface extend PropertyMapping?

    /**
     * An identifying name; a class name or collection role name.
     */
    public String getName();

    /**
     * The table to join to.
     */
    public String getTableName();

    /**
     * All columns to select, when loading.
     */
    public String selectFragment(String alias, String suffix);

    /**
     * Get the where clause part of any joins (optional operation)
     */
    public String whereJoinFragment(String alias, boolean innerJoin,
            boolean includeSubclasses);

    /**
     * Get the from clause part of any joins (optional operation)
     */
    public String fromJoinFragment(String alias, boolean innerJoin,
            boolean includeSubclasses);

    /**
     * The columns to join on.
     */
    public String[] getJoinKeyColumnNames();

    /**
     * Is this instance actually a CollectionPersister?
     */
    public boolean isCollection();

    /**
     * Is this instance actually a many-to-many association?
     */
    public boolean isManyToMany();

    /**
     * Ugly, very ugly....
     */
    public boolean consumesAlias();

}