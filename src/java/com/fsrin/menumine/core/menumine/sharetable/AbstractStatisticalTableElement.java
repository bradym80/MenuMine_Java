/*
 * Created on Jan 27, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.sharetable;

public abstract class AbstractStatisticalTableElement {

    public static final String NONE = "None";

    public static final String NOT_ON_MENU = "Not on menu.";

    private String name;

    private StatisticalTableIF parentTable;

    private String nameWordClickable;

    public StatisticalTableIF getParentTable() {
        return parentTable;
    }

    public void setParentTable(StatisticalTableIF parentTable) {
        this.parentTable = parentTable;
    }

    public String getNameWordClickable() {
        // return new StatisticalTableUtil().prepareWordClickable(name, this
        // .getFieldEnum().getAndName());

        if (nameWordClickable == null) {
            if (this.getName() != null) {
                String ret = this.getName().replaceAll("'", "&apos;");
                ret.replaceAll("&", "and");
                nameWordClickable = ret;
            } else {
                nameWordClickable = NONE;
            }
        }

        return nameWordClickable;

    }

    public String getNameWordClickableShort() {
        // return new StatisticalTableUtil().prepareWordClickable(name, this
        // .getFieldEnum().getAndName());
        String ret = this.getNameWordClickable();
        
        if (ret.length() > 15) {
            ret = ret.substring(0,14) + "...";
        }
        
        return ret;

    }

    public String getName() {
        if (name == null)
            return NONE;

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {

        return new Integer(this.getNumberInSample().intValue());
    }

    public abstract Long getNumberInSample();
}
