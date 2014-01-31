package com.fsrin.menumine.core.menumine.express.xwork;

import com.fsrin.menumine.common.util.MenuMineUtil;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.dessertmine.xwork.MineChanger;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBeanBuilder;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.ParameterDecoratorFactory;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapperImpl;
import com.fsrin.menumine.core.minefields.MineFields;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

/**
 * 2006-01-24 Simplified express query action.
 * 
 * @author Reid
 */

public class MenuMineExpressActionV2 extends
        AbstractMenuMineSessionContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    public static final String SPRING_BEAN_NAME = "menuMineExpressActionV2";

    public static final String DISPLAY_TYPE_WHO = "who";

    public static final String DISPLAY_TYPE_OPPORTUNITIES = "opportunities";

    private String searchString;

    private String expressDisplayType;

    private String expressMine;

    private String submit;

    public String execute() throws Exception {

        /*
         * 2006-03-02 RSC Removed an "issubmit"
         */
        if (this.getSearchString() == null
                || this.getSearchString().trim().length() == 0)
            return INPUT;

        /*
         * set the mine type. Needs to be firMenuMineExpressAction*st.
         */
        // new MineChanger().changeMine(this.getMenuMineSessionContextWrapper(),
        // MineFields.factory.getByKey(MineFieldsFactory.MINE_TYPE_MENU));
        new MineChanger().changeMine(this.getMenuMineSessionContextWrapper(),
                MineFields.factory.getByKey(this.getExpressMine()));

        /*
         * 2006-01-23 RSC we're building this here for the query, etc. "Menu
         * Opportunities"
         */
        MasterFoodFilterParameters p = getSelectedFields();

        /*
         * 2006-01-31 RSC gets rid of the UK
         */
        p.getHqRegion().getNotValues().add("UK");

        /*
         * get the tokens and decorate the query
         */
        ParameterDecoratorFactory.factory.buildExpressItemDescription(p).decorate(
                this.getSearchString());

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

    private MasterFoodFilterParameters getSelectedFields() {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        if (this.getExpressDisplayType().equals(DISPLAY_TYPE_WHO)) {
            p.getOperationName().setSelect(true);
            p.getMenuItemType().setSelect(true);
            p.getMenuItem().setSelect(true);
            p.getGenMenuPart().setSelect(true);
            p.getSegment().setSelect(true);
            p.getPrice2005().setSelect(true);
            /*   p.getSegment().setSelect(true);
        	p.getCuisine().setSelect(true);
        	p.getMenuItemType().setSelect(true);
        	p.getMenuItemClass().setSelect(true);
            p.getGenMenuPart().setSelect(true);*/
        } else {
/*
            p.getGenMenuPart().setSelect(true);
            p.getMenuItemType().setSelect(true);
            p.getMenuItemClass().setSelect(true);
            p.getCuisine().setSelect(true);
            p.getSegment().setSelect(true);
            
            JDL 05-13-08 Changed returned fields*/
        	p.getSegment().setSelect(true);
        	p.getCuisine().setSelect(true);
        	p.getMenuItemType().setSelect(true);
        	p.getMenuItemClass().setSelect(true);
            p.getGenMenuPart().setSelect(true);
            
            
        }
        return p;

    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String expressSearchQuery) {
        this.searchString = expressSearchQuery;
    }

    private boolean isSubmit() {
        return !MenuMineUtil.isEmpty(this.getSubmit());
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getExpressMine() {
        if (expressMine == null)
            expressMine = MineFieldsFactory.MINE_TYPE_MENU;

        return expressMine;
    }

    public void setExpressMine(String expressMine) {
        this.expressMine = expressMine;
    }

    public String getExpressDisplayType() {
        if (expressDisplayType == null)
            expressDisplayType = DISPLAY_TYPE_OPPORTUNITIES;

        return expressDisplayType;
    }

    public void setExpressDisplayType(String expressDisplayType) {
        this.expressDisplayType = expressDisplayType;
    }

}