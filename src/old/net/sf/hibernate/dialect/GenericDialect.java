//$Id: GenericDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

import java.sql.Types;

/**
 * A generic SQL dialect which may or may not work on any actual databases
 * 
 * @author Gavin King
 */
public class GenericDialect extends Dialect {

    public GenericDialect() {
        super();
        registerColumnType(Types.BIT, "BIT");
        registerColumnType(Types.BIGINT, "BIGINT");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "TINYINT");
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        registerColumnType(Types.VARBINARY, "VARBINARY($l)");
        registerColumnType(Types.NUMERIC, "NUMERIC(19, $l)");
        registerColumnType(Types.BLOB, "BLOB");
        registerColumnType(Types.CLOB, "CLOB");
    }

}

