/*
 * Created on May 5, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork;

public class AbstractCategoryIncidenceAction extends
        AbstractMenuMineDisplayAction {

    private String submitOptionsItems;
    private String imagePath;

    public String getSubmitOptionsItems() {
        return submitOptionsItems;
    }

    public void setSubmitOptionsItems(String submitOptionsItems) {
        this.submitOptionsItems = submitOptionsItems;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
