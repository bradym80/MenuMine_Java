/*
 * Created on Jan 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.io.Serializable;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;

/**
 * @author Nick
 * 
 * 
 */
public class MasterFoodFilterParametersWrapperImpl extends FilterWrapper
        implements Serializable, MasterFoodFilterParametersWrapper {

    private MasterFoodFilterParameters masterFoodFilterParameters = new MasterFoodFilterParametersImpl();

    public MasterFoodFilterParametersWrapperImpl() {
        super();
    }

    public MasterFoodFilterParametersWrapperImpl(
            MasterFoodFilterParameters element) {
        super();
        masterFoodFilterParameters = element;
    }

    public MasterFoodFilterParameters getMasterFoodFilterParameters() {
        return masterFoodFilterParameters;
    }

    /*
     * 2006-02-06
     *  (non-Javadoc)
     * @see com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper#getBasicProtein()
     */
//    public ChainFilterParametersWrapper getChain() {
//        return new ChainFilterParametersWrapper(masterFoodFilterParameters
//                .getChain());
//    }

    public FilterParameterWrapper getKeywords() {

        return new FilterParameterWrapper(this.getMasterFoodFilterParameters()
                .getKeywords());
    }
    
    public FilterParameterWrapper getBasicProtein() {

        return new FilterParameterWrapper(this.getMasterFoodFilterParameters()
                .getBasicProtein());
    }

    public FilterParameterWrapper getBreadBakeGoodsMM() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBreadBakeGoodsMM());
    }

    public FilterParameterWrapper getCarboVegFruit() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCarboVegFruit());
    }

    public FilterParameterWrapper getCheeseMM() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCheeseMM());
    }

    public FilterParameterWrapper getCookMeth() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCookMeth());
    }

    public FilterParameterWrapper getCuisine() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCuisine());
    }

    public FilterParameterWrapper getCuisineFamily() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCuisineFamily());
    }

    public FilterParameterWrapper getFlavEnhancSeasBrdgDesIngredMM() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getFlavEnhancSeasBrdgDesIngredMM());
    }

    public FilterParameterWrapper getGenCookMeth() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getGenCookMeth());
    }

    public FilterParameterWrapper getGenMenuPart() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getGenMenuPart());
    }

    public FilterParameterWrapper getItemDescription() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getItemDescription());
    }

    public FilterParameterWrapper getMenuItem() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getMenuItem());
    }

    public FilterParameterWrapper getMenuItemClass() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getMenuItemClass());
    }

    public FilterParameterWrapper getMenuItemType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getMenuItemType());
    }

    public FilterParameterWrapper getMenuStatus() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getMenuStatus());
    }

    // public FilterParameterWrapper getProteinType() {
    // return new FilterParameterWrapper(masterFoodFilterParameters
    // .getProteinType());
    // }

    public FilterParameterWrapper getProteinTypeCut() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getProteinTypeCut());
    }
    
    // 2009-06-01 MJB added 9 protein fields below.
    
    public FilterParameterWrapper getChickenType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getChickenType());
    }
    
    public FilterParameterWrapper getBeefType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBeefType());
    }
    
    public FilterParameterWrapper getPorkType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPorkType());
    }
    
    public FilterParameterWrapper getFishType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getFishType());
    }
    
    public FilterParameterWrapper getSeafoodType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getSeafoodType());
    }
    
    public FilterParameterWrapper getLambType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getLambType());
    }
    
    public FilterParameterWrapper getTurkeyType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getTurkeyType());
    }
    
    public FilterParameterWrapper getOtherProteinType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getOtherProteinType());
    }
    
    public FilterParameterWrapper getShrimpType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getShrimpType());
    }

    public FilterParameterWrapper getSauceCondDressMarMM() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getSauceCondDressMarMM());
    }

    public FilterParameterWrapper getTopFillIngredMM() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getTopFillIngredMM());
    }

    // MJB 11-12-2009 Added 2010
    public FilterParameterWrapper getPrice2011() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2011());
    }
    public FilterParameterWrapper getPrice2010() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2010());
    }
    // DBB 1-20-2009 Add 2008, 2009
    public FilterParameterWrapper getPrice2009() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2009());
    }
    
    public FilterParameterWrapper getPrice2008() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2008());
    }
    
    public FilterParameterWrapper getPrice2006() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2006());
    }
    
    //JDL 10-5-07
    public FilterParameterWrapper getPrice2007() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2007());
    }
    
    public FilterParameterWrapper getPrice2005() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2005());
    }

    public FilterParameterWrapper getPrice2004() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2004());
    }

    public FilterParameterWrapper getPrice2003() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2003());
    }

    public FilterParameterWrapper getPrice2002() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2002());
    }

    public FilterParameterWrapper getPrice2001() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2001());
    }

    public FilterParameterWrapper getPrice2000() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice2000());
    }

    public FilterParameterWrapper getPrice1999() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice1999());
    }

    public FilterParameterWrapper getPrice1998() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice1998());
    }

    public FilterParameterWrapper getPrice1997() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice1997());
    }

    public FilterParameterWrapper getPrice1996() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrice1996());
    }

    public Long getLimit() {
        return masterFoodFilterParameters.getLimit();
    }

    public void setLimit(Long limit) {
        masterFoodFilterParameters.setLimit(limit);
    }

    public String getOrderBy() {
        return masterFoodFilterParameters.getOrderBy();
    }

    public boolean isSortAsc() {
        return masterFoodFilterParameters.isSortAsc();
    }

    public void setOrderBy(String orderBy) {
        masterFoodFilterParameters.setOrderBy(orderBy);
    }

    public void setSortAsc(boolean sortAsc) {
        masterFoodFilterParameters.setSortAsc(sortAsc);
    }

    public String getSortType() {
        if (this.masterFoodFilterParameters.isSortAsc()) {
            return "ASC";
        } else {
            return "DESC";
        }
    }

    public void setSortType(String sortType) {
        if (sortType.equals("ASC")) {
            this.masterFoodFilterParameters.setSortAsc(true);
        }
        if (sortType.equals("DESC")) {
            this.masterFoodFilterParameters.setSortAsc(false);
        }

    }

    public FilterParameterWrapper getBrand() {

        return new FilterParameterWrapper(masterFoodFilterParameters.getBrand());

    }

    public FilterParameterWrapper getCakeIngredient() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCakeIngredient());
    }

    public FilterParameterWrapper getCakeUse() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCakeUse());
    }

    public FilterParameterWrapper getCandyIngredient() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCandyIngredient());
    }

    public FilterParameterWrapper getCookieIngredient() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCookieIngredient());
    }

    public FilterParameterWrapper getCookieUse() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCookieUse());
    }

    public FilterParameterWrapper getDayPartCategory() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getDayPartCategory());
    }

    public FilterParameterWrapper getDessertDoughCrustIngred() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getDessertDoughCrustIngred());
    }

    public FilterParameterWrapper getFruitOrFruitFillingIngred() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getFruitOrFruitFillingIngred());
    }

    public FilterParameterWrapper getNutIngredient() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getNutIngredient());
    }

    public FilterParameterWrapper getPrimaryFlavor() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getPrimaryFlavor());
    }

    public FilterParameterWrapper getSyrupTopping() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getSyrupTopping());
    }

    public FilterParameterWrapper getTasteFlavorWords() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getTasteFlavorWords());
    }

    public FilterParameterWrapper getWhippedToppingIngred() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getWhippedToppingIngred());
    }

    public FilterParameterWrapper getIceCreamIngredient() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getIceCreamIngredient());
    }

    public FilterParameterWrapper getBreadUse() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBreadUse());

    }

    public FilterParameterWrapper getCarboMM() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCarboMM());

    }
    
    public FilterParameterWrapper getCarboAll() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCarboAll());

    }

    public FilterParameterWrapper getFlavApplication() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getFlavApplication());

    }

    public FilterParameterWrapper getFlavorSoup() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getFlavorSoup());

    }

    public FilterParameterWrapper getSideOrAccomp() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getSideOrAccomp());

    }

    public FilterParameterWrapper getVeggieFruitMM() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getVeggieFruitMM());

    }

    public FilterParameterWrapper getHealthyTerm() {

        return new FilterParameterWrapper(masterFoodFilterParameters
                .getHealthyTerm());
    }

    public FilterParameterWrapper getBatterBreadingCoating() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBatterBreadingCoating());
    }

    public FilterParameterWrapper getBreadWrapChips() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBreadWrapChips());
    }

    public FilterParameterWrapper getButterApplication() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getButterApplication());
    }

    public FilterParameterWrapper getCarboAccompName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCarboAccompName());
    }

    public FilterParameterWrapper getCarboTopName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCarboTopName());
    }

    public FilterParameterWrapper getCarboType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCarboType());
    }

    public FilterParameterWrapper getCheeseCheeseSauceFillingType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCheeseCheeseSauceFillingType());
    }

    public FilterParameterWrapper getCheeseRollUp() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCheeseRollUp());
    }

    public FilterParameterWrapper getCondiments() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCondiments());
    }

    public FilterParameterWrapper getCookingSauceOrGravy() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getCookingSauceOrGravy());
    }

    public FilterParameterWrapper getDairyButterCream() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getDairyButterCream());
    }

    public FilterParameterWrapper getOnionScallionLeek() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getOnionScallionLeek());
    }
    
    public FilterParameterWrapper getMushroomType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getMushroomType());
    }
    
    public FilterParameterWrapper getTomatoType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getTomatoType());
    }
    
    public FilterParameterWrapper getDipSauceName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getDipSauceName());
    }
    
    public FilterParameterWrapper getDressings() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getDressings());
    }

    public FilterParameterWrapper getFruitType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getFruitType());
    }

    public FilterParameterWrapper getGlaze() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getGlaze());
    }

    public FilterParameterWrapper getGreenVegName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getGreenVegName());
    }

    public FilterParameterWrapper getMarinade() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getMarinade());
    }

    public FilterParameterWrapper getProteinAccompName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getProteinAccompName());
    }

    public FilterParameterWrapper getProteinTopName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getProteinTopName());
    }

    public FilterParameterWrapper getSeasoningName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getSeasoningName());
    }

    public FilterParameterWrapper getStuffName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getStuffName());
    }

    public FilterParameterWrapper getVegAccompName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getVegAccompName());
    }

    public FilterParameterWrapper getVeggieFruitType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getVeggieFruitType());
    }

    public FilterParameterWrapper getVegTopName() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getVegTopName());
    }

    public FilterParameterWrapper getBevSize() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBevSize());
    }

    public FilterParameterWrapper getBreakCakeWaff() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBreakCakeWaff());
    }

    public FilterParameterWrapper getBreakfastPastry() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getBreakfastPastry());
    }

    public FilterParameterWrapper getEggType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getEggType());
    }

    public FilterParameterWrapper getHotColdCereal() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getHotColdCereal());
    }

    public FilterParameterWrapper getLogoImageStyle() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getLogoImageStyle());
    }

    public FilterParameterWrapper getServingCount() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getServingCount());
    }

    public FilterParameterWrapper getSpreadType() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getSpreadType());
    }

    /*
     * 2006-01-17 RSC (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.menumine.webwork.MasterFoodFilterParametersWrapper#getProteinFishShrimpSeafood()
     */
    public FilterParameterWrapper getProteinFishShrimpSeafood() {
        return new FilterParameterWrapper(masterFoodFilterParameters
                .getProteinFishShrimpSeafood());
    }

    /*
     * 2006-02-06 RSC
     */
    public FilterParameterWrapper getCountryLoc() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getCountryLoc());
    }
    
    public FilterParameterWrapper getHqRegion() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getHqRegion());
    }

    public FilterParameterWrapper getHqState() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getHqState());
    }

    public FilterParameterWrapper getOperationName() {
     return new FilterParameterWrapper(masterFoodFilterParameters.getOperationName());
    }

    public FilterParameterWrapper getOperatorType() {
     return new FilterParameterWrapper(masterFoodFilterParameters.getOperatorType());   
    }

    public FilterParameterWrapper getSectorName() {
return new FilterParameterWrapper(masterFoodFilterParameters.getSectorName());        
    }

    public FilterParameterWrapper getSegment() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getSegment());
    }

    public FilterParameterWrapper getYearPutInDatabase() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getYearPutInDatabase());
    }
    
    public FilterParameterWrapper getYearPutInDatabaseSameStore() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getYearPutInDatabaseSameStore());
    }

    public FilterParameterWrapper getChainID() {
        return new FilterParameterWrapper(masterFoodFilterParameters.getChainID());
    }

    public FilterParameterWrapper getOtherIngredName() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getOtherIngredName());
    }

    public FilterParameterWrapper getOtherToppings() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getOtherToppings());
    }

    public FilterParameterWrapper getOtherTopIngred() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getOtherTopIngred());
    }

    public FilterParameterWrapper getOtherAccompaniments() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getOtherAccompaniments());
    }

    public FilterParameterWrapper getHealthyFlag() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getHealthyFlag());
    }

    public FilterParameterWrapper getHealthySymbol() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getHealthySymbol());
    }

    public FilterParameterWrapper getFillingSaucesDressings() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getFillingSaucesDressings());
    }

    public FilterParameterWrapper getCuisineVerySpecific() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getCuisineVerySpecific());
    }

    public FilterParameterWrapper getGrillRoastSmoke() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getGrillRoastSmoke());
    }

    public FilterParameterWrapper getVegCookMeth() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getVegCookMeth());
    }

    public FilterParameterWrapper getCookSauceType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getCookSauceType());
    }

    public FilterParameterWrapper getDressingType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getDressingType());
    }

    public FilterParameterWrapper getDressingFlavor() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getDressingFlavor());
    }

    public FilterParameterWrapper getMexBreadType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getMexBreadType());
    }

    public FilterParameterWrapper getRoastVegItemType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getRoastVegItemType());
    }

    public FilterParameterWrapper getAppetClassTyp() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getAppetClassTyp());
    }

    public FilterParameterWrapper getPrepEntreeType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getPrepEntreeType());
    }

    public FilterParameterWrapper getBreadedFriedAppSide() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getBreadedFriedAppSide());
    }

    public FilterParameterWrapper getPotatoTypeUse() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getPotatoTypeUse());
    }

    public FilterParameterWrapper getSalsaType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getSalsaType());
    }

    public FilterParameterWrapper getCookieLookAlikeDessert() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getCookieLookAlikeDessert());
    }

    public FilterParameterWrapper getBreakfastToGo() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getBreakfastToGo());
    }

    public FilterParameterWrapper getPizzaStyle() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getPizzaStyle());
    }

    public FilterParameterWrapper getBbqCook() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getBbqCook());
    }

    public FilterParameterWrapper getEthnicBreadType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getEthnicBreadType());
    }

    public FilterParameterWrapper getPepperType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getPepperType());
    }

    public FilterParameterWrapper getRiceTypeUse() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getRiceTypeUse());
    }

    public FilterParameterWrapper getMexIngredUse() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getMexIngredUse());
    }

    public FilterParameterWrapper getFlavorChangeAnyYear() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getFlavorChangeAnyYear());
    }
    
    public FilterParameterWrapper getNewItemBrag() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getNewItemBrag());
    }

    public FilterParameterWrapper getProteinFlavorApp() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getProteinFlavorApp());
    }

    public FilterParameterWrapper getOilTypeUse() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getOilTypeUse());
    }
    
    public FilterParameterWrapper getEggItemUse() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getEggItemUse());
    }

    public FilterParameterWrapper getCheeseForm() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getCheeseForm());
    }

    public FilterParameterWrapper getCheeseSauceFillingType() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getCheeseSauceFillingType());
    }    
    
    public FilterParameterWrapper getSoupWith() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getSoupWith());
    }

    public FilterParameterWrapper getSoupBaseBroth() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getSoupBaseBroth());
    }

    public FilterParameterWrapper getVeggieAll() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getVeggieAll());
    }
    
    public FilterParameterWrapper getAllVegCarbFruit() {
        
    	return new FilterParameterWrapper(masterFoodFilterParameters.getAllVegCarbFruit());
    }	

//JDL 05-21-08 don't know how i missed this earlier
    public FilterParameterWrapper getTextureAttrib() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getTextureAttrib());
    }
    
    public FilterParameterWrapper getCreamyFill() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getCreamyFill());
    }
    
    public FilterParameterWrapper getCreamyTop() {
        
        return new FilterParameterWrapper(masterFoodFilterParameters.getCreamyTop());
    }

    public FilterParameterWrapper getBevMenuItem() {
    
    	return new FilterParameterWrapper(masterFoodFilterParameters.getBevMenuItem());
    }
    public FilterParameterWrapper getSideAccompDisFlavor() {
    
    	return new FilterParameterWrapper(masterFoodFilterParameters.getSideAccompDisFlavor());
    }

    public FilterParameterWrapper getCookieTypeSource() {
    
    	return new FilterParameterWrapper(masterFoodFilterParameters.getCookieTypeSource());
    }

    public FilterParameterWrapper getQualityStyle() {
    
    	return new FilterParameterWrapper(masterFoodFilterParameters.getQualityStyle());
    }	


}