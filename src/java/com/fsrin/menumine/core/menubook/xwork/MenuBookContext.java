/*
 * Created on May 9, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menubook.xwork;

import java.io.Serializable;

/**
 * @author Nick
 * 
 *  
 */
public class MenuBookContext implements Serializable {
    private String target;

    public MenuBookContext() {
        super();

    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}