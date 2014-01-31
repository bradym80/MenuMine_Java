//$Id: UpdateTimestampsCache.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import net.sf.hibernate.HibernateException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Tracks the timestamps of the most recent updates to particular tables. It is
 * important that the cache timeout of the underlying cache implementation be
 * set to a higher value than the timeouts of any of the query caches. In fact,
 * we recommend that the the underlying cache not be configured for expiry at
 * all. Note, in particular, that an LRU cache expiry policy is never
 * appropriate.
 * 
 * @author Gavin King, Mikheil Kapanadze
 */
public class UpdateTimestampsCache {

    private static final Log log = LogFactory
            .getLog(UpdateTimestampsCache.class);

    private Cache updateTimestamps;

    public static final String REGION_NAME = UpdateTimestampsCache.class
            .getName();

    public void clear() throws CacheException {
        updateTimestamps.clear();
    }

    public UpdateTimestampsCache(CacheProvider provider, Properties props)
            throws HibernateException {
        log.info("starting update timestamps cache at region: " + REGION_NAME);
        this.updateTimestamps = provider.buildCache(REGION_NAME, props);
    }

    public synchronized void preinvalidate(Serializable[] spaces)
            throws CacheException {
        Long ts = new Long(updateTimestamps.nextTimestamp()
                + updateTimestamps.getTimeout());
        for (int i = 0; i < spaces.length; i++)
            updateTimestamps.put(spaces[i], ts);
    }

    public synchronized void invalidate(Serializable[] spaces)
            throws CacheException {
        Long ts = new Long(updateTimestamps.nextTimestamp());
        for (int i = 0; i < spaces.length; i++)
            updateTimestamps.put(spaces[i], ts);
    }

    public synchronized boolean isUpToDate(Set spaces, Long timestamp)
            throws HibernateException {
        Iterator iter = spaces.iterator();
        boolean result = true;
        while (iter.hasNext()) {
            Serializable space = (Serializable) iter.next();
            Long lastUpdate = (Long) updateTimestamps.get(space);
            if (lastUpdate == null) {
                //the last update timestamp was lost from the cache
                //(or there were no updates since startup!)
                //updateTimestamps.put( space, new Long(
                // updateTimestamps.nextTimestamp() ) );
                //result = false; // safer
            } else {
                if (lastUpdate.longValue() >= timestamp.longValue())
                    result = false;
            }
        }
        return result;
    }

    public void destroy() {
        try {
            updateTimestamps.destroy();
        } catch (Exception e) {
            log.warn("could not destroy UpdateTimestamps cache", e);
        }
    }

}