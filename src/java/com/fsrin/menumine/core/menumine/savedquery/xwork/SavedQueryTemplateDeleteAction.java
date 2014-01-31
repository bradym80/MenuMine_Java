
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.xwork.Action;

/*
 * 2006-09-06 this only handled query conversion.
 */
public class SavedQueryTemplateDeleteAction extends
        AbstractMenuMineSessionContextAwareAction {

    private SavedQueryServiceDelegate savedQueryServiceDelegate;

    private Long target;

    public String execute() throws Exception {

        SavedQueryServiceDelegate sqsd = SavedQueryServiceDelegate.factory
                .build();
        this.setSavedQueryServiceDelegate(sqsd);

        if (this.getTarget() != null) {

            SavedQuery sq = sqsd.getById(this.getTarget());
            
            sqsd.delete(sq);

        }

        return Action.SUCCESS;

    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public SavedQueryServiceDelegate getSavedQueryServiceDelegate() {
        return savedQueryServiceDelegate;
    }

    public void setSavedQueryServiceDelegate(
            SavedQueryServiceDelegate savedQueryServiceDelegate) {
        this.savedQueryServiceDelegate = savedQueryServiceDelegate;
    }

    public Collection getGroups() {
        Collection ret = null;

        ret = UserGroupServiceDelegate.factory.build().getAll();

        return ret;
    }
}
