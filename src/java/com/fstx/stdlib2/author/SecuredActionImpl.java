/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

/**
 * @author Reid
 *  
 */

/*
 * 
 * Be sure to add new SecuredActions to the SecuredActionFinder @author Nick
 * 
 *  
 */
class SecuredActionImpl implements SecuredAction {

    private String actionName;

    private SecuredActionTypeEnum typeEnum;

    /**
     * @return
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * @param string
     */
    public void setActionName(String string) {
        actionName = string;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.author.SecuredAction#getTypeEnum()
     */
    public SecuredActionTypeEnum getTypeEnum() {
        return this.typeEnum;
    }

    /**
     * @param enum
     */
    public void setTypeEnum(SecuredActionTypeEnum enums) {
        typeEnum = enums;
    }

}