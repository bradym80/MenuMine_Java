/*
 * Created on Aug 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.Collection;

/**
 * @author Nick
 * 
 * The MineDetector helps up determine which mine represents a query the best.
 * Given a collection of keyCounters we can see what fields are most
 * significant.
 * 
 * Using this info we can compare significant fields to each mine to determine
 * which are likly.
 * 
 * Ultimatly we will give give users suggestions, so we need to be able to
 * return a collection of possible mine.
 * 
 * This may have to take authoization into account, but is is possible that we
 * tease users with the mines they have not purchased yet.
 * 
 *  
 */
public class MineDetector {

    /*
     * We will keep this around so we don't have to calculate multiple times.
     */
    private Collection mineRanks;

    public MineDetector() {
        super();

    }

    /*
     * This can do some post processing of the mineRanks to limit the number
     * that we think are likly.
     * 
     * Version 1, we just suggest them all.
     */
    public Collection detect(Collection keyCounters) {

        Collection mineRanks = this.rankMines(keyCounters);

        return mineRanks;

    }

    /*
     * This attempts to rank the applicability of the mines.
     * 
     * Look at the MineFieldExpressQueryCounters to determine ranks of
     * appropriateness for the query.
     *  
     */
    private Collection rankMines(Collection mineFieldExpressQueryCounters) {
        if (mineRanks == null) {
            mineRanks = new MineRankerFieldPriorityImpl()
                    .rank(mineFieldExpressQueryCounters);
        }
        return mineRanks;
    }

}