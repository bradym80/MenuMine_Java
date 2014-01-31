/*
 * Created on July 12, 2005
 *
 * 
 */
package com.fsrin.menumine.common.crud.xwork;

import com.fsrin.menumine.common.ServiceDelegate;

/**
 * @author Nick
 * 
 * This is expected to take the parameters from the UI and apply them to domain
 * object. Persistance will be handled by the PersistanceInterceptor before the
 * execute is called.
 * 
 * We need to add a Validator, and the ability apply stages parameters to the
 * domain object.
 */
public abstract class EditAction extends ViewAction {

    private ServiceDelegate serviceDelegate;

    public ServiceDelegate getServiceDelegate() {
        return serviceDelegate;
    }

    public void setServiceDelegate(ServiceDelegate serviceDelegate) {
        this.serviceDelegate = serviceDelegate;
    }

    /*
     * This should add action errors if there zre problems. (non-Javadoc)
     * 
     * @see com.opensymphony.xwork.Validateable#validate()
     */
    abstract public void validate();

    abstract public WebParameters getWebParameters();

    abstract public void applyWebParameters();
}