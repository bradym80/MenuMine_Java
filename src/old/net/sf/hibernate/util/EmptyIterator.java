//$Id: EmptyIterator.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.util;

import java.util.Iterator;

/**
 * @author Gavin King
 */
public final class EmptyIterator implements Iterator {

    public static final Iterator INSTANCE = new EmptyIterator();

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        throw new UnsupportedOperationException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    private EmptyIterator() {
    }

}