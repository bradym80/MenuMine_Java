/*
 * Created on Jul 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.xwork;

import com.fsrin.menumine.core.minefields.MineField;

/**
 * @author Nick
 * 
 *  
 */
public class GroupByFieldOptionMenuFieldImpl implements GroupByFieldOption {
    private MineField mineField;

    public GroupByFieldOptionMenuFieldImpl(MineField mineField) {
        super();
        this.mineField = mineField;
    }

    public String getKey() {

        return mineField.getOgnlName();
    }

    public String getValue() {

        return mineField.getFriendlyName();
    }

}