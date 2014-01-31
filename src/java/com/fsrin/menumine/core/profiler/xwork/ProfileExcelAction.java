/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler.xwork;

import java.util.Collection;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.profiler.aggregation.AggregatedProfileBuilder;
import com.fsrin.menumine.core.profiler.aggregation.Profile;
import com.opensymphony.xwork.Action;

/**
 * @author Nick
 * 
 * 
 */
public class ProfileExcelAction extends AbstractProfileContextAware {

    private HSSFWorkbook workbook = null;

    // private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    

    public String execute() throws Exception {

        Profile bigPicture = new AggregatedProfileBuilder().buildBigPicture(
                this.getProfileContext().getFieldListProvider(), this
                        .getProfileContext().getSearchString());

        Collection applications = new AggregatedProfileBuilder()
                .buildApplications(this.getProfileContext()
                        .getFieldListProvider(), this.getProfileContext()
                        .getSearchString());

        Collection operatorShare = new AggregatedProfileBuilder()
                .buildOperatorShare(this.getProfileContext()
                        .getFieldListProvider(), this.getProfileContext()
                        .getSearchString(), this.getProfileContext().getApplicationFocus());

        Collection segmentShare = new AggregatedProfileBuilder()
                .buildSegmentShare(this.getProfileContext()
                        .getFieldListProvider(), this.getProfileContext()
                        .getSearchString(), this.getProfileContext().getApplicationFocus());

        Collection sectorShare = new AggregatedProfileBuilder()
                .buildSectorShare(this.getProfileContext()
                        .getFieldListProvider(), this.getProfileContext()
                        .getSearchString(), this.getProfileContext().getApplicationFocus());

        ProfileExcelBuilder builder = new ProfileExcelBuilder();

        this.workbook = builder.buildExcelWorkbook(bigPicture, applications,
                operatorShare, segmentShare, sectorShare);

        return Action.SUCCESS;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }


}