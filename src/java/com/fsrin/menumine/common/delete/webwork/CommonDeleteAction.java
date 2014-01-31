/*
 * Created on 2005-1-14
 */
package com.fsrin.menumine.common.delete.webwork;

import com.fsrin.menumine.context.MenuMineSessionContext;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;

/**
 * @author Nick
 */
public class CommonDeleteAction extends
        AbstractMenuMineSessionContextAwareAction {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private String deleteConfirm;

    private String deleteCancel;

    /*
     * This for the most part is depricated as we use java script to get the
     * confermation. If in the future we need it I don't want to delete the
     * code! (non-Javadoc)
     * 
     * 2006-04-04 - RSC - using.
     * 
     * @see com.opensymphony.xwork.Action#execute()
     */

    public String execute() throws Exception {
        String ret = null;
        if (this.getMenuMineSessionContextWrapper().getDeleteContext() == null
                || !this.getMenuMineSessionContextWrapper().getDeleteContext()
                        .isValid())
            return ERROR;

        if (this.getDeleteConfirm() == null && this.getDeleteCancel() == null)
            return INPUT;

        if (this.getDeleteCancel() != null) {
            // do nothing...
        } else {
            try {
                this.getMenuMineSessionContextWrapper().getDeleteContext()
                        .getCommand().delete(
                                this.getMenuMineSessionContextWrapper()
                                        .getMenuMineSessionContext());
            } catch (Exception e) {
                return ERROR;
            }
        }

        ret = this.getMenuMineSessionContextWrapper().getDeleteContext()
                .getSuccess();

        this.getMenuMineSessionContextWrapper().setDeleteContext(null);

        return ret;
    }

    /**
     * @return Returns the submitCancel.
     */
    public String getDeleteCancel() {
        return deleteCancel;
    }

    /**
     * @param submitCancel
     *            The submitCancel to set.
     */
    public void setDeleteCancel(String submitCancel) {
        this.deleteCancel = submitCancel;
    }

    /**
     * @return Returns the submitConfirm.
     */
    public String getDeleteConfirm() {
        return deleteConfirm;
    }

    /**
     * @param submitConfirm
     *            The submitConfirm to set.
     */
    public void setDeleteConfirm(String submitConfirm) {
        this.deleteConfirm = submitConfirm;
    }

    // public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
    // return menuMineSessionContextWrapper;
    // }
    //
    // public void setMenuMineSessionContextWrapper(
    // MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
    // this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
    // }

    public MenuMineSessionContext getMenuMineSessionContext() {
        return this.getMenuMineSessionContextWrapper()
                .getMenuMineSessionContext();
    }
}
