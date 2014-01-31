/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

/**
 * @author Reid
 *  
 */
public class AuthorizerFailedException extends Exception {

    /**
     *  
     */
    public AuthorizerFailedException() {
        super();
    }

    /**
     * @param arg0
     */
    public AuthorizerFailedException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public AuthorizerFailedException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public AuthorizerFailedException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}