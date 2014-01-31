/*
 * Created on Mar 24, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.webwork.util.PriceVO;
import com.fsrin.menumine.core.menumine.webwork.util.PriceVOComparator;

/**
 * @author Nick
 * 
 *  
 */
public class StatisticalTablePriceDataStandardImpl implements StatisticalTablePriceDataIF {

    private Collection results = new ArrayList();
    
    private TreeSet prices2011 = new TreeSet(new PriceVOComparator());
    // DBB 1-20-2009 Add 2008, 2009
    private TreeSet prices2010 = new TreeSet(new PriceVOComparator());
    // mjb 11-12-2009 added 2010
    private TreeSet prices2009 = new TreeSet(new PriceVOComparator());
    
    private TreeSet prices2008 = new TreeSet(new PriceVOComparator());
    
    private TreeSet prices2007 = new TreeSet(new PriceVOComparator());
    
    private TreeSet prices2006 = new TreeSet(new PriceVOComparator());
    
    private TreeSet prices2005 = new TreeSet(new PriceVOComparator());

    private TreeSet prices2004 = new TreeSet(new PriceVOComparator());

    private TreeSet prices2003 = new TreeSet(new PriceVOComparator());

    private TreeSet prices2002 = new TreeSet(new PriceVOComparator());

    private TreeSet prices2001 = new TreeSet(new PriceVOComparator());

    private TreeSet prices2000 = new TreeSet(new PriceVOComparator());

    private TreeSet prices1999 = new TreeSet(new PriceVOComparator());

    private TreeSet prices1998 = new TreeSet(new PriceVOComparator());

    private TreeSet prices1997 = new TreeSet(new PriceVOComparator());

    private TreeSet prices1996 = new TreeSet(new PriceVOComparator());

    // MJB 11-12-2009 Add 2010
    private Double averagePrice2011;
    private Double averagePrice2010;
    // DBB 1-20-2009 Add 2008, 2009
    private Double averagePrice2009;
    
    private Double averagePrice2008;
    
    private Double averagePrice2006;
    
    //JDL 10-5-07
    private Double averagePrice2007;
    
    private Double averagePrice2005;

    private Double averagePrice2004;

    private Double averagePrice2003;

    private Double averagePrice2002;

    private Double averagePrice2001;

    private Double averagePrice2000;

    private Double averagePrice1999;

    private Double averagePrice1998;

    private Double averagePrice1997;

    private Double averagePrice1996;
    
    // MJB 11-12-2009
    private Double medianPrice2011;
    
    private Double medianPrice2010;
    // DBB 1-20-2009
    private Double medianPrice2009;
    
    private Double medianPrice2008;

    private Double medianPrice2006;
    //JDL 10-5-07
    private Double medianPrice2007;
    
    private Double medianPrice2005;

    private Double medianPrice2004;

    private Double medianPrice2003;

    private Double medianPrice2002;

    private Double medianPrice2001;

    private Double medianPrice2000;

    private Double medianPrice1999;

    private Double medianPrice1998;

    private Double medianPrice1997;

    private Double medianPrice1996;
    
    private final Double defaultValue = new Double(0.0);

    public Double getAveragePrice1996() {
        if (averagePrice1996 == null) {

            averagePrice1996 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices1996);
        }
        if (averagePrice1996 == null)
            averagePrice1996 = defaultValue;
        
        return averagePrice1996;
    }

    //    public void setAvgPrice1996(Double avgPrice1996) {
    //        this.avgPrice1996 = avgPrice1996;
    //    }
    public Double getAveragePrice1997() {
        if (averagePrice1997 == null) {

            averagePrice1997 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices1997);
        }
        
        if (averagePrice1997 == null)
            averagePrice1997 = defaultValue;
        
        return averagePrice1997;
    }

    //    public void setAvgPrice1997(Double avgPrice1997) {
    //        this.avgPrice1997 = avgPrice1997;
    //    }
    public Double getAveragePrice1998() {
        if (averagePrice1998 == null) {

            averagePrice1998 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices1998);
        }
        
        if (averagePrice1998 == null)
            averagePrice1998 = defaultValue;
        
        return averagePrice1998;
    }

    //    public void setAvgPrice1998(Double avgPrice1998) {
    //        this.avgPrice1998 = avgPrice1998;
    //    }
    public Double getAveragePrice1999() {
        if (averagePrice1999 == null) {

            averagePrice1999 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices1999);
        }
        
        if (averagePrice1999 == null)
            averagePrice1999 = defaultValue;
        
        return averagePrice1999;
    }

    //    public void setAvgPrice1999(Double avgPrice1999) {
    //        this.avgPrice1999 = avgPrice1999;
    //    }
    public Double getAveragePrice2000() {
        if (averagePrice2000 == null) {

            averagePrice2000 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2000);
        }
        
        if (averagePrice2000 == null)
            averagePrice2000 = defaultValue;
        
        return averagePrice2000;
    }

    //    public void setAvgPrice2000(Double avgPrice2000) {
    //        this.avgPrice2000 = avgPrice2000;
    //    }
    public Double getAveragePrice2001() {
        if (averagePrice2001 == null) {

            averagePrice2001 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2001);
        }
        
        if (averagePrice2001 == null)
            averagePrice2001 = defaultValue;
        
        return averagePrice2001;
    }

    //    public void setAvgPrice2001(Double avgPrice2001) {
    //        this.avgPrice2001 = avgPrice2001;
    //    }
    public Double getAveragePrice2002() {
        if (averagePrice2002 == null) {

            averagePrice2002 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2002);
        }
        
        if (averagePrice2002 == null)
            averagePrice2002 = defaultValue;
        
        return averagePrice2002;
    }

    //    public void setAvgPrice2002(Double avgPrice2002) {
    //        this.avgPrice2002 = avgPrice2002;
    //    }
    public Double getAveragePrice2003() {
        if (averagePrice2003 == null) {

            averagePrice2003 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2003);
        }
        
        if (averagePrice2003 == null)
            averagePrice2003 = defaultValue;
        
        return averagePrice2003;
    }

    //    public void setAvgPrice2003(Double avgPrice2003) {
    //        this.avgPrice2003 = avgPrice2003;
    //    }
    public Double getAveragePrice2004() {
        if (averagePrice2004 == null) {

            averagePrice2004 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2004);
        }
        
        if (averagePrice2004 == null)
            averagePrice2004 = defaultValue;
        
        return averagePrice2004;
    }

    public Double getAveragePrice2005() {
        if (averagePrice2005 == null) {

            averagePrice2005 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2005);
        }
        
        if (averagePrice2005 == null)
            averagePrice2005 = defaultValue;
        
        return averagePrice2005;
    }

    public Double getAveragePrice2006() {
        if (averagePrice2006 == null) {

            averagePrice2006 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2006);
        }
        
        if (averagePrice2006 == null)
            averagePrice2006 = defaultValue;
        
        return averagePrice2006;
    }
    
    //JDL 10-507
    public Double getAveragePrice2007() {
        if (averagePrice2007 == null) {

            averagePrice2007 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2007);
        }
        
        if (averagePrice2007 == null)
            averagePrice2007 = defaultValue;
        
        return averagePrice2007;
    }
    
    // DBB 1-20-2009 Add 2008, 2009
    public Double getAveragePrice2008() {
        if (averagePrice2008 == null) {

            averagePrice2008 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2008);
        }
        
        if (averagePrice2008 == null)
            averagePrice2008 = defaultValue;
        
        return averagePrice2008;
    }
    
    public Double getAveragePrice2009() {
        if (averagePrice2009 == null) {

            averagePrice2009 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2009);
        }
        
        if (averagePrice2009 == null)
            averagePrice2009 = defaultValue;
        
        return averagePrice2009;
    }
    //MJB 11-12-2009 Added 2010
    public Double getAveragePrice2010() {
        if (averagePrice2010 == null) {

            averagePrice2010 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2010);
        }
        
        if (averagePrice2010 == null)
            averagePrice2010 = defaultValue;
        
        return averagePrice2010;
    }
    public Double getAveragePrice2011() {
        if (averagePrice2011 == null) {

            averagePrice2011 = new StatisticalTableUtil()
                    .getAveragePrice(this.prices2011);
        }
        
        if (averagePrice2011 == null)
            averagePrice2011 = defaultValue;
        
        return averagePrice2011;
    }
    //    public void setAvgPrice2004(Double avgPrice2004) {
    //        this.avgPrice2004 = avgPrice2004;
    //    }
    public Double getMedianPrice1996() {
        if (medianPrice1996 == null) {

            medianPrice1996 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices1996);
        }
        
        if (medianPrice1996 == null)
            medianPrice1996 = defaultValue;
        
        return medianPrice1996;
    }

    //    public void setMedianPrice1996(Double medianPrice1996) {
    //        this.medianPrice1996 = medianPrice1996;
    //    }
    public Double getMedianPrice1997() {
        if (medianPrice1997 == null) {

            medianPrice1997 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices1997);
        }
        
        if (medianPrice1997 == null)
            medianPrice1997 = defaultValue;
        
        return medianPrice1997;
    }

    //    public void setMedianPrice1997(Double medianPrice1997) {
    //        this.medianPrice1997 = medianPrice1997;
    //    }
    public Double getMedianPrice1998() {
        if (medianPrice1998 == null) {

            medianPrice1998 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices1998);
        }
        if (medianPrice1998 == null)
            medianPrice1998 = defaultValue;
        
        return medianPrice1998;
    }

    //    public void setMedianPrice1998(Double medianPrice1998) {
    //        this.medianPrice1998 = medianPrice1998;
    //    }
    public Double getMedianPrice1999() {
        if (medianPrice1999 == null) {

            medianPrice1999 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices1999);
        }
        
        if (medianPrice1999 == null)
            medianPrice1999 = defaultValue;
        
        return medianPrice1999;
    }

    //    public void setMedianPrice1999(Double medianPrice1999) {
    //        this.medianPrice1999 = medianPrice1999;
    //    }
    public Double getMedianPrice2000() {
        if (medianPrice2000 == null) {

            medianPrice2000 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2000);
        }
        
        if (medianPrice2000 == null)
            medianPrice2000 = defaultValue;
        
        return medianPrice2000;
    }

    //    public void setMedianPrice2000(Double medianPrice2000) {
    //        this.medianPrice2000 = medianPrice2000;
    //    }
    public Double getMedianPrice2001() {
        if (medianPrice2001 == null) {

            medianPrice2001 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2001);
        }
        
        if (medianPrice2001 == null)
            medianPrice2001 = defaultValue;
        
        return medianPrice2001;
    }

    //    public void setMedianPrice2001(Double medianPrice2001) {
    //        this.medianPrice2001 = medianPrice2001;
    //    }
    public Double getMedianPrice2002() {
        if (medianPrice2002 == null) {

            medianPrice2002 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2002);
        }
        if (medianPrice2002 == null)
            medianPrice2002 = defaultValue;
        
        return medianPrice2002;
    }

    //    public void setMedianPrice2002(Double medianPrice2002) {
    //        this.medianPrice2002 = medianPrice2002;
    //    }
    public Double getMedianPrice2003() {
        if (medianPrice2003 == null) {

            medianPrice2003 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2003);
        }
        
        if (medianPrice2003 == null)
            medianPrice2003 = defaultValue;
        
        return medianPrice2003;

    }

    //    public void setMedianPrice2003(Double medianPrice2003) {
    //        this.medianPrice2003 = medianPrice2003;
    //    }
    public Double getMedianPrice2004() {
        if (medianPrice2004 == null) {

            medianPrice2004 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2004);
        }
        
        if (medianPrice2004 == null)
            medianPrice2004 = defaultValue;
        
        return medianPrice2004;
    }

    public Double getMedianPrice2005() {
        if (medianPrice2005 == null) {

            medianPrice2005 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2005);
        }
        
        if (medianPrice2005 == null)
            medianPrice2005 = defaultValue;
        
        return medianPrice2005;
    }
    
    public Double getMedianPrice2006() {
        if (medianPrice2006 == null) {

            medianPrice2006 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2006);
        }
        
        if (medianPrice2006 == null)
            medianPrice2006 = defaultValue;
        
        return medianPrice2006;
    } 
    
    //JDL 10-5-07
    public Double getMedianPrice2007() {
        if (medianPrice2007 == null) {

            medianPrice2007 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2007);
        }
        
        if (medianPrice2007 == null)
            medianPrice2007 = defaultValue;
        
        return medianPrice2007;
    }
    
    // DBB 1-20-2009 Add 2008, 2009
    public Double getMedianPrice2008() {
        if (medianPrice2008 == null) {

            medianPrice2008 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2008);
        }
        
        if (medianPrice2008 == null)
            medianPrice2008 = defaultValue;
        
        return medianPrice2008;
    }
    
    public Double getMedianPrice2009() {
        if (medianPrice2009 == null) {

            medianPrice2009 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2009);
        }
        
        if (medianPrice2009 == null)
            medianPrice2009 = defaultValue;
        
        return medianPrice2009;
    }
    //MJB 11-12-2009 Added 2010
    public Double getMedianPrice2010() {
        if (medianPrice2010 == null) {

            medianPrice2010 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2010);
        }
        
        if (medianPrice2010 == null)
            medianPrice2010 = defaultValue;
        
        return medianPrice2010;
    }
    public Double getMedianPrice2011() {
        if (medianPrice2011 == null) {

            medianPrice2011 = new StatisticalTableUtil()
                    .getMedianPrice(this.prices2011);
        }
        
        if (medianPrice2011 == null)
            medianPrice2011 = defaultValue;
        
        return medianPrice2011;
    }
    //    public void setMedianPrice2004(Double medianPrice2004) {
    //        this.medianPrice2004 = medianPrice2004;
    //    }
    public Collection getResults() {
        return results;
    }

    public void addMasterFood(MasterFood mf) {

        addPrice(this.prices1996, mf.getPrice1996());
        addPrice(this.prices1997, mf.getPrice1997());
        addPrice(this.prices1998, mf.getPrice1998());
        addPrice(this.prices1999, mf.getPrice1999());
        addPrice(this.prices2000, mf.getPrice2000());
        addPrice(this.prices2001, mf.getPrice2001());
        addPrice(this.prices2002, mf.getPrice2002());
        addPrice(this.prices2003, mf.getPrice2003());
        addPrice(this.prices2004, mf.getPrice2004());
        addPrice(this.prices2005, mf.getPrice2005());
        addPrice(this.prices2006, mf.getPrice2006());
        addPrice(this.prices2007, mf.getPrice2007());
        
        // DBB 1-20-2009 Add 2008, 2009
        addPrice(this.prices2008, mf.getPrice2008());
        addPrice(this.prices2009, mf.getPrice2009());
        // MJB 11-12-2009 Added 2010
        addPrice(this.prices2010, mf.getPrice2010());
        addPrice(this.prices2011, mf.getPrice2011());
    }

    private void addPrice(TreeSet set, Double price) {

        if (price != null && price.doubleValue() != 0.0) {
            PriceVO vo = new PriceVO(price, set.size());
            set.add(vo);
        }
    }
    
    private void addPrice2(TreeSet set, Float price) {

        if (price != null && price.doubleValue() != 0.0) {
            PriceVO vo = new PriceVO(price.doubleValue(), set.size());
            set.add(vo);
        }
    }


}