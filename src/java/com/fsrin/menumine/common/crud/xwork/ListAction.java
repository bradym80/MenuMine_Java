/*
 * Created on July 12, 2005
 *
 * 
 */
package com.fsrin.menumine.common.crud.xwork;

import java.util.Collection;

import com.fsrin.menumine.common.ServiceDelegate;
import com.fsrin.menumine.common.dao.CriteriaParameters;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapper;
import com.fsrin.menumine.context.webwork.MenuMineSessionContextWrapperAware;
import com.opensymphony.xwork.ActionSupport;

/**
 * @author Nick
 * 
 *  
 */
public abstract class ListAction extends ActionSupport implements
        MenuMineSessionContextWrapperAware {

    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private Collection list;

    private CriteriaParameters criteriaParameters;

    private ServiceDelegate serviceDelegate;

    public ServiceDelegate getServiceDelegate() {
        return serviceDelegate;
    }

    public void setServiceDelegate(ServiceDelegate serviceDelegate) {
        this.serviceDelegate = serviceDelegate;
    }

    public Collection getList() {
        return list;
    }

    public void setList(Collection list) {
        this.list = list;
    }

    public CriteriaParameters getCriteriaParameters() {
        return criteriaParameters;
    }

    public void setCriteriaParameters(CriteriaParameters criteriaParameters) {
        this.criteriaParameters = criteriaParameters;
    }

    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
        return menuMineSessionContextWrapper;
    }

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    }
}