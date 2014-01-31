//$Id: SerializationException.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.type;

import net.sf.hibernate.HibernateException;

/**
 * Thrown when a property cannot be serializaed/deserialized
 * 
 * @author Gavin King
 */
public class SerializationException extends HibernateException {

    public SerializationException(String message, Exception root) {
        super(message, root);
    }

}

