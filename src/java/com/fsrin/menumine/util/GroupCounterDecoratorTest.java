/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.util;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

public class GroupCounterDecoratorTest extends TestCase {

    public void testBasic() throws Exception {

        GroupCounterVO one = new GroupCounterVO(new Integer(5), "one");
        GroupCounterVO two = new GroupCounterVO(new Integer(5), "two");
        Collection c = new ArrayList();
        c.add(one);
        c.add(two);

        new GroupCounterDecorator().decorateWithShare(c);

        assertEquals(0.5, one.getShare().doubleValue(), .01);
        assertEquals(0.5, two.getShare().doubleValue(), .01);

    }

    public void testBasicTwo() throws Exception {

        GroupCounterVO one = new GroupCounterVO(new Integer(5), "one");
        GroupCounterVO two = new GroupCounterVO(new Integer(15), "two");
        Collection c = new ArrayList();
        c.add(one);
        c.add(two);

        new GroupCounterDecorator().decorateWithShare(c);

        assertEquals(0.25, one.getShare().doubleValue(), .01);
        assertEquals(0.75, two.getShare().doubleValue(), .01);

    }
}
