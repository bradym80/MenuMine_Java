package net.sf.hibernate.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * <tt>double</tt>: A type that maps an SQL DOUBLE to a Java Double.
 * 
 * @author Gavin King
 */
public class DoubleType extends PrimitiveType {
    public Object get(ResultSet rs, String name) throws SQLException {
        return new Double(rs.getDouble(name));
    }

    public Class getPrimitiveClass() {
        return double.class;
    }

    public Class getReturnedClass() {
        return Double.class;
    }

    public void set(PreparedStatement st, Object value, int index)
            throws SQLException {

        //   if (value instanceof Double) {
        st.setDouble(index, ((Double) value).doubleValue());
        //   } else {
        //        st.setObject(index, new Double(123456));
        //   }
    }

    public int sqlType() {
        return Types.DOUBLE;
    }

    public String getName() {
        return "double";
    }

    public String objectToSQLString(Object value) throws Exception {
        return value.toString();
    }

    public Object fromStringValue(String xml) {
        return new Double(xml);
    }

}