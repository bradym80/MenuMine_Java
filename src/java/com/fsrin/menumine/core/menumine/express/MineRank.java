/*
 * Created on Aug 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

/**
 * @author Nick
 * 
 * This is a basic VO to hold MineFields and a determined rank.(Rank is some
 * value associated with the minefield, such as the sum of the field counts.)
 *  
 */
public class MineRank {

    private MineFieldsExpressQueryCounter mineFieldsExpressQueryCounter;

    private Integer mineCount;

    public MineRank(
            MineFieldsExpressQueryCounter mineFieldsExpressQueryCounter,
            int mineCount) {
        super();

        this.mineFieldsExpressQueryCounter = mineFieldsExpressQueryCounter;
        this.mineCount = new Integer(mineCount);
    }

    public MineRank(
            MineFieldsExpressQueryCounter mineFieldsExpressQueryCounter,
            Integer mineCount) {
        super();

        this.mineFieldsExpressQueryCounter = mineFieldsExpressQueryCounter;
        this.mineCount = mineCount;
    }

    public Integer getMineCount() {
        return mineCount;
    }

    public MineFieldsExpressQueryCounter getMineFieldsExpressQueryCounter() {
        return this.mineFieldsExpressQueryCounter;
    }
}