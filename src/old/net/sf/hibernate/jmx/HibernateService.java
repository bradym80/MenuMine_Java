//$Id: HibernateService.java,v 1.4 2005/08/24 04:33:27 nick Exp $
package net.sf.hibernate.jmx;

import java.util.Properties;

import javax.naming.InitialContext;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.util.NamingHelper;
import net.sf.hibernate.util.PropertiesHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of <tt>HibernateServiceMBean</tt>. Creates a
 * <tt>SessionFactory</tt> and binds it to the specified JNDI name. <br>
 * <br>
 * All mapping documents are loaded as resources by the MBean.
 * 
 * @see HibernateServiceMBean
 * @see net.sf.hibernate.SessionFactory
 * @author John Urberg
 */
public class HibernateService implements HibernateServiceMBean {

    private static final Log log = LogFactory
            .getLog(HibernateServiceMBean.class);

    private String mapResources;

    private String boundName;

    private Properties properties = new Properties();

    /**
     * The name of the current bean
     * 
     * @return String
     */
    public String getName() {
        return getProperty(Environment.SESSION_FACTORY_NAME);
    }

    public String getMapResources() {
        return mapResources;
    }

    public void setMapResources(String mapResources) {
        if (mapResources == null) {
            this.mapResources = null;
        } else {
            this.mapResources = mapResources.trim();
        }
    }

    public void addMapResource(String mapResource) {
        if (mapResources == null || mapResources.length() == 0) {
            mapResources = mapResource.trim();
        } else {
            mapResources += ", " + mapResource.trim();
        }
    }

    protected boolean getBooleanProperty(String propName) {
        return PropertiesHelper.getBoolean(propName, properties);
    }

    protected void setProperty(String propName, boolean value) {
        setProperty(propName, value ? "true" : "false"); //Boolean.toString()
        // only in JDK1.4
    }

    protected void setProperty(String propName, Integer value) {
        setProperty(propName, value == null ? null : value.toString()); //Boolean.toString()
        // only
        // in
        // JDK1.4
    }

    protected Integer getIntegerProperty(String propName) {
        return PropertiesHelper.getInteger(propName, properties);
    }

    public String getDatasource() {
        return getProperty(Environment.DATASOURCE);
    }

    public void setDatasource(String datasource) {
        setProperty(Environment.DATASOURCE, datasource);
    }

    public String getDialect() {
        return getProperty(Environment.DIALECT);
    }

    public void setDialect(String dialect) {
        setProperty(Environment.DIALECT, dialect);
    }

    public String getJndiName() {
        return getProperty(Environment.SESSION_FACTORY_NAME);
    }

    public void setJndiName(String jndiName) {
        setProperty(Environment.SESSION_FACTORY_NAME, jndiName);
    }

    public boolean getUseOuterJoin() {
        return getBooleanProperty(Environment.USE_OUTER_JOIN);
    }

    public void setUseOuterJoin(boolean uoj) {
        setProperty(Environment.USE_OUTER_JOIN, uoj);
    }

    public boolean getShowSql() {
        return getBooleanProperty(Environment.SHOW_SQL);
    }

    public void setShowSql(boolean showSql) {
        setProperty(Environment.SHOW_SQL, showSql);
    }

    public String getUserName() {
        return getProperty(Environment.USER);
    }

    public void setUserName(String userName) {
        setProperty(Environment.USER, userName);
    }

    public String getPassword() {
        return getProperty(Environment.PASS);
    }

    public void setPassword(String password) {
        setProperty(Environment.PASS, password);
    }

    private static String[] parseResourceList(String resourceList) {
        return PropertiesHelper.toStringArray(resourceList, " ,\n\t\r\f");
    }

    public void start() throws HibernateException {
        boundName = getJndiName();
        try {
            buildSessionFactory();
        } catch (HibernateException he) {
            log
                    .info("Could not build SessionFactory using the MBean classpath - will try again using client classpath: "
                            + he.getMessage());
            log.debug("Error was", he);
            new SessionFactoryStub(this);
        }
    }

    public void stop() {
        log.info("stopping service");
        try {
            InitialContext context = NamingHelper
                    .getInitialContext(getProperties());
            ((SessionFactory) context.lookup(boundName)).close();
            //context.unbind(boundName);
        } catch (Exception e) {
            log.warn("exception while stopping service", e);
        }
    }

    SessionFactory buildSessionFactory() throws HibernateException {
        log.info("starting service at JNDI name: " + boundName);
        log.info("service properties: " + properties);

        Configuration cfg = new Configuration().addProperties(getProperties());

        String[] mappingFiles = parseResourceList(getMapResources());
        for (int i = 0; i < mappingFiles.length; i++) {
            cfg.addResource(mappingFiles[i], Thread.currentThread()
                    .getContextClassLoader());
        }
        return cfg.buildSessionFactory();
    }

    public String getTransactionStrategy() {
        return getProperty(Environment.TRANSACTION_STRATEGY);
    }

    public String getUserTransactionName() {
        return getProperty(Environment.USER_TRANSACTION);
    }

    public void setTransactionStrategy(String txnStrategy) {
        setProperty(Environment.TRANSACTION_STRATEGY, txnStrategy);
    }

    public void setUserTransactionName(String utName) {
        setProperty(Environment.USER_TRANSACTION, utName);
    }

    public String getTransactionManagerLookupStrategy() {
        return getProperty(Environment.TRANSACTION_MANAGER_STRATEGY);
    }

    public void setTransactionManagerLookupStrategy(String lkpStrategy) {
        setProperty(Environment.TRANSACTION_MANAGER_STRATEGY, lkpStrategy);
    }

    public String getPropertyList() {
        return getProperties().toString();
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }

    public void setProperty(String property, String value) {
        properties.setProperty(property, value);
    }

    protected Properties getProperties() {
        return properties;
    }

    public String getCacheProvider() {
        return getProperty(Environment.CACHE_PROVIDER);
    }

    public String getDefaultSchema() {
        return getProperty(Environment.DEFAULT_SCHEMA);
    }

    public Integer getJdbcBatchSize() {
        return getIntegerProperty(Environment.STATEMENT_BATCH_SIZE);
    }

    public Integer getJdbcFetchSize() {
        return getIntegerProperty(Environment.STATEMENT_FETCH_SIZE);
    }

    public Integer getMaxFetchDepth() {
        return getIntegerProperty(Environment.MAX_FETCH_DEPTH);
    }

    public boolean getUseQueryCache() {
        return getBooleanProperty(Environment.USE_QUERY_CACHE);
    }

    public String getQuerySubstitutions() {
        return getProperty(Environment.QUERY_SUBSTITUTIONS);
    }

    public void setCacheProvider(String cacheProvider) {
        setProperty(Environment.CACHE_PROVIDER, cacheProvider);
    }

    public void setDefaultSchema(String schema) {
        setProperty(Environment.DEFAULT_SCHEMA, schema);
    }

    public void setJdbcBatchSize(Integer depth) {
        setProperty(Environment.STATEMENT_BATCH_SIZE, depth);
    }

    public void setJdbcFetchSize(Integer depth) {
        setProperty(Environment.STATEMENT_FETCH_SIZE, depth);
    }

    public void setMaxFetchDepth(Integer depth) {
        setProperty(Environment.MAX_FETCH_DEPTH, depth);
    }

    public void setUseQueryCache(boolean enabled) {
        setProperty(Environment.USE_QUERY_CACHE, enabled);
    }

    public void setQuerySubstitutions(String substitutions) {
        setProperty(Environment.QUERY_SUBSTITUTIONS, substitutions);
    }

}

