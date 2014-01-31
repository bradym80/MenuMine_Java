/*
 * Created on Mar 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import java.io.Serializable;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;

/**
 * @author Nick
 * 
 *  
 */
public class MenuMineCrossTabulationOptions implements Serializable {

    private String verticalField;// = FieldEnum.BASIC_PROTEIN.getOgnlName();

    private String horizontalField;// = FieldEnum.MENU_PART.getOgnlName();

    private String verticalRollUpName;

    private String horizontalRollUpName;

    private RollUpOptions verticalRollUpOptions;

    private RollUpOptions horizontalRollUpOptions;
    
    private MasterFoodFilterParameters filter;

    public String getHorizontalField() {
        return horizontalField;
    }

    public void setHorizontalField(String horizontalField) {
        this.horizontalField = horizontalField;
    }

    public String getVerticalField() {
        return verticalField;
    }

    public void setVerticalField(String verticalField) {
        this.verticalField = verticalField;
    }

    public boolean isFieldsSelected() {

        return this.getHorizontalField() != null
                && this.getVerticalField() != null
                && this.getHorizontalField().length() > 0
                && this.getVerticalField().length() > 0;
    }

    public RollUpOptions getHorizontalRollUpOptions() {
        return horizontalRollUpOptions;
    }

    public void setHorizontalRollUpOptions(RollUpOptions horizontalRollUpOptions) {
        this.horizontalRollUpOptions = horizontalRollUpOptions;
    }

    public RollUpOptions getVerticalRollUpOptions() {
        return verticalRollUpOptions;
    }

    public void setVerticalRollUpOptions(RollUpOptions verticalRollUpOptions) {
        this.verticalRollUpOptions = verticalRollUpOptions;
    }

    public String getHorizontalRollUpName() {
        return horizontalRollUpName;
    }

    public void setHorizontalRollUpName(String horizontalRollUpName) {
        this.horizontalRollUpName = horizontalRollUpName;
    }

    public String getVerticalRollUpName() {
        return verticalRollUpName;
    }

    public void setVerticalRollUpName(String verticalRollUpName) {
        this.verticalRollUpName = verticalRollUpName;
    }

    public MasterFoodFilterParameters getFilter() {
        return filter;
    }

    public void setFilter(MasterFoodFilterParameters filter) {
        this.filter = filter;
    }
}