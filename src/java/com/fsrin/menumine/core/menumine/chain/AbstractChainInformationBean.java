/*
 * Created on Feb 7, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.chain;

public abstract class AbstractChainInformationBean {

    public static final String UNKNOWN_OPERATION_KEY = "N/A";
    
    public static final String UNKNOWN_SEGMENT_KEY = "N/A";
    
    public static final String UNKNOWN_SECTOR_KEY = "N/A";
    
    private String sectorName;
    
    private String segment;
    
    private String operationName;
    
    private Integer yearPutInDatabase;
    
    private String hqState;
    
    private String hqRegion;
    
    private String operatorType;
    
    private String countryLoc;

    public String getCountryLoc() {
        return countryLoc;
    }

    public void setCountryLoc(String countryLoc) {
        this.countryLoc = countryLoc;
    }

    public String getHqRegion() {
        return hqRegion;
    }

    public void setHqRegion(String hqRegion) {
        this.hqRegion = hqRegion;
    }

    public String getHqState() {
        return hqState;
    }

    public void setHqState(String hqState) {
        this.hqState = hqState;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public Integer getYearPutInDatabase() {
        return yearPutInDatabase;
    }

    public void setYearPutInDatabase(Integer yearPutInDatabase) {
        this.yearPutInDatabase = yearPutInDatabase;
    }
    
}
