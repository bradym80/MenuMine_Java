/*
 * Created on Mar 24, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.sharetable.AbstractStatisticalTableElement;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIFBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * 2006-04-06 RSC The keyword filter removes records with keyword in it.
 * 
 * For example, a query that results in records with "Ribeye Steak", the word
 * "steak" may be useless, and so could be eliminated.
 * 
 * If the resulting table has multiple rows named "Ribeye", those should be
 * combined into one row.
 * 
 * @author Reid
 */
public class CommonTermsFilter extends AbstractFilter {

    private String keywords;

    public void execute(StatisticalTableIF input) throws Exception {

        if (this.getKeywords() == null) {
            this.setResults(input);
            log.info("no keywords sent in");
            return;
        }
        Collection rows = new ArrayList();

        StatisticalTableElementIF none = null;

        StatisticalTableElementIF combined = null;

        // create an array with just the terms to be filtered
        String[] keys = this.getKeywords().toLowerCase().split("\\W");

        for (Iterator iter = input.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            boolean purged = false;

            for (int i = 0; i < keys.length; i++) {
                if (element.getName().toLowerCase().indexOf(keys[i]) != -1) {
                    element = handleElementNamePurge(element, keys);
                    rows.add(element);
                    purged = true;
                    break;
                }
            }

            if (!purged) {
                rows.add(element);
            }
        }

        /*
         * step 2 consolidate the results to something more meaningful.
         */
        Collection dups = new ArrayList();

        for (Iterator iter = rows.iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            for (Iterator iterator = dups.iterator(); iterator.hasNext();) {
                StatisticalTableElementIF dupElement = (StatisticalTableElementIF) iterator
                        .next();

                if (dupElement.getName() != null
                        && element.getName() != null
                        && dupElement.getName().toLowerCase().equals(
                                element.getName().toLowerCase())) {
                    dupElement = new StatisticalTableElementIFBuilder()
                            .decorateCombined(dupElement.getName(), dupElement,
                                    element);
                    element = null;
                    break;
                } else if (dupElement.getName() == null
                        && element.getName() == null) {
                    dupElement = new StatisticalTableElementIFBuilder()
                            .buildCombined(
                                    AbstractStatisticalTableElement.NONE,
                                    dupElement, element);
                    element = null;
                }
            }

            if (element != null) {
                dups.add(element);
            }

        }

        this.handleBuildResults(input, dups);

        // FilteredTable table = new FilteredTable();
        //
        // table.setRows(dups);
        //
        // table.setFieldEnum(input.getFieldEnum());
        //
        // this.postFilterDecoration(table);
        //
        // this.setResults(table);

    }

    private StatisticalTableElementIF handleElementNamePurge(
            StatisticalTableElementIF element, String[] keys) {

        // not to LC yet because I'd like to put it back together in the same
        // order it was originally.

        boolean isCombination = false;

        if (element.getName().trim().indexOf(" ") == -1
                && element.getName().trim().indexOf("/") != -1) {
            isCombination = true;
        }
        String[] nameKeys = element.getName().split("\\W");

        for (int i = 0; i < nameKeys.length; i++) {
            for (int j = 0; j < keys.length; j++) {
                if (nameKeys[i].toLowerCase().equals(keys[j])) {

//                    log.info("purging " + nameKeys[i] + " because of "
//                            + keys[j]);
                    nameKeys[i] = null;

                    break;
                }
            }
        }

        StringBuffer newName = new StringBuffer();

        for (int i = 0; i < nameKeys.length; i++) {
            if (nameKeys[i] != null) {
                newName.append(nameKeys[i]);

                if (isCombination) {
                    newName.append("/");
                } else {
                    newName.append(" ");
                }

            }
        }

        String newNameString = newName.toString().trim();

        if (newNameString.endsWith("/")) {
            newNameString = newNameString.substring(0, newNameString.length()-1);
        }

        if (newNameString.trim().length() == 0) {
            newNameString = null;
        }
        StatisticalTableElementIF ret = new StatisticalTableElementIFBuilder()
                .setName(newNameString, element);

//        log.info("ret name is " + ret.getName());

        return ret;

    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
