// $Id: FilterTranslator.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.hql;

import java.util.Map;

import net.sf.hibernate.MappingException;
import net.sf.hibernate.QueryException;
import net.sf.hibernate.engine.SessionFactoryImplementor;

public class FilterTranslator extends QueryTranslator {

    public FilterTranslator(String filterString) {
        super(filterString);
    }

    /**
     * Compile a filter. This method may be called multiple times. Subsequent
     * invocations are no-ops.
     */
    public synchronized void compile(String collectionRole,
            SessionFactoryImplementor factory, Map replacements, boolean scalar)
            throws QueryException, MappingException {

        if (!isCompiled()) {
            setFactory(factory); // yick!
            addFromAssociation("this", collectionRole);
            super.compile(factory, replacements, scalar);
        }
    }

}

