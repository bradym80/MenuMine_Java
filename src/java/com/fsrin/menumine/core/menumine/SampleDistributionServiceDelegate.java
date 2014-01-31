/*
 * Created on Jan 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine;

import java.util.ArrayList;
import java.util.Collection;

import ognl.OgnlException;

import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDaoAware;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;

/**
 * @author Nick
 * 
 * This class is used to get the values to populate the selection boxes for the
 * main list. Rather then put each method in the service delegate we collect
 * them here.
 */
public class SampleDistributionServiceDelegate implements MasterFoodDaoAware {

    public static final String SPRING_BEAN_NAME = "sampleDistributionServiceDelegate";

    private Collection results;

    private MasterFoodDao masterFoodDao;

    private StatisticalTableIF marketSegment;

    private StatisticalTableIF marketSector;

    private StatisticalTableIF menuPart;

    private StatisticalTableIF basicProtein;

    private StatisticalTableIF cuisineOfItem;

    private StatisticalTableIF cookingMethod;

    private StatisticalTableIF operationName;

    private StatisticalTableIF cuisineFamily;

    private StatisticalTableIF genCookingMethod;

    public synchronized StatisticalTableIF getMenuPartDistribution()
            throws OgnlException {

        if (menuPart == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.MENU_PART.getOgnlName());

            menuPart = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }
        return menuPart;
    }

    public synchronized StatisticalTableIF getMarketSectorDistribution()
            throws OgnlException {
        if (marketSector == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.MARKET_SECTOR.getOgnlName());
            marketSector = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }
        return marketSector;
    }

    public synchronized StatisticalTableIF getMarketSegmentDistribution()
            throws OgnlException {
        if (marketSegment == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.MARKET_SEGMENT.getOgnlName());

            marketSegment = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }
        return marketSegment;
    }

    public synchronized StatisticalTableIF getBasicProteinDistribution()
            throws OgnlException {
        if (basicProtein == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.BASIC_PROTEIN.getOgnlName());

            basicProtein = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }
        return basicProtein;
    }

    public synchronized StatisticalTableIF getCuisineOfItemDistribution()
            throws OgnlException {
        if (cuisineOfItem == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.CUISINE.getOgnlName());

            cuisineOfItem = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }
        return cuisineOfItem;
    }

    public synchronized StatisticalTableIF getCookingMethodDistribution()
            throws OgnlException {
        if (cookingMethod == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.COOKING_METHOD.getOgnlName());

            cookingMethod = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }
        return cookingMethod;
    }

    public synchronized StatisticalTableIF getOperationNameDistribution()
            throws OgnlException {

        //operationName = null;
        if (operationName == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.OPERATION_NAME.getOgnlName());

            operationName = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }
        return operationName;
    }

    public MasterFoodDao getMasterFoodDao() {
        return masterFoodDao;
    }

    public void setMasterFoodDao(MasterFoodDao masterFoodDao) {
        this.masterFoodDao = masterFoodDao;
    }

    public synchronized StatisticalTableIF getCuisineFamilyDistribution()
            throws OgnlException {
        if (cuisineFamily == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.CUISINE_FAMILY.getOgnlName());

            cuisineFamily = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }

        return cuisineFamily;

    }

    public synchronized StatisticalTableIF getGenCookingMethodDistribution()
            throws OgnlException {
        if (genCookingMethod == null) {
            MenuMineGraphOptions option = new MenuMineGraphOptions();
            option.setGraphByField(FieldEnum.GEN_COOKING_METHOD.getOgnlName());

            genCookingMethod = new StatisticalTableBuilder()
                    .buildStatisticalTableFromCollection_WithoutAggregation(this.getData(),
                            option, new RollUpOptions());
        }

        return genCookingMethod;
    }

    private synchronized Collection getData() {

        if (results == null) {

            results = new ArrayList();
            MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();

            Collection col = this.getMasterFoodDao().findUsingCriteria(params);
            //            Collection pageCol =
            // this.getMasterFoodDao().getPageableResults(
            //                    params);
            //           
            //            for (Iterator iter = pageCol.iterator(); iter.hasNext();) {
            //                MasterFood element = (MasterFood) iter.next();
            //                results.add(element);
            //            }

            results = col;

        }

        return results;
    }

    public Integer getCount() {

        int i = this.getData().size();
        return new Integer(i);
    }
}