//$Id: SybaseDialect.java,v 1.3 2005/08/24 04:33:26 nick Exp $
package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;

/**
 * An SQL dialect compatible with Sybase and MS SQL Server.
 * 
 * @author Gavin King
 */

public class SybaseDialect extends Dialect {
    public SybaseDialect() {
        super();
        registerColumnType(Types.BIT, "TINYINT"); //Sybase BIT type does not
        // support null values
        registerColumnType(Types.BIGINT, "NUMERIC(19,0)");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "TINYINT");
        registerColumnType(Types.INTEGER, "INT");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATETIME");
        registerColumnType(Types.TIME, "DATETIME");
        registerColumnType(Types.TIMESTAMP, "DATETIME");
        registerColumnType(Types.VARBINARY, "VARBINARY($l)");
        registerColumnType(Types.NUMERIC, "NUMERIC(19,$l)");
        registerColumnType(Types.BLOB, "IMAGE");
        registerColumnType(Types.CLOB, "TEXT");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                NO_BATCH);
    }

    public String getAddColumnString() {
        return "add";
    }

    public String getNullColumnString() {
        return " null";
    }

    public boolean qualifyIndexName() {
        return false;
    }

    public boolean supportsForUpdate() {
        return false;
    }

    public boolean supportsIdentityColumns() {
        return true;
    }

    public String getIdentitySelectString() {
        return "select @@identity";
    }

    public String getIdentityColumnString() {
        return "IDENTITY NOT NULL";
    }

    public String getNoColumnsInsertString() {
        return "DEFAULT VALUES";
    }

    public char closeQuote() {
        return ']';
    }

    public char openQuote() {
        return '[';
    }

}

