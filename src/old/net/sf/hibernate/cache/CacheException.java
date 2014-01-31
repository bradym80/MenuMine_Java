//$Id: CacheException.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import net.sf.hibernate.HibernateException;

/**
 * Something went wrong in the cache
 */
public class CacheException extends HibernateException {

    public CacheException(String s) {
        super(s);
    }

    public CacheException(Exception e) {
        super(e);
    }

}

