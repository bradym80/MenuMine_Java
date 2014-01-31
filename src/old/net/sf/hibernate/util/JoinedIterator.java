// $Id: JoinedIterator.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.util;

import java.util.Iterator;

public class JoinedIterator implements Iterator {
    private Iterator[] iterators;

    private int current;

    public JoinedIterator(Iterator[] iterators) {
        this.iterators = iterators;
        this.current = 0;
    }

    public JoinedIterator(Iterator first, Iterator second) {
        this(new Iterator[] { first, second });
    }

    public boolean hasNext() {
        for (int i = current; i < iterators.length; i++) {
            if (iterators[i].hasNext())
                return true;
        }
        return false;
    }

    public Object next() {
        if (iterators[current].hasNext()) {
            return iterators[current].next();
        } else {
            current++;
            return next();
        }
    }

    public void remove() {
        iterators[current].remove();
    }

}

