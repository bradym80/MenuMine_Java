//$Id: OSCache.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

/**
 * @author <a href="mailto:m.bogaert@intrasoft.be">Mathias Bogaert </a>
 */
public class OSCache implements Cache {
    /**
     * The OSCache 2.0 cache administrator.
     */
    private GeneralCacheAdministrator cache = new GeneralCacheAdministrator();

    private int refreshPeriod;

    private String cron;

    public OSCache(int refreshPeriod, String cron) {
        this.refreshPeriod = refreshPeriod;
        this.cron = cron;
    }

    public void setCacheCapacity(int cacheCapacity) {
        cache.setCacheCapacity(cacheCapacity);
    }

    public Object get(Object key) throws CacheException {
        try {
            return cache.getFromCache(String.valueOf(key), refreshPeriod, cron);
        } catch (NeedsRefreshException e) {
            cache.cancelUpdate(String.valueOf(key));
            return null;
        }
    }

    public void put(Object key, Object value) throws CacheException {
        cache.putInCache(String.valueOf(key), value);
    }

    public void remove(Object key) throws CacheException {
        cache.flushEntry(String.valueOf(key));
    }

    public void clear() throws CacheException {
        cache.flushAll();
    }

    public void destroy() throws CacheException {
        cache.destroy();
    }

    public void lock(Object key) throws CacheException {
        // local cache, so we use synchronization
    }

    public void unlock(Object key) throws CacheException {
        // local cache, so we use synchronization
    }

    public long nextTimestamp() {
        return Timestamper.next();
    }

    public int getTimeout() {
        return Timestamper.ONE_MS * 60000; //ie. 60 seconds
    }

}