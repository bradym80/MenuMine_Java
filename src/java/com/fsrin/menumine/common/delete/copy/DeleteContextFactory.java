/*
 * Created on 2005-1-14
 *
 * 
 */
package com.fsrin.menumine.common.delete.copy;

/**
 * @author Nick
 */
public class DeleteContextFactory {

    public DeleteContext build(DeleteCommand deleteCommand) {
        DeleteContextImpl ret = new DeleteContextImpl(deleteCommand);

        return ret;
    }

    public DeleteContext build(DeleteCommand deleteCommand,
            String successOverride) {
        DeleteContextImpl ret = new DeleteContextImpl(deleteCommand);
        ret.setSuccessOverride(successOverride);
        return ret;
    }
}