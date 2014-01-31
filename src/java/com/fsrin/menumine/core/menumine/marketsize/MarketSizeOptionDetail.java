/*
 * Created on Jul 25, 2006
 *
 */
package com.fsrin.menumine.core.menumine.marketsize;

public class MarketSizeOptionDetail {

    private int servingsPerDay;
    
    private double ouncesPerServing;
    
    private int menuCycle;

    public MarketSizeOptionDetail() {
        super();
    }
    
    public MarketSizeOptionDetail(int servings, double ounces, int menuCycle) {
        this.servingsPerDay = servings;
        this.ouncesPerServing = ounces;
        this.menuCycle = menuCycle;
    }
    /**
     * @return Returns the menuCycle.
     */
    public int getMenuCycle() {
        return menuCycle;
    }

    /**
     * @param menuCycle The menuCycle to set.
     */
    public void setMenuCycle(int menuCycle) {
        this.menuCycle = menuCycle;
    }

    /**
     * @return Returns the ouncesPerServing.
     */
    public double getOuncesPerServing() {
        return ouncesPerServing;
    }

    /**
     * @param ouncesPerServing The ouncesPerServing to set.
     */
    public void setOuncesPerServing(double ouncesPerServing) {
        this.ouncesPerServing = ouncesPerServing;
    }

    /**
     * @return Returns the servingsPerDay.
     */
    public int getServingsPerDay() {
        return servingsPerDay;
    }

    /**
     * @param servingsPerDay The servingsPerDay to set.
     */
    public void setServingsPerDay(int servingsPerDay) {
        this.servingsPerDay = servingsPerDay;
    }
}
