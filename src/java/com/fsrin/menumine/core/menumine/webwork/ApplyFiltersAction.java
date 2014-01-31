/*
 * Created on May 4, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.menumine.sharetable.filters.ActionFilterSettings;

/**
 * 2006-05-04 RSC Really this is just a placeholder so the user can apply filters.
 * 
 * @author Reid
 */
public class ApplyFiltersAction extends AbstractMenuMineDisplayAction {

    private ActionFilterSettings filterSettings = new ActionFilterSettings();

    public String execute() throws Exception {
        
        /*
         * update values based on filter settings
         */
        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setFilterNone(this.getFilterSettings().isFilterNone());

        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setFilterBelowPercentage(
                        this.getFilterSettings().isFilterLowPass());

        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setFilterAbovePercentage(
                        this.getFilterSettings().isFilterHighPass());

        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setFilterCombination(
                        this.getFilterSettings().isFilterCombination());

        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setFilterCommonTerms(
                        this.getFilterSettings().isFilterCommonTerms());

        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setFilterKeywordRow(
                        this.getFilterSettings().isFilterKeywordRow());

        this.getMenuMineSessionContextWrapper().getLastGraphOptions()
                .setFilterConsolidateByTerms(
                        this.getFilterSettings()
                                .isFilterConsolidateByTerms());
        
        if (this.getMenuMineSessionContextWrapper().getLastDisplayOptions().getDisplayType().equals(MenuMineDisplayStatisticalTableAction.STATISTICAL_TABLE)) {
            return SUCCESS + ".single";
        }
        if (this.getMenuMineSessionContextWrapper().getLastDisplayOptions().getDisplayType().equals(MenuMineDisplayStatisticalTableActionV2.MULTIPLE_STATISTICAL_TABLE)) {
            return SUCCESS + ".multi";
        }
        if (this.getMenuMineSessionContextWrapper().getLastDisplayOptions().getDisplayType().equals(MenuMineDisplayOptions.DISPLAY_TYPE_GRAPH)) {
            return SUCCESS + ".graph";
        }
        return SUCCESS;
        
    }

    public ActionFilterSettings getFilterSettings() {
        return filterSettings;
    }

    public void setFilterSettings(ActionFilterSettings filterSettings) {
        this.filterSettings = filterSettings;
    }
}
