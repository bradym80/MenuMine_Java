//$Id: HSQLDialect.java,v 1.3 2005/08/24 04:33:26 nick Exp $
// Contributed by Phillip Baird

package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.sql.CaseFragment;
import net.sf.hibernate.sql.HSQLCaseFragment;

/**
 * An SQL dialect compatible with HSQLDB (Hypersonic SQL).
 * 
 * @author Christoph Sturm
 */
public class HSQLDialect extends Dialect {

    public HSQLDialect() {
        super();
        registerColumnType(Types.BIGINT, "BIGINT");
        registerColumnType(Types.BINARY, "BINARY");
        registerColumnType(Types.BIT, "BIT");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.DECIMAL, "DECIMAL");
        registerColumnType(Types.DOUBLE, "DOUBLE");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.LONGVARBINARY, "LONGVARBINARY");
        registerColumnType(Types.LONGVARCHAR, "LONGVARCHAR");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "TINYINT");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.VARBINARY, "VARBINARY($l)");
        registerColumnType(Types.NUMERIC, "NUMERIC");
        //HSQL has no Blob/Clob support .... but just put these here for now!
        registerColumnType(Types.BLOB, "LONGVARBINARY");
        registerColumnType(Types.CLOB, "LONGVARCHAR");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "false"); //HSQL
        // has
        // outer
        // joins
        // but
        // not
        // for
        // composite
        // keys!
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                NO_BATCH);
    }

    public String getAddColumnString() {
        return "add column";
    }

    public boolean supportsIdentityColumns() {
        return true;
    }

    public String getIdentityColumnString() {
        return "NOT NULL IDENTITY";
    }

    public String getIdentitySelectString() {
        return "CALL IDENTITY()";
    }

    public String getIdentityInsertString() {
        return "null";
    }

    public boolean supportsForUpdate() {
        return false;
    }

    /**
     * Not supported in 1.7.1 (1.7.2 only)
     */
    public boolean supportsUnique() {
        return false;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, boolean hasOffset) {
        return new StringBuffer(sql.length() + 10).append(sql).insert(6,
                hasOffset ? " limit ? ?" : " top ?").toString();
    }

    public CaseFragment createCaseFragment() {
        return new HSQLCaseFragment();
    }

    public boolean bindLimitParametersFirst() {
        return true;
    }

    public boolean supportsIfExistsAfterTableName() {
        return true;
    }

}

