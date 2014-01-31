//$Id: CacheProvider.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.util.Properties;

/**
 * Support for pluggable caches.
 * 
 * @author Gavin King
 */
public interface CacheProvider {

    /**
     * Configure the cache
     * 
     * @param regionName
     *            the name of the cache region
     * @param properties
     *            configuration settings
     * @throws CacheException
     */
    public Cache buildCache(String regionName, Properties properties)
            throws CacheException;

    /**
     * Generate a timestamp
     */
    public long nextTimestamp();

}