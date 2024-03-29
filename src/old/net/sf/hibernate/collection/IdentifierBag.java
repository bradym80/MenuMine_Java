//$Id: IdentifierBag.java,v 1.3 2005/08/24 04:33:26 nick Exp $
package net.sf.hibernate.collection;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.JDBCException;
import net.sf.hibernate.engine.SessionImplementor;
import net.sf.hibernate.type.Type;

/**
 * An <tt>IdentifierBag</tt> implements "bag" semantics more efficiently than
 * a regular <tt>Bag</tt> by adding a synthetic identifier column to the
 * table. This identifier is unique for all rows in the table, allowing very
 * efficient updates and deletes. The value of the identifier is never exposed
 * to the application. <br>
 * <br>
 * <tt>IdentifierBag</tt> s may not be used for a many-to-one association.
 * Furthermore, there is no reason to use <tt>inverse="true"</tt>.
 * 
 * @author Gavin King
 */
public class IdentifierBag extends ODMGCollection implements java.util.List {

    private java.util.List values;

    private java.util.Map identifiers; //element -> id

    public IdentifierBag(SessionImplementor session) {
        super(session);
    }

    public IdentifierBag() {
    } //needed for SOAP libraries, etc

    public IdentifierBag(SessionImplementor session, java.util.Collection coll) {
        super(session);
        if (coll instanceof java.util.List) {
            values = (java.util.List) coll;
        } else {
            values = new ArrayList();
            Iterator iter = coll.iterator();
            while (iter.hasNext()) {
                values.add(iter.next());
            }
        }
        setInitialized(true);
        setDirectlyAccessible(true);
        identifiers = new HashMap();
    }

    public IdentifierBag(SessionImplementor session,
            CollectionPersister persister, Serializable disassembled,
            Object owner) throws HibernateException {
        super(session);
        beforeInitialize(persister);
        Serializable[] array = (Serializable[]) disassembled;
        for (int i = 0; i < array.length; i += 2) {
            Object value = persister.getElementType().assemble(array[i + 1],
                    session, owner);
            identifiers.put(value, persister.getIdentifierType().assemble(
                    array[i], session, owner));
            values.add(value);
        }
        setInitialized(true);
    }

    public boolean isWrapper(Object collection) {
        return values == collection;
    }

    public boolean add(Object o) {
        write();
        values.add(o);
        return true;
    }

    public void clear() {
        write();
        values.clear();
        identifiers.clear();
    }

    public boolean contains(Object o) {
        read();
        return values.contains(o);
    }

    public boolean containsAll(Collection c) {
        read();
        return values.containsAll(c);
    }

    public boolean isEmpty() {
        read();
        return values.isEmpty();
    }

    public Iterator iterator() {
        read();
        return values.iterator();
    }

    public boolean remove(Object o) {
        write();
        return values.remove(o);
    }

    public boolean removeAll(Collection c) {
        if (c.size() > 0) {
            write();
            return values.removeAll(c);
        } else {
            return false;
        }
    }

    public boolean retainAll(Collection c) {
        write();
        return values.retainAll(c);
    }

    public int size() {
        read();
        return values.size();
    }

    public Object[] toArray() {
        read();
        return values.toArray();
    }

    public Object[] toArray(Object[] a) {
        read();
        return values.toArray();
    }

    public void beforeInitialize(CollectionPersister persister) {
        identifiers = new HashMap();
        values = new ArrayList();
    }

    public Serializable disassemble(CollectionPersister persister)
            throws HibernateException {

        Serializable[] result = new Serializable[values.size() * 2];
        Iterator iter = values.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Object value = iter.next();
            result[i++] = persister.getIdentifierType().disassemble(
                    identifiers.get(value), getSession());
            result[i++] = persister.getElementType().disassemble(value,
                    getSession());
        }
        return result;
    }

    public boolean empty() {
        return values.isEmpty();
    }

    public Iterator entries() {
        return values.iterator();
    }

    public boolean entryExists(Object entry, int i) {
        return entry != null;
    }

    public boolean equalsSnapshot(Type elementType) throws HibernateException {
        java.util.Map snap = (java.util.Map) getSnapshot();
        if (snap.size() != values.size())
            return false;
        Iterator iter = values.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Object value = iter.next();
            Object id = identifiers.get(new Integer(i++));
            if (id == null)
                return false;
            Object old = snap.get(id);
            if (elementType.isDirty(old, value, getSession()))
                return false;
        }
        return true;
    }

    public Iterator getDeletes(Type elemType) throws HibernateException {
        java.util.Map snap = (java.util.Map) getSnapshot();
        java.util.List deletes = new ArrayList(snap.keySet());
        Iterator iter = values.iterator();
        int i = 0;
        while (iter.hasNext()) {
            if (iter.next() != null)
                deletes.remove(identifiers.get(new Integer(i++)));
        }
        return deletes.iterator();
    }

    public Object getIndex(Object entry, int i) {
        throw new UnsupportedOperationException("Bags don't have indexes");
    }

    public boolean needsInserting(Object entry, int i, Type elemType)
            throws HibernateException {

        java.util.Map snap = (java.util.Map) getSnapshot();
        Object id = identifiers.get(new Integer(i));
        return entry != null && (id == null || snap.get(id) == null);
    }

    public boolean needsUpdating(Object entry, int i, Type elemType)
            throws HibernateException {

        if (entry == null)
            return false;
        java.util.Map snap = (java.util.Map) getSnapshot();
        Object id = identifiers.get(new Integer(i));
        if (id == null)
            return false;
        Object old = snap.get(id);
        return old != null && elemType.isDirty(old, entry, getSession());
    }

    public Object readFrom(ResultSet rs, CollectionPersister persister,
            Object owner) throws HibernateException, SQLException {

        Object element = persister.readElement(rs, owner, getSession());
        Object old = identifiers.put(new Integer(values.size()), persister
                .readIdentifier(rs, getSession()));
        if (old == null)
            values.add(element); //maintain correct duplication if loaded in a
        // cartesian product
        return element;
    }

    protected Serializable snapshot(CollectionPersister persister)
            throws HibernateException {

        HashMap map = new HashMap(values.size());
        Iterator iter = values.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Object value = iter.next();
            map.put(identifiers.get(new Integer(i++)), persister
                    .getElementType().deepCopy(value));
        }
        return map;
    }

    public Collection getOrphans(Serializable snapshot)
            throws HibernateException {
        java.util.Map sn = (java.util.Map) snapshot;
        ArrayList result = new ArrayList(sn.values());
        PersistentCollection.identityRemoveAll(result, values, getSession());
        return result;
    }

    public void preInsert(CollectionPersister persister)
            throws HibernateException {
        try {
            Iterator iter = entries();
            int i = 0;
            while (iter.hasNext()) {
                Object entry = iter.next();
                Integer loc = new Integer(i++);
                if (!identifiers.containsKey(loc)) { //TODO: native ids
                    Serializable id = persister.getIdentifierGenerator()
                            .generate(getSession(), entry);
                    identifiers.put(loc, id);
                }
            }
        } catch (SQLException sqle) {
            throw new JDBCException("could not generate idbag row id", sqle);
        }
    }

    public void writeTo(PreparedStatement st, CollectionPersister persister,
            Object entry, int i, boolean writeOrder) throws HibernateException,
            SQLException {

        persister.writeElement(st, entry, writeOrder, getSession());
        //TODO: if not using identity columns:
        persister.writeIdentifier(st, identifiers.get(new Integer(i)),
                writeOrder, getSession());

    }

    public void add(int index, Object element) {
        write();
        values.add(index, element);
    }

    public boolean addAll(int index, Collection c) {
        if (c.size() > 0) {
            write();
            return values.addAll(index, c);
        } else {
            return false;
        }
    }

    public Object get(int index) {
        read();
        return values.get(index);
    }

    public int indexOf(Object o) {
        read();
        return values.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        read();
        return values.lastIndexOf(o);
    }

    public ListIterator listIterator() {
        read();
        return values.listIterator();
    }

    public ListIterator listIterator(int index) {
        read();
        return values.listIterator(index);
    }

    public Object remove(int index) {
        write();
        return values.remove(index);
    }

    public Object set(int index, Object element) {
        write();
        return values.set(index, element);
    }

    public List subList(int fromIndex, int toIndex) {
        read();
        return values.subList(fromIndex, toIndex);
    }

    public boolean addAll(Collection c) {
        if (c.size() > 0) {
            write();
            return values.addAll(c);
        } else {
            return false;
        }
    }

    public void afterRowInsert(CollectionPersister persister, Object entry,
            int i) throws HibernateException {
        //TODO: if we are using identity columns, fetch the identifier
    }

}