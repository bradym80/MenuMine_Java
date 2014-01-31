/*
 * Created on Aug 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 * This
 */
public class MineDetectorOverrideImpl extends MineDetector {

    private String mineTypeOverride;

    public MineDetectorOverrideImpl(String mineTypeOverride) {
        super();

        this.mineTypeOverride = mineTypeOverride;
    }

    /*
     * This uses the standard MineDetector then filters so we only have the mine
     * that the override indicates. 
     * 
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.menumine.express.MineDetector#detect(java.util.Collection)
     */
    public Collection detect(Collection keyCounters) {

        Collection ret = new ArrayList();

        
        
        Collection mineRanks = super.detect(keyCounters);
        for (Iterator iter = mineRanks.iterator(); iter.hasNext();) {
            MineRank element = (MineRank) iter.next();
            String elementMineType = element.getMineFieldsExpressQueryCounter()
                    .getTargetMine().getMineType();
            if (elementMineType.equals(mineTypeOverride)) {
                ret.add(element);
            }
        }

        return ret;
    }

    public String getMineTypeOverride() {
        return mineTypeOverride;
    }

    public void setMineTypeOverride(String mineTypeOverride) {
        this.mineTypeOverride = mineTypeOverride;
    }

}