//$Id: Delete.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.sql;

import net.sf.hibernate.util.StringHelper;

/**
 * An SQL <tt>DELETE</tt> statement
 * 
 * @author Gavin King
 */
public class Delete {

    private String tableName;

    private String[] primaryKeyColumnNames;

    private String versionColumnName;

    private String where;

    public Delete setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String toStatementString() {
        StringBuffer buf = new StringBuffer(tableName.length() + 10);
        buf.append("delete from ").append(tableName).append(" where ").append(
                StringHelper.join("=? and ", primaryKeyColumnNames)).append(
                "=?");
        if (where != null) {
            buf.append(" and ").append(where);
        }
        if (versionColumnName != null) {
            buf.append(" and ").append(versionColumnName).append("=?");
        }
        return buf.toString();
    }

    public Delete setWhere(String where) {
        this.where = where;
        return this;
    }

    public Delete setPrimaryKeyColumnNames(String[] primaryKeyColumnNames) {
        this.primaryKeyColumnNames = primaryKeyColumnNames;
        return this;
    }

    public Delete setVersionColumnName(String versionColumnName) {
        this.versionColumnName = versionColumnName;
        return this;
    }

}