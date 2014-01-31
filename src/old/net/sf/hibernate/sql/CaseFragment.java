//$Id: CaseFragment.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.sql;

import java.util.Map;

import net.sf.hibernate.util.StringHelper;

import org.apache.commons.collections.SequencedHashMap;

/**
 * Abstract SQL case fragment renderer
 * 
 * @author Gavin King, Simon Harris
 */
public abstract class CaseFragment {
    public abstract String toFragmentString();

    protected String returnColumnName;

    protected Map cases = new SequencedHashMap();

    public CaseFragment setReturnColumnName(String returnColumnName) {
        this.returnColumnName = returnColumnName;
        return this;
    }

    public CaseFragment setReturnColumnName(String returnColumnName,
            String suffix) {
        return setReturnColumnName(new Alias(suffix)
                .toAliasString(returnColumnName));
    }

    public CaseFragment addWhenColumnNotNull(String alias, String columnName,
            String value) {
        cases.put(StringHelper.qualify(alias, columnName), value);
        return this;
    }

}