//$Id: CompositeElementPropertyMapping.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.collection;

import net.sf.hibernate.MappingException;
import net.sf.hibernate.engine.SessionFactoryImplementor;
import net.sf.hibernate.persister.AbstractPropertyMapping;
import net.sf.hibernate.type.AbstractComponentType;
import net.sf.hibernate.type.Type;

/**
 * @author Gavin King
 */
public class CompositeElementPropertyMapping extends AbstractPropertyMapping {

    private final AbstractComponentType compositeType;

    public CompositeElementPropertyMapping(String[] elementColumns,
            AbstractComponentType compositeType,
            SessionFactoryImplementor factory) throws MappingException {

        this.compositeType = compositeType;

        initComponentPropertyPaths(null, compositeType, elementColumns, factory);

    }

    public Type getType() {
        return compositeType;
    }

    protected String getClassName() {
        return compositeType.getName();
    }

}