/*
 * Created on Feb 1, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

public class StatisticalTablePriceDataAggregationImpl implements
        StatisticalTablePriceDataIF {

    private Double averagePrice1996;
    private Double averagePrice1997;
    private Double averagePrice1998;
    private Double averagePrice1999;
    private Double averagePrice2000;
    private Double averagePrice2001;
    private Double averagePrice2002;
    private Double averagePrice2003;
    private Double averagePrice2004;
    private Double averagePrice2005;
    private Double averagePrice2006;
    //JDL 10-5-07
    private Double averagePrice2007;
    
    // DBB 1-20-2009 Add 2008, 2009
    private Double averagePrice2008;
    private Double averagePrice2009;
    // MJB 11-12-2009 Added 2010
    private Double averagePrice2010;
    private Double averagePrice2011;
    
    private Double medianPrice1996;
    private Double medianPrice1997;
    private Double medianPrice1998;
    private Double medianPrice1999;
    private Double medianPrice2000;
    private Double medianPrice2001;
    private Double medianPrice2002;
    private Double medianPrice2003;
    private Double medianPrice2004;
    private Double medianPrice2005;
    private Double medianPrice2006;
    //JDL 10-5-07
    private Double medianPrice2007;
    
    // DBB 1-20-2009 Add 2008, 2009
    private Double medianPrice2008;
    private Double medianPrice2009;
    // MJB 11-12-2009 Added 2010
    private Double medianPrice2010;
    private Double medianPrice2011;
    
    public StatisticalTablePriceDataAggregationImpl() {
        super();
    }
    public StatisticalTablePriceDataAggregationImpl(Object[] data) {
        super();
        this.populate(data);
    }
    /**
     * requires an object array where the last 10 items are the prices 
     * we're interested in.
     * 
     * @param object
     */
    public void populate(Object[] object) {
        // TODO MJB I iterated this by 1 for each number, will review history to see what changes have been made.
    	// DBB 1-20-2009 Add 2008, 2009
        if (object.length > 18 || object.length < 17)
            throw new RuntimeException("can't populate from the object");
       
        if (object.length == 18)
            handlePopulateFromGroup(object);
       
        if (object.length == 17)
            handlePopulateFromTotal(object);
    }
    
    /**
     * 12 elements
     * @param object
     */
    private void handlePopulateFromGroup(Object[] object) {
        this.setAveragePrice1996((Double)object[2]);
        this.setAveragePrice1997((Double)object[3]);
        this.setAveragePrice1998((Double)object[4]);
        this.setAveragePrice1999((Double)object[5]);
        this.setAveragePrice2000((Double)object[6]);
        this.setAveragePrice2001((Double)object[7]);
        this.setAveragePrice2002((Double)object[8]);
        this.setAveragePrice2003((Double)object[9]);
        this.setAveragePrice2004((Double)object[10]);
        this.setAveragePrice2005((Double)object[11]);
        this.setAveragePrice2006((Double)object[12]);
        //JDL 10-5-07
        this.setAveragePrice2007((Double)object[13]);
        
        // DBB 1-20-2009 Add 2008, 2009
        this.setAveragePrice2008((Double)object[14]);
        this.setAveragePrice2009((Double)object[15]);
        // MJB 11-12-2009 Added 2010
        this.setAveragePrice2010((Double)object[16]);
        this.setAveragePrice2011((Double)object[17]);
    }
//TODO DBB is this array correct? The one above starts with 0 then goes to 2 -MJB 11-12-2009
    private void handlePopulateFromTotal(Object[] object) {
        this.setAveragePrice1996((Double)object[1]);
        this.setAveragePrice1997((Double)object[2]);
        this.setAveragePrice1998((Double)object[3]);
        this.setAveragePrice1999((Double)object[4]);
        this.setAveragePrice2000((Double)object[5]);
        this.setAveragePrice2001((Double)object[6]);
        this.setAveragePrice2002((Double)object[7]);
        this.setAveragePrice2003((Double)object[8]);
        this.setAveragePrice2004((Double)object[9]);
        this.setAveragePrice2005((Double)object[10]);
        this.setAveragePrice2006((Double)object[11]);
        //JDL 10-5-07
        this.setAveragePrice2007((Double)object[12]);
        
        // DBB 1-20-2009 Add 2008, 2009
        this.setAveragePrice2008((Double)object[13]);
        this.setAveragePrice2009((Double)object[14]);
        // MJB 11-12-2009 Added 2010
        this.setAveragePrice2010((Double)object[15]);
        this.setAveragePrice2011((Double)object[16]);
        

    }

    public Double getAveragePrice1996() {
        return averagePrice1996;
    }
    public void setAveragePrice1996(Double averagePrice1996) {
        this.averagePrice1996 = averagePrice1996;
    }
    public Double getAveragePrice1997() {
        return averagePrice1997;
    }
    public void setAveragePrice1997(Double averagePrice1997) {
        this.averagePrice1997 = averagePrice1997;
    }
    public Double getAveragePrice1998() {
        return averagePrice1998;
    }
    public void setAveragePrice1998(Double averagePrice1998) {
        this.averagePrice1998 = averagePrice1998;
    }
    public Double getAveragePrice1999() {
        return averagePrice1999;
    }
    public void setAveragePrice1999(Double averagePrice1999) {
        this.averagePrice1999 = averagePrice1999;
    }
    public Double getAveragePrice2000() {
        return averagePrice2000;
    }
    public void setAveragePrice2000(Double averagePrice2000) {
        this.averagePrice2000 = averagePrice2000;
    }
    public Double getAveragePrice2001() {
        return averagePrice2001;
    }
    public void setAveragePrice2001(Double averagePrice2001) {
        this.averagePrice2001 = averagePrice2001;
    }
    public Double getAveragePrice2002() {
        return averagePrice2002;
    }
    public void setAveragePrice2002(Double averagePrice2002) {
        this.averagePrice2002 = averagePrice2002;
    }
    public Double getAveragePrice2003() {
        return averagePrice2003;
    }
    public void setAveragePrice2003(Double averagePrice2003) {
        this.averagePrice2003 = averagePrice2003;
    }
    public Double getAveragePrice2004() {
        return averagePrice2004;
    }
    public void setAveragePrice2004(Double averagePrice2004) {
        this.averagePrice2004 = averagePrice2004;
    }
    public Double getAveragePrice2005() {
        return averagePrice2005;
    }
    public void setAveragePrice2005(Double averagePrice2005) {
        this.averagePrice2005 = averagePrice2005;
    }
    public Double getMedianPrice1996() {
        return medianPrice1996;
    }
    public void setMedianPrice1996(Double medianPrice1996) {
        this.medianPrice1996 = medianPrice1996;
    }
    public Double getMedianPrice1997() {
        return medianPrice1997;
    }
    public void setMedianPrice1997(Double medianPrice1997) {
        this.medianPrice1997 = medianPrice1997;
    }
    public Double getMedianPrice1998() {
        return medianPrice1998;
    }
    public void setMedianPrice1998(Double medianPrice1998) {
        this.medianPrice1998 = medianPrice1998;
    }
    public Double getMedianPrice1999() {
        return medianPrice1999;
    }
    public void setMedianPrice1999(Double medianPrice1999) {
        this.medianPrice1999 = medianPrice1999;
    }
    public Double getMedianPrice2000() {
        return medianPrice2000;
    }
    public void setMedianPrice2000(Double medianPrice2000) {
        this.medianPrice2000 = medianPrice2000;
    }
    public Double getMedianPrice2001() {
        return medianPrice2001;
    }
    public void setMedianPrice2001(Double medianPrice2001) {
        this.medianPrice2001 = medianPrice2001;
    }
    public Double getMedianPrice2002() {
        return medianPrice2002;
    }
    public void setMedianPrice2002(Double medianPrice2002) {
        this.medianPrice2002 = medianPrice2002;
    }
    public Double getMedianPrice2003() {
        return medianPrice2003;
    }
    public void setMedianPrice2003(Double medianPrice2003) {
        this.medianPrice2003 = medianPrice2003;
    }
    public Double getMedianPrice2004() {
        return medianPrice2004;
    }
    public void setMedianPrice2004(Double medianPrice2004) {
        this.medianPrice2004 = medianPrice2004;
    }
    public Double getMedianPrice2005() {
        return medianPrice2005;
    }
    public void setMedianPrice2005(Double medianPrice2005) {
        this.medianPrice2005 = medianPrice2005;
    }
    /**
     * @return Returns the averagePrice2006.
     */
    public Double getAveragePrice2006() {
        return averagePrice2006;
    }
    /**
     * @param averagePrice2006 The averagePrice2006 to set.
     */
    public void setAveragePrice2006(Double averagePrice2006) {
        this.averagePrice2006 = averagePrice2006;
    }
    /**
     * @return Returns the medianPrice2006.
     */
    public Double getMedianPrice2006() {
        return medianPrice2006;
    }
    /**
     * @param medianPrice2006 The medianPrice2006 to set.
     */
    public void setMedianPrice2006(Double medianPrice2006) {
        this.medianPrice2006 = medianPrice2006;
    }
    
    //JDL 10-5-07
    /**
     * @return Returns the averagePrice2007.
     */
    public Double getAveragePrice2007() {
        return averagePrice2007;
    }
    /**
     * @param averagePrice2007 The averagePrice2007 to set.
     */
    public void setAveragePrice2007(Double averagePrice2007) {
        this.averagePrice2007 = averagePrice2007;
    }
    /**
     * @return Returns the medianPrice2007.
     */
    public Double getMedianPrice2007() {
        return medianPrice2007;
    }
    /**
     * @param medianPrice2007 The medianPrice2007 to set.
     */
    public void setMedianPrice2007(Double medianPrice2007) {
        this.medianPrice2007 = medianPrice2007;
    }
    
    // DBB 1-20-2009 Add 2008, 2009
    /**
     * @return Returns the averagePrice2008.
     */
    public Double getAveragePrice2008() {
        return averagePrice2008;
    }
    /**
     * @param averagePrice2008 The averagePrice2008 to set.
     */
    public void setAveragePrice2008(Double averagePrice2008) {
        this.averagePrice2008 = averagePrice2008;
    }
    
    /**
     * @return Returns the medianPrice2008.
     */
    public Double getMedianPrice2008() {
        return medianPrice2008;
    }
    /**
     * @param medianPrice2008 The medianPrice2008 to set.
     */
    public void setMedianPrice2008(Double medianPrice2008) {
        this.medianPrice2008 = medianPrice2008;
    }
    
    /**
     * @return Returns the averagePrice2009.
     */
    public Double getAveragePrice2009() {
        return averagePrice2009;
    }
    /**
     * @param averagePrice2007 The averagePrice2007 to set.
     */
    public void setAveragePrice2009(Double averagePrice2009) {
        this.averagePrice2009 = averagePrice2009;
    }
    /**
     * @return Returns the medianPrice2009.
     */
    public Double getMedianPrice2009() {
        return medianPrice2009;
    }
    /**
     * @param medianPrice2009 The medianPrice2009 to set.
     */
    public void setMedianPrice2009(Double medianPrice2009) {
        this.medianPrice2009 = medianPrice2009;
    }
    
    /**
     * @return Returns the averagePrice2010.
     */
    public Double getAveragePrice2010() {
        return averagePrice2010;
    }
    /**
     * @param averagePrice2007 The averagePrice2007 to set.
     */
    public void setAveragePrice2010(Double averagePrice2010) {
        this.averagePrice2010 = averagePrice2010;
    }
    /**
     * @return Returns the medianPrice2009.
     */
    public Double getMedianPrice2010() {
        return medianPrice2010;
    }
    /**
     * @param medianPrice2009 The medianPrice2009 to set.
     */
    public void setMedianPrice2010(Double medianPrice2010) {
        this.medianPrice2010 = medianPrice2010;
    }
    
    public Double getAveragePrice2011() {
        return averagePrice2011;
    }
    /**
     * @param averagePrice2007 The averagePrice2007 to set.
     */
    public void setAveragePrice2011(Double averagePrice2011) {
        this.averagePrice2011 = averagePrice2011;
    }
    /**
     * @return Returns the medianPrice2009.
     */
    public Double getMedianPrice2011() {
        return medianPrice2011;
    }
    /**
     * @param medianPrice2009 The medianPrice2009 to set.
     */
    public void setMedianPrice2011(Double medianPrice2011) {
        this.medianPrice2011 = medianPrice2011;
    }
    
}
