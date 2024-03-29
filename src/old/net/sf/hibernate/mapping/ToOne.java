//$Id: ToOne.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import net.sf.hibernate.MappingException;

/**
 * A simple-point association (ie. a reference to another entity).
 * 
 * @author Gavin King
 */
public abstract class ToOne extends SimpleValue implements Fetchable {

    private int joinedFetch;

    protected String referencedPropertyName;

    protected ToOne(Table table) {
        super(table);
    }

    public int getOuterJoinFetchSetting() {
        return joinedFetch;
    }

    public void setOuterJoinFetchSetting(int joinedFetch) {
        this.joinedFetch = joinedFetch;
    }

    public abstract void setTypeByReflection(Class propertyClass,
            String propertyName) throws MappingException;

    public abstract void createForeignKey();

    public String getReferencedPropertyName() {
        return referencedPropertyName;
    }

    public void setReferencedPropertyName(String string) {
        referencedPropertyName = string;
    }

}

