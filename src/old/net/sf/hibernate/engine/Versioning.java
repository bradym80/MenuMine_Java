//$Id: Versioning.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.engine;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.persister.ClassPersister;
import net.sf.hibernate.type.VersionType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility methods for managing versions and timestamps
 * 
 * @author Gavin King
 */
public final class Versioning {

    private Versioning() {
    }

    private static final Log log = LogFactory.getLog(Versioning.class);

    /**
     * Increment the given version number
     */
    public static Object increment(Object version, VersionType versionType) {
        Object next = versionType.next(version);
        if (log.isTraceEnabled())
            log.trace("Incrementing: " + version + " to " + next);
        return next;
    }

    /**
     * Create an initial version number
     */
    private static Object seed(VersionType versionType) {
        Object seed = versionType.seed();
        if (log.isTraceEnabled())
            log.trace("Seeding: " + seed);
        return seed;
    }

    /**
     * Seed the given instance state snapshot with an initial version number
     */
    public static boolean seedVersion(Object[] fields, int versionProperty,
            VersionType versionType) {
        if (fields[versionProperty] == null) {
            fields[versionProperty] = seed(versionType);
            return true;
        } else {
            return false;
        }
    }

    private static Object getVersion(Object[] fields, int versionProperty) {
        return fields[versionProperty];
    }

    private static void setVersion(Object[] fields, Object version,
            int versionProperty) {
        fields[versionProperty] = version;
    }

    /**
     * Set the version number of the given instance state snapshot
     */
    public static void setVersion(Object[] fields, Object version,
            ClassPersister persister) {
        setVersion(fields, version, persister.getVersionProperty());
    }

    /**
     * Get the version number of the given instance state snapshot
     */
    public static Object getVersion(Object[] fields, ClassPersister persister)
            throws HibernateException {
        return persister.isVersioned() ? getVersion(fields, persister
                .getVersionProperty()) : null;
    }

    public static final int OPTIMISTIC_LOCK_NONE = -1;

    public static final int OPTIMISTIC_LOCK_ALL = 2;

    public static final int OPTIMISTIC_LOCK_DIRTY = 1;

    public static final int OPTIMISTIC_LOCK_VERSION = 0;

}

