/*
 * Created on May 26, 2004
 *
 */
package com.fstx.stdlib2.authen.users;

/**
 * @author Reid
 *  
 */
public class DaoException extends Exception {

    /**
     *  
     */
    public DaoException() {
        super();
    }

    /**
     * @param arg0
     */
    public DaoException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public DaoException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}