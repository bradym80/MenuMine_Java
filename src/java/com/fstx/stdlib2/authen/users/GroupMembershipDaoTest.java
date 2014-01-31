/*
 * Created on Mar 13, 2006 by Reid
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;

import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class GroupMembershipDaoTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testMembershipQuery() throws Exception {
        
        User user = UserServiceDelegate.factory.build().getByUsername("mbrady");
        
        assertNotNull(user);
        
        Collection groups = UserGroupServiceDelegate.factory.build().getGroupsByUser(user);
        
        assertNotNull(groups);
        
        assertTrue(groups.size() > 0);
        
        UserGroup group = (UserGroup) groups.toArray()[0];
        
        GroupMembershipDao dao = new GroupMembershipDao();
        
        GroupMembership m = new GroupMembership();
        m.setGroupId(group.getId());
        m.setUserId(user.getId());
        
        Collection test = GenericDAOFactory.factory.buildAdmin().find(GroupMembershipDao.SELECT_BY_GROUP_AND_USER, m);
        
        assertNotNull(test);
        
        assertTrue(test.size() > 0);

        
    }
}
