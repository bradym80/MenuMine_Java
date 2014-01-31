//$Id: OneToManyLoader.java,v 1.3 2005/08/24 04:33:28 nick Exp $
package net.sf.hibernate.loader;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.LockMode;
import net.sf.hibernate.MappingException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.QueryableCollection;
import net.sf.hibernate.engine.SessionFactoryImplementor;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.persister.Loadable;
import net.sf.hibernate.persister.OuterJoinLoadable;
import net.sf.hibernate.sql.JoinFragment;
import net.sf.hibernate.sql.Select;
import net.sf.hibernate.type.Type;

/**
 * Loads one-to-many associations <br>
 * <br>
 * The collection persister must implement <tt>QueryableCOllection<tt>. For
 * other collections, create a customized subclass of <tt>Loader</tt>.
 * 
 * @see CollectionLoader
 * @author Gavin King
 */
public class OneToManyLoader extends OuterJoinLoader implements
        CollectionInitializer {

    private final QueryableCollection collectionPersister;

    private final Type idType;

    protected boolean isJoinedFetchEnabled(Type type, boolean mappingDefault,
            String path, String table, String[] foreignKeyColumns) {
        //disable a join back to this same association
        return super.isJoinedFetchEnabled(type, mappingDefault, path, table,
                foreignKeyColumns)
                && (!table.equals(collectionPersister.getTableName()) || !Arrays
                        .equals(foreignKeyColumns, collectionPersister
                                .getKeyColumnNames()));
    }

    public OneToManyLoader(QueryableCollection collPersister,
            SessionFactoryImplementor session) throws MappingException {
        this(collPersister, 1, session);
    }

    public OneToManyLoader(QueryableCollection collPersister, int batchSize,
            SessionFactoryImplementor session) throws MappingException {

        super(session.getDialect());

        collectionPersister = collPersister;

        idType = collPersister.getKeyType();

        OuterJoinLoadable persister = (OuterJoinLoadable) collPersister
                .getElementPersister();

        String alias = generateRootAlias(collPersister.getRole());

        List associations = walkTree(persister, alias, session);

        int joins = associations.size();
        suffixes = generateSuffixes(joins + 1);

        sql = renderStatementString(collPersister, persister, alias,
                associations, batchSize, session);

        classPersisters = new Loadable[joins + 1];
        lockModeArray = createLockModeArray(joins + 1, LockMode.NONE);
        for (int i = 0; i < joins; i++)
            classPersisters[i] = (Loadable) ((OuterJoinableAssociation) associations
                    .get(i)).joinable; //cast is safe b/c one-to-many can't
        // outerjoin to another collection!
        classPersisters[joins] = persister;

        postInstantiate();
    }

    protected CollectionPersister getCollectionPersister() {
        return collectionPersister;
    }

    public void initialize(Serializable id, SessionImplementor session)
            throws SQLException, HibernateException {
        loadCollection(session, id, idType);
    }

    public final String renderStatementString(
            final QueryableCollection collPersister,
            final OuterJoinLoadable persister, final String alias,
            final List associations, final int batchSize,
            final SessionFactoryImplementor factory) throws MappingException {

        StringBuffer whereString = whereString(alias, collPersister
                .getKeyColumnNames(), batchSize);
        if (collPersister.hasWhere())
            whereString.append(" and ").append(
                    collPersister.getSQLWhereString(alias));

        int joins = associations.size();

        JoinFragment ojf = mergeOuterJoins(associations);
        Select select = new Select()
                .setSelectClause(
                        collPersister.selectClauseFragment(alias)
                                + selectString(associations, factory)
                                + ", "
                                + persister.selectFragment(alias,
                                        suffixes[joins]))
                .setFromClause(
                        persister.fromTableFragment(alias)
                                + persister.fromJoinFragment(alias, true, true))
                .setWhereClause(whereString.toString()).setOuterJoins(
                        ojf.toFromFragmentString(),
                        ojf.toWhereFragmentString()
                                + persister
                                        .whereJoinFragment(alias, true, true));
        if (collPersister.hasOrdering())
            select.setOrderByClause(collPersister.getSQLOrderByString(alias));

        return select.toStatementString();
    }

}