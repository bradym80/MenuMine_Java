//$Id: IdentityGenerator.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.id;

import java.io.Serializable;
import java.sql.SQLException;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.SessionImplementor;

/**
 * The IdentityGenerator for autoincrement/identity key generation. <br>
 * <br>
 * Indicates to the <tt>Session</tt> that identity (ie. identity/autoincrement
 * column) key generation should be used.
 * 
 * @author Christoph Sturm
 */
public class IdentityGenerator implements IdentifierGenerator {

    public Serializable generate(SessionImplementor s, Object obj)
            throws SQLException, HibernateException {
        return IdentifierGeneratorFactory.IDENTITY_COLUMN_INDICATOR;
    }

}

