/*
 * Created on Mar 24, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import ognl.Ognl;
import ognl.OgnlException;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.webwork.util.PriceVO;

/**
 * @author Nick
 * 
 *  
 */
public class StatisticalTableUtil {

    public StatisticalTableUtil() {
        super();

    }

    public Double getAve(double total, int countOfItemsWithPrice) {

        if (countOfItemsWithPrice == 0) {
            return new Double(0);
        }

        return new Double(total / ((double) countOfItemsWithPrice));
    }

    public Double getMedianPrice(String ognl, Collection results) {

        
        TreeSet set = new TreeSet(new MMSorter().getAscending(ognl, "id"));

        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            try {
                Double price = (Double) Ognl.getValue(ognl, element);
                if (price != null && price.doubleValue() > 0.0) {
                    set.add(element);
                }
            } catch (OgnlException e) {

                e.printStackTrace();

            }
        }

        int size = set.size();
        try {
            /*
             * If odd
             */
            if (size == 0) {
                return new Double(0.0);
            }
            if (size % 2 != 0) {
                MasterFood mf = (MasterFood) set.toArray()[size / 2];


                return (Double) Ognl.getValue(ognl, mf);

            } else {
                MasterFood mf = (MasterFood) set.toArray()[size / 2];
                MasterFood mf2 = (MasterFood) set.toArray()[(size / 2) - 1];

                return new Double((((Double) Ognl.getValue(ognl, mf))
                        .doubleValue() + ((Double) Ognl.getValue(ognl, mf2))
                        .doubleValue()) / 2);

            }

        } catch (OgnlException e) {

            e.printStackTrace();
            return new Double(-1.0);
        }

    }

    public String prepareWordClickable(Object value, String header) {
        if (value == null) {
            return "";
        }
        StringBuffer ret = new StringBuffer();
        String stringValue = value.toString();

        /*
         * We don't work click on price fields.
         */
        if (header.toLowerCase().indexOf("price") >= 0) {
            return value.toString();
        }

        String[] tokens = stringValue.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String tok = tokens[i];

            /*
             * nick 2005-2-16 if we have a ' in the word click, it causes a
             * javascript error.
             */
            String[] toks = tok.split("'");
            for (int j = 0; j < toks.length; j++) {
                if (j > 0) {
                    ret.append("'");
                } else {
                    ret.append(" ");
                }
                String tok2 = toks[j];

                if (tok.length() > 2) {
                    ret
                            .append("<a href=\"javascript:handleFilterByWord('"
                                    + "mp."
                                    + header
                                    + "','"
                                    + tok2
                                    + "');\" class=\"javascriptLink\">"
                                    + tok2
                                    + "</a>");

                } else {
                    ret.append(" " + tok + " ");
                }
            }
        }

        return ret.toString();

    }

    public Double getAveragePrice(String ognl, Collection results) {

        double total = 0.0;
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            try {
                Double price = (Double) Ognl.getValue(ognl, element);
                if (price != null && price.doubleValue() > 0.0) {
                    total += price.doubleValue();
                }
            } catch (OgnlException e) {

                e.printStackTrace();

            }

        }
        return this.getAve(total, results.size());

    }

    public Double getMedianPrice(TreeSet set) {
        int size = set.size();

        /*
         * If odd
         */
        if (size == 0) {
            return new Double(0.0);
        }
        if (size % 2 != 0) {
            PriceVO d = (PriceVO) set.toArray()[size / 2];

            long timeEnd = new Date().getTime();
            //  LogFactory.getLog(this.getClass()).info("Got Median in " +
            // (timeEnd-timeStart));
            return d.getPrice();

        } else {
            PriceVO d = (PriceVO) set.toArray()[size / 2];
            PriceVO d2 = (PriceVO) set.toArray()[(size / 2) - 1];

            return new Double((d.getPrice().doubleValue() + d2.getPrice()
                    .doubleValue()) / 2.0);

        }

    }

    public Double getAveragePrice(TreeSet set) {

        double total = 0.0;
        for (Iterator iter = set.iterator(); iter.hasNext();) {
            PriceVO element = (PriceVO) iter.next();
            total += element.getPrice().doubleValue();
        }
        return this.getAve(total, set.size());
    }
    
    public static Double getAverageAverage(Double one, Double two, int sizeOne, int sizeTwo) {

        double p1 = 0.0;
        if (one != null) {
            p1 = one.doubleValue();
        }

        double p2 = 0.0;
        if (two != null) {
            p2 = two.doubleValue();
        }

        double r = (p1 * ((double) sizeOne) + p2
                * ((double) sizeTwo))
                / ((double) sizeOne + (double) sizeTwo);

        return new Double(r);
    }

}