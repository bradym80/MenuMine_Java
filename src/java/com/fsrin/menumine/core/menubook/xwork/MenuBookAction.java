/*
 * Created on 2005-3-18
 *
 */
package com.fsrin.menumine.core.menubook.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menubook.MenuBook;
import com.fsrin.menumine.core.menubook.MenuBookBuilder;
import com.fsrin.menumine.core.menubook.MenuBookBuilderException;

/**
 * @author Nick
 * @version 1
 */

public class MenuBookAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private MenuBookBuilder menuBookBuilder;

    private String target;

    public static final String SPRING_BEAN_NAME = "menuBookAction";

    public String execute() throws Exception {

        if (this.getTarget() != null) {
            this.getMenuMineSessionContextWrapper().getMenuBookContext()
                    .setTarget(this.getTarget());
        } else {
            this.setTarget(this.getMenuMineSessionContextWrapper()
                    .getMenuBookContext().getTarget());
        }

        if (this.getMenuBook() == null) {
            this.addActionError("Error finding Chain Stat Detail");
        }
        return SUCCESS;
    }

    private MenuBook menuBook;

    public MenuBook getMenuBook() {

        if (menuBook == null) {
            try {
                menuBook = this.getMenuBookBuilder().build(this.getTarget());
            } catch (MenuBookBuilderException e) {
                e.printStackTrace();
                LOG.error("Error getting MenuBook: id=" + this.getTarget()
                        + e.getMessage() + " : " + e.getStackTrace());

                return null;
            }
        }
        return menuBook;

    }


    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public MenuBookBuilder getMenuBookBuilder() {
        return menuBookBuilder;
    }

    public void setMenuBookBuilder(MenuBookBuilder menuBookBuilder) {
        this.menuBookBuilder = menuBookBuilder;
    }

}