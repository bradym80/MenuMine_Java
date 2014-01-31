/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak.xwork;

import com.fsrin.menumine.core.dessertmine.xwork.MineChanger;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.ParameterDecoratorFactory;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.minefields.MineFields;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

public class FlavorTrakToSpreadsheetAction extends
        AbstractFlavorTrakContextAwareAction {

    public String execute() throws Exception {
        
        new MineChanger().changeMine(this.getMenuMineSessionContextWrapper(),
                MineFields.factory.getByKey(MineFieldsFactory.MINE_TYPE_MENU));

        /*
         * 2006-08-08 RSC fields selected automatically.
         */
        MasterFoodFilterParameters p = getSelectedFields();

        /*
         * basic criteria
         */
        //p.getKeywords().getAndValues().add(this.getFlavorTrakContext().getQuery());
        
        if (this.getFlavorTrakContext().getQuery() != null) {
            ParameterDecoratorFactory.factory.buildExpressKeywords(p).decorate(
                    this.getFlavorTrakContext().getQuery());
        }
        
        if (this.getFlavorTrakContext().getCuisineFamily() != null) {
            p.getCuisineFamily().getAndValues().add(this.getFlavorTrakContext().getCuisineFamily());
        }
        
        if (this.getFlavorTrakContext().getGenCookingMethod() != null) {
            p.getGenCookMeth().getAndValues().add(this.getFlavorTrakContext().getGenCookingMethod());
        }
        
        if (this.getFlavorTrakContext().getGenMenuPart() != null) {
            p.getGenMenuPart().getAndValues().add(this.getFlavorTrakContext().getGenMenuPart());
        }
        
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

        
        return SUCCESS;
    }
    
    private MasterFoodFilterParameters getSelectedFields() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        p.getMenuItem().setSelect(Boolean.TRUE);
        p.getMenuItemType().setSelect(Boolean.TRUE);
        p.getGenMenuPart().setSelect(Boolean.TRUE);
        p.getCuisine().setSelect(Boolean.TRUE);
        p.getItemDescription().setSelect(Boolean.TRUE);

        return p;

    }
    
}
