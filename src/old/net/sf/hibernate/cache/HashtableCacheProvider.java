//$Id: HashtableCacheProvider.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.util.Properties;

/**
 * @author Gavin King
 */
public class HashtableCacheProvider implements CacheProvider {

    public Cache buildCache(String regionName, Properties properties)
            throws CacheException {
        return new HashtableCache();
    }

    public long nextTimestamp() {
        return Timestamper.next();
    }

}