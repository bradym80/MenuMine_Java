/*
 * Created on Mar 30, 2005
 *
 * 
 */
package net.sf.hibernate.loader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.core.menumine.chain.Chain;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public class FiveSticksMasterFoodHydrator implements FiveSticksHydrator {

    private static Log log = LogFactory.getLog(FiveSticksMasterFoodHydrator.class);
    

    public void hydrate(Object object, Object[] values) {
        if (values.length != 84) {
            throw new RuntimeException(
                    "HBM must have changed!  Please update FiveSticksMasterFoodHydrator " +
                    "to reflect changes.");
        }

        MasterFood masterFood = (MasterFood) object;

//        LogFactory.getLog(this.getClass()).info("Hydrating");
        log.info("Hydrating.");
        ((MasterFood) object).setChainID((Integer) values[0]);

        if (values[1] instanceof Chain) {
            masterFood.setChain((Chain) values[1]);
        }
        masterFood.setMenuStatus((String) values[2]);
        masterFood.setMenuItem((String) values[3]);
        masterFood.setMenuItemType((String) values[4]);
        masterFood.setGenMenuPart((String) values[5]);
        masterFood.setMenuItemClass((String) values[6]);
        masterFood.setItemDescription((String) values[7]);
        masterFood.setProteinTypeCut((String) values[8]);
        masterFood.setProteinType((String) values[9]);
        masterFood.setBasicProtein((String) values[10]);
        masterFood.setGenCookMeth((String) values[11]);
        masterFood.setCookMeth((String) values[12]);
        masterFood.setCuisine((String) values[13]);
        masterFood.setCuisineFamily((String) values[14]);
        masterFood.setPrice2005((Double) values[15]);
        masterFood.setPrice2004((Double) values[16]);
        masterFood.setPrice2003((Double) values[17]);
        masterFood.setPrice2002((Double) values[18]);
        masterFood.setPrice2001((Double) values[19]);
        masterFood.setPrice2000((Double) values[20]);
        masterFood.setPrice1999((Double) values[21]);
        masterFood.setPrice1998((Double) values[22]);
        masterFood.setPrice1997((Double) values[23]);
        masterFood.setPrice1996((Double) values[24]);
        masterFood.setCarboVegFruit((String) values[25]);
        masterFood.setSauceCondDressMarMM((String) values[26]);
        masterFood.setFlavEnhancSeasBrdgDesIngredMM((String) values[27]);
        masterFood.setTopFillIngredMM((String) values[28]);
        masterFood.setCheeseMM((String) values[29]);
        masterFood.setBreadBakeGoodsMM((String) values[30]);

        masterFood.setDayPartCategory((String) values[31]);
        masterFood.setCakeIngredient((String) values[32]);
        masterFood.setCakeUse((String) values[32]);
        masterFood.setCookieIngredient((String) values[34]);
        masterFood.setCookieUse((String) values[35]);
        masterFood.setDessertDoughCrustIngred((String) values[36]);
        masterFood.setIceCreamIngredient((String) values[37]);
        masterFood.setSyrupTopping((String) values[38]);
        masterFood.setNutIngredient((String) values[39]);
        masterFood.setFruitorFruitFillingIngred((String) values[40]);

        masterFood.setWhippedToppingIngred((String) values[41]);
        masterFood.setCandyIngredient((String) values[42]);
        masterFood.setPrimaryFlavor((String) values[43]);
        masterFood.setTasteFlavorWords((String) values[44]);
        masterFood.setBrand((String) values[45]);

        masterFood.setVeggieFruitMM((String) values[46]);
        masterFood.setCarboMM((String) values[47]);
        masterFood.setBreadUse((String) values[48]);
        masterFood.setFlavApplication((String) values[49]);
        masterFood.setFlavorSoup((String) values[50]);
        masterFood.setSideOrAccomp((String) values[51]);

        masterFood.setHealthyTerm((String) values[52]);

        masterFood.setCookingSauceOrGravy((String) values[53]);

        masterFood.setMarinade((String) values[54]);

        masterFood.setGlaze((String) values[55]);

        masterFood.setDressings((String) values[56]);

        masterFood.setDipSauceName((String) values[57]);

        masterFood.setCondiments((String) values[58]);

        masterFood.setButterApplication((String) values[59]);

        masterFood.setSeasoningName((String) values[60]);

        masterFood.setBatterBreadingCoating((String) values[61]);

        masterFood.setStuffName((String) values[62]);

        masterFood.setCheeseRollUp((String) values[63]);

        masterFood.setCheeseCheeseSauceFillingType((String) values[64]);

        masterFood.setProteinTopName((String) values[65]);

        masterFood.setProteinAccompName((String) values[66]);

        masterFood.setVeggieFruitType((String) values[67]);

        masterFood.setGreenVegName((String) values[68]);

        masterFood.setVegTopName((String) values[69]);

        masterFood.setVegAccompName((String) values[70]);

        masterFood.setFruitType((String) values[71]);

        masterFood.setCarboType((String) values[72]);

        masterFood.setCarboTopName((String) values[73]);

        masterFood.setCarboAccompName((String) values[74]);

        masterFood.setBreadWrapChips((String) values[75]);

        masterFood.setEggType((String) values[76]);
        masterFood.setHotColdCereal((String) values[77]);

        masterFood.setSpreadType((String) values[78]);
        masterFood.setBreakfastPastry((String) values[79]);
        masterFood.setBreakCakeWaff((String) values[80]);

        masterFood.setLogoImageStyle((String) values[81]);
        masterFood.setBevSize((String) values[82]);
        masterFood.setServingCount((String) values[83]);

    }

}