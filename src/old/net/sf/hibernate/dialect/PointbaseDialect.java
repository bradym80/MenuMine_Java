//$Id: PointbaseDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
//Created on 04 February 2002, 17:35
package net.sf.hibernate.dialect;

import java.sql.Types;

import net.sf.hibernate.cfg.Environment;

/**
 * A <tt>Dialect</tt> for Pointbase.
 * 
 * @author Ed Mackenzie
 */
public class PointbaseDialect extends net.sf.hibernate.dialect.Dialect {

    /**
     * Creates new PointbaseDialect
     */
    public PointbaseDialect() {
        super();
        registerColumnType(Types.BIT, "SMALLINT"); //no pointbase BIT
        registerColumnType(Types.BIGINT, "BIGINT");
        registerColumnType(Types.SMALLINT, "SMALLINT");
        registerColumnType(Types.TINYINT, "SMALLINT"); //no pointbase TINYINT
        registerColumnType(Types.INTEGER, "INTEGER");
        registerColumnType(Types.CHAR, "CHAR(1)");
        registerColumnType(Types.VARCHAR, "VARCHAR($l)");
        registerColumnType(Types.FLOAT, "FLOAT");
        registerColumnType(Types.DOUBLE, "DOUBLE PRECISION");
        registerColumnType(Types.DATE, "DATE");
        registerColumnType(Types.TIME, "TIME");
        registerColumnType(Types.TIMESTAMP, "TIMESTAMP");
        //the BLOB type requires a size arguement - this defaults to
        //bytes - no arg defaults to 1 whole byte!
        //other argument mods include K - kilobyte, M - megabyte, G - gigabyte.
        //refer to the PBdevelopers guide for more info.
        registerColumnType(Types.VARBINARY, "BLOB($l)");
        registerColumnType(Types.NUMERIC, "NUMERIC(19, $l)");

        getDefaultProperties().setProperty(Environment.USE_OUTER_JOIN, "true");

    }

    public String getAddColumnString() {
        return "add";
    }

    public boolean dropConstraints() {
        return false;
    }

    public String getCascadeConstraintsString() {
        return " cascade";
    }

    public boolean supportsForUpdate() {
        return false;
    }

}

