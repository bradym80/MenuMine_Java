/*
 * Created on 2005-1-14
 */
package com.fsrin.menumine.common.delete.copy;

import java.io.Serializable;

/**
 * @author Nick
 */
public interface DeleteContext extends Serializable {

    public static DeleteContextFactory factory = new DeleteContextFactory();

    public DeleteCommand getCommand();

    public String getDescription();

    public String getEffect();

    public String getSuccess();

    public void setSuccessOverride(String successOverride);

    public boolean isValid();

}