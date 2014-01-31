/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization.test;

import junit.framework.TestCase;

import com.fsrin.menumine.authorization.AuthorizationBean;
import com.fsrin.menumine.authorization.AuthorizationManagerImpl;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.author.SecuredAction;
import com.fstx.stdlib2.author.SecuredActionEnum;

/**
 * @author Nick
 * 
 *  
 */
public class AuthorizationManagerTest extends TestCase {

    private UserGroup userGroup;

    AuthorizationManagerImpl manager;

    private GroupRightServiceDelegateMockImpl groupRightServiceDelegate;

    public AuthorizationManagerTest() {
        super();
        this.userGroup = new UserGroup();
        this.userGroup.setName("Group");
        this.userGroup.setId(new Long(1));
        this.groupRightServiceDelegate = new GroupRightServiceDelegateMockImpl();

        this.manager = new AuthorizationManagerImpl();

        this.manager.setGroupRightServiceDelegate(groupRightServiceDelegate);
    }

    /*
     * Test granting a group an authorization.
     */
    public void testAuthorizeGroup() throws Exception {

        SecuredAction authorizationToken = SecuredActionEnum
                .getByName(SecuredActionEnum.DESSERT_MENU_MINE.getActionName());

        assertFalse(manager.isAuthorized(userGroup, authorizationToken));

        manager.authorize(userGroup, authorizationToken);

        assertTrue(manager.isAuthorized(userGroup, authorizationToken));

    }

    /*
     * Test taking away authorization from a group.
     */
    public void testDeauthorizeGroup() throws Exception {

        SecuredAction authorizationToken = SecuredActionEnum
                .getByName(SecuredActionEnum.DESSERT_MENU_MINE.getActionName());

        manager.authorize(userGroup, authorizationToken);

        assertTrue(manager.isAuthorized(userGroup, authorizationToken));

        manager.deauthorize(userGroup, authorizationToken);

        assertFalse(manager.isAuthorized(userGroup, authorizationToken));
    }

    /*
     * Is this user authorized?
     */
    public void testAuthorizationCheck() throws Exception {

        SecuredAction authorizationToken = SecuredActionEnum
                .getByName(SecuredActionEnum.DESSERT_MENU_MINE.getActionName());

        manager.authorize(userGroup, authorizationToken);

        assertTrue(manager.isAuthorized(userGroup, authorizationToken));

    }

    /*
     * Prepares a bean with a groups authorizations.
     */
    public void testPrepareAuthorizationBean() throws Exception {

        SecuredAction authorizationToken = SecuredActionEnum
                .getByName(SecuredActionEnum.DESSERT_MENU_MINE.getActionName());

        manager.authorize(userGroup, authorizationToken);

        AuthorizationBean bean = manager.prepareAuthorizationBean(userGroup);
        assertTrue(bean.isDessertMine());
        assertFalse(bean.isMenumine());
    }
}