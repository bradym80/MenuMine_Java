//$Id: UserSuppliedConnectionProvider.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import net.sf.hibernate.HibernateException;

import org.apache.commons.logging.LogFactory;

/**
 * An implementation of the <literal>ConnectionProvider </literal> interface
 * that simply throws an exception when a connection is requested. This
 * implementation indicates that the user is expected to supply a JDBC
 * connection.
 * 
 * @see ConnectionProvider
 * @author Gavin King
 */
public class UserSuppliedConnectionProvider implements ConnectionProvider {

    /**
     * @see net.sf.hibernate.connection.ConnectionProvider#configure(Properties)
     */
    public void configure(Properties props) throws HibernateException {
        LogFactory
                .getLog(UserSuppliedConnectionProvider.class)
                .warn(
                        "No connection properties specified - the user must supply JDBC connections");
    }

    /**
     * @see net.sf.hibernate.connection.ConnectionProvider#getConnection()
     */
    public Connection getConnection() throws SQLException {
        throw new UnsupportedOperationException(
                "The user must supply a JDBC connection");
    }

    /**
     * @see net.sf.hibernate.connection.ConnectionProvider#closeConnection(Connection)
     */
    public void closeConnection(Connection conn) throws SQLException {
        throw new UnsupportedOperationException(
                "The user must supply a JDBC connection");
    }

    public void close() {
    }

}

