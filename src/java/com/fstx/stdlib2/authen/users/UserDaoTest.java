/*
 * Created on Mar 13, 2006 by Reid
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class UserDaoTest extends AbstractNonInitializingMenuMineTestCase {

    public void testBasicSelectUsersByGroupMembership() throws Exception {
        
        UserGroup g = UserGroupServiceDelegate.factory.build().find("FSRIN");
        
        Collection c = new UserDaoFactory().build().getUsersByGroup(g);
        
        assertNotNull(c);
        
        assertTrue(c.size() > 3);
        
    }
}
