/*
 * Created on May 31, 2005
 *
 * 
 */
package com.fsrin.menumine.core.minefields;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.collection.UnmodifiableCollection;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.DistinctQueryBuilder;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper;

/**
 * This will be what controls the *Mine we are working with. We could be working
 * on the MenuMine , DessertMine, CustomeMine.
 * 
 * We will collect the fields that are required for the *Mine. The fields will
 * provide any information the we need to build querys and analyse the results.
 * 
 * We will also have to provide some display specific data.
 * 
 * @author Nick 2005-5-31
 * 
 * 
 */
public abstract class MineFields {
    // private MineType mineType = MineType.MENUMINE;;

    public static final MineFieldsFactory factory = new MineFieldsFactory();

    private List mineGroups = new ArrayList();

    /*
     * These are helpers for building the form. We need to be able to find the
     * selected values.
     */
    private FieldsToDisplayBean fieldsToDisplayBean;

    private MasterFoodFilterParametersWrapper masterFoodFilterParameters;

    private DistinctQueryBuilder distinctQueryBuilder;

    public MineFields() {
        super();

    }

    public Collection getAllFields() {
        Collection collection = new ArrayList();
        for (Iterator iter = this.getMineGroups().iterator(); iter.hasNext();) {
            MineGroup element = (MineGroup) iter.next();
            collection.addAll(element.getMineFields());
        }
        return UnmodifiableCollection.decorate(collection);

    }

    public List getMineGroups() {
        return mineGroups;
    }

    public void setMineGroups(List mineGroups) {
        this.mineGroups = mineGroups;
    }

    public FieldsToDisplayBean getFieldsToDisplayBean() {
        return fieldsToDisplayBean;
    }

    public void setFieldsToDisplayBean(FieldsToDisplayBean fieldsToDisplayBean) {
        this.fieldsToDisplayBean = fieldsToDisplayBean;
    }

    public MasterFoodFilterParametersWrapper getMasterFoodFilterParameters() {
        return masterFoodFilterParameters;
    }

    public void setMasterFoodFilterParameters(
            MasterFoodFilterParametersWrapper masterFoodFilterParameters) {
        this.masterFoodFilterParameters = masterFoodFilterParameters;
    }

    public DistinctQueryBuilder getDistinctQueryBuilder() {
        return distinctQueryBuilder;
    }

    public void setDistinctQueryBuilder(
            DistinctQueryBuilder distinctQueryBuilder) {
        this.distinctQueryBuilder = distinctQueryBuilder;
    }

    /*
     * If we need to apply specific filters for the *Mine we do it here.
     */
    public final void applyHiddenParams(
            MasterFoodFilterParametersWrapper masterFoodFilterParametersWrapper) {
        this.applyHiddenParams(masterFoodFilterParametersWrapper
                .getMasterFoodFilterParameters());
    }

    /*
     * 2006-01-24 RSC Subclasses override this with additional hidden criteria.
     */
    public void applyHiddenParams(MasterFoodFilterParameters filterParams) {
        // if (!filterParams.getChain().getCountryLoc().getAndValues().contains(
        // "USA")) {
        //
        // filterParams.getChain().getCountryLoc().getAndValues().add("USA");
        // }

        /*
         * 2006-02-06 RSC Refactored Chain out of existance.
         */
        if (!filterParams.getHqRegion().getNotValues().contains("UK")) {
            filterParams.getHqRegion().getNotValues().add("UK");
        }

    }

    public abstract Collection getPrimaryFields();

    public MineField findByOgnlName(String ognlName) {
        for (Iterator iter = this.getAllFields().iterator(); iter.hasNext();) {
            MineField element = (MineField) iter.next();
            if (element.getOgnlName().equals(ognlName)) {
                return element;
            }

        }
        return null;
    }

    public String getName() {
        String type = this.getMineType().toLowerCase();
        String toks[] = type.split("\\W");

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < toks.length; i++) {
            String string = toks[i];
            if (string.length() > 0) {
                char char1 = string.charAt(0);
                buffer.append(string.replaceFirst(char1 + "",
                        ((char) (char1 - 32)) + ""));
                // buffer.append(" ");
            }
        }

