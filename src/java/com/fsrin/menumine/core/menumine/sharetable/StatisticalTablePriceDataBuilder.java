/*
 * Created on Feb 3, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

public class StatisticalTablePriceDataBuilder {

    private int sizeOne;

    private int sizeTwo;

    public StatisticalTablePriceDataIF buildCombined(
            StatisticalTablePriceDataIF one, int sampleSizeOne,
            StatisticalTablePriceDataIF two, int sampleSizeTwo) {

        this.sizeOne = sampleSizeOne;
        this.sizeTwo = sampleSizeTwo;

        StatisticalTablePriceDataAggregationImpl ret = new StatisticalTablePriceDataAggregationImpl();

        if (one == null && two == null)
            return ret;
        
        if (one == null) { one = new StatisticalTablePriceDataAggregationImpl(); }
        if (two == null) { two = new StatisticalTablePriceDataAggregationImpl(); }
        
        ret.setAveragePrice1996(getAverage(one.getAveragePrice1996(), two
                .getAveragePrice1996()));
        ret.setAveragePrice1997(getAverage(one.getAveragePrice1997(), two
                .getAveragePrice1997()));
        ret.setAveragePrice1998(getAverage(one.getAveragePrice1998(), two
                .getAveragePrice1998()));
        ret.setAveragePrice1999(getAverage(one.getAveragePrice1999(), two
                .getAveragePrice1999()));
        ret.setAveragePrice2000(getAverage(one.getAveragePrice2000(), two
                .getAveragePrice2000()));
        ret.setAveragePrice2001(getAverage(one.getAveragePrice2001(), two
                .getAveragePrice2001()));
        ret.setAveragePrice2002(getAverage(one.getAveragePrice2002(), two
                .getAveragePrice2002()));
        ret.setAveragePrice2003(getAverage(one.getAveragePrice2003(), two
                .getAveragePrice2003()));
        ret.setAveragePrice2004(getAverage(one.getAveragePrice2004(), two
                .getAveragePrice2004()));
        ret.setAveragePrice2005(getAverage(one.getAveragePrice2005(), two
                .getAveragePrice2005()));
        ret.setAveragePrice2006(getAverage(one.getAveragePrice2006(), two
                .getAveragePrice2006()));  
        //JDL 10-5-07
        ret.setAveragePrice2007(getAverage(one.getAveragePrice2007(), two
                .getAveragePrice2007())); 
        
        // DBB 1-20-2009 Add 2008, 2009        
        ret.setAveragePrice2008(getAverage(one.getAveragePrice2008(), 
        		two.getAveragePrice2008()));
        ret.setAveragePrice2009(getAverage(one.getAveragePrice2009(),
        		two.getAveragePrice2009()));
        // MJB 11-12-2009 Added 2010
        ret.setAveragePrice2010(getAverage(one.getAveragePrice2010(),
        		two.getAveragePrice2010()));
        ret.setAveragePrice2011(getAverage(one.getAveragePrice2011(),
        		two.getAveragePrice2011()));
        

        ret.setMedianPrice1996(getMedian(one.getMedianPrice1996(), two
                .getMedianPrice1996()));
        ret.setMedianPrice1997(getMedian(one.getMedianPrice1997(), two
                .getMedianPrice1997()));
        ret.setMedianPrice1998(getMedian(one.getMedianPrice1998(), two
                .getMedianPrice1998()));
        ret.setMedianPrice1999(getMedian(one.getMedianPrice1999(), two
                .getMedianPrice1999()));
        ret.setMedianPrice2000(getMedian(one.getMedianPrice2000(), two
                .getMedianPrice2000()));
        ret.setMedianPrice2001(getMedian(one.getMedianPrice2001(), two
                .getMedianPrice2001()));
        ret.setMedianPrice2002(getMedian(one.getMedianPrice2002(), two
                .getMedianPrice2002()));
        ret.setMedianPrice2003(getMedian(one.getMedianPrice2003(), two
                .getMedianPrice2003()));
        ret.setMedianPrice2004(getMedian(one.getMedianPrice2004(), two
                .getMedianPrice2004()));
        ret.setMedianPrice2005(getMedian(one.getMedianPrice2005(), two
                .getMedianPrice2005()));
        ret.setMedianPrice2006(getMedian(one.getMedianPrice2006(), two
                .getMedianPrice2006())); 
        //JDL 10-5-07
        ret.setMedianPrice2007(getMedian(one.getMedianPrice2007(), two
                .getMedianPrice2007()));
        
        // DBB 1-20-2009 Add 2008, 2009
        ret.setMedianPrice2008(getMedian(one.getMedianPrice2008(),
        		two.getMedianPrice2008()));
        ret.setMedianPrice2009(getMedian(one.getMedianPrice2009(),
        		two.getMedianPrice2009()));
        // MJB 11-12-2009 Added 2010
        ret.setMedianPrice2010(getMedian(one.getMedianPrice2010(),
        		two.getMedianPrice2010()));
        ret.setMedianPrice2011(getMedian(one.getMedianPrice2011(),
        		two.getMedianPrice2011()));
        return ret;
    }

    public Double getAverage(Double one, Double two) {

        return StatisticalTableUtil.getAverageAverage(one,two, sizeOne,sizeTwo);
        

    }

    public Double getMedian(Double one, Double two) {

        return getAverage(one, two);
    }
}
