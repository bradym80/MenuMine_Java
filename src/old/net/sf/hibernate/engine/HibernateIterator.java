//$Id: HibernateIterator.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.engine;

import java.sql.SQLException;
import java.util.Iterator;

/**
 * An iterator that may be "closed"
 * 
 * @see net.sf.hibernate.Hibernate#close(java.util.Iterator)
 * @author Gavin King
 */
public interface HibernateIterator extends Iterator {
    public void close() throws SQLException;
}