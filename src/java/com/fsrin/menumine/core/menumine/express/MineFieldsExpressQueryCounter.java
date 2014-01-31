/*
 * Created on Aug 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.util.MenuMineUtil;
import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.SearchTermContext;
import com.fsrin.menumine.core.menumine.masterfood.SearchTermContextMapper;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableKeyFinder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableKeyFinderFactory;
import com.fsrin.menumine.core.minefields.MineField;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * 
 * This takes data and organizes it for the target mine, to help choose the
 * correct mine.
 *  
 */
public class MineFieldsExpressQueryCounter {
    private MineFields targetMine;

    private static Log log = LogFactory.getLog(MineFieldsExpressQueryCounter.class);
    
    private Collection mineFieldKeyCounters;

    /*
     * These are the tokens we need to search by.
     */
    private Collection searchCollection;

    /*
     * Keep track of the number of elements that we find that are members of the
     * targetMine.
     */
    private FieldsToDisplayBean expressFieldsToDisplayBean;

    private int count;

    public MineFieldsExpressQueryCounter(MineFields mineFieldsElement,
            Collection searchCollection) {
        super();

        this.targetMine = mineFieldsElement;
        this.searchCollection = searchCollection;
        this.mineFieldKeyCounters = new TreeSet(new MMSorter()
                .getDescendingAllUnique("count", "name"));
        StatisticalTableKeyFinderFactory statisticalTableKeyFinderFactory = new StatisticalTableKeyFinderFactory();

        /*
         * Init the keyCounters for this mine.
         */
        for (Iterator iterator = mineFieldsElement.getAllFields().iterator(); iterator
                .hasNext();) {
            MineField mineFieldElement = (MineField) iterator.next();

            try {
                StatisticalTableKeyFinder keyFinder = (StatisticalTableKeyFinder) Ognl
                        .getValue(mineFieldElement.getFieldEnum()
                                .getShortOgnlName(),
                                statisticalTableKeyFinderFactory);
                KeyCounter kc = new KeyCounter(mineFieldElement, keyFinder);
                this.mineFieldKeyCounters.add(kc);
            } catch (OgnlException e) {

                e.printStackTrace();
            }

        }

    }

    public void handleMasterFood(MasterFood masterFoodElement) {

        if (this.targetMine.isMemberOfMine(masterFoodElement)) {

            this.count++;
            for (Iterator iter = this.mineFieldKeyCounters.iterator(); iter
                    .hasNext();) {
                KeyCounter keyCounterElement = (KeyCounter) iter.next();

                Object o = keyCounterElement.getStatisticalTableKeyFinder()
                        .getKey(masterFoodElement);
                /*
                 * We only need strings. It is safe to ignore the prices.
                 */
                if (o instanceof String) {

                    String keyValue = (String) o;

                    //                    StringTokenizer stringTokenizer = new StringTokenizer(
                    //                            keyValue);
                    for (Iterator cleanedTokenIterator = this.searchCollection
                            .iterator(); cleanedTokenIterator.hasNext();) {
                        String tok = (String) cleanedTokenIterator.next();

                        SearchTermContext context = SearchTermContextMapper.singleton
                                .find(tok);
                        if (context != null) {
                            for (Iterator iterator = context.getOrTerms()
                                    .iterator(); iterator.hasNext();) {
                                String orTerm = (String) iterator.next();
                                /*
                                 * We increment by tok as we want to count all
                                 * the context terms the same way.
                                 */

                                if (!MenuMineUtil.isEmpty(orTerm)
                                        && keyValue.toLowerCase().indexOf(
                                                orTerm.toLowerCase()) > -1) {
                                    keyCounterElement.incrementCount(tok);
                                }
                            }
                            for (Iterator iterator = context.getAndTerms()
                                    .iterator(); iterator.hasNext();) {
                                String andTerm = (String) iterator.next();
                                /*
                                 * We increment by tok as we want to count all
                                 * the context terms the same way.
                                 */

                                if (!MenuMineUtil.isEmpty(andTerm)
                                        && keyValue.toLowerCase().indexOf(
                                                andTerm.toLowerCase()) > -1) {
                                    keyCounterElement.incrementCount(tok);
                                }
                            }
                        } else {

                            if (!MenuMineUtil.isEmpty(tok)
                                    && keyValue.toLowerCase().indexOf(
                                            tok.toLowerCase()) > -1) {
                                keyCounterElement.incrementCount(tok);
                            }
                        }
                    }
                }

            }

        }

    }

    /*
     * 2006-01-18 RSC
     * 
     * New requirement to display only a set number of fields.
     * 
     */
    private void buildExpressFieldsToDisplayBean() {

        //  Collection keyFinders = new
        // StatisticalTableKeyFinderFactory().getAll();

        Collection keyCounter = this.getSortedMineFieldKeyCounters();

        int count = 0;

        count = 0;
        FieldsToDisplayBean bean = new FieldsToDisplayBean();

        /*
         * We show the top 6+ we will force MenuItemName to show. This can be
         * optimized to be more specific to the Mine Being used.
         *  
         */

//        for (Iterator iter = keyCounter.iterator(); iter.hasNext() && count < 6;) {
//            count++;
//            KeyCounter element = (KeyCounter) iter.next();
//
//            try {
//                Ognl.setValue(element.getMineField().getFieldEnum().getShortOgnlName(), bean, Boolean.TRUE);
//            } catch (OgnlException e) {
//
//                e.printStackTrace();
//            }
//        }
        /*
         * We don't want to look at ItemDescription. The real power of menumine
         * is the fact we have more detail than just the description.
         */

        //bean.setItemDescription(Boolean.FALSE);
        //bean.setMenuItem(Boolean.TRUE);
        
        bean.setGenMenuPart(Boolean.TRUE);
        bean.setMenuItemType(Boolean.TRUE);
        bean.setMenuItemClass(Boolean.TRUE);
        bean.setCuisine(Boolean.TRUE);
        bean.setSegment(Boolean.TRUE);
        
        
        this.expressFieldsToDisplayBean = bean;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Collection getMineFieldKeyCounters() {
        return mineFieldKeyCounters;
    }

    public Collection getSortedMineFieldKeyCounters() {
        Collection keyCounter = this.getMineFieldKeyCounters();
        TreeSet sorted = new TreeSet(new MMSorter().getDescendingAllUnique(
                "count", "friendlyName"));
        sorted.addAll(keyCounter);
        return sorted;
    }

    //    public void setMineFieldKeyCounters(Collection mineFieldKeyCounters) {
    //        this.mineFieldKeyCounters = mineFieldKeyCounters;
    //    }

    public MineFields getTargetMine() {
        return targetMine;
    }

    public void setTargetMine(MineFields targetMine) {
        this.targetMine = targetMine;
    }

    public FieldsToDisplayBean getProjectedFieldsToDisplay() {
        if (expressFieldsToDisplayBean == null) {
            buildExpressFieldsToDisplayBean();
        }
        return expressFieldsToDisplayBean;
    }

    public Integer getRawFieldCount() {
        int count = 0;
        int i = 0;
        for (Iterator iter = this.mineFieldKeyCounters.iterator(); iter
                .hasNext()
                && i < 10;) {
            KeyCounter element = (KeyCounter) iter.next();
            if (element.getCount().intValue() > 0) {
                i++;
                log.info(element.getMineField().getFieldEnum()
                        .getName()+": "+element.getMineField().getPriority());

                count += element.getMineField().getPriority();
                ;

            }
        }
        return new Integer(count);
    }

}

