package com.fsrin.menumine.core.menumine.clusters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import ognl.Ognl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableElementIF;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.minefields.MineFields;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

/**
 * 2006-03-29 RSC
 * 
 * Adapted from the auto rollup builder.
 * 
 */
public class ClusterBuilder {

    private Log log = LogFactory.getLog(ClusterBuilder.class);

    private FieldEnum targetField;

    private StatisticalTableIF menuShare;

    private Collection excludedTerms = new ArrayList();

    private Map commonTerms = new HashMap();
    
    private Collection sortedTerms;
    
    private Collection orphans;

    public ClusterBuilder(FieldEnum fieldEnum) {
        super();
        this.setTargetField(fieldEnum);

        String[] name = fieldEnum.getFriendlyName().split("\\W");
        for (int i = 0; i < name.length; i++) {
            this.getExcludedTerms().add(name[i].toLowerCase());
        }
    }

    public void reduceToClusters() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory
                .getEmtpy();

        // p.getSauceCondDressMarMM().setEmpty(Boolean.FALSE);

        Ognl.setValue(this.getTargetField().getOgnlName() + ".empty", p,
                Boolean.FALSE);

        MineFields.factory.getByKey(MineFieldsFactory.MINE_TYPE_MENU)
                .applyHiddenParams(p);

        MenuMineGraphOptions options = new MenuMineGraphOptions();

        options.setGraphByField(this.getTargetField().getOgnlName());

        RollUpOptions roll = new RollUpOptions();

        StatisticalTableIF table = new StatisticalTableBuilder()
                .buildStatisticalTable_FromAggregation(p, options, roll);

        this.setMenuShare(table);

        // figure out the terms
        for (Iterator iter = this.getMenuShare().getRows().iterator(); iter
                .hasNext();) {
            StatisticalTableElementIF current = (StatisticalTableElementIF) iter
                    .next();

            String[] t = current.getName().split("\\W");

            boolean foundFirst = false;

            for (int i = 0; i < t.length; i++) {
                String target = t[i].toLowerCase().trim();

                if (this.isValidToken(target) && !this.isExcludedToken(target)) {

                    AutoRollUpWordCountVO counter = null;

                    if (this.getCommonTerms().containsKey(target)) {
                        counter = (AutoRollUpWordCountVO) this.getCommonTerms()
                                .get(target);
                    } else {
                        counter = new AutoRollUpWordCountVO(target);
                        this.getCommonTerms().put(target, counter);
                    }

                    counter.incrementCount();

                }
            }

        }

        
        
        Collection sorted = new TreeSet(new MMSorter().getDescending("count",
                "name"));
        
        for (Iterator iter = this.getCommonTerms().values().iterator(); iter.hasNext();) {
            AutoRollUpWordCountVO element = (AutoRollUpWordCountVO) iter.next();
            if (element.getCount() > 5) {
                sorted.add(element);
            }
        }
        

        this.setSortedTerms(sorted);
        
        
        
        Collection orphans = new ArrayList();
        
        for (Iterator iter = this.getMenuShare().getRows().iterator(); iter.hasNext();) {
            StatisticalTableElementIF element = (StatisticalTableElementIF) iter.next();
            boolean found = false;
            for (Iterator iterator = sorted.iterator(); iterator.hasNext();) {
                AutoRollUpWordCountVO word = (AutoRollUpWordCountVO) iterator.next();
                if (element.getName().toLowerCase().indexOf(word.getName()) > -1) {
                    found = true;
                    word.addStatisticalTableElement(element);
                    break;
                }
                
            }
            if (!found) {
                orphans.add(element);
            }
        }
        
        this.setOrphans(orphans);
        
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

    private boolean isExcludedToken(String tok) {

        boolean ret = this.getExcludedTerms().contains(tok);

        return ret;
    }

    public Collection getExcludedTerms() {
        return excludedTerms;
    }

    public void setExcludedTerms(Collection excludedTerms) {
        this.excludedTerms = excludedTerms;
    }

    public StatisticalTableIF getMenuShare() {
        return menuShare;
    }

    public void setMenuShare(StatisticalTableIF menuShare) {
        this.menuShare = menuShare;
    }

    public Map getCommonTerms() {
        return commonTerms;
    }

    public void setCommonTerms(Map commonTerms) {
        this.commonTerms = commonTerms;
    }

    public FieldEnum getTargetField() {
        return targetField;
    }

    public void setTargetField(FieldEnum targetField) {
        this.targetField = targetField;
    }

    public Collection getSortedTerms() {
        return sortedTerms;
    }

    public void setSortedTerms(Collection sortedTerms) {
        this.sortedTerms = sortedTerms;
    }

    public Collection getOrphans() {
        return orphans;
    }

    public void setOrphans(Collection orphans) {
        this.orphans = orphans;
    }

}