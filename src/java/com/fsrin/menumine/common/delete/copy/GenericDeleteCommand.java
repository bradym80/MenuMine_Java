/*
 * Created on 2005-1-14
 *
 * 
 */
package com.fsrin.menumine.common.delete.copy;

import com.fsrin.menumine.common.ServiceDelegate;
import com.fsrin.menumine.context.MenuMineSessionContext;

/**
 * @author Nick
 * 
 *  
 */
public class GenericDeleteCommand extends DeleteCommand {

    private ServiceDelegate serviceDelegate;

    protected void handleDelete(MenuMineSessionContext cmmsSessionessionContext)
            throws DeleteCommandFailedException {

        serviceDelegate.setMenuMineSessionContext(cmmsSessionessionContext);
        //  try {
        serviceDelegate.delete(this.getTarget());
        //        } catch (ServiceDelegateException e) {
        //            throw new DeleteCommandFailedException(e);
        //        }

    }

    public String getTargetDescription() throws DeleteCommandFailedException {

        return this.getTarget().toString();
    }

    public String getEffectDescription() throws DeleteCommandFailedException {

        return "This will permanently remove this  entry.";
    }

    public String getXWorkSuccess() throws DeleteCommandFailedException {

        return "success";
    }

    public ServiceDelegate getServiceDelegate() {
        return serviceDelegate;
    }

    public void setServiceDelegate(ServiceDelegate serviceDelegate) {
        this.serviceDelegate = serviceDelegate;
    }
}