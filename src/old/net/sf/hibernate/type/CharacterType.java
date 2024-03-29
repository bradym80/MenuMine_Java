//$Id: CharacterType.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import net.sf.hibernate.MappingException;

/**
 * <tt>character</tt>: A type that maps an SQL CHAR(1) to a Java Character.
 * 
 * @author Gavin King
 */
public class CharacterType extends PrimitiveType implements DiscriminatorType {

    public Object get(ResultSet rs, String name) throws SQLException {
        String str = rs.getString(name);
        if (str == null) {
            return null;
        } else {
            return new Character(str.charAt(0));
        }
    }

    public Class getPrimitiveClass() {
        return char.class;
    }

    public Class getReturnedClass() {
        return Character.class;
    }

    public void set(PreparedStatement st, Object value, int index)
            throws SQLException {
        st.setString(index, (value).toString());
    }

    public int sqlType() {
        return Types.CHAR;
    }

    public String getName() {
        return "character";
    }

    public String objectToSQLString(Object value) throws Exception {
        return '\'' + value.toString() + '\'';
    }

    public Object stringToObject(String xml) throws Exception {
        if (xml.length() != 1)
            throw new MappingException(
                    "multiple or zero characters found parsing string");
        return new Character(xml.charAt(0));
    }

    public Object fromStringValue(String xml) {
        return new Character(xml.charAt(0));
    }

}

