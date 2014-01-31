//$Id: SAPDBDialect.java,v 1.3 2005/04/03 06:29:04 nick Exp $
// contributed by Brad Clow
package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.sql.CaseFragment;
import net.sf.hibernate.sql.DecodeCaseFragment;
import net.sf.hibernate.sql.JoinFragment;
import net.sf.hibernate.sql.OracleJoinFragment;
import net.sf.hibernate.util.StringHelper;

/**
 * An SQL dialect compatible with SAP DB.
 * 
 * @author Brad Clow
 */
public class SAPDBDialect extends Dialect {

    public SAPDBDialect() {
        super();
        registerColumnType(Types.BIT, "BOOLEAN");
        registerColumnType(Types.BIGINT, "FIXED(19,0)");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "FIXED(3,0)");
        registerColumnType(Types.INTEGER, "INT");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        registerColumnType(Types.VARBINARY, "LONG BYTE");
        registerColumnType(Types.NUMERIC, "FIXED(19,$l)");
        registerColumnType(Types.CLOB, "LONG VARCHAR");
        registerColumnType(Types.BLOB, "LONG BYTE");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");
        getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
                DEFAULT_BATCH_SIZE);

    }

    public boolean supportsForUpdate() {
        return true;
    }

    public boolean dropConstraints() {
        return false;
    }

    public String getAddColumnString() {
        return "add";
    }

    public String getAddForeignKeyConstraintString(String constraintName,
            String[] foreignKey, String referencedTable, String[] primaryKey) {
        return new StringBuffer(30).append(" foreign key ").append(
                constraintName).append(" (").append(
                StringHelper.join(StringHelper.COMMA_SPACE, foreignKey))
                .append(") references ").append(referencedTable).toString();
    }

    public String getAddPrimaryKeyConstraintString(String constraintName) {
        return " primary key ";
    }

    public String getNullColumnString() {
        return " null";
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

    public String getQuerySequencesString() {
        return "select SEQUENCE_NAME from DOMAIN.SEQUENCES";
    }

    public JoinFragment createOuterJoinFragment() {
        return new OracleJoinFragment();
    }

    public boolean supportsSequences() {
        return true;
    }

    public CaseFragment createCaseFragment() {
        return new DecodeCaseFragment();
    }

}

