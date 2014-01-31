//$Id: SequenceGenerator.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.id;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.MappingException;
import net.sf.hibernate.dialect.Dialect;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.type.Type;
import net.sf.hibernate.util.JDBCExceptionReporter;
import net.sf.hibernate.util.PropertiesHelper;
import net.sf.hibernate.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <b>sequence </b> <br>
 * <br>
 * Generates <tt>long</tt> values using an oracle-style sequence. A higher
 * performance algorithm is <tt>SequenceHiLoGenerator</tt>.<br>
 * <br>
 * Mapping parameters supported: sequence, parameters.
 * 
 * @see SequenceHiLoGenerator
 * @see TableHiLoGenerator
 * @author Gavin King
 */

public class SequenceGenerator implements PersistentIdentifierGenerator,
        Configurable {

    /**
     * The sequence parameter
     */
    public static final String SEQUENCE = "sequence";

    /**
     * The parameters parameter, appended to the create sequence DDL. For
     * example (Oracle):
     * <tt>INCREMENT BY 1 START WITH 1 MAXVALUE 100 NOCACHE</tt>.
     */
    public static final String PARAMETERS = "parameters";

    private String sequenceName;

    private String parameters;

    private Type type;

    private String sql;

    private static final Log log = LogFactory.getLog(SequenceGenerator.class);

    public void configure(Type type, Properties params, Dialect dialect)
            throws MappingException {
        this.sequenceName = PropertiesHelper.getString(SEQUENCE, params,
                "hibernate_sequence");
        this.parameters = params.getProperty(PARAMETERS);
        String schemaName = params.getProperty(SCHEMA);
        if (schemaName != null && sequenceName.indexOf(StringHelper.DOT) < 0)
            sequenceName = schemaName + '.' + sequenceName;
        this.type = type;
        sql = dialect.getSequenceNextValString(sequenceName);
    }

    public Serializable generate(SessionImplementor session, Object obj)
            throws SQLException, HibernateException {

        PreparedStatement st = session.getBatcher().prepareStatement(sql);
        try {
            ResultSet rs = st.executeQuery();
            final Serializable result;
            try {
                rs.next();
                result = IdentifierGeneratorFactory.get(rs, type, session, obj);
            } finally {
                rs.close();
            }
            log.debug("Sequence identifier generated: " + result);
            return result;
        } catch (SQLException sqle) {
            JDBCExceptionReporter.logExceptions(sqle);
            throw sqle;
        } finally {
            session.getBatcher().closeStatement(st);
        }

    }

    public String[] sqlCreateStrings(Dialect dialect) throws HibernateException {
        String ddl = dialect.getCreateSequenceString(sequenceName);
        if (parameters != null)
            ddl += ' ' + parameters;
        return new String[] { ddl };
    }

    public String sqlDropString(Dialect dialect) throws HibernateException {
        return dialect.getDropSequenceString(sequenceName);
    }

    public Object generatorKey() {
        return sequenceName;
    }

}

