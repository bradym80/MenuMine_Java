//$Id: ScrollableResultsImpl.java,v 1.3 2005/08/24 04:33:25 nick Exp $
package net.sf.hibernate.impl;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.JDBCException;
import net.sf.hibernate.MappingException;
import net.sf.hibernate.ScrollableResults;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.type.Type;

/**
 * Implementation of the <tt>ScrollableResults</tt> interface
 * 
 * @author Gavin King
 */
public class ScrollableResultsImpl implements ScrollableResults {

    private final ResultSet rs;

    private final PreparedStatement ps;

    private final SessionImplementor sess;

    private final Type[] types;

    private final String[][] names;

    /**
     * @see net.sf.hibernate.ScrollableResults#scroll(int)
     */
    public boolean scroll(int i) throws HibernateException {
        try {
            return rs.relative(i);
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#first()
     */
    public boolean first() throws HibernateException {
        try {
            return rs.first();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#last()
     */
    public boolean last() throws HibernateException {
        try {
            return rs.last();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#next()
     */
    public boolean next() throws HibernateException {
        try {
            return rs.next();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#previous()
     */
    public boolean previous() throws HibernateException {
        try {
            return rs.previous();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#get()
     */
    public Object[] get() throws HibernateException {
        Object[] row = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            try {
                row[i] = types[i].nullSafeGet(rs, names[i], sess, null);
            } catch (SQLException sqle) {
                throw new JDBCException(sqle);
            }
        }
        return row;
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#get(int)
     */
    public Object get(int col) throws HibernateException {
        try {
            return types[col].nullSafeGet(rs, names[col], sess, null);
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * If the type of the column is assignable to the return type, use the
     * column type. Otherwise use the given return type.
     * 
     * @param col
     *            the column
     * @param returnType
     *            a "final" type
     */
    private Object getFinal(int col, Type returnType) throws HibernateException {
        if (returnType.getReturnedClass() == types[col].getReturnedClass()) {
            return get(col);
        } else {
            return get(col, returnType);
        }
    }

    /**
     * If the type of the column is assignable to the return type, use the
     * column type. Otherwise use the given return type.
     * 
     * @param col
     *            the column
     * @param returnType
     *            any type
     */
    private Object getNonFinal(int col, Type returnType)
            throws HibernateException {
        if (returnType.getReturnedClass().isAssignableFrom(
                types[col].getReturnedClass())) {
            return get(col);
        } else {
            return get(col, returnType);
        }
    }

    public ScrollableResultsImpl(ResultSet rs, PreparedStatement ps,
            SessionImplementor sess, Type[] types, String[][] columnNames)
            throws MappingException {

        this.rs = rs;
        this.ps = ps;
        this.sess = sess;
        this.types = types;
        this.names = columnNames;

    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getBigDecimal(int)
     */
    public BigDecimal getBigDecimal(int col) throws HibernateException {
        return (BigDecimal) getFinal(col, Hibernate.BIG_DECIMAL);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getBinary(int)
     */
    public byte[] getBinary(int col) throws HibernateException {
        return (byte[]) getFinal(col, Hibernate.BINARY);
    }

    public String getText(int col) throws HibernateException {
        return (String) getFinal(col, Hibernate.TEXT);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getBlob(int)
     */
    public Blob getBlob(int col) throws HibernateException {
        return (Blob) getNonFinal(col, Hibernate.BLOB);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getClob(int)
     */
    public Clob getClob(int col) throws HibernateException {
        return (Clob) getNonFinal(col, Hibernate.CLOB);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getBoolean(int)
     */
    public Boolean getBoolean(int col) throws HibernateException {
        return (Boolean) getFinal(col, Hibernate.BOOLEAN);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getByte(int)
     */
    public Byte getByte(int col) throws HibernateException {
        return (Byte) getFinal(col, Hibernate.BYTE);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getCharacter(int)
     */
    public Character getCharacter(int col) throws HibernateException {
        return (Character) getFinal(col, Hibernate.CHARACTER);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getDate(int)
     */
    public Date getDate(int col) throws HibernateException {
        return (Date) getNonFinal(col, Hibernate.TIMESTAMP);
    }

    public Calendar getCalendar(int col) throws HibernateException {
        return (Calendar) getNonFinal(col, Hibernate.CALENDAR);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getDouble(int)
     */
    public Double getDouble(int col) throws HibernateException {
        return (Double) getFinal(col, Hibernate.DOUBLE);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getFloat(int)
     */
    public Float getFloat(int col) throws HibernateException {
        return (Float) getFinal(col, Hibernate.FLOAT);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getInteger(int)
     */
    public Integer getInteger(int col) throws HibernateException {
        return (Integer) getFinal(col, Hibernate.INTEGER);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getLong(int)
     */
    public Long getLong(int col) throws HibernateException {
        return (Long) getFinal(col, Hibernate.LONG);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getShort(int)
     */
    public Short getShort(int col) throws HibernateException {
        return (Short) getFinal(col, Hibernate.SHORT);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getString(int)
     */
    public String getString(int col) throws HibernateException {
        return (String) getFinal(col, Hibernate.STRING);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#afterLast()
     */
    public void afterLast() throws HibernateException {
        try {
            rs.afterLast();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#beforeFirst()
     */
    public void beforeFirst() throws HibernateException {
        try {
            rs.beforeFirst();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#close()
     */
    public void close() throws HibernateException {
        try {
            sess.getBatcher().closeQueryStatement(ps, rs); //not absolutely
            // necessary
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getLocale(int)
     */
    public Locale getLocale(int col) throws HibernateException {
        return (Locale) getFinal(col, Hibernate.LOCALE);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getCurrency(int)
     */
    /*
     * public Currency getCurrency(int col) throws HibernateException { return
     * (Currency) get(col); }
     */

    /**
     * @see net.sf.hibernate.ScrollableResults#getTimeZone(int)
     */
    public TimeZone getTimeZone(int col) throws HibernateException {
        return (TimeZone) getNonFinal(col, Hibernate.TIMEZONE);
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#getType(int)
     */
    public Type getType(int i) {
        return types[i];
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#isFirst()
     */
    public boolean isFirst() throws HibernateException {
        try {
            return rs.isFirst();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    /**
     * @see net.sf.hibernate.ScrollableResults#isLast()
     */
    public boolean isLast() throws HibernateException {
        try {
            return rs.isLast();
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    public Object get(int i, Type type) throws HibernateException {
        try {
            return type.nullSafeGet(rs, names[i], sess, null);
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    public int getRowNumber() throws HibernateException {
        try {
            return rs.getRow() - 1;
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

    public boolean setRowNumber(int rowNumber) throws HibernateException {
        if (rowNumber >= 0)
            rowNumber++;
        try {
            return rs.absolute(rowNumber);
        } catch (SQLException sqle) {
            throw new JDBCException(sqle);
        }
    }

}