        return buffer.toString();

    }

    public boolean contains(FieldEnum e) {
        boolean ret = false;

        for (Iterator iter = this.getAllFields().iterator(); iter.hasNext();) {
            MineField element = (MineField) iter.next();
            if (element.getFieldEnum() == e) {
                return true;
            }
        }

        return ret;
    }

    public abstract String getMineType();

    public abstract boolean isMemberOfMine(MasterFood masterFood);

    public MineGroup getPlacesGroup() {
        MineGroup places = new MineGroup("Places");
        places.setImage("img/menumine-business.gif");
        places.setBgcolor("#99CCFF");
        places.setCssClass("headerBGProductBiz");
        places.getMineFields().add(
                new MineField(FieldEnum.OPERATION_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        places.getMineFields().add(
                new MineField(FieldEnum.MARKET_SECTOR, this,
                        MineField.FIELD_PRIORITY_LOW));
        places.getMineFields().add(
                new MineField(FieldEnum.MARKET_SEGMENT, this,
                        MineField.FIELD_PRIORITY_LOW));
        places.getMineFields().add(
                new MineField(FieldEnum.HEADQUARTERS_STATE, this,
                        MineField.FIELD_PRIORITY_LOW));
        places.getMineFields().add(
                new MineField(FieldEnum.HEADQUARTERS_REGION, this,
                        MineField.FIELD_PRIORITY_LOW));

        places.getMineFields().add(
                new MineField(FieldEnum.OPERATOR_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));

        return places;
    }

    public MineGroup getPricesGroup() {
        MineGroup prices = new MineGroup("Prices");
        prices.setImage("");
        prices.setBgcolor("");
        prices.setCssClass("");
        /*
         * We don't want these included in the menu in the standard fashion. We
         * currently will force them to be at the bottom of any menu.
         * 
         * 2006-03-29 RSC They're all displaying this way, so I've added this to
         * the parent class.
         */
        prices.setIncludeInMenu(true);
        
        // MJB 11-12-2009
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2011, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2010, this,
                        MineField.FIELD_PRIORITY_LOW));
        // DBB 1-20-2009 Add 2008, 2009
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2009, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2008, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2007, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2006, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2005, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2004, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2003, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2002, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2001, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_2000, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_1999, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_1998, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_1997, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.PRICE_1996, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.YEAR_PUT_IN_DATABASE, this,
                        MineField.FIELD_PRIORITY_LOW));
        prices.getMineFields().add(
                new MineField(FieldEnum.YEAR_PUT_IN_DATABASE_SAME_STORE, this,
                        MineField.FIELD_PRIORITY_LOW));

        return prices;
    }

    public MineGroup getPositionGroup(FieldEnum menuPart) {
        return this.getPositionGroup(menuPart, true);
    }

    public MineGroup getPositionGroup(FieldEnum menuPart,
            boolean includeKeywords) {
        /*
         * 2006-11-07 rsc ingredient doesn't use this.
         */
        MineGroup position = new MineGroup("Position");
        position.setImage("img/menumine-position.gif");
        position.setBgcolor("#3399FF");
        position.setCssClass("headerBGProduct");
        position.getMineFields().add(
                new MineField(menuPart, this, MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MENU_ITEM_CLASS, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.ITEM_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MENU_ITEM_NAME, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.DESCRIPTION, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MENU_STATUS, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.CUISINE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.CUISINE_FAMILY, this,
                        MineField.FIELD_PRIORITY_LOW));
        /*
         * 2006-08-08 reid little bit of a hack... on breakfast, they want this
         * ordered after breakfast to go.
         */
        if (includeKeywords) {
            position.getMineFields().add(
                    new MineField(FieldEnum.KEYWORDS, this,
                            MineField.FIELD_PRIORITY_LOW));
        }
        return position;

    }

    public MineGroup getTypesAndUsesGroup() {
        MineGroup position = new MineGroup("Types & Uses");
        position.setImage("img/menumine-position.gif");
        position.setBgcolor("#3399FF");
        position.setCssClass("headerBGProduct");

        position.getMineFields().add(
                new MineField(FieldEnum.CUISINE_VERY_SPECIFIC, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.GRILL_ROAST_SMOKE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.VEG_COOK_METHOD, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.COOK_SAUCE_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.DRESSING_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MEX_BREAD_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.ROAST_VEG_ITEM_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.APPET_CLASS_TYP, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.PREP_ENTREE_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));

        position.getMineFields().add(
                new MineField(FieldEnum.BREADED_FRIED_APPET_SIDE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.POTATO_TYPE_USE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.SALSA_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.COOKIE_LOOK_ALIKE_DESSERT, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.BREAKFAST_TO_GO, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.PIZZA_STYLE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.BBQ_COOK, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.ETHNIC_BREAD_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));

        position.getMineFields().add(
                new MineField(FieldEnum.PEPPER_TYPE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.RICE_TYPE_USE, this,
                        MineField.FIELD_PRIORITY_LOW));
        position.getMineFields().add(
                new MineField(FieldEnum.MEX_INGRED_USE, this,
                        MineField.FIELD_PRIORITY_LOW));

        return position;

    }
}