//$Id: CollectionLoader.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.loader;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.LockMode;
import net.sf.hibernate.MappingException;
import net.sf.hibernate.collection.CollectionPersister;
import net.sf.hibernate.collection.QueryableCollection;
import net.sf.hibernate.engine.SessionFactoryImplementor;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.persister.Loadable;
import net.sf.hibernate.sql.JoinFragment;
import net.sf.hibernate.sql.Select;
import net.sf.hibernate.type.AssociationType;
import net.sf.hibernate.type.Type;
import net.sf.hibernate.util.StringHelper;

/**
 * Loads a collection of values or a many-to-many association. <br>
 * The collection persister must implement <tt>QueryableCOllection<tt>. For
 * other collections, create a customized subclass of <tt>Loader</tt>.
 * 
 * @see OneToManyLoader
 * @author Gavin King
 */
public class CollectionLoader extends OuterJoinLoader implements
        CollectionInitializer {

    private final QueryableCollection collectionPersister;

    private final Type keyType;

    public CollectionLoader(QueryableCollection persister,
            SessionFactoryImplementor session) throws MappingException {
        this(persister, 1, session);
    }

    public CollectionLoader(QueryableCollection persister, int batchSize,
            SessionFactoryImplementor factory) throws MappingException {

        super(factory.getDialect());

        keyType = persister.getKeyType();

        String alias = generateRootAlias(persister.getRole());

        List associations = walkCollectionTree(persister, alias, factory);

        int joins = associations.size();
        suffixes = generateSuffixes(joins);

        sql = renderStatementString(persister, alias, associations, batchSize,
                factory);

        classPersisters = new Loadable[joins];
        lockModeArray = createLockModeArray(joins, LockMode.NONE);
        for (int i = 0; i < joins; i++)
            classPersisters[i] = (Loadable) ((OuterJoinableAssociation) associations
                    .get(i)).joinable;
        this.collectionPersister = persister;

        postInstantiate();

    }

    protected CollectionPersister getCollectionPersister() {
        return collectionPersister;
    }

    public void initialize(Serializable id, SessionImplementor session)
            throws SQLException, HibernateException {
        loadCollection(session, id, keyType);
    }

    public final String renderStatementString(QueryableCollection persister,
            String alias, List associations, int batchSize,
            SessionFactoryImplementor factory) throws MappingException {

        StringBuffer whereString = whereString(alias, persister
                .getKeyColumnNames(), batchSize);
        if (persister.hasWhere())
            whereString.append(" and ").append(
                    persister.getSQLWhereString(alias));

        JoinFragment ojf = mergeOuterJoins(associations);
        Select select = new Select().setSelectClause(
                persister.selectClauseFragment(alias)
                        + selectString(associations, factory)).setFromClause(
                persister.getTableName(), alias).setWhereClause(
                whereString.toString()).setOuterJoins(
                ojf.toFromFragmentString(), ojf.toWhereFragmentString());
        if (persister.hasOrdering())
            select.setOrderByClause(persister.getSQLOrderByString(alias));
        return select.toStatementString();
    }

    protected int getJoinType(AssociationType type, int config, String path,
            String table, String[] foreignKeyColumns,
            SessionFactoryImplementor factory) throws MappingException {

        int joinType = super.getJoinType(type, config, path, table,
                foreignKeyColumns, factory);
        //we can use an inner join for the many-to-many
        if (joinType == JoinFragment.LEFT_OUTER_JOIN
                && StringHelper.EMPTY_STRING.equals(path))
            joinType = JoinFragment.INNER_JOIN;
        return joinType;
    }

}

