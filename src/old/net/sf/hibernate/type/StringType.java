//$Id: StringType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import net.sf.hibernate.util.EqualsHelper;

/**
 * <tt>string</tt>: A type that maps an SQL VARCHAR to a Java String.
 * 
 * @author Gavin King
 */
public class StringType extends ImmutableType implements DiscriminatorType {

    public Object get(ResultSet rs, String name) throws SQLException {
        return rs.getString(name);
    }

    public Class getReturnedClass() {
        return String.class;
    }

    public void set(PreparedStatement st, Object value, int index)
            throws SQLException {
        st.setString(index, (String) value);
    }

    public int sqlType() {
        return Types.VARCHAR;
    }

    public String getName() {
        return "string";
    }

    public String objectToSQLString(Object value) throws Exception {
        return '\'' + (String) value + '\'';
    }

    public Object stringToObject(String xml) throws Exception {
        return xml;
    }

    public boolean equals(Object x, Object y) {
        return EqualsHelper.equals(x, y);
    }

    public String toString(Object value) {
        return (String) value;
    }

    public Object fromStringValue(String xml) {
        return xml;
    }

}

