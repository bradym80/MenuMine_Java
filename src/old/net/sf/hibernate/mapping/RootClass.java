//$Id: RootClass.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.mapping;

import java.util.Collections;
import java.util.Iterator;

import net.sf.hibernate.MappingException;
import net.sf.hibernate.cache.CacheConcurrencyStrategy;
import net.sf.hibernate.engine.Mapping;

/**
 * The root class of a table-per-subclass, or table-per-concrete-class
 * inheritance hierarchy.
 * 
 * @author Gavin King
 */
public class RootClass extends PersistentClass {

    public static final String DEFAULT_IDENTIFIER_COLUMN_NAME = "id";

    public static final String DEFAULT_DISCRIMINATOR_COLUMN_NAME = "class";

    private Property identifierProperty; //may be final

    private SimpleValue identifier; //may be final

    private Property version; //may be final

    private boolean polymorphic;

    private CacheConcurrencyStrategy cache;

    private SimpleValue discriminator; //may be final

    private boolean mutable;

    private boolean embeddedIdentifier = false; // may be final

    private boolean explicitPolymorphism;

    private Class classPersisterClass;

    private boolean forceDiscriminator;

    private String where;

    public Property getIdentifierProperty() {
        return identifierProperty;
    }

    public SimpleValue getIdentifier() {
        return identifier;
    }

    public boolean hasIdentifierProperty() {
        return identifierProperty != null;
    }

    public Value getDiscriminator() {
        return discriminator;
    }

    public boolean isInherited() {
        return false;
    }

    public boolean isPolymorphic() {
        return polymorphic;
    }

    public void setPolymorphic(boolean polymorphic) {
        this.polymorphic = polymorphic;
    }

    public RootClass getRootClass() {
        return this;
    }

    public Iterator getPropertyClosureIterator() {
        return getPropertyIterator();
    }

    public Iterator getTableClosureIterator() {
        return Collections.singleton(getTable()).iterator();
    }

    public void addSubclass(Subclass subclass) throws MappingException {
        super.addSubclass(subclass);
        setPolymorphic(true);
    }

    public boolean isExplicitPolymorphism() {
        return explicitPolymorphism;
    }

    public Property getVersion() {
        return version;
    }

    public void setVersion(Property version) {
        this.version = version;
    }

    public boolean isVersioned() {
        return version != null;
    }

    public CacheConcurrencyStrategy getCache() {
        return cache;
    }

    public boolean isMutable() {
        return mutable;
    }

    public boolean hasEmbeddedIdentifier() {
        return embeddedIdentifier;
    }

    public Class getClassPersisterClass() {
        return classPersisterClass;
    }

    public Table getRootTable() {
        return getTable();
    }

    public void setClassPersisterClass(Class persister) {
        this.classPersisterClass = persister;
    }

    public PersistentClass getSuperclass() {
        return null;
    }

    public SimpleValue getKey() {
        return getIdentifier();
    }

    /**
     * Sets the discriminator.
     * 
     * @param discriminator
     *            The discriminator to set
     */
    public void setDiscriminator(SimpleValue discriminator) {
        this.discriminator = discriminator;
    }

    /**
     * Sets the embeddedIdentifier.
     * 
     * @param embeddedIdentifier
     *            The embeddedIdentifier to set
     */
    public void setEmbeddedIdentifier(boolean embeddedIdentifier) {
        this.embeddedIdentifier = embeddedIdentifier;
    }

    /**
     * Sets the explicitPolymorphism.
     * 
     * @param explicitPolymorphism
     *            The explicitPolymorphism to set
     */
    public void setExplicitPolymorphism(boolean explicitPolymorphism) {
        this.explicitPolymorphism = explicitPolymorphism;
    }

    /**
     * Sets the identifier.
     * 
     * @param identifier
     *            The identifier to set
     */
    public void setIdentifier(SimpleValue identifier) {
        this.identifier = identifier;
    }

    /**
     * Sets the identifierProperty.
     * 
     * @param identifierProperty
     *            The identifierProperty to set
     */
    public void setIdentifierProperty(Property identifierProperty) {
        this.identifierProperty = identifierProperty;
    }

    /**
     * Sets the mutable.
     * 
     * @param mutable
     *            The mutable to set
     */
    public void setMutable(boolean mutable) {
        this.mutable = mutable;
    }

    /**
     * Sets the cache.
     * 
     * @param cache
     *            The cache to set
     */
    public void setCache(CacheConcurrencyStrategy cache) {
        this.cache = cache;
    }

    /**
     * Returns the forceDiscriminator.
     * 
     * @return boolean
     */
    public boolean isForceDiscriminator() {
        return forceDiscriminator;
    }

    /**
     * Sets the forceDiscriminator.
     * 
     * @param forceDiscriminator
     *            The forceDiscriminator to set
     */
    public void setForceDiscriminator(boolean forceDiscriminator) {
        this.forceDiscriminator = forceDiscriminator;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String string) {
        where = string;
    }

    public void validate(Mapping mapping) throws MappingException {
        super.validate(mapping);
        if (!getIdentifier().isValid(mapping)) {
            throw new MappingException(
                    "identifier mapping has wrong number of columns: "
                            + getMappedClass().getName() + " type: "
                            + getIdentifier().getType().getName());
        }
    }

}

