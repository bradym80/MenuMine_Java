//$Id: TreeCacheProvider.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.util.Properties;

/**
 * Support for JBoss TreeCache
 * 
 * @author Gavin King
 */
public class TreeCacheProvider implements CacheProvider {

    public Cache buildCache(String regionName, Properties properties)
            throws CacheException {
        return new TreeCache(regionName, properties);
    }

    public long nextTimestamp() {
        return 0;
        //TreeCache does not provide a cluster time;
    }

}