//$Id: NotExpression.java,v 1.3 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.expression;

import java.util.Map;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.dialect.MySQLDialect;
import net.sf.hibernate.engine.SessionFactoryImplementor;
import net.sf.hibernate.engine.TypedValue;
import net.sf.hibernate.util.StringHelper;

/**
 * Negates another criterion
 * 
 * @author Gavin King
 */
public class NotExpression extends AbstractCriterion {

    private Criterion criterion;

    NotExpression(Criterion criterion) {
        this.criterion = criterion;
    }

    public String toSqlString(SessionFactoryImplementor sessionFactory,
            Class persistentClass, String alias, Map aliasClasses)
            throws HibernateException {
        //return "not " + criterion.toSqlString(sessionFactory,
        // persistentClass, alias, aliasClasses);
        /*
         * Nick 2005-4-1 this was a bug in hibernate. I found this from a later
         * version.
         */
        if (sessionFactory.getDialect() instanceof MySQLDialect) {
            return "not ("
                    + criterion.toSqlString(sessionFactory, persistentClass,
                            alias, aliasClasses) + StringHelper.CLOSE_PAREN;
        } else {
            return "not "
                    + criterion.toSqlString(sessionFactory, persistentClass,
                            alias, aliasClasses);
        }

    }

    public TypedValue[] getTypedValues(
            SessionFactoryImplementor sessionFactory, Class persistentClass,
            Map aliasClasses) throws HibernateException {
        return criterion.getTypedValues(sessionFactory, persistentClass,
                aliasClasses);
    }

    public String toString() {
        return "not " + criterion.toString();
    }

}