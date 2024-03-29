//$Id: IndexMetadata.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.tool.hbm2ddl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC index metadata
 * 
 * @author Christoph Sturm
 */
public class IndexMetadata {
    private final String name;

    private final List columns = new ArrayList();

    IndexMetadata(ResultSet rs) throws SQLException {
        name = rs.getString("INDEX_NAME");
    }

    public String getName() {
        return name;
    }

    void addColumn(ColumnMetadata column) {
        if (column != null)
            columns.add(column);
    }

    public ColumnMetadata[] getColumns() {
        return (ColumnMetadata[]) columns.toArray(new ColumnMetadata[0]);
    }

    public String toString() {
        return name;
    }
}

