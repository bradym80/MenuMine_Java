//$Id: AbstractEntityLoader.java,v 1.5 2005/08/24 04:33:28 nick Exp $
package net.sf.hibernate.loader;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.AssertionFailure;
import net.sf.hibernate.LockMode;
import net.sf.hibernate.MappingException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.QueryableCollection;
import net.sf.hibernate.engine.SessionFactoryImplementor;
import net.sf.hibernate.persister.Loadable;
import net.sf.hibernate.persister.OuterJoinLoadable;
import net.sf.hibernate.sql.JoinFragment;
import net.sf.hibernate.sql.Select;
import net.sf.hibernate.type.Type;
import net.sf.hibernate.util.ArrayHelper;
import net.sf.hibernate.util.StringHelper;

/**
 * Abstract superclass for entity loaders that use outer joins
 * 
 * @see CriteriaLoader
 * @see EntityLoader
 * @author Gavin King
 */
public abstract class AbstractEntityLoader extends OuterJoinLoader {

    private final OuterJoinLoadable persister;

    private CollectionPersister collectionPersister;

    private int collectionOwner;

    private String alias;

    protected Select select;

    public AbstractEntityLoader(OuterJoinLoadable persister,
            SessionFactoryImplementor factory) {
        super(factory.getDialect());
        this.persister = persister;
        alias = generateRootAlias(persister.getClassName());
    }

    protected final void renderStatement(String condition,
            SessionFactoryImplementor factory) throws MappingException {
        renderStatement(condition, StringHelper.EMPTY_STRING, factory);
    }

    protected final void addAllToPropertySpaces(Serializable[] spaces) {
        for (int i = 0; i < spaces.length; i++)
            addToPropertySpaces(spaces[i]);
    }

    protected void addToPropertySpaces(Serializable space) {
        throw new AssertionFailure("only criteria queries need to autoflush");
    }

    private int toOwner(OuterJoinableAssociation oj, int joins,
            boolean dontIgnore) {
        if (dontIgnore) {
            return (oj.owner == -1) ? joins : oj.owner; //TODO: UGLY AS SIN!
        } else {
            return -1;
        }
    }

    protected final void renderStatement(String condition, String orderBy,
            SessionFactoryImplementor factory) throws MappingException {

        List associations = walkTree(persister, alias, factory);

        int joins = countClassPersisters(associations);

        collectionOwner = -1; //if no collection found
        classPersisters = new Loadable[joins + 1];
        owners = new int[joins + 1];
        lockModeArray = createLockModeArray(joins + 1, LockMode.NONE);
        int i = 0;
        Iterator iter = associations.iterator();
        while (iter.hasNext()) {
            OuterJoinableAssociation oj = (OuterJoinableAssociation) iter
                    .next();
            Object subpersister = oj.joinable;
            if (subpersister instanceof Loadable) {
                classPersisters[i] = (Loadable) subpersister;
                owners[i] = toOwner(oj, joins, oj.isOneToOne);
                if (oj.joinType == JoinFragment.INNER_JOIN)
                    addAllToPropertySpaces(classPersisters[i]
                            .getPropertySpaces());
                i++;
            } else {
                QueryableCollection collPersister = (QueryableCollection) subpersister;
                if (oj.joinType == JoinFragment.LEFT_OUTER_JOIN) { //supress
                    // initialization
                    // of
                    // collections
                    // with a
                    // where
                    // condition!
                    collectionPersister = collPersister;
                    collectionOwner = toOwner(oj, joins, true);
                } else {
                    addToPropertySpaces(collPersister.getCollectionSpace());
                }
                if (collPersister.isOneToMany()) {
                    classPersisters[i++] = (Loadable) collPersister
                            .getElementPersister();
                }
            }
        }
        classPersisters[joins] = persister;
        owners[joins] = -1;

        if (ArrayHelper.isAllNegative(owners))
            owners = null;

        suffixes = generateSuffixes(joins + 1);

        JoinFragment ojf = mergeOuterJoins(associations);

        //sql = new Select()
        select = new Select().setSelectClause(
                persister.selectFragment(alias, suffixes[joins])
                        + selectString(associations, factory)).setFromClause(
                persister.fromTableFragment(alias)
                        + persister.fromJoinFragment(alias, true, true))
                .setWhereClause(condition).setOuterJoins(
                        ojf.toFromFragmentString(),
                        ojf.toWhereFragmentString() + getWhereFragment())
                .setOrderByClause(orderBy);
        //.toStatementString();
        sql = select.toStatementString();
        System.out.println(sql);
    }

    /**
     * Don't bother with the discriminator, unless overridded by subclass
     */
    protected String getWhereFragment() throws MappingException {
        return persister.whereJoinFragment(alias, true, true);
    }

    protected final Loadable getPersister() {
        return persister;
    }

    protected final void setAlias(String alias) {
        this.alias = alias;
    }

    protected final String getAlias() {
        return alias;
    }

    protected final CollectionPersister getCollectionPersister() {
        return collectionPersister;
    }

    protected final int getCollectionOwner() {
        return collectionOwner;
    }

    protected boolean isJoinedFetchEnabled(Type type, boolean mappingDefault,
            String path, String table, String[] foreignKeyColumns) {

        return mappingDefault;
    }

    public String toString() {
        return getClass().getName() + " for " + getPersister().getClassName();
    }
}