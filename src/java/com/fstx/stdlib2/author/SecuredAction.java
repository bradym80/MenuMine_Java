/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

/**
 * <p>
 * The idea is to encapsulate the system rights into something more robust than
 * a String.
 * 
 * @version 2004-05-27
 * @author Reid
 *  
 */
public interface SecuredAction {

    public static final SecuredActionFactory factory = new SecuredActionFactory();

    /**
     * read only property
     * 
     * @author Reid
     *  
     */
    public String getActionName();

    public SecuredActionTypeEnum getTypeEnum();

}