//$Id: MckoiDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
// Contributed by Gabe Hicks
package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.sql.CaseFragment;
import net.sf.hibernate.sql.MckoiCaseFragment;

/**
 * An SQL dialect compatible with McKoi SQL
 * 
 * @author Doug Currie
 */

public class MckoiDialect extends Dialect {
    public MckoiDialect() {
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
        registerColumnType(Types.VARBINARY, "VARBINARY");
        registerColumnType(Types.NUMERIC, "NUMERIC");
        registerColumnType(Types.BLOB, "BLOB");
        registerColumnType(Types.CLOB, "CLOB");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                NO_BATCH);
    }

    public String getAddColumnString() {
        return "add column";
    }

    public String getSequenceNextValString(String sequenceName) {
        return "SELECT UNIQUEKEY('" + sequenceName + "')";
    }

    public String getCreateSequenceString(String sequenceName) {
        return "CREATE TABLE " + sequenceName + "(id NUMERIC)";
    }

    public String getDropSequenceString(String sequenceName) {
        return "DROP TABLE " + sequenceName;
    }

    public boolean supportsForUpdate() {
        return false;
    }

    public boolean supportsSequences() {
        return true;
    }

    public CaseFragment createCaseFragment() {
        return new MckoiCaseFragment();
    }

}

