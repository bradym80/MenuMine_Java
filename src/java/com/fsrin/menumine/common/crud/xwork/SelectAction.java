/*
 * Created on July 12, 2005
 *
 * 
 */
package com.fsrin.menumine.common.crud.xwork;

import com.fsrin.menumine.common.ServiceDelegate;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;

/**
 * @author Nick
 * 
 *  
 */
public abstract class SelectAction extends AbstractMenuMineSessionContextAwareAction{

    private Long target;

    private Object targetInstance;

    private ServiceDelegate serviceDelegate;

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public Object getTargetInstance() {
        return targetInstance;
    }

    public void setTargetInstance(Object targetInstance) {
        this.targetInstance = targetInstance;
    }

    public ServiceDelegate getServiceDelegate() {
        return serviceDelegate;
    }

    public void setServiceDelegate(ServiceDelegate serviceDelegate) {
        this.serviceDelegate = serviceDelegate;
    }

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;
//
//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

}