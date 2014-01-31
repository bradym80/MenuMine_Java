package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;

/**
 * An SQL dialect for Interbase.
 * 
 * @author Gavin King
 */

public class InterbaseDialect extends Dialect {

    public InterbaseDialect() {
        super();
        registerColumnType(Types.BIT, "SMALLINT");
        registerColumnType(Types.BIGINT, "NUMERIC(18,0)");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "SMALLINT");
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        registerColumnType(Types.VARBINARY, "BLOB");
        registerColumnType(Types.NUMERIC, "NUMERIC(18, $l)");
        registerColumnType(Types.BLOB, "BLOB");
        registerColumnType(Types.CLOB, "BLOB SUB_TYPE 1");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                NO_BATCH);
        getDefaultProperties().setProperty(Environment.STATEMENT_CACHE_SIZE,
                "0");
    }

    public String getAddColumnString() {
        return "add";
    }

    public String getSequenceNextValString(String sequenceName) {
        return "select gen_id( " + sequenceName + ", 1 ) from RDB$DATABASE";
    }

    public String getCreateSequenceString(String sequenceName) {
        return "create generator " + sequenceName;
    }

    public String getDropSequenceString(String sequenceName) {
        return "delete from RDB$GENERATORS where RDB$GENERATOR_NAME = '"
                + sequenceName.toUpperCase() + "'";
    }

    public boolean supportsForUpdateOf() {
        return true;
    }

    public boolean supportsSequences() {
        return true;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, boolean hasOffset) {
        return new StringBuffer(sql.length() + 15).append(sql).append(
                hasOffset ? " rows ? to ?" : " rows ?").toString();
    }

    public boolean bindLimitParametersFirst() {
        return false;
    }

    public boolean bindLimitParametersInReverseOrder() {
        return false;
    }

}