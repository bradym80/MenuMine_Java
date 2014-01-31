//$Id: ReadOnlyCache.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Caches data that is never updated.
 * 
 * @see CacheConcurrencyStrategy
 */
public class ReadOnlyCache implements CacheConcurrencyStrategy {

    private Cache cache;

    private static final Log log = LogFactory.getLog(ReadOnlyCache.class);

    public ReadOnlyCache() {
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public synchronized Object get(Object key, long timestamp)
            throws CacheException {
        Object result = cache.get(key);
        if (result != null && log.isDebugEnabled())
            log.debug("Cache hit: " + key);
        return result;
    }

    /**
     * Unsupported!
     */
    public SoftLock lock(Object key) {
        log.error("Application attempted to edit read only item: " + key);
        throw new UnsupportedOperationException(
                "Can't write to a readonly object");
    }

    public synchronized boolean put(Object key, Object value, long timestamp)
            throws CacheException {
        if (log.isDebugEnabled())
            log.debug("Caching: " + key);
        cache.put(key, value);
        return true;
    }

    /**
     * Unsupported!
     */
    public void release(Object key, SoftLock lock) {
        log.error("Application attempted to edit read only item: " + key);
        //throw new UnsupportedOperationException("Can't write to a readonly
        // object");
    }

    public void clear() throws CacheException {
        cache.clear();
    }

    public void remove(Object key) throws CacheException {
        cache.remove(key);
    }

    public void destroy() {
        try {
            cache.destroy();
        } catch (Exception e) {
            log.warn("could not destroy cache", e);
        }
    }

    /**
     * Unsupported!
     */
    public void afterUpdate(Object key, Object value, SoftLock lock)
            throws CacheException {
        log.error("Application attempted to edit read only item: " + key);
        throw new UnsupportedOperationException(
                "Can't write to a readonly object");
    }

    /**
     * Do nothing.
     */
    public void afterInsert(Object key, Object value) throws CacheException {
        // ignore
    }

    /**
     * Do nothing.
     */
    public void evict(Object key) throws CacheException {
        // noop
    }

    /**
     * Do nothing.
     */
    public void insert(Object key, Object value) throws CacheException {
        // noop
    }

    /**
     * Unsupported!
     */
    public void update(Object key, Object value) throws CacheException {
        log.error("Application attempted to edit read only item: " + key);
        throw new UnsupportedOperationException(
                "Can't write to a readonly object");
    }

}

