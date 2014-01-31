//$Id: ProgressDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
// contributed by Phillip Baird
package net.sf.hibernate.dialect;

import java.sql.Types;

/**
 * An SQL dialect compatible with Progress 9.1C <br>
 * <br>
 * Connection Parameters required:
 * <ul>
 * <li>hibernate.dialect net.sf.hibernate.sql.ProgressDialect
 * <li>hibernate.driver com.progress.sql.jdbc.JdbcProgressDriver
 * <li>hibernate.url jdbc:JdbcProgress:T:host:port:dbname;WorkArounds=536870912
 * <li>hibernate.username username
 * <li>hibernate.password password
 * </ul>
 * The WorkArounds parameter in the URL is required to avoid an error in the
 * Progress 9.1C JDBC driver related to PreparedStatements.
 * 
 * @author Phillip Baird
 *  
 */
public class ProgressDialect extends Dialect {
    public ProgressDialect() {
        super();
        registerColumnType(Types.BIT, "BIT");
        registerColumnType(Types.BIGINT, "NUMERIC");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "TINYINT");
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.CHAR, "CHARACTER(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "REAL");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        registerColumnType(Types.VARBINARY, "VARBINARY($l)");
        registerColumnType(Types.NUMERIC, "NUMERIC(19,$l)");
    }

    public boolean hasAlterTable() {
        return false;
    }

    public String getAddColumnString() {
        return "add column";
    }

    public boolean qualifyIndexName() {
        return false;
    }
}

