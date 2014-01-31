/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.util;

import java.text.NumberFormat;

public class GroupCounterVO implements ItemCountAwareIF {

    private Integer count;

    private String group;

    private Integer distinctCount;

    private Double share;

    public GroupCounterVO(Integer count, String group) {
        this.count = count;
        this.group = group;
    }

    public GroupCounterVO(Integer count, Double group) {
        this.count = count;
        if (group == null)
            this.group = "0.00";
        else
            this.group = NumberFormat.getCurrencyInstance().format(
                    group.doubleValue());
    }

    public GroupCounterVO(Integer count, Integer group) {
        this.count = count;
        if (group == null)
            this.group = "";
        else
            this.group = group.toString();
    }

    public GroupCounterVO(Integer count, int group) {
        this.count = count;
        this.group = new Integer(group).toString();
    }

    public GroupCounterVO(Integer count, String group, Integer distinctCount) {
        this.count = count;
        this.group = group;
        this.distinctCount = distinctCount;
    }

    /**
     * @return Returns the count.
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     *            The count to set.
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return Returns the group.
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group
     *            The group to set.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return Returns the share.
     */
    public Double getShare() {
        return share;
    }

    /**
     * @param share
     *            The share to set.
     */
    public void setShare(Double share) {
        this.share = share;
    }

    public Integer getDistinctCount() {
        return distinctCount;
    }

    public void setDistinctCount(Integer distinctCount) {
        this.distinctCount = distinctCount;
    }

}
