//$Id: TransactionManagerLookupFactory.java,v 1.3 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.transaction;

import java.util.Properties;

import javax.transaction.TransactionManager;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.cfg.Environment;
import net.sf.hibernate.util.ReflectHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Gavin King
 */
public final class TransactionManagerLookupFactory {

    private static final Log log = LogFactory
            .getLog(TransactionManagerLookupFactory.class);

    private TransactionManagerLookupFactory() {
    }

    public static final TransactionManager getTransactionManager(
            Properties props) throws HibernateException {
        log.info("obtaining TransactionManager");
        return getTransactionManagerLookup(props).getTransactionManager(props);
    }

    public static final TransactionManagerLookup getTransactionManagerLookup(
            Properties props) throws HibernateException {

        String tmLookupClass = props
                .getProperty(Environment.TRANSACTION_MANAGER_STRATEGY);
        if (tmLookupClass == null) {
            log
                    .info("No TransactionManagerLookup configured (in JTA environment, use of process level read-write cache is not recommended)");
            return null;
        } else {

            log
                    .info("instantiating TransactionManagerLookup: "
                            + tmLookupClass);

            try {
                TransactionManagerLookup lookup = (TransactionManagerLookup) ReflectHelper
                        .classForName(tmLookupClass).newInstance();
                log.info("instantiated TransactionManagerLookup");
                return lookup;
            } catch (Exception e) {
                log.error("Could not instantiate TransactionManagerLookup", e);
                throw new HibernateException(
                        "Could not instantiate TransactionManagerLookup");
            }
        }
    }
}