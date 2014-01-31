//$Id: IngresDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

import java.sql.Types;

/**
 * An Ingres SQL dialect
 * 
 * @author Ian Booth
 */
public class IngresDialect extends Dialect {

    public IngresDialect() {
        super();
        registerColumnType(Types.BIT, "BYTE");
        registerColumnType(Types.BIGINT, "INTEGER4");
        registerColumnType(Types.SMALLINT, "INTEGER2");
        registerColumnType(Types.TINYINT, "INTEGER1");
        registerColumnType(Types.INTEGER, "INTEGER4");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.CHAR, "CHAR($1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "DATE");
        registerColumnType(Types.TIMESTAMP, "DATE");
        registerColumnType(Types.VARBINARY, "VARBINARY($l)");
        registerColumnType(Types.NUMERIC, "NUMERIC(19, $l)");
        registerColumnType(Types.BLOB, "LONG VARCHAR");
        registerColumnType(Types.CLOB, "LONG VARCHAR");
        registerColumnType(Types.VARBINARY, "LONG VARCHAR");
    }

    public String getAddColumnString() {
        return "add column";
    }

    /**
     * Do we need to drop constraints before dropping tables in this dialect?
     * 
     * @return boolean
     */
    public boolean dropConstraints() {
        return false;
    }

    public String getLowercaseFunction() {
        return "lowercase";
    }

}