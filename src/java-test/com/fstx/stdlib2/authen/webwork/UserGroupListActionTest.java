/*
 * Created on Jun 21, 2005
 *
 * 
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.fstx.stdlib2.authen.users.UserGroup;

/**
 * @author Nick
 * 
 *  
 */
public class UserGroupListActionTest extends TestCase {

    /*
     * We want to action to return a sorted list.
     */
    public void testGetGroupsSorted() {
        UserGroupListAction action = new UserGroupListAction();
        action
                .setUserGroupServiceDelegate(new UserGroupServiceDelegateMockImpl());

        Collection sorted = action.getGroups();

        assertNotNull(sorted);
        assertEquals(5, sorted.size());

        UserGroup previousElement = null;

        for (Iterator iter = sorted.iterator(); iter.hasNext();) {
            UserGroup element = (UserGroup) iter.next();
            if (previousElement != null) {
                assertTrue(previousElement.getName().compareTo(
                        element.getName()) < 0);
            }

            previousElement = element;

        }

    }

}