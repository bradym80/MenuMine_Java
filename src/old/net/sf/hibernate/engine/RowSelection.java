//$Id: RowSelection.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.engine;

/**
 * Represents a selection of rows in a JDBC <tt>ResultSet</tt>
 * 
 * @author Gavin King
 */
public final class RowSelection {
    private Integer firstRow;

    private Integer maxRows;

    private Integer timeout;

    public void setFirstRow(Integer firstRow) {
        this.firstRow = firstRow;
    }

    public Integer getFirstRow() {
        return firstRow;
    }

    public void setMaxRows(Integer maxRows) {
        this.maxRows = maxRows;
    }

    public Integer getMaxRows() {
        return maxRows;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getTimeout() {
        return timeout;
    }

}

