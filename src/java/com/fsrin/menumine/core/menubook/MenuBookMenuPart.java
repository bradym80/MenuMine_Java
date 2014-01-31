/*
 * Created on Mar 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menubook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 * 
 */
public class MenuBookMenuPart {

    /*
     * Appetizer, Center of Plate, ect.
     */
    private String name;

    /*
     * Collection of MasterFood records
     */
    private Collection menuItems = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getMenuItems() {
        return menuItems;
    }
    
    // MJB 08-29-11 add price 2011
    public Double getMedianPrice2011() {
        Double ret = this.getMedianPrice("price2011");

        return ret;
    }
    
    public Double getMedianPrice2010() {
        Double ret = this.getMedianPrice("price2010");

        return ret;
    }
    // DBB 1-20-2009 Add 2008, 2009
    public Double getMedianPrice2009() {
        Double ret = this.getMedianPrice("price2009");

        return ret;
    }
    
    public Double getMedianPrice2008() {
        Double ret = this.getMedianPrice("price2008");

        return ret;
    }
    
    //JDL 10-5-07
    public Double getMedianPrice2007() {
        Double ret = this.getMedianPrice("price2007");

        return ret;
    }

    public Double getMedianPrice2006() {
        Double ret = this.getMedianPrice("price2006");

        return ret;
        
//        return this.getMedianPrice("price2005");
    }
    
    public Double getMedianPrice2005() {
        Double ret = this.getMedianPrice("price2005");

        return ret;
        
//        return this.getMedianPrice("price2005");
    }

    public Double getMedianPrice2004() {

        Double ret = this.getMedianPrice("price2004");
        
        return ret;
        // return this.getMedianPrice("price2004");
    }

    public Double getMedianPrice2003() {
        return this.getMedianPrice("price2003");
    }

    public Double getMedianPrice2002() {
        return this.getMedianPrice("price2002");
    }

    public Double getMedianPrice2001() {
        return this.getMedianPrice("price2001");
    }

    public Double getMedianPrice2000() {
        return this.getMedianPrice("price2000");
    }

    public Double getMedianPrice1999() {
        return this.getMedianPrice("price1999");
    }

    public Double getMedianPrice1998() {
        return this.getMedianPrice("price1998");
    }

    public Double getMedianPrice1997() {
        return this.getMedianPrice("price1997");
    }

    public Double getMedianPrice1996() {
        return this.getMedianPrice("price1996");
    }

    public Double getMedianPrice(String ognl) {

        Collection c = new ArrayList();
        for (Iterator iter = this.menuItems.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            try {
                Double price = (Double) Ognl.getValue(ognl, element);
                if (price != null && price.doubleValue() > 0.0) {
                    c.add(price);
                }
            } catch (OgnlException e) {

                e.printStackTrace();

            }
        }

        double sum = 0.0;

        for (Iterator iter = c.iterator(); iter.hasNext();) {
            Double element = (Double) iter.next();
            sum += element.doubleValue();
        }

        Double ret = new Double(0.0);

        if (sum > 0 && c.size() > 0) {
            ret = new Double(sum / (double) c.size());
        }

//        System.out.println("avg: " + ognl + " " + ret.toString());
        return ret;



    }
}