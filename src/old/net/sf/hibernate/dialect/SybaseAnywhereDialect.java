package net.sf.hibernate.dialect;

/**
 * SQL Dialect for Sybase Anywhere extending Sybase (Enterprise) Dialect (Tested
 * on ASA 8.x)
 * 
 * @author ?
 */
public class SybaseAnywhereDialect extends SybaseDialect {

    /**
     * Sybase Anywhere syntax would require a "DEFAULT" for each column
     * specified, but I suppose Hibernate use this syntax only with tables with
     * just 1 column
     */
    public String getNoColumnsInsertString() {
        //return "DEFAULT VALUES";
        return "VALUES (DEFAULT)";
    }

    /**
     * ASA does not require to drop constraint before dropping tables, and DROP
     * statement syntax used by Hibernate to drop constraint is not compatible
     * with ASA, so disable it
     */
    public boolean dropConstraints() {
        return false;
    }

    public char closeQuote() {
        return '"';
    }

    public char openQuote() {
        return '"';
    }

}