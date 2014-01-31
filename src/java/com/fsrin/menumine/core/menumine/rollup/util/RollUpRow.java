/*
 * Created on May 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.util;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpRow {
    private String roll = "";

    public RollUpRow() {
        super();

    }

    public boolean isRollSet() {
        return roll != null && roll.length() > 0;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getRoll() {
        return this.roll;
    }
}