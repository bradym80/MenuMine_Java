//$Id: TreeCache.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.util.Properties;

import javax.transaction.TransactionManager;

import net.sf.hibernate.transaction.TransactionManagerLookup;
import net.sf.hibernate.transaction.TransactionManagerLookupFactory;

import org.jboss.cache.PropertyConfigurator;

/**
 * @author Gavin King
 */
public class TreeCache implements Cache {

    private static org.jboss.cache.TreeCache cache;

    private final String regionName;

    static final class TransactionManagerLookupAdaptor implements
            org.jboss.cache.TransactionManagerLookup {
        private final TransactionManagerLookup tml;

        private final Properties props;

        TransactionManagerLookupAdaptor(TransactionManagerLookup tml,
                Properties props) {
            this.tml = tml;
            this.props = props;
        }

        public TransactionManager getTransactionManager() throws Exception {
            // TODO Auto-generated method stub
            return tml.getTransactionManager(props);
        }
    }

    public TreeCache(String regionName, Properties props) throws CacheException {
        this.regionName = '/' + regionName.replace('.', '/');
        try {
            synchronized (TreeCache.class) {
                if (cache == null) {
                    cache = new org.jboss.cache.TreeCache();
                    PropertyConfigurator config = new PropertyConfigurator();
                    config.configure(cache, "treecache.xml");
                    //cache.setCacheMode(org.jboss.cache.TreeCache.REPL_ASYNC);
                    //cache.setLockingLevel(LockStrategyFactory.REPEATABLE_READ);
                    TransactionManagerLookup tml = TransactionManagerLookupFactory
                            .getTransactionManagerLookup(props);
                    //if (tml==null) throw new CacheException("TreeCache
                    // requires a TransactionManager (set
                    // hibernate.transaction.manager_lookup_class)");
                    if (tml != null)
                        cache
                                .setTransactionManagerLookup(new TransactionManagerLookupAdaptor(
                                        tml, props));
                    cache.start();
                }
            }
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public Object get(Object key) throws CacheException {
        try {
            return cache.get(regionName, key);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public void put(Object key, Object value) throws CacheException {
        try {
            cache.put(regionName, key, value);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public void remove(Object key) throws CacheException {
        try {
            cache.remove(regionName, key);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public void clear() throws CacheException {
        try {
            cache.remove(regionName);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public void destroy() throws CacheException {
        cache.destroy();
    }

    public void lock(Object key) throws CacheException {
        throw new UnsupportedOperationException(
                "TreeCache is a full transactional cache" + regionName);
    }

    public void unlock(Object key) throws CacheException {
        throw new UnsupportedOperationException(
                "TreeCache is a full transactional cache: " + regionName);
    }

    public long nextTimestamp() {
        throw new UnsupportedOperationException(
                "TreeCache does not expose the cluster time" + regionName);
    }

    public int getTimeout() {
        throw new UnsupportedOperationException(
                "TreeCache does not expose the cluster time" + regionName);
    }

}