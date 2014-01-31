/*
 * Created on May 28, 2004
 *
 */
package com.fstx.stdlib2.author;

import org.apache.commons.lang.enums.Enum;

/**
 * @author Reid
 *  
 */
public class SecuredActionTypeEnum extends Enum {

    public static final SecuredActionTypeEnum GENERIC = new SecuredActionTypeEnum(
            "GENERIC");

    public static final SecuredActionTypeEnum ACTION_SAVE = new SecuredActionTypeEnum(
            "ACTION_SAVE");

    /**
     * @param arg0
     */
    public SecuredActionTypeEnum(String arg0) {
        super(arg0);
    }

}