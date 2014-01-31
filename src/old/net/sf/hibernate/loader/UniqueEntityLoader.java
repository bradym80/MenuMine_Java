//$Id: UniqueEntityLoader.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.loader;

import java.io.Serializable;
import java.sql.SQLException;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * Loads entities for a <tt>ClassPersister</tt>
 * 
 * @author Gavin King
 */
public interface UniqueEntityLoader {
    /**
     * Load an entity instance. If <tt>optionalObject</tt> is supplied, load
     * the entity state into the given (uninitialized) object.
     */
    public Object load(SessionImplementor session, Serializable id,
            Object optionalObject) throws HibernateException, SQLException;
}

