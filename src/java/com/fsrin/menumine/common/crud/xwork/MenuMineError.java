/*
 * Created on Jul 14, 2005
 *
 * 
 */
package com.fsrin.menumine.common.crud.xwork;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineError {

    private final String message;

    public MenuMineError(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}