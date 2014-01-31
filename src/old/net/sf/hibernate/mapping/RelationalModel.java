//$Id: RelationalModel.java,v 1.3 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.dialect.Dialect;
import net.sf.hibernate.engine.Mapping;

/**
 * A relational object which may be created using DDL
 * 
 * @author Gavin King
 */
public interface RelationalModel {
    public String sqlCreateString(Dialect dialect, Mapping p)
            throws HibernateException;

    public String sqlDropString(Dialect dialect);
}

