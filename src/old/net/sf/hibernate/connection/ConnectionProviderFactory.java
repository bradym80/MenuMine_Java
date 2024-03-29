//$Id: ConnectionProviderFactory.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.connection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.util.ReflectHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Instantiates a connection provider given either <tt>System</tt> properties
 * or a <tt>java.util.Properties</tt> instance. The
 * <tt>ConnectionProviderFactory</tt> first attempts to find a name of a
 * <tt>ConnectionProvider</tt> subclass in the property
 * <tt>hibernate.connection.provider_class</tt>. If missing, heuristics are
 * used to choose either <tt>DriverManagerConnectionProvider</tt>,
 * <tt>DatasourceConnectionProvider</tt>,<tt>C3P0ConnectionProvider</tt>
 * or <tt>DBCPConnectionProvider</tt>.
 * 
 * @see ConnectionProvider
 * @author Gavin King
 */

public final class ConnectionProviderFactory {

    private static final Log log = LogFactory
            .getLog(ConnectionProviderFactory.class);

    /**
     * Instantiate a <tt>ConnectionProvider</tt> using <tt>System</tt>
     * properties.
     * 
     * @return ConnectionProvider
     * @throws HibernateException
     */
    public static ConnectionProvider newConnectionProvider()
            throws HibernateException {
        return newConnectionProvider(Environment.getProperties());
    }

    /**
     * Instantiate a <tt>ConnectionProvider</tt> using given properties.
     * Method newConnectionProvider.
     * 
     * @param properties
     *            hibernate <tt>SessionFactory</tt> properties
     * @return ConnectionProvider
     * @throws HibernateException
     */
    public static ConnectionProvider newConnectionProvider(Properties properties)
            throws HibernateException {
        ConnectionProvider connections;
        String providerClass = properties
                .getProperty(Environment.CONNECTION_PROVIDER);
        if (providerClass != null) {
            try {
                log.info("Initializing connection provider: " + providerClass);
                connections = (ConnectionProvider) ReflectHelper.classForName(
                        providerClass).newInstance();
            } catch (Exception e) {
                log.fatal("Could not instantiate connection provider", e);
                throw new HibernateException(
                        "Could not instantiate connection provider: "
                                + providerClass);
            }
        } else if (properties.getProperty(Environment.DATASOURCE) != null) {
            connections = new DatasourceConnectionProvider();
        } else if (properties.getProperty(Environment.C3P0_MAX_SIZE) != null) {
            connections = new C3P0ConnectionProvider();
        } else if (properties.getProperty(Environment.DBCP_MAXACTIVE) != null) {
            connections = new DBCPConnectionProvider();
        } else if (properties.getProperty(Environment.PROXOOL_XML) != null
                || properties.getProperty(Environment.PROXOOL_PROPERTIES) != null
                || properties.getProperty(Environment.PROXOOL_EXISTING_POOL) != null) {
            connections = new ProxoolConnectionProvider();
        } else if (properties.getProperty(Environment.URL) != null) {
            connections = new DriverManagerConnectionProvider();
        } else {
            connections = new UserSuppliedConnectionProvider();
        }
        connections.configure(properties);
        return connections;
    }

    // cannot be instantiated
    private ConnectionProviderFactory() {
        throw new UnsupportedOperationException();
    }

    /**
     * Transform JDBC connection properties.
     * 
     * Passed in the form <tt>hibernate.connection.*</tt> to the format
     * accepted by <tt>DriverManager</tt> by triming the leading "
     * <tt>hibernate.connection</tt>".
     */
    public static Properties getConnectionProperties(Properties properties) {

        Iterator iter = properties.keySet().iterator();
        Properties result = new Properties();
        while (iter.hasNext()) {
            String prop = (String) iter.next();
            if (prop.indexOf(Environment.CONNECTION_PREFIX) > -1
                    && !SPECIAL_PROPERTIES.contains(prop)) {
                result.setProperty(prop.substring(Environment.CONNECTION_PREFIX
                        .length() + 1), properties.getProperty(prop));
            }
        }
        String userName = properties.getProperty(Environment.USER);
        if (userName != null)
            result.setProperty("user", userName);
        return result;
    }

    private static final Set SPECIAL_PROPERTIES;
    static {
        SPECIAL_PROPERTIES = new HashSet();
        SPECIAL_PROPERTIES.add(Environment.DATASOURCE);
        SPECIAL_PROPERTIES.add(Environment.URL);
        SPECIAL_PROPERTIES.add(Environment.CONNECTION_PROVIDER);
        SPECIAL_PROPERTIES.add(Environment.POOL_SIZE);
        SPECIAL_PROPERTIES.add(Environment.ISOLATION);
        SPECIAL_PROPERTIES.add(Environment.DRIVER);
        SPECIAL_PROPERTIES.add(Environment.USER);

    }

}

