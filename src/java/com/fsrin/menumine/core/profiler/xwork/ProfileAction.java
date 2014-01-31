/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.xwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;

import com.fsrin.menumine.context.util.BuildStatisticalTableFromActionDelegate;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.util.SearchableTokenBuilder;
import com.fsrin.menumine.core.menumine.sharetable.StatisticalTableIF;
import com.fsrin.menumine.core.menumine.webwork.MenuMineDisplayOptions;
import com.fsrin.menumine.core.menumine.webwork.MenuMineGraphOptions;
import com.fsrin.menumine.core.profiler.aggregation.AggregatedProfileBuilder;
import com.fsrin.menumine.core.profiler.aggregation.AggregatedProfileFieldEnumImpl;
import com.fsrin.menumine.core.profiler.aggregation.Profile;
import com.fsrin.menumine.core.profiler.aggregation.ProfileFieldListProvider;

/**
 * @author Nick
 * 
 * 
 */

public class ProfileAction extends AbstractProfileContextAware {

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private final String APPLICATIONS = "Applications";

    private final String OPERATOR_SHARE = "Operator Share";

    private final String SEGMENT_SHARE = "Segment Share";

    private final String SECTOR_SHARE = "Sector Share";

    private String postAction;

    private String profilerTitle;

    private String searchString;

    private String displayType = APPLICATIONS;

    private MenuMineDisplayOptions menuMineDisplayOptions = new MenuMineDisplayOptions();

    

    private Collection applications;

    private Profile bigPicture;

    private Collection tables;

    private ProfileFieldListProvider fieldListProvider;

    
    

    public String execute() throws Exception {

        this.getMenuMineDisplayOptions().setDisplayType("Profiler");

        if (!this.isSearchStringValid()
                && this.getProfileContext().getSearchString() == null) {
            this.addActionError("Query must be at least 3 characters long");
            return SUCCESS;
        } else if (!this.isSearchStringValid()) {
            this.setSearchString(this.getProfileContext().getSearchString());
        } else {
            this.getProfileContext().setSearchString(this.getSearchString());
        }

        this.getProfileContext().setFieldListProvider(
                this.getFieldListProvider());

        Collection applications = null;

        Collection searchableTokens = new SearchableTokenBuilder()
                .buildSearchableToken(this.getSearchString());

        if (displayType.equalsIgnoreCase(APPLICATIONS)) {
            applications = new AggregatedProfileBuilder().buildApplications(
                    this.getFieldListProvider(), this.getSearchString());

            /*
             * let's take a second and build the tables...
             */
            tables = new ArrayList();

            for (Iterator iter = applications.iterator(); iter.hasNext();) {
                AggregatedProfileFieldEnumImpl element = (AggregatedProfileFieldEnumImpl) iter
                        .next();

                if (element.getFieldEnum() == FieldEnum.DESCRIPTION || element.getFieldEnum() == FieldEnum.MENU_ITEM_NAME) {
                    continue;
                }
                
                if (element.getNumberOfApplications() > 0) {
                    MenuMineGraphOptions graphOptions = new MenuMineGraphOptions();
                    graphOptions.setGraphByField(element.getFieldEnum()
                            .getOgnlName());

                    MasterFoodFilterParameters filterParameters = new MasterFoodFilterParametersImpl();
                    Ognl.setValue(element.getFieldEnum().getOgnlName()
                            + ".andValues", filterParameters, searchableTokens);

                    StatisticalTableIF table = new BuildStatisticalTableFromActionDelegate()
                            .buildFromFieldCollectionAndParameters(
                                    graphOptions, filterParameters, this);

                    tables.add(table);
                }

            }

        } else if (displayType.equalsIgnoreCase(OPERATOR_SHARE)) {
            applications = new AggregatedProfileBuilder().buildOperatorShare(
                    this.getFieldListProvider(), this.getSearchString(), this.getProfileContext().getApplicationFocus());
        } else if (displayType.equalsIgnoreCase(SEGMENT_SHARE)) {
            applications = new AggregatedProfileBuilder().buildSegmentShare(
                    this.getFieldListProvider(), this.getSearchString(), this.getProfileContext().getApplicationFocus());
        } else if (displayType.equalsIgnoreCase(SECTOR_SHARE)) {
            applications = new AggregatedProfileBuilder().buildSectorShare(this
                    .getFieldListProvider(), this.getSearchString(), this.getProfileContext().getApplicationFocus());
        }

        this.setBigPicture(new AggregatedProfileBuilder().buildBigPicture(this
                .getFieldListProvider(), this.getSearchString()));

        this.setApplications(applications);

        return SUCCESS;

    }

    public boolean isProfileAvailable() {
        /*
         * If we have a valid seach string we can assume we have a profile.
         */
        return isSearchStringValid();
    }

    public boolean isSearchStringValid() {
        return this.searchString != null && this.searchString.length() > 2;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getPostAction() {
        return postAction;
    }

    public void setPostAction(String postAction) {
        this.postAction = postAction;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getProfilerTitle() {
        return profilerTitle;
    }

    public void setProfilerTitle(String profilerTitle) {
        this.profilerTitle = profilerTitle;
    }

    public MenuMineDisplayOptions getMenuMineDisplayOptions() {
        return menuMineDisplayOptions;
    }

    public void setMenuMineDisplayOptions(
            MenuMineDisplayOptions menuMineDisplayOptions) {
        this.menuMineDisplayOptions = menuMineDisplayOptions;
    }

    public Collection getTables() {
        return tables;
    }

    public void setTables(Collection tables) {
        this.tables = tables;
    }

    public Collection getApplications() {
        return applications;
    }

    public void setApplications(Collection applications) {
        this.applications = applications;
    }

    public ProfileFieldListProvider getFieldListProvider() {
        return fieldListProvider;
    }

    public void setFieldListProvider(ProfileFieldListProvider fieldListProvider) {
        this.fieldListProvider = fieldListProvider;
    }

    public Profile getBigPicture() {
        return bigPicture;
    }

    public void setBigPicture(Profile bigPicture) {
        this.bigPicture = bigPicture;
    }


}