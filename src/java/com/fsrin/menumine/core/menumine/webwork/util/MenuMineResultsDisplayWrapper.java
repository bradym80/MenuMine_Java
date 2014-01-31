/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork.util;

import java.text.DecimalFormat;

/**
 * @author Nick
 * 
 * 
 */
public class MenuMineResultsDisplayWrapper {

    private Object value1;

    private Object value2;

    private Object value3;

    private Object value4;

    private Object value5;

    private Object value6;

    private Object value7;
    
    private Object value8;
    
    private Object value9;
    
    private Object value10;
    
    private Object value11;
  
    private Object value12;
    
    private Object value13;
    
    private Object value14;
    
    private Object value15;

    public MenuMineResultsDisplayWrapper() {
        super();

    }

    public Object getValue1() {
        return prepareWordClickable(value1, header.getValue1().getAndName());
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public Object getValue2() {

        return prepareWordClickable(value2, header.getValue2().getAndName());
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    public Object getValue3() {
        return prepareWordClickable(value3, header.getValue3().getAndName());
    }

    public void setValue3(Object value3) {
        this.value3 = value3;
    }

    public Object getValue4() {
        return prepareWordClickable(value4, header.getValue4().getAndName());
    }

    public void setValue4(Object value4) {
        this.value4 = value4;
    }

    public Object getValue5() {
        if (this.header.getValue5() != null) {
            return prepareWordClickable(value5, header.getValue5().getAndName());
        }
        return "";
    }

    public void setValue5(Object value5) {
        this.value5 = value5;
    }

    public Object getValue6() {
        if (this.header.getValue6() != null) {
            return prepareWordClickable(value6, header.getValue6().getAndName());
        }
        return "";
    }

    public void setValue6(Object value6) {
        this.value6 = value6;
    }

    public Object getValue7() {
        if (this.header.getValue7() != null) {
            return prepareWordClickable(value7, header.getValue7().getAndName());
        }
        return "";
    }

    public void setValue7(Object value7) {
        this.value7 = value7;
    }

    public Object getValue1Clean() {
        return value1;
    }

    public Object getValue2Clean() {
        return value2;
    }

    public Object getValue3Clean() {
        return value3;
    }

    public Object getValue4Clean() {
        return value4;
    }

    public Object getValue5Clean() {
        return value5;
    }

    public Object getValue6Clean() {
        return value6;
    }

    public Object getValue7Clean() {
        return value7;
    }
    
    public Object getValue8Clean() {
        return value8;
    }
    
    public Object getValue9Clean() {
        return value9;
    }
    
    public Object getValue10Clean() {
        return value10;
    }    
    
    public Object getValue11Clean() {
        return value11;
    }   
    
    public Object getValue12Clean() {
        return value12;
    }   
    
    public Object getValue13Clean() {
        return value13;
    }   
    
    public Object getValue14Clean() {
        return value14;
    }   
    
    public Object getValue15Clean() {
        return value15;
    }   
    

    private String prepareWordClickable(Object value, String header) {
        if (value == null) {
            return "";
        }
        StringBuffer ret = new StringBuffer();
        String stringValue = value.toString();

        /*
         * We don't work click on price fields.
         * 2006-03-10 RSC But we do need them to be a decent format.
         */
        if (header.toLowerCase().indexOf("price") >= 0) {
            return DecimalFormat.getCurrencyInstance().format(((Double)value).doubleValue());
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

                    /*
                     * If the tok2 has a " in it, we get java script errors.
                     */
                    tok2 = tok2.replaceAll("\"", "");
                    ret.append(
                            "<a href=\"javascript:handleFilterByWord('"
                                    + "mp.").append(header).append("','")
                            .append(tok2).append(
                                    "');\" class=\"javascriptLink\">").append(
                                    tok2).append("</a>");
                } else {
                    /*
                     * 2006-03-08 RSC WC3 Validation
                     */
                    if (tok.equals("&"))
                        ret.append(" &amp; ");
                    else
                        ret.append(" ").append(tok).append(" ");
                }
            }
        }

        return ret.toString();

    } /*
         * We need to keep the header so the workclick can decide what like
         * field to populate.
         */

    private MenuMineResultsDisplayWrapperHeader header;

    public void setHeader(MenuMineResultsDisplayWrapperHeader header) {
        this.header = header;
    }

    public Object getValue10() {
        if (this.header.getValue10() != null) {
            return prepareWordClickable(value10, header.getValue10().getAndName());
        }
        return "";
    }

    public void setValue10(Object value10) {
        this.value10 = value10;
    }

    public Object getValue8() {
        if (this.header.getValue8() != null) {
            return prepareWordClickable(value8, header.getValue8().getAndName());
        }
        return "";
    }

    public void setValue8(Object value8) {
        this.value8 = value8;
    }

    public Object getValue9() {
        if (this.header.getValue9() != null) {
            return prepareWordClickable(value9, header.getValue9().getAndName());
        }
        return "";
    }

    public void setValue9(Object value9) {
        this.value9 = value9;
    }

    public Object getValue11() {
        if (this.header.getValue11() != null) {
            return prepareWordClickable(value11, header.getValue11().getAndName());
        }
        return "";
    }

    public void setValue11(Object value11) {
        this.value11 = value11;
    }

    public Object getValue12() {
        if (this.header.getValue12() != null) {
            return prepareWordClickable(value12, header.getValue12().getAndName());
        }
        return "";
    }

    public void setValue12(Object value12) {
        this.value12 = value12;
    }

    public Object getValue13() {
        if (this.header.getValue13() != null) {
            return prepareWordClickable(value13, header.getValue13().getAndName());
        }
        return "";
    }

    public void setValue13(Object value13) {
        this.value13 = value13;
    }

    public Object getValue14() {
        if (this.header.getValue14() != null) {
            return prepareWordClickable(value14, header.getValue14().getAndName());
        }
        return "";
    }

    public void setValue14(Object value14) {
        this.value14 = value14;
    }

    public Object getValue15() {
        if (this.header.getValue15() != null) {
            return prepareWordClickable(value15, header.getValue15().getAndName());
        }
        return "";
    }

    public void setValue15(Object value15) {
        this.value15 = value15;
    }
}