package net.sf.hibernate.dialect;

import java.sql.Types;

/**
 * An SQL Dialect for Frontbase. Assumes you're using the latest version of the
 * FrontBase JDBC driver, available from <tt>http://frontbase.com/</tt>
 * <p>
 * <b>NOTE </b>: The latest JDBC driver is not always included with the latest
 * release of FrontBase. Download the driver separately, and enjoy the
 * informative release notes.
 * <p>
 * This dialect was tested with JDBC driver version 2.3.1. This driver contains
 * a bug that causes batches of updates to fail. (The bug should be fixed in the
 * next release of the JDBC driver.) If you are using JDBC driver 2.3.1, you can
 * work-around this problem by setting the following in your
 * <tt>hibernate.properties</tt> file: <tt>hibernate.jdbc.batch_size=15</tt>
 * 
 * @author Ron Lussier <tt>rlussier@lenscraft.com</tt>
 */
public class FrontBaseDialect extends Dialect {

    public FrontBaseDialect() {
        super();

        registerColumnType(Types.BIT, "BIT");
        registerColumnType(Types.BIGINT, "LONGINT");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "TINYINT");
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        registerColumnType(Types.VARBINARY, "BIT VARYING($l)");
        registerColumnType(Types.NUMERIC, "NUMERIC(19, $l)");
        registerColumnType(Types.BLOB, "BLOB");
        registerColumnType(Types.CLOB, "CLOB");
    }

    public String getAddColumnString() {
        return "add column";
    }

    public String getCascadeConstraintsString() {
        return " cascade";
    }

    /**
     * Does this dialect support the <tt>FOR UPDATE</tt> syntax. No!
     * 
     * @return false always. FrontBase doesn't support this syntax, which was
     *         dropped with SQL92
     */
    public boolean supportsForUpdate() {
        return false;
    }

}