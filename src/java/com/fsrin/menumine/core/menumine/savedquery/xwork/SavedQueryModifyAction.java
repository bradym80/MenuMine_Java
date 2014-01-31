/*
 * Created on Feb 9, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.xwork.Action;

public class SavedQueryModifyAction extends
        AbstractMenuMineSessionContextAwareAction implements
        SavedQueryModifyContextAware {

    private SavedQueryModifyContext savedQueryModifyContext;

    private SavedQueryServiceDelegate savedQueryServiceDelegate;

    private String submitQuery;

    private String cancelQuery;

    private String deleteQuery;

    private Long target;

    private SavedQuery targetQuery = new SavedQuery();

    public String execute() throws Exception {

        if (this.getCancelQuery() != null)
            return Action.SUCCESS;

        if (this.getTarget() != null && this.getDeleteQuery() == null) {
            this.getSavedQueryModifyContext().setTarget(
                    this.getSavedQueryServiceDelegate().getSimpleById(
                            this.getTarget()));

            if (this.getSavedQueryModifyContext().getTarget() == null) {
                this.getMenuMineSessionContextWrapper().getErrorContext()
                        .addError("Cannot load that query for modification.");
            } else {
                this.targetQuery = this.getSavedQueryModifyContext()
                        .getTarget();
            }

            return Action.INPUT;
        }



        if (this.getDeleteQuery() != null && this.getTarget() != null) {
            SavedQuery d = this.getSavedQueryServiceDelegate().getById(this.getTarget());
            
            this.getSavedQueryServiceDelegate().delete(d);

            this.getSavedQueryModifyContext().setTarget(null);

            return SUCCESS;
        } else if (this.getDeleteQuery() != null) {
            this.getSavedQueryServiceDelegate().delete(
                    this.getSavedQueryModifyContext().getTarget());

            this.getSavedQueryModifyContext().setTarget(null);

            return SUCCESS;            
        }
        
        if (this.getSavedQueryModifyContext().getTarget() == null)
            return SUCCESS;

        if (this.getSubmitQuery() != null) {

            SavedQuery t = this.getSavedQueryModifyContext().getTarget();

            t.setName(this.targetQuery.getName());
            t.setGroupName(this.targetQuery.getGroupName());
            t.setPermission(this.targetQuery.getPermission());

            this.getSavedQueryServiceDelegate().saveNew(t);

            this.getSavedQueryModifyContext().setTarget(null);
        }

        return Action.SUCCESS;

    }

    public String getCancelQuery() {
        return cancelQuery;
    }

    public void setCancelQuery(String cancelQuery) {
        this.cancelQuery = cancelQuery;
    }

    public String getDeleteQuery() {
        return deleteQuery;
    }

    public void setDeleteQuery(String deleteQuery) {
        this.deleteQuery = deleteQuery;
    }

    public String getSubmitQuery() {
        return submitQuery;
    }

    public void setSubmitQuery(String submitQuery) {
        this.submitQuery = submitQuery;
    }

    public SavedQueryModifyContext getSavedQueryModifyContext() {
        return savedQueryModifyContext;
    }

    public void setSavedQueryModifyContext(
            SavedQueryModifyContext savedQueryModifyContext) {
        this.savedQueryModifyContext = savedQueryModifyContext;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public SavedQuery getTargetQuery() {
        return targetQuery;
    }

    public void setTargetQuery(SavedQuery targetQuery) {
        this.targetQuery = targetQuery;
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
