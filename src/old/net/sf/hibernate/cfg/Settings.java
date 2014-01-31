//$Id: Settings.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.cfg;

import java.util.Map;

import net.sf.hibernate.cache.CacheProvider;
import net.sf.hibernate.connection.ConnectionProvider;
import net.sf.hibernate.dialect.Dialect;
import net.sf.hibernate.transaction.TransactionFactory;
import net.sf.hibernate.transaction.TransactionManagerLookup;

/**
 * Settings that affect the behaviour of Hibernate at runtime.
 * 
 * @author Gavin King
 */
public final class Settings {

    private boolean showSql;

    private boolean outerJoinFetchEnabled;

    private Integer maximumFetchDepth;

    private Map querySubstitutions;

    private Dialect dialect;

    private int jdbcBatchSize;

    private boolean scrollableResultSetsEnabled;

    private String defaultSchemaName;

    private Integer statementFetchSize;

    private ConnectionProvider connectionProvider;

    private TransactionFactory transactionFactory;

    private TransactionManagerLookup transactionManagerLookup;

    private String sessionFactoryName;

    private boolean autoCreateSchema;

    private boolean autoDropSchema;

    private boolean autoUpdateSchema;

    private CacheProvider cacheProvider;

    private boolean queryCacheEnabled;

    public String getDefaultSchemaName() {
        return defaultSchemaName;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public int getJdbcBatchSize() {
        return jdbcBatchSize;
    }

    public Map getQuerySubstitutions() {
        return querySubstitutions;
    }

    public boolean isShowSqlEnabled() {
        return showSql;
    }

    public boolean isOuterJoinFetchEnabled() {
        return outerJoinFetchEnabled;
    }

    public boolean isScrollableResultSetsEnabled() {
        return scrollableResultSetsEnabled;
    }

    void setDefaultSchemaName(String string) {
        defaultSchemaName = string;
    }

    void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    void setJdbcBatchSize(int i) {
        jdbcBatchSize = i;
    }

    void setQuerySubstitutions(Map map) {
        querySubstitutions = map;
    }

    void setShowSqlEnabled(boolean b) {
        showSql = b;
    }

    void setOuterJoinFetchEnabled(boolean b) {
        outerJoinFetchEnabled = b;
    }

    void setScrollableResultSetsEnabled(boolean b) {
        scrollableResultSetsEnabled = b;
    }

    public Integer getStatementFetchSize() {
        return statementFetchSize;
    }

    void setStatementFetchSize(Integer integer) {
        statementFetchSize = integer;
    }

    public ConnectionProvider getConnectionProvider() {
        return connectionProvider;
    }

    void setConnectionProvider(ConnectionProvider provider) {
        connectionProvider = provider;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    void setTransactionFactory(TransactionFactory factory) {
        transactionFactory = factory;
    }

    public String getSessionFactoryName() {
        return sessionFactoryName;
    }

    void setSessionFactoryName(String string) {
        sessionFactoryName = string;
    }

    public boolean isAutoCreateSchema() {
        return autoCreateSchema;
    }

    public boolean isAutoDropSchema() {
        return autoDropSchema;
    }

    public boolean isAutoUpdateSchema() {
        return autoUpdateSchema;
    }

    void setAutoCreateSchema(boolean b) {
        autoCreateSchema = b;
    }

    void setAutoDropSchema(boolean b) {
        autoDropSchema = b;
    }

    void setAutoUpdateSchema(boolean b) {
        autoUpdateSchema = b;
    }

    public Integer getMaximumFetchDepth() {
        return maximumFetchDepth;
    }

    void setMaximumFetchDepth(Integer i) {
        maximumFetchDepth = i;
    }

    public CacheProvider getCacheProvider() {
        return cacheProvider;
    }

    void setCacheProvider(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }

    public TransactionManagerLookup getTransactionManagerLookup() {
        return transactionManagerLookup;
    }

    void setTransactionManagerLookup(TransactionManagerLookup lookup) {
        transactionManagerLookup = lookup;
    }

    public boolean isQueryCacheEnabled() {
        return queryCacheEnabled;
    }

    void setQueryCacheEnabled(boolean b) {
        queryCacheEnabled = b;
    }

}