//$Id: IdentifierGenerationException.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.id;

import net.sf.hibernate.HibernateException;

/**
 * Thrown by <tt>IdentifierGenerator</tt> implementation class when ID
 * generation fails.
 * 
 * @see IdentifierGenerator
 * @author Gavin King
 */

public class IdentifierGenerationException extends HibernateException {

    public IdentifierGenerationException(String msg) {
        super(msg);
    }

    public IdentifierGenerationException(String msg, Throwable t) {
        super(msg, t);
    }

}

