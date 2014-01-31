//$Id: MySQLDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.util.StringHelper;

/**
 * An SQL dialect for MySQL.
 * 
 * @author Gavin King
 */
public class MySQLDialect extends Dialect {
    public MySQLDialect() {
        super();
        registerColumnType(Types.BIT, "BIT");
        registerColumnType(Types.BIGINT, "BIGINT");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "TINYINT");
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "LONGTEXT");
        registerColumnType(Types.VARCHAR, 16777215, "MEDIUMTEXT");
        registerColumnType(Types.VARCHAR, 65535, "TEXT");
        registerColumnType(Types.VARCHAR, 255, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "DATETIME");
        registerColumnType(Types.VARBINARY, "LONGBLOB");
        registerColumnType(Types.VARBINARY, 16777215, "MEDIUMBLOB");
        registerColumnType(Types.VARBINARY, 65535, "BLOB");
        registerColumnType(Types.VARBINARY, 255, "VARCHAR($l) BINARY");
        registerColumnType(Types.NUMERIC, "NUMERIC(19, $l)");
        registerColumnType(Types.BLOB, "LONGBLOB");
        registerColumnType(Types.BLOB, 16777215, "MEDIUMBLOB");
        registerColumnType(Types.BLOB, 65535, "BLOB");
        registerColumnType(Types.CLOB, "LONGTEXT");
        registerColumnType(Types.CLOB, 16777215, "MEDIUMTEXT");
        registerColumnType(Types.CLOB, 65535, "TEXT");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                DEFAULT_BATCH_SIZE);
    }

    public String getAddColumnString() {
        return "add column";
    }

    public boolean dropConstraints() {
        return false;
    }

    public boolean qualifyIndexName() {
        return false;
    }

    public boolean supportsIdentityColumns() {
        return true;
    }

    public String getIdentitySelectString() {
        return "SELECT LAST_INSERT_ID()";
    }

    public String getIdentityColumnString() {
        return "NOT NULL AUTO_INCREMENT";
    }

    public String getAddForeignKeyConstraintString(String constraintName,
            String[] foreignKey, String referencedTable, String[] primaryKey) {
        String cols = StringHelper.join(StringHelper.COMMA_SPACE, foreignKey);
        return new StringBuffer(30).append(" add index (").append(cols).append(
                "), add constraint ").append(constraintName).append(
                " foreign key (").append(cols).append(") references ").append(
                referencedTable).append(" (").append(
                StringHelper.join(StringHelper.COMMA_SPACE, primaryKey))
                .append(')').toString();
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, boolean hasOffset) {
        return new StringBuffer(sql.length() + 20).append(sql).append(
                hasOffset ? " limit ?, ?" : " limit ?").toString();
    }

    public char closeQuote() {
        return '`';
    }

    public char openQuote() {
        return '`';
    }

    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    public char getSchemaSeperator() {
        return StringHelper.UNDERSCORE;
    }

}

