package com.fsrin.menumine.core.menumine.express.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.dessertmine.xwork.MineChanger;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.minefields.MineFields;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

/**
 * 2006-08-08 For the new item spreadsheet brag.
 * 
 */

public class MenuMineNewItemsAction extends
        AbstractMenuMineSessionContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private Integer target;

    public String execute() throws Exception {

        if (this.getTarget() == null || this.getTarget().intValue() == 0) {
            target = 2007;
        } 

        /*
         * set the mine type. Needs to be first.
         */
        // new MineChanger().changeMine(this.getMenuMineSessionContextWrapper(),
        // MineFields.factory.getByKey(MineFieldsFactory.MINE_TYPE_MENU));
        new MineChanger().changeMine(this.getMenuMineSessionContextWrapper(),
                MineFields.factory.getByKey(MineFieldsFactory.MINE_TYPE_MENU));

        /*
         * 2006-08-08 RSC fields selected automatically.
         */
        MasterFoodFilterParameters p = getSelectedFields();

        /*
         * basic criteria
         */
        p.getMenuStatus().getAndValues().add("" + this.getTarget());
        p.getMenuStatus().getNotValues().add("deleted");
        p.getMenuStatus().getNotValues().add("operation");
        p.getMenuStatus().getNotValues().add("back");
        
        /*
         * 2006-01-31 RSC gets rid of the UK
         */
        p.getHqRegion().getNotValues().add("UK");



        /*
         * set the filter parameters
         */
        this.getMenuMineSessionContextWrapper().setLastFilterWrapper(
                new MasterFoodFilterParametersWrapperImpl(p));

        /*
         * set the display fields
         */
        this.getMenuMineSessionContextWrapper().setLastFieldsToDisplay(
                new FieldsToDisplayBeanBuilder().build(p));

        /*
         * 2006-03-02 RSC must have the first query sent set to true
         */
        this.getMenuMineSessionContextWrapper().setFirstQuerySent(true);

        /*
         * move on to menu mine action.
         */
        return SUCCESS;

    }

    private MasterFoodFilterParameters getSelectedFields() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        p.getOperationName().setSelect(Boolean.TRUE);
        p.getGenMenuPart().setSelect(Boolean.TRUE);
        p.getMenuItem().setSelect(Boolean.TRUE);
        p.getMenuItemType().setSelect(Boolean.TRUE);
        p.getCuisine().setSelect(Boolean.TRUE);
      //  p.getMenuStatus().setSelect(Boolean.TRUE);
        //JDL 10-7-07
        p.getPrice2007().setSelect(Boolean.TRUE);
        return p;

    }

    /**
     * @return Returns the target.
     */
    public Integer getTarget() {
        return target;
    }

    /**
     * @param target The target to set.
     */
    public void setTarget(Integer target) {
        this.target = target;
    }

 

}