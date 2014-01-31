/*
 * Created on Aug 2, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.webwork;

import com.fsrin.menumine.core.dessertmine.xwork.test.SavedQueryManagerMockImpl;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.SavedQuery;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

/**
 * @author Nick
 * 
 *  
 */
public class SavedQueryManagerMockImpl2 extends SavedQueryManagerMockImpl {

    public static final String SAMPLE_MOCK_QUERY_2 = "sample.mock.query.dessert";

    public SavedQueryManagerMockImpl2() {
        super();

        SavedQuery savedQuery1 = new SavedQuery();
        savedQuery1.setName(SAMPLE_MOCK_QUERY_1);
        savedQuery1
                .setMasterFoodFilterParameters(new MasterFoodFilterParametersImpl());
        savedQuery1.setFieldsToDisplayBean(new FieldsToDisplayBean());
        savedQuery1.getMasterFoodFilterParameters().getCakeUse().getAndValues()
                .add("MOCK_CAKE_USE 1");

        savedQuery1.setMineType(MineFieldsFactory.MINE_TYPE_DESSERT);
        savedQuery1.getFieldsToDisplayBean().setCakeUse(Boolean.TRUE);
        this.getQuerys().put(SAMPLE_MOCK_QUERY_2, savedQuery1);

    }

}