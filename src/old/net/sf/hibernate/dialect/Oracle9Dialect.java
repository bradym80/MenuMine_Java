//$Id: Oracle9Dialect.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.engine.Mapping;
import net.sf.hibernate.type.Type;

/**
 * An SQL dialect for Oracle 9 (uses ANSI-style syntax where possible).
 * 
 * @author Gavin King, David Channon
 */
public class Oracle9Dialect extends Dialect {

    public Oracle9Dialect() {
        super();
        registerColumnType(Types.BIT, "NUMBER(1,0)");
        registerColumnType(Types.BIGINT, "NUMBER(19,0)");
        registerColumnType(Types.SMALLINT, "NUMBER(5,0)");
        registerColumnType(Types.TINYINT, "NUMBER(3,0)");
        registerColumnType(Types.INTEGER, "NUMBER(10,0)");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR2($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "DATE");
        registerColumnType(Types.TIMESTAMP, "DATE");
        //registerColumnType( Types.VARBINARY, "RAW" );
        registerColumnType(Types.VARBINARY, "LONG RAW");
        registerColumnType(Types.VARBINARY, 255, "RAW($l)");
        registerColumnType(Types.NUMERIC, "NUMBER(19, $l)");
        registerColumnType(Types.BLOB, "BLOB");
        registerColumnType(Types.CLOB, "CLOB");

        getDefaultProperties().setProperty(Environment.USE_STREAMS_FOR_BINARY,
                "true");
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                DEFAULT_BATCH_SIZE);
        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");

        registerFunction("trunc", new StandardSQLFunction());
        registerFunction("round", new StandardSQLFunction());
        registerFunction("abs", new StandardSQLFunction(Hibernate.INTEGER));
        registerFunction("sign", new StandardSQLFunction(Hibernate.INTEGER));
        registerFunction("ceil", new StandardSQLFunction(Hibernate.INTEGER));
        registerFunction("floor", new StandardSQLFunction(Hibernate.INTEGER));
        registerFunction("sqrt", new StandardSQLFunction());
        registerFunction("exp", new StandardSQLFunction());
        registerFunction("ln", new StandardSQLFunction());
        registerFunction("sin", new StandardSQLFunction());
        registerFunction("sinh", new StandardSQLFunction());
        registerFunction("cos", new StandardSQLFunction());
        registerFunction("cosh", new StandardSQLFunction());
        registerFunction("tan", new StandardSQLFunction());
        registerFunction("tanh", new StandardSQLFunction());
        registerFunction("stddev", new StandardSQLFunction());
        registerFunction("variance", new StandardSQLFunction());
        registerFunction("sysdate", new SQLFunction() {
            public Type getReturnType(Type columnType, Mapping mapping) {
                return Hibernate.DATE;
            }

            public boolean hasArguments() {
                return false;
            }

            public boolean hasParenthesesIfNoArguments() {
                return false;
            }
        });
        registerFunction("lastday", new StandardSQLFunction(Hibernate.DATE));
    }

    public String getAddColumnString() {
        return "add";
    }

    public String getSequenceNextValString(String sequenceName) {
        return "select " + sequenceName + ".nextval from dual";
    }

    public String getCreateSequenceString(String sequenceName) {
        return "create sequence " + sequenceName;
    }

    public String getDropSequenceString(String sequenceName) {
        return "drop sequence " + sequenceName;
    }

    public String getCascadeConstraintsString() {
        return " cascade constraints";
    }

    public boolean supportsForUpdateNowait() {
        return true;
    }

    public boolean supportsSequences() {
        return true;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, boolean hasOffset) {
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
        if (hasOffset) {
            pagingSelect
                    .append("select * from ( select row_.*, rownum rownum_ from ( ");
        } else {
            pagingSelect.append("select * from ( ");
        }
        pagingSelect.append(sql);
        if (hasOffset) {
            pagingSelect.append(" ) row_ where rownum <= ?) where rownum_ > ?");
        } else {
            pagingSelect.append(" ) where rownum <= ?");
        }
        return pagingSelect.toString();
    }

    public boolean bindLimitParametersInReverseOrder() {
        return true;
    }

    public boolean useMaxForLimit() {
        return true;
    }

    public boolean supportsForUpdateOf() {
        return false;
    }

    public String getQuerySequencesString() {
        return "select SEQUENCE_NAME from user_sequences";
    }

}

