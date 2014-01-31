/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize.xwork;

import com.fsrin.menumine.core.menumine.marketsize.MarketSizeIncidenceTable;
import com.fsrin.menumine.core.menumine.marketsize.MarketSizeOptions;
import com.opensymphony.xwork.Action;

public class DisplayMarketSizeProjectorAction extends AbstractMarketSizeAction {

    private String submitMarketSize;

    private String submitMarketSizeBar;

    private String submitMarketSizePie;

    MarketSizeOptions options = new MarketSizeOptions();

    public String execute() throws Exception {

        if (this.getSubmitMarketSizeBar() != null
                || this.getSubmitMarketSizePie() != null) {
            return Action.SUCCESS + ".graph";
        }

        if (this.getSubmitMarketSize() != null) {

            MarketSizeIncidenceTable marketSizeIncidenceTable = this
                    .handleBuild(this.getOptions());

            this.getMarketSizeProjectorContext().setMarketSizeIncidenceTable(
                    marketSizeIncidenceTable);

            this.getMarketSizeProjectorContext().setMarketSizeOptions(
                    this.getOptions());
        }

        return Action.SUCCESS;

    }

    /**
     * @return Returns the options.
     */
    public MarketSizeOptions getOptions() {
        return options;
    }

    /**
     * @param options
     *            The options to set.
     */
    public void setOptions(MarketSizeOptions options) {
        this.options = options;
    }

    /**
     * @return Returns the submitMarketSize.
     */
    public String getSubmitMarketSize() {
        return submitMarketSize;
    }

    /**
     * @param submitMarketSize
     *            The submitMarketSize to set.
     */
    public void setSubmitMarketSize(String submitMarketSize) {
        this.submitMarketSize = submitMarketSize;
    }

    public String getSubmitMarketSizeBar() {
        return submitMarketSizeBar;
    }

    public void setSubmitMarketSizeBar(String submitMarketSizeBar) {
        this.submitMarketSizeBar = submitMarketSizeBar;
    }

    public String getSubmitMarketSizePie() {
        return submitMarketSizePie;
    }

    public void setSubmitMarketSizePie(String submitMarketSizePie) {
        this.submitMarketSizePie = submitMarketSizePie;
    }
}
