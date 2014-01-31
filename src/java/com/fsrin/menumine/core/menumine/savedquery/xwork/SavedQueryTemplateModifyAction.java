/*
 * Created on Feb 9, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.savedquery.xwork;

import java.util.Collection;

import org.springframework.util.StringUtils;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryServiceDelegate;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.xwork.Action;

public class SavedQueryTemplateModifyAction extends
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

        SavedQueryServiceDelegate sqsd = SavedQueryServiceDelegate.factory
                .build();
        this.setSavedQueryServiceDelegate(sqsd);

        if (this.getTarget() != null && this.getDeleteQuery() == null) {
            this.getSavedQueryModifyContext().setTarget(
                    this.getSavedQueryServiceDelegate().getById(
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

        if (this.getSavedQueryModifyContext().getTarget() == null)
            return SUCCESS;

        if (this.getSubmitQuery() != null) {

            SavedQuery t = this.getSavedQueryModifyContext().getTarget();

            t.setName(this.targetQuery.getName());
            t.setGroupName(this.targetQuery.getGroupName());
            // t.setPermission(this.targetQuery.getPermission());
            t.setPermission(SavedQuery.CUSTOM_TEMPLATE_PERMISSION.intValue()); // 3 is
                                                                                // template
                                                                                // code.
            t.setTemplateGroup(this.targetQuery.getTemplateGroup());

            if (!StringUtils.hasText(t.getName())) {
                t.setName("None");
            }
            if (!StringUtils.hasText(t.getGroupName())) {
                t.setGroupName("None");
            }
            if (!StringUtils.hasText(t.getTemplateGroup())) {
                t.setTemplateGroup("None");
            }
            
//            t.setId(null);

            t.getMasterFoodFilterParameters().setId(null);

            t.getFieldsToDisplayBean().setId(null);

            if (t.getId() == null) {
                this.getSavedQueryServiceDelegate().saveNew(t);
            } else {
                this.getSavedQueryServiceDelegate().update(t);
            }
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
