/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * @author Nick
 *  
 */
public class MenuMineSessionContextFactory {

    public MenuMineSessionContext build(AuthenticatedUser authenticatedUser) {
        MenuMineSessionContextImpl ret = (MenuMineSessionContextImpl) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineSessionContext.SPRING_BEAN_NAME);

        //SPRING will take care of setting the rest of this.

        ret.setAuthenticatedUser(authenticatedUser);

        return ret;
    }

    public MenuMineSessionContext buildMock() {
        AuthenticatedUser authenticatedUser = AuthenticatedUser.factory
                .buildMock();
        return buildMockWithUser(authenticatedUser);
    }
    
    public MenuMineSessionContext buildMock(String username) {
        AuthenticatedUser authenticatedUser = AuthenticatedUser.factory
                .buildMock(username);
        return buildMockWithUser(authenticatedUser);
    }
    
    public static MenuMineSessionContext getMock() {
        return new MenuMineSessionContextFactory().buildMock();
    }
    
    public static MenuMineSessionContext getMock(String username) {
        return new MenuMineSessionContextFactory().buildMock(username);
    }
    
    public static MenuMineSessionContextWrapper getMockWrapper() {
        return new MenuMineSessionContextWrapper(MenuMineSessionContextFactory.getMock());
    }
    
    public static MenuMineSessionContextWrapper getMockWrapper(String username) {
        
        MenuMineSessionContext context = MenuMineSessionContextFactory.getMock(username);
        
        
        return new MenuMineSessionContextWrapper(context);
    }

    public static MenuMineSessionContextWrapper getMockWrapperWithBacon(String username) {
        
        MenuMineSessionContext context = MenuMineSessionContextFactory.getMock(username);
        
        MenuMineSessionContextWrapper ret = new MenuMineSessionContextWrapper(context);
        
        ret.setLastFilterWrapper(MasterFoodFilterParametersTestFactory.getItemDescriptionWithBaconInWrapper());
        
        return ret;
    }
    
    public static MenuMineSessionContextWrapper getMockWrapperWithChicken(String username) {
        
        MenuMineSessionContext context = MenuMineSessionContextFactory.getMock(username);
        
        MenuMineSessionContextWrapper ret = new MenuMineSessionContextWrapper(context);
        
        ret.setLastFilterWrapper(MasterFoodFilterParametersTestFactory.getItemDescriptionWithChickenInWrapper());
        
        return ret;
    }    

    
    public MenuMineSessionContext buildMockWithUser(AuthenticatedUser authenticatedUser) {

        MenuMineSessionContextImpl ret = (MenuMineSessionContextImpl) SpringBeanBroker
                .getBeanFactory().getBean(
                        MenuMineSessionContext.SPRING_BEAN_NAME);

        ret.setAuthenticatedUser(authenticatedUser);

        return ret;
    }

    public MenuMineSessionContext buildMockInvalid() {
        return buildMockWithUser(null);
    }
}