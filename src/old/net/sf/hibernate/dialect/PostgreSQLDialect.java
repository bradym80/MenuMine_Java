//$Id: PostgreSQLDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;

/**
 * An SQL dialect for Postgres
 * 
 * @author Gavin King
 */

public class PostgreSQLDialect extends Dialect {
    public PostgreSQLDialect() {
        super();
        registerColumnType(Types.BIT, "BOOL");
        registerColumnType(Types.BIGINT, "INT8");
        registerColumnType(Types.SMALLINT, "INT2");
        registerColumnType(Types.TINYINT, "INT2");
        registerColumnType(Types.INTEGER, "INT4");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT4");
        registerColumnType(Types.DOUBLE, "FLOAT8");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        registerColumnType(Types.VARBINARY, "BYTEA");
        registerColumnType(Types.CLOB, "TEXT");
        registerColumnType(Types.BLOB, "BYTEA");
        registerColumnType(Types.NUMERIC, "NUMERIC");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                DEFAULT_BATCH_SIZE);
    }

    public String getAddColumnString() {
        return "add column";
    }

    public boolean dropConstraints() {
        return true;
    }

    public String getSequenceNextValString(String sequenceName) {
        return "select nextval ('" + sequenceName + "')";
    }

    public String getCreateSequenceString(String sequenceName) {
        return "create sequence " + sequenceName;
    }

    public String getDropSequenceString(String sequenceName) {
        return "drop sequence " + sequenceName;
    }

    public String getCascadeConstraintsString() {
        return "";//" cascade";
    }

    public boolean supportsSequences() {
        return true;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, boolean hasOffset) {
        return new StringBuffer(sql.length() + 20).append(sql).append(
                hasOffset ? " limit ? offset ?" : " limit ?").toString();
    }

    public boolean bindLimitParametersInReverseOrder() {
        return true;
    }

    public boolean supportsForUpdateOf() {
        return true;
    }

}

