//$Id: OracleDialect.java,v 1.3 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.dialect;

import net.sf.hibernate.sql.CaseFragment;
import net.sf.hibernate.sql.DecodeCaseFragment;
import net.sf.hibernate.sql.JoinFragment;
import net.sf.hibernate.sql.OracleJoinFragment;

/**
 * An SQL dialect for Oracle, compatible with Oracle 8.
 * 
 * @author Gavin King
 */
public class OracleDialect extends Oracle9Dialect {

    public OracleDialect() {
        super();
    }

    public JoinFragment createOuterJoinFragment() {
        return new OracleJoinFragment();
    }

    public CaseFragment createCaseFragment() {
        return new DecodeCaseFragment();
    }

}

