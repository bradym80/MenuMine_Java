/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

/**
 * @author Reid
 *  
 */
public class SecuredActionFactory {

    public SecuredAction build(String string) {
        SecuredActionImpl ret = new SecuredActionImpl();

        ret.setActionName(string);
        ret.setTypeEnum(SecuredActionTypeEnum.GENERIC);
        return ret;
    }

}