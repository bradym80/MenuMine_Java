//$Id: SwarmCacheProvider.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.util.Properties;

import net.sf.swarmcache.CacheConfiguration;
import net.sf.swarmcache.CacheConfigurationManager;
import net.sf.swarmcache.CacheFactory;

/**
 * Support for SwarmCache replicated cache. SwarmCache does not support locking,
 * so strict "read-write" semantics are unsupported.
 * 
 * @author Jason Carreira
 */
public class SwarmCacheProvider implements CacheProvider {

    public Cache buildCache(String s, Properties properties)
            throws CacheException {
        CacheConfiguration config = CacheConfigurationManager
                .getConfig(properties);
        CacheFactory factory = new CacheFactory(config);
        return new SwarmCache(factory.createCache(s));
    }

    public long nextTimestamp() {
        return System.currentTimeMillis();
    }

}