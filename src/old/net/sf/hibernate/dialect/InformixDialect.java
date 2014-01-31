package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.MappingException;

/**
 * Informix dialect. This class is required in order to use Hibernate with
 * Informix. <br>
 * <br>
 * Seems to work with Informix Dynamic Server Version 7.31.UD3, Informix JDBC
 * driver version 2.21JC3.
 * 
 * @author Steve Molitor
 */
public class InformixDialect extends Dialect {

    /**
     * Creates new <code>InformixDialect</code> instance. Sets up the JDBC /
     * Informix type mappings.
     */
    public InformixDialect() {
        super();

        registerColumnType(Types.BIGINT, "INT8");
        registerColumnType(Types.BINARY, "BYTE");
        registerColumnType(Types.BIT, "SMALLINT"); // Informix doesn't have a
        // bit type
        registerColumnType(Types.CHAR, "CHAR($l)");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.DECIMAL, "DECIMAL");
        registerColumnType(Types.DOUBLE, "DOUBLE");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.LONGVARBINARY, "BLOB"); // or BYTE
        registerColumnType(Types.LONGVARCHAR, "CLOB"); // or TEXT?
        registerColumnType(Types.NUMERIC, "DECIMAL"); // or MONEY
        registerColumnType(Types.REAL, "SMALLFLOAT");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TIME, "DATETIME YEAR TO FRACTION(5)");
        registerColumnType(Types.TIMESTAMP, "DATETIME HOUR TO SECOND");
        registerColumnType(Types.TINYINT, "SMALLINT");
        registerColumnType(Types.VARBINARY, "BYTE");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
    }

    /**
     * @see net.sf.hibernate.dialect.Dialect#getAddColumnString()
     */
    public String getAddColumnString() {
        return "add";
    }

    /**
     * @see net.sf.hibernate.dialect.Dialect#supportsIdentityColumns()
     */
    public boolean supportsIdentityColumns() {
        return true;
    }

    /**
     * @see net.sf.hibernate.dialect.Dialect#getIdentitySelectString()
     */
    public String getIdentitySelectString() throws MappingException {
        return "select first 1 dbinfo('sqlca.sqlerrd1') from systables";
    }

    /**
     * @see net.sf.hibernate.dialect.Dialect#getIdentityColumnString()
     */
    public String getIdentityColumnString() throws MappingException {
        return "SERIAL NOT NULL";
    }

}