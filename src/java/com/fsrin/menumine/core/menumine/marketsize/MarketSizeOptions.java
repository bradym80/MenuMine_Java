/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize;



public class MarketSizeOptions {

    /*
     * 2006-07-25 These numbers are from Joe.
     * 
     */
    private MarketSizeOptionDetail chainOptions = new MarketSizeOptionDetail(20,1.0,365);
    
    private MarketSizeOptionDetail independentOptions = new MarketSizeOptionDetail(15,1.0,365);
    
    private MarketSizeOptionDetail nonCommercialOptions = new MarketSizeOptionDetail(200,1.0,100);

    private final double CONVERSION_POUND = 0.0625;
    
    private final double CONVERSION_GALLONS = 0.0078125;
    
    private String resultMeasurement = "weight";
    
    /**
     * @return Returns the chainOptions.
     */
    public MarketSizeOptionDetail getChainOptions() {
        return chainOptions;
    }

    /**
     * @param chainOptions The chainOptions to set.
     */
    public void setChainOptions(MarketSizeOptionDetail chainOptions) {
        this.chainOptions = chainOptions;
    }

    /**
     * @return Returns the independentOptions.
     */
    public MarketSizeOptionDetail getIndependentOptions() {
        return independentOptions;
    }

    /**
     * @param independentOptions The independentOptions to set.
     */
    public void setIndependentOptions(MarketSizeOptionDetail independentOptions) {
        this.independentOptions = independentOptions;
    }

    /**
     * @return Returns the nonCommercialOptions.
     */
    public MarketSizeOptionDetail getNonCommercialOptions() {
        return nonCommercialOptions;
    }

    /**
     * @param nonCommercialOptions The nonCommercialOptions to set.
     */
    public void setNonCommercialOptions(MarketSizeOptionDetail nonCommercialOptions) {
        this.nonCommercialOptions = nonCommercialOptions;
    }
    
    public MarketSizeOptionDetail getByName(String segmentName) {
        
        MarketSizeOptionDetail ret = this.getChainOptions();
        
        if (segmentName.indexOf("Indep") > -1) {
            ret = this.getIndependentOptions();
        } else if (segmentName.indexOf("Non-Com") > -1) {
            ret = this.getNonCommercialOptions();
        }
        
        return ret;
    }

    /**
     * @return Returns the resultMeasurement.
     */
    public String getResultMeasurement() {
        return resultMeasurement;
    }

    /**
     * @param resultMeasurement The resultMeasurement to set.
     */
    public void setResultMeasurement(String resultMeasurement) {
        this.resultMeasurement = resultMeasurement;
   }
    
    public double getResultConversion() {
        if (this.resultMeasurement.equalsIgnoreCase("weight")) {
            return this.CONVERSION_POUND;
        } else {
            return this.CONVERSION_GALLONS;
        }
    }
    
    public String getResultLabel() {
        if (this.resultMeasurement.equalsIgnoreCase("weight")) {
            return "pounds";
        } else {
            return "gallons";
        }
    }    
}
