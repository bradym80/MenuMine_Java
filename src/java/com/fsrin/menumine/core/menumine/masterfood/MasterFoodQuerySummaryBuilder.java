/*
 * Created on Feb 1, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.LastQuerySummaryElement;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.minefields.DessertMineFields;
import com.fsrin.menumine.core.minefields.MenuMineFields;
import com.fsrin.menumine.core.minefields.MineField;
import com.fsrin.menumine.core.minefields.MineFields;
import com.opensymphony.webwork.util.Sorter;

/**
 * @author Nick
 */
public class MasterFoodQuerySummaryBuilder {

    public static MasterFoodQuerySummaryBuilder singleton = new MasterFoodQuerySummaryBuilder();

    private MasterFoodQuerySummaryBuilder() {
        super();

    }

    public Collection build(MasterFoodFilterParameters params,
            MineFields mineFields) {

        Collection summary = new ArrayList();
        // FieldEnum field = FieldEnum.BASIC_PROTEIN;
        // for (Iterator iter = mineFields.getAllFields().iterator();
        // iter.hasNext();) {

        return this.build(params, mineFields.getAllFields());
    }

    /*
     * We may have to build a summary without knowing which mine it came from.
     */
    public Collection build(MasterFoodFilterParameters parameters) {

        Set allFields = new TreeSet(new Sorter()
                .getAscending("fieldEnum.friendlyName"));
        allFields.addAll(new DessertMineFields().getAllFields());
        allFields.addAll(new MenuMineFields().getAllFields());
        return this.build(parameters, allFields);
    }

    private Collection build(MasterFoodFilterParameters params,
            Collection fields) {

        Collection summary = new ArrayList();
        // FieldEnum field = FieldEnum.BASIC_PROTEIN;
        for (Iterator iter = fields.iterator(); iter.hasNext();) {
            FieldEnum field = ((MineField) iter.next()).getFieldEnum();

            try {
                /*
                 * See if any data is set in here.
                 */
                Collection type = null;
                if (field.getAndName() != null) {
                    String andName = field.getAndName();


                        type = (Collection) Ognl.getValue(field.getAndName(),
                                params);

                } else {
                    type = new ArrayList();
                }
                Collection selection = null;
                if (field.getInName() != null) {
                    selection = (Collection) Ognl.getValue(field.getInName(),
                            params);
                } else {
                    selection = new ArrayList();
                }

                Collection orValues = null;
                if (field.getOrName() != null) {
                    orValues = (Collection) Ognl.getValue(field.getOrName(),
                            params);
                } else {
                    orValues = new ArrayList();
                }

                Collection notValues = null;
                if (field.getNotName() != null) {
                    notValues = (Collection) Ognl.getValue(field.getNotName(),
                            params);
                } else {
                    notValues = new ArrayList();
                }

                Boolean empty = null;
                if (field.getEmptyName() != null) {
                    empty = (Boolean) Ognl.getValue(field.getEmptyName(),
                            params);
                }

                if (type.size() > 0 || selection.size() > 0
                        || orValues.size() > 0 || notValues.size() > 0
                        || (empty != null)) {

                    LastQuerySummaryElement lqse = new LastQuerySummaryElement();
                    lqse.setField(field);
                    lqse.setTypeIn(type);
                    lqse.setOrValues(orValues);
                    lqse.setNotValues(notValues);
                    lqse.setSelection(selection);
                    lqse.setEmpty(empty);
                    summary.add(lqse);

                }
            } catch (OgnlException e) {

                e.printStackTrace();
            }
        }

        return summary;
    }

}