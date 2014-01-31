/*
 * Created on Sep 14, 2006 by Reid
 */
package com.fsrin.menumine.core.incidence.trend;

public class IncidenceTrendItem implements Comparable {

    private String name;

    
    private double incidence2011;
    
    private double incidence2010;
    // DBB 1-20-2009 Add 2008, 2009
    private double incidence2009;
    
    private double incidence2008;
    
    //JDL 10-5-07
    private double incidence2007;
    
    private double incidence2006;

    private double incidence2005;

    private double incidence2004;

    private double incidence2003;

    private double incidence2002;

    private double incidence2001;

    private double incidence2000;

    private double incidence1999;

    private double incidence1998;

    private double incidence1997;

    private double incidence1996;

    public double getIncidence1996() {
        return incidence1996;
    }

    public void setIncidence1996(double incidence1996) {
        this.incidence1996 = incidence1996;
    }

    public double getIncidence1997() {
        return incidence1997;
    }

    public void setIncidence1997(double incidence1997) {
        this.incidence1997 = incidence1997;
    }

    public double getIncidence1998() {
        return incidence1998;
    }

    public void setIncidence1998(double incidence1998) {
        this.incidence1998 = incidence1998;
    }

    public double getIncidence1999() {
        return incidence1999;
    }

    public void setIncidence1999(double incidence1999) {
        this.incidence1999 = incidence1999;
    }

    public double getIncidence2000() {
        return incidence2000;
    }

    public void setIncidence2000(double incidence2000) {
        this.incidence2000 = incidence2000;
    }

    public double getIncidence2001() {
        return incidence2001;
    }

    public void setIncidence2001(double incidence2001) {
        this.incidence2001 = incidence2001;
    }

    public double getIncidence2002() {
        return incidence2002;
    }

    public void setIncidence2002(double incidence2002) {
        this.incidence2002 = incidence2002;
    }

    public double getIncidence2003() {
        return incidence2003;
    }

    public void setIncidence2003(double incidence2003) {
        this.incidence2003 = incidence2003;
    }

    public double getIncidence2004() {
        return incidence2004;
    }

    public void setIncidence2004(double incidence2004) {
        this.incidence2004 = incidence2004;
    }

    public double getIncidence2005() {
        return incidence2005;
    }

    public void setIncidence2005(double incidence2005) {
        this.incidence2005 = incidence2005;
    }

    public double getIncidence2006() {
        return incidence2006;
    }

    public void setIncidence2006(double incidence2006) {
        this.incidence2006 = incidence2006;
    }
    
    //JDL 10-5-07
    public double getIncidence2007() {
        return incidence2007;
    }

    public void setIncidence2007(double incidence2007) {
        this.incidence2007 = incidence2007;
    }
    
    // DBB 1-20-2009 Add 2008, 2009
    public double getIncidence2008() {
        return incidence2008;
    }
    
    public void setIncidence2008(double incidence2008) {
        this.incidence2008 = incidence2008;
    }
    
    public double getIncidence2009() {
        return incidence2009;
    }
    
    public void setIncidence2009(double incidence2009) {
        this.incidence2009 = incidence2009;
    }
    
    public double getIncidence2010() {
        return incidence2010;
    }
    
    public void setIncidence2010(double incidence2010) {
        this.incidence2010 = incidence2010;
    }
    
    public double getIncidence2011() {
        return incidence2011;
    }
    
    public void setIncidence2011(double incidence2011) {
        this.incidence2011 = incidence2011;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * just want to alphabetize
     */
    public int compareTo(Object arg0) {

        IncidenceTrendItem test = (IncidenceTrendItem) arg0;

        if (this.getName() != null) {
            return this.getName().compareTo(test.getName());
        }
        
        return 0;
    }

}
