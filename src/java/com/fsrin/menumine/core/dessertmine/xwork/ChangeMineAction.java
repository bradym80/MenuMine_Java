/*
 * Created on 2005-1-18
 *
 */

package com.fsrin.menumine.core.dessertmine.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * 2006-01-13 Changes superclass.
 * 2006-04-05 RSC Added default field selection.
 * 
 * @author Reid
 * @author Nick
 * @version 1
 */

public class ChangeMineAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private String key;

    public String execute() throws Exception {

        MineChanger mineChanger = new MineChanger();
        MineFields fields = MineFields.factory.getByKey(this.getKey());

        mineChanger.changeMine(this.getMenuMineSessionContextWrapper(), fields);

        
        return SUCCESS;

    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}