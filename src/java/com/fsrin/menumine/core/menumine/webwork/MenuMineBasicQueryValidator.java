/*
 * Created on Jan 24, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineBasicQueryValidator implements QueryValidator {

    public MenuMineBasicQueryValidator() {
        super();

    }

    /*
     * 
     * Rules: User must 2-4 fields, the 5th will always be menu Item One must be
     * from Menu Part, Market Sector, Market Segment, Basic Protein, Cuisine of
     * Item or Cooking Method Must select at least one filter option.
     * 
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.menumine.webwork.QueryValidator#validate(com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper)
     */

    public boolean validate(
            MasterFoodFilterParameters masterFoodFilterParameters,
            FieldsToDisplayBean fieldsToDisplayBean) {

        boolean selectedFieldCount = this
                .validateSelectedFieldCount(fieldsToDisplayBean);

        /*
         * nick 2005-2-18 remove as a result of reorg of fields
         */
        boolean primaryFieldIsSelected = true;
        //        boolean primaryFieldIsSelected = this
        //                .validatePrimaryFieldIsSelected(fieldsToDisplayBean);
        //        boolean filterIsSelected = this
        //                .validateFilterIsSelected(masterFoodFilterParameters);
        //        
        /*
         * nick 2005-1-31 Per Joe. We do not need to force a filter to be
         * selected. Since we limit the number of records per page, this doesn't
         * provide as much value.
         */
        boolean filterIsSelected = true;

        //        boolean itemTypeIsSelected = this
        //                .validateItemTypeIsSelected(fieldsToDisplayBean);
        /*
         * nick 2005-2-15 per joe we don't need to force this to be included.
         */
        boolean itemTypeIsSelected = true;
        return !(!selectedFieldCount || !primaryFieldIsSelected
                || !filterIsSelected || !itemTypeIsSelected);

    }

    /*
     * MenuItemType Must be selected(true).
     */
    private boolean validateItemTypeIsSelected(
            FieldsToDisplayBean fieldsToDisplayBean) {

        return fieldsToDisplayBean.isMenuItemType().booleanValue();

    }

    /*
     * 2006-01-21 RSC commented out.  Both of the other counters were 
     * zero, so this is likely never being called.
     */
//    private boolean validateFilterIsSelected(
//            MasterFoodFilterParameters masterFoodFilterParameters) {
//        int countLike = masterFoodFilterParameters.getCountLikeParameters();
//        int countIn = masterFoodFilterParameters.getCountInParameters();
//
//        return (countLike + countIn) > 0;
//    }

    /*
     * Make sure at least one primary field is selected. This excludes Operation
     * Name.
     */
    /*
     * 2006-08-16 reid@fivesticks.com removed
     */
//    private boolean validatePrimaryFieldIsSelected(
//            FieldsToDisplayBean fieldsToDisplayBean) {
//        int count = fieldsToDisplayBean.countPrimaryFieldsSelected();
//        return count > 0;
//    }

    /*
     * We need to be sure between 2 and 5 fields are selected.
     */
    private boolean validateSelectedFieldCount(
            FieldsToDisplayBean fieldsToDisplayBean) {

        int count = fieldsToDisplayBean.countTotalSelected();

        /*
         * nick 2005-1-18 changed for 2 min to 1, one is sufficient.
         */
        return count <= 7 && count >= 1;
    }

}