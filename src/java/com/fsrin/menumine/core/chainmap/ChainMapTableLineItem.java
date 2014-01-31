/*
 * Created on Jul 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

/**
 * @author Nick
 * 
 *  
 */
public class ChainMapTableLineItem {

    private final String name;

    private final ChainMapTable table;

    private Long allChainCount = new Long(0);

    private Long chainCount = new Long(0);

    public ChainMapTableLineItem(String name, ChainMapTable table) {
        super();
        this.name = name;
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public Long getAllChainCount() {
        return allChainCount;
    }

    public void setAllChainCount(Long allChainCount) {
        this.allChainCount = allChainCount;
    }

    public Long getChainCount() {
        return chainCount;
    }

    public void setChainCount(Long chainCount) {
        this.chainCount = chainCount;
    }

    public void addChainCount(Long count) {
        if (count != null) {
            this.chainCount = new Long(this.chainCount.longValue()
                    + count.longValue());
        }

    }

    public void addAllChainCount(Long count) {
        if (count != null) {
            this.allChainCount = new Long(this.allChainCount.longValue()
                    + count.longValue());
        }
    }

    public Double getAllChainPercent() {
        Long totalAllChains = this.table.getTotalCount().getAllChainCount();
        Long myAllChains = this.getAllChainCount();

        if (totalAllChains.doubleValue() == 0.0
                || myAllChains.doubleValue() == 0.0) {
            return new Double(0.0);
        }

        double percent = myAllChains.doubleValue()
                / totalAllChains.doubleValue();

        return new Double(percent * 100.0);
    }

    public Double getChainPercent() {
        Long totalChains = this.table.getTotalCount().getChainCount();
        Long myChains = this.getChainCount();

        if (myChains.doubleValue() == 0.0 || totalChains.doubleValue() == 0.0) {
            return new Double(0.0);
        }

        double percent = myChains.doubleValue() / totalChains.doubleValue();

        return new Double(percent * 100.0);
    }

    public Double getIndex() {
        Double all = this.getAllChainPercent();
        Double chain = this.getChainPercent();

        if (all.doubleValue() == 0.0 || chain.doubleValue() == 0.0) {
            return new Double(0.0);
        }

        double index = (chain.doubleValue() / all.doubleValue()) * 100.0;

        if (index > 9999.0) {
            return new Double(9999.0);
        }

        return new Double(index);
    }

}