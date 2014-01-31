/*
 * Created on Jan 28, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat;

import com.fsrin.menumine.core.chainmap.ChainStateCount;
import com.fsrin.menumine.core.menumine.chain.AbstractChainInformationBean;


/**
 * 2006-01-28 Originally extended Chain.  Removed that.
 * 2006-02-06 RSC Added it back in -- needs it for the incidencetable builder/standard impl.
 * 2006-02-17 RSC Removed and switched to the AbstractChainInfo.  Hib was doing double queries
 * when you just extend Chain.
 * 
 * @author Reid
 * @author Nick
 *  
 */
public class ChainStat extends AbstractChainInformationBean {

    private Long id;
//    private String operationName;
    private String hqAddress;
    private String hqCity;
    private String hqState;
    private String hqZip;
    private String phone;
    private String fax;
    private String webSite;
    private String units2003;
    private String units2004;
    private String units2007;
    private String units2008;
    private String sales2003;
    private String sales2004;
    private String sales2007;
    private String sales2008;
    private String indusRankDoll04;
    private String indusRankDoll03;
    private String indusRankDoll07;
    private String indusRankDoll08;
    private String indusRankUnits04;
    private String indusRankUnits03;
    private String indusRankUnits07;
    private String indusRankUnits08;
    private String segRankDoll04;
    private String segRankDoll03;
    private String segRankDoll07;
    private String segRankDoll08;
    private String segRankUnits04;
    private String segRankUnits03;
    private String segRankUnits07;
    private String segRankUnits08;
    private String parentCo;
    private String parentAddress;
    private String parentState;
    private String parentCity;
    private String parentZip;
//    private String segment;
//    private String sectorName;
//    private String hqRegion;
//    private String operatorType;
//    private String countryLoc;
    
//    private Integer yearPutInDatabase;
    
    private ChainStateCount chainStateCount;
    
//    public String getOperationName() {
//        return operationName;
//    }
//    public void setOperationName(String chain) {
//        this.operationName = chain;
//    }
//    public String getCountryLoc() {
//        return countryLoc;
//    }
//    public void setCountryLoc(String countryLoc) {
//        this.countryLoc = countryLoc;
//    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getHqAddress() {
        return hqAddress;
    }
    public void setHqAddress(String hqAddress) {
        this.hqAddress = hqAddress;
    }
    public String getHqCity() {
        return hqCity;
    }
    public void setHqCity(String hqCity) {
        this.hqCity = hqCity;
    }
//    public String getHqRegion() {
//        return hqRegion;
//    }
//    public void setHqRegion(String hqRegion) {
//        this.hqRegion = hqRegion;
//    }
    public String getHqState() {
        return hqState;
    }
    public void setHqState(String hqState) {
        this.hqState = hqState;
    }
    public String getHqZip() {
        return hqZip;
    }
    public void setHqZip(String hqZip) {
        this.hqZip = hqZip;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIndusRankDoll03() {
        return indusRankDoll03;
    }
    public void setIndusRankDoll03(String indusRankDoll03) {
        this.indusRankDoll03 = indusRankDoll03;
    }
    public String getIndusRankDoll04() {
        return indusRankDoll04;
    }
    public void setIndusRankDoll04(String indusRankDoll04) {
        this.indusRankDoll04 = indusRankDoll04;
    }
    public String getIndusRankDoll07() {
        return indusRankDoll07;
    }
    public void setIndusRankDoll07(String indusRankDoll07) {
        this.indusRankDoll07 = indusRankDoll07;
    }
    public String getIndusRankDoll08() {
        return indusRankDoll08;
    }
    public void setIndusRankDoll08(String indusRankDoll08) {
        this.indusRankDoll08 = indusRankDoll08;
    }
    public String getIndusRankUnits03() {
        return indusRankUnits03;
    }
    public void setIndusRankUnits03(String indusRankUnits03) {
        this.indusRankUnits03 = indusRankUnits03;
    }
    public String getIndusRankUnits04() {
        return indusRankUnits04;
    }
    public void setIndusRankUnits04(String indusRankUnits04) {
        this.indusRankUnits04 = indusRankUnits04;
    }
    public String getIndusRankUnits07() {
        return indusRankUnits07;
    }
    public void setIndusRankUnits07(String indusRankUnits07) {
        this.indusRankUnits07 = indusRankUnits07;
    }
    public String getIndusRankUnits08() {
        return indusRankUnits08;
    }
    public void setIndusRankUnits08(String indusRankUnits08) {
        this.indusRankUnits08 = indusRankUnits08;
    }
//    public String getOperatorType() {
//        return operatorType;
//    }
//    public void setOperatorType(String operatorType) {
//        this.operatorType = operatorType;
//    }
    public String getParentAddress() {
        return parentAddress;
    }
    public void setParentAddress(String parentAddress) {
        this.parentAddress = parentAddress;
    }
    public String getParentCity() {
        return parentCity;
    }
    public void setParentCity(String parentCity) {
        this.parentCity = parentCity;
    }
    public String getParentCo() {
        return parentCo;
    }
    public void setParentCo(String parentCo) {
        this.parentCo = parentCo;
    }
    public String getParentState() {
        return parentState;
    }
    public void setParentState(String parentState) {
        this.parentState = parentState;
    }
    public String getParentZip() {
        return parentZip;
    }
    public void setParentZip(String parentZip) {
        this.parentZip = parentZip;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSales2003() {
        return sales2003;
    }
    public void setSales2003(String sales2003) {
        this.sales2003 = sales2003;
    }
    public String getSales2004() {
        return sales2004;
    }
    public void setSales2004(String sales2004) {
        this.sales2004 = sales2004;
    }
    public String getSales2007() {
        return sales2007;
    }
    public void setSales2007(String sales2007) {
        this.sales2007 = sales2007;
    }
    public String getSales2008() {
        return sales2008;
    }
    public void setSales2008(String sales2008) {
        this.sales2008 = sales2008;
    }
//    public String getSectorName() {
//        return sectorName;
//    }
//    public void setSectorName(String sectorName) {
//        this.sectorName = sectorName;
//    }
//    public String getSegment() {
//        return segment;
//    }
//    public void setSegment(String segment) {
//        this.segment = segment;
//    }
    public String getSegRankDoll03() {
        return segRankDoll03;
    }
    public void setSegRankDoll03(String segRankDoll03) {
        this.segRankDoll03 = segRankDoll03;
    }
    public String getSegRankDoll04() {
        return segRankDoll04;
    }
    public void setSegRankDoll04(String segRankDoll04) {
        this.segRankDoll04 = segRankDoll04;
    }
    public String getSegRankDoll07() {
        return segRankDoll07;
    }
    public void setSegRankDoll07(String segRankDoll07) {
        this.segRankDoll07 = segRankDoll07;
    }
    public String getSegRankDoll08() {
        return segRankDoll08;
    }
    public void setSegRankDoll08(String segRankDoll08) {
        this.segRankDoll08 = segRankDoll08;
    }
    public String getSegRankUnits03() {
        return segRankUnits03;
    }
    public void setSegRankUnits03(String segRankUnits03) {
        this.segRankUnits03 = segRankUnits03;
    }
    public String getSegRankUnits04() {
        return segRankUnits04;
    }
    public void setSegRankUnits04(String segRankUnits04) {
        this.segRankUnits04 = segRankUnits04;
    }
    public String getSegRankUnits07() {
        return segRankUnits07;
    }
    public void setSegRankUnits07(String segRankUnits07) {
        this.segRankUnits07 = segRankUnits07;
    }
    public String getSegRankUnits08() {
        return segRankUnits08;
    }
    public void setSegRankUnits08(String segRankUnits08) {
        this.segRankUnits08 = segRankUnits08;
    }
    public String getUnits2003() {
        return units2003;
    }
    public void setUnits2003(String units2003) {
        this.units2003 = units2003;
    }
    public String getUnits2004() {
        return units2004;
    }
    public void setUnits2004(String units2004) {
        this.units2004 = units2004;
    }
    public String getUnits2007() {
        return units2007;
    }
    public void setUnits2007(String units2007) {
        this.units2007 = units2007;
    }
    public String getUnits2008() {
        return units2008;
    }
    public void setUnits2008(String units2008) {
        this.units2008 = units2008;
    }
    public String getWebSite() {
        return webSite;
    }
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    public ChainStateCount getChainStateCount() {
        return chainStateCount;
    }
    public void setChainStateCount(ChainStateCount chainStateCount) {
        this.chainStateCount = chainStateCount;
    }
//    public Integer getYearPutInDatabase() {
//        return yearPutInDatabase;
//    }
//    public void setYearPutInDatabase(Integer yearPutInDatabase) {
//        this.yearPutInDatabase = yearPutInDatabase;
//    }
    
    /*
     * 2006-02-07 RSC Using for incidence tables. 
     * 
     *  (non-Javadoc)
     * @see com.fsrin.menumine.core.menumine.chain.Chain#getOperationName()
     */
//    public String getOperationName(){
//        return this.chain;
//    }
    
    
}