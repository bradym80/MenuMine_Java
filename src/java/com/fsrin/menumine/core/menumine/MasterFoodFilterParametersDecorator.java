/*
 * Created on Mar 17, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine;

import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.users.UserPreference;
import com.fsrin.menumine.users.UserPreferenceKeys;
import com.fsrin.menumine.users.UserPreferenceServiceDelegateFactory;

/**
 * 2006-03-17 RSC Happy St. Patrick's Day!
 * 
 * A quick utility to set the "select" bit on each filter parameters so they
 * match the fields to display bean.
 * 
 * @author Reid
 */
public class MasterFoodFilterParametersDecorator {

    private Log log = LogFactory
            .getLog(MasterFoodFilterParametersDecorator.class);

    public static final String DISPLAY_TYPE_CUSTOM = "custom";

    public static final String DISPLAY_TYPE_WHO = "who";

    public static final String DISPLAY_TYPE_PROTEIN = "protein";

    public static final String DISPLAY_TYPE_FLAVOR = "flavor";

    public static final String DISPLAY_TYPE_OPPORTUNITIES = "opportunities";

    public void decorateSelect(
            MasterFoodFilterParameters masterFoodFilterParameters,
            FieldsToDisplayBean fieldsToDisplayBean) throws Exception {

        Collection allFields = FieldEnum.getAll();

        for (Iterator iter = allFields.iterator(); iter.hasNext();) {

            FieldEnum element = (FieldEnum) iter.next();

            Boolean display = (Boolean) Ognl.getValue(element.getOgnlName(),
                    fieldsToDisplayBean);

            FilterParameter clonesParameter = (FilterParameter) Ognl.getValue(
                    element.getOgnlName(), masterFoodFilterParameters);

            clonesParameter.setSelect(display);
        }

    }

    public void decorateWithFieldSet(MasterFoodFilterParameters p,
            String username, String minetype) throws Exception {

        this.handleDecoration(p, DISPLAY_TYPE_CUSTOM, username, minetype);

    }

    public void decorateWithFieldSet(MasterFoodFilterParameters p, String set,
            String username, String minetype) throws Exception {

        this.handleDecoration(p, set, username, minetype);

    }

    public void handleDecoration(MasterFoodFilterParameters p, String set,
            String username, String minetype) throws Exception {
        if (set.equals(MasterFoodFilterParametersDecorator.DISPLAY_TYPE_CUSTOM)) {
            UserPreference pref = UserPreferenceServiceDelegateFactory.build()
                    .getUserPreference(
                            username,
                            UserPreferenceKeys.FAVORITE_FIELDS_PREFIX
                                    + minetype);

            if (pref != null) {

                String[] fields = pref.getValue().split(",");

                for (int i = 0; i < fields.length; i++) {
                    try {
                        Ognl.setValue(fields[i] + ".select", p, Boolean.TRUE);
                    } catch (Exception e) {
                        log
                                .debug("Caught an OGNL exception in handleDecorations "
                                        + fields[i]);
                    }
                }

                return;
            }

        }

        if (set.equals(MasterFoodFilterParametersDecorator.DISPLAY_TYPE_FLAVOR)) {
            p.getBasicProtein().setSelect(true);
            p.getSauceCondDressMarMM().setSelect(true);
            p.getFlavApplication().setSelect(true);
            p.getCheeseMM().setSelect(true);
            p.getFlavEnhancSeasBrdgDesIngredMM().setSelect(true);
            
        } else if (set
                .equals(MasterFoodFilterParametersDecorator.DISPLAY_TYPE_PROTEIN)) {
            p.getGenMenuPart().setSelect(true);
            p.getMenuItemType().setSelect(true);
            p.getBasicProtein().setSelect(true);
            p.getSegment().setSelect(true);
            p.getPrice2005().setSelect(false);
            p.getPrice2005().setEmpty(Boolean.FALSE);
            p.getProteinTypeCut().setSelect(true);
            p.getProteinFishShrimpSeafood().setSelect(true);

        } else if (set
                .equals(MasterFoodFilterParametersDecorator.DISPLAY_TYPE_WHO)) {
            p.getOperationName().setSelect(true);
            p.getMenuItemType().setSelect(true);
            p.getMenuItem().setSelect(true);
            p.getGenMenuPart().setSelect(true);
            p.getSegment().setSelect(true);
            p.getPrice2005().setSelect(true);
        } else {

            p.getGenMenuPart().setSelect(true);
            p.getMenuItemType().setSelect(true);
            p.getMenuItemClass().setSelect(true);
            p.getCuisine().setSelect(true);
            p.getSegment().setSelect(true);
            
            // DBB Add Operation Name, Menu Item Name
            p.getOperationName().setSelect(true);
            p.getMenuItem().setSelect(true);
        }
    }
    
    
}
