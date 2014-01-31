//$Id: JCSCacheProvider.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.util.Properties;

/**
 * @author Gavin King
 * @deprecated JCS support will be removed in version 2.1.1
 */
public class JCSCacheProvider implements CacheProvider {

    public Cache buildCache(String regionName, Properties properties)
            throws CacheException {
        return new JCSCache(regionName, properties);
    }

    public long nextTimestamp() {
        return Timestamper.next();
    }

}