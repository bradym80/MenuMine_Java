//$Id: QueryCache.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.type.Type;
import net.sf.hibernate.type.TypeFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A cache for query result sets. The transactional semantics are necessarily
 * less strict than the semantics of an item cache. Note that the actual
 * entities in the result set are not kept in this cache, only their ids.
 * 
 * @author Gavin King
 */
public class QueryCache {

    private static final Log log = LogFactory.getLog(QueryCache.class);

    private Cache queryCache;

    private UpdateTimestampsCache updateTimestampsCache;

    private final String regionName;

    public void clear() throws CacheException {
        queryCache.clear();
    }

    public QueryCache(CacheProvider provider, Properties props,
            UpdateTimestampsCache updateTimestampsCache, String regionName)
            throws HibernateException {
        if (regionName == null)
            regionName = QueryCache.class.getName();
        log.info("starting query cache at region: " + regionName);
        this.queryCache = provider.buildCache(regionName, props);
        this.updateTimestampsCache = updateTimestampsCache;
        this.regionName = regionName;
    }

    public void put(QueryKey key, Type[] returnTypes, List result,
            SessionImplementor session) throws HibernateException {
        if (log.isDebugEnabled())
            log.debug("caching query results in region: " + regionName);
        List cacheable = new ArrayList(result.size() + 1);
        cacheable.add(new Long(session.getTimestamp()));
        for (int i = 0; i < result.size(); i++) {
            if (returnTypes.length == 1) {
                cacheable.add(returnTypes[0]
                        .disassemble(result.get(i), session));
            } else {
                cacheable.add(TypeFactory.disassemble((Object[]) result.get(i),
                        returnTypes, session));
            }
        }
        queryCache.put(key, cacheable);
    }

    public List get(QueryKey key, Type[] returnTypes, Set spaces,
            SessionImplementor session) throws HibernateException {
        if (log.isDebugEnabled())
            log.debug("checking cached query results in region: " + regionName);
        List cacheable = (List) queryCache.get(key);
        if (cacheable == null) {
            log.debug("query results were not found in cache");
            return null;
        }
        List result = new ArrayList(cacheable.size() - 1);
        Long timestamp = (Long) cacheable.get(0);
        if (!updateTimestampsCache.isUpToDate(spaces, timestamp)) {
            log.debug("cached query results were not up to date");
            return null;
        }
        log.debug("returning cached query results");
        for (int i = 1; i < cacheable.size(); i++) {
            if (returnTypes.length == 1) {
                result.add(returnTypes[0].assemble((Serializable) cacheable
                        .get(i), session, null));
            } else {
                result.add(TypeFactory.assemble((Serializable[]) cacheable
                        .get(i), returnTypes, session, null));
            }
        }
        return result;
    }

    public void destroy() {
        try {
            queryCache.destroy();
        } catch (Exception e) {
            log.warn("could not destroy query cache: " + regionName, e);
        }
    }

}