//$Id: SQLServerDialect.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

/**
 * A dialect for Microsoft SQL Server 2000
 * 
 * @author Gavin King
 */
public class SQLServerDialect extends SybaseDialect {

    public boolean bindLimitParametersFirst() {
        return super.bindLimitParametersFirst();
    }

    public String getLimitString(String querySelect, boolean hasOffset,
            int limit) {
        if (hasOffset)
            throw new UnsupportedOperationException("sql server has no offset");
        return new StringBuffer(querySelect.length() + 6)
                .append(querySelect)
                .insert(getAfterSelectInsertPoint(querySelect), " top " + limit)
                .toString();
    }

    public boolean supportsLimit() {
        return true;
    }

    public boolean useMaxForLimit() {
        return true;
    }

    public boolean supportsLimitOffset() {
        return false;
    }

    public boolean supportsVariableLimit() {
        return false;
    }

    private static int getAfterSelectInsertPoint(String sql) {
        return sql.startsWith("select distinct") ? 15 : 6;
    }

}