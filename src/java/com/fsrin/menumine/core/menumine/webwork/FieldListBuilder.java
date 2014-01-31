/*
 * Created on Jan 24, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.util.Collection;
import java.util.TreeSet;

import com.fsrin.menumine.core.minefields.MineFields;
import com.opensymphony.webwork.util.Sorter;

/**
 * @author Nick This builds a list of all the fields. USED FOR: The menumine
 *         form requires us to choose a fields to Sort By and to Graph By. This
 *         moves the list building to one spot.
 *  
 */
public class FieldListBuilder {

    public static FieldListBuilder singleton = new FieldListBuilder();

    public FieldListBuilder() {
        super();

    }

    public Collection buildFieldList(MineFields mineFields) {

        // Map map = new HashMap();
        Collection all = mineFields.getAllFields();
        Collection allSorted = new TreeSet(new Sorter()
                .getAscending("friendlyName"));
        allSorted.addAll(all);

        return allSorted;
    }

}