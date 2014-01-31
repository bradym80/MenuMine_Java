/*
 * Created on Aug 26, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;

/**
 * @author Nick
 * 
 * This class attempts to guess an appropriate roll up.
 * 
 * We do this by counting all the words that appear in the share table, then
 * assuming that the words that appear most often are the most important, and
 * roll up by that.
 *  
 */
public class AutoRollUpBuilder {

    /*
     * This indicated how aggressivly we try to roll Up
     *  
     */
    public static final int INTENSITY_VERY_HIGH = 5;

    public static final int INTENSITY_HIGH = 4;

    public static final int INTENSITY_MEDIUM = 3;

    public static final int INTENSITY_LOW = 2;

    public static final int INTENSITY_VERY_LOW = 1;

    private StatisticalTableIF menuShare;

    /*
     * INTENCITY_VERY_HIGH => index 5 => 0.90, thus if a word appears in more
     * than %70 of the lines, it is too strict
     */
    private double[] intensityThresholdMap = { 0.0, 0.30, 0.50, 0.70, 0.80,
            0.90 };

    private int rollUpIntensity = 5;

    private RollUpOptions proposedRollUpOptions;

    public AutoRollUpBuilder(StatisticalTableIF menuShare, int rollUpIntensity) {
        super();
        this.menuShare = menuShare;
        this.rollUpIntensity = rollUpIntensity;
    }

    public void processAutoRollUp() {

        HashMap wordCountMap = new HashMap();
        int initialRows = menuShare.getRows().size();

        for (Iterator iter = menuShare.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter
                    .next();

            String[] tokens = element.getName().split("\\W");
            for (int i = 0; i < tokens.length; i++) {
                String tok = tokens[i];

                if (this.isValidToken(tok)) {
                    if (wordCountMap.containsKey(tok.toLowerCase().trim())) {
                        AutoRollUpWordCountVO vo = (AutoRollUpWordCountVO) wordCountMap
                                .get(tok.toLowerCase().trim());
                        vo.incrementCount();
                        // vo.incrementCount(element.getNumberInSample());
                    } else {
                        AutoRollUpWordCountVO vo = new AutoRollUpWordCountVO(
                                tok);
                        vo.incrementCount();
                        wordCountMap.put(tok.toLowerCase().trim(), vo);
                    }
                }
            }

        }

        Collection sorted = new TreeSet(new MMSorter().getDescending("count",
                "name"));
        sorted.addAll(wordCountMap.values());
        /*
         * Funnel elements in to autoRollUp elements.
         */
        for (Iterator iter = menuShare.getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF origElement = (StatisticalTableElementIF) iter
                    .next();

            for (Iterator iterator = sorted.iterator(); iterator.hasNext();) {
                AutoRollUpWordCountVO autoRollUpElement = (AutoRollUpWordCountVO) iterator
                        .next();
                /*
                 * If a term is in more than %90 of the rows, it is probably too
                 * restrictive.
                 */
                if (autoRollUpElement.getCount() < initialRows
                        * this.getRollUpIntensityThreshold()) {
                    if (origElement.getName().toLowerCase().indexOf(
                            autoRollUpElement.getName().toLowerCase()) > -1) {
                        autoRollUpElement
                                .addStatisticalTableElement(origElement);
                        break;
                    }
                }
            }

        }

        proposedRollUpOptions = new RollUpOptions();
        for (Iterator iterator = sorted.iterator(); iterator.hasNext();) {
            AutoRollUpWordCountVO autoRollUpElement = (AutoRollUpWordCountVO) iterator
                    .next();

            if (autoRollUpElement.getIncludedStatisticalTableElement().size() > 1) {
                for (Iterator iter = autoRollUpElement
                        .getIncludedStatisticalTableElement().iterator(); iter
                        .hasNext();) {
                    StatisticalTableElementIF statisticalTableElement = (StatisticalTableElementIF) iter
                            .next();
                    RollUpElement rollUpElement = new RollUpElement();

                    rollUpElement.setLabel(autoRollUpElement.getName().trim());
                    rollUpElement.setTerm(statisticalTableElement.getName());
                    proposedRollUpOptions.getRollUpElements()
                            .add(rollUpElement);
                }

            }
        }

        for (Iterator iter = sorted.iterator(); iter.hasNext();) {
            AutoRollUpWordCountVO element = (AutoRollUpWordCountVO) iter.next();

            LogFactory.getLog(this.getClass()).debug(element.getName() + ": " + element.getCount());
        }

    }

    private double getRollUpIntensityThreshold() {
        return intensityThresholdMap[this.rollUpIntensity];
    }

    /*
     * This can filter out words:
     * 
     * with, then, and, not and toks shorted then 3 chars.
     */
    private boolean isValidToken(String tok) {

        if (tok.length() < 3) {
            return false;
        }

        /*
         * 2006-02-03 RSC
         */
//        if (tok.toLowerCase().trim().equals("with")) {
//            return false;
//        }
//
//        if (tok.toLowerCase().trim().equals("then")) {
//            return false;
//        }
//        if (tok.toLowerCase().trim().equals("and")) {
//            return false;
//        }
//        if (tok.toLowerCase().trim().equals("not")) {
//            return false;
//        }
//        if (tok.toLowerCase().trim().equals("for")) {
//            return false;
//        }
//        if (tok.toLowerCase().trim().equals("the")) {
//            return false;
//        }

        String[] exclusions = { "with", "then", "and", "not", "for", "the" };
        
        if (!isValidToken(tok, exclusions))
            return false;
        return true;
    }
    
    private boolean isValidToken(String target, String[] exclusions) {
        
        for (int i = 0; i < exclusions.length; i++) {
            if (target.toLowerCase().trim().equals(exclusions[i]))
                return false;
        }
        
        return true;
    }

    public RollUpOptions getProposedRollUp() {
        if (proposedRollUpOptions == null) {
            this.processAutoRollUp();
        }

        return proposedRollUpOptions;
    }

}