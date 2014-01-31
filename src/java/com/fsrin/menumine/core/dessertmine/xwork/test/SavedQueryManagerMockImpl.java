/*
 * Created on Jun 9, 2005
 *
 * 
 */
package com.fsrin.menumine.core.dessertmine.xwork.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.savedquery.SavedQuery;
import com.fsrin.menumine.core.menumine.savedquery.SavedQueryManager;
import com.fstx.stdlib2.authen.AuthenticatedUser;

/**
 * @author Nick
 * 
 *  
 */
public class SavedQueryManagerMockImpl implements SavedQueryManager {

    public static final String SAMPLE_MOCK_QUERY_1 = "sample.mock.query";

    Map querys = new HashMap();

    public SavedQueryManagerMockImpl() {
        super();

        SavedQuery savedQuery1 = new SavedQuery();
        savedQuery1.setName(SAMPLE_MOCK_QUERY_1);
        savedQuery1
                .setMasterFoodFilterParameters(new MasterFoodFilterParametersImpl());
        savedQuery1.setFieldsToDisplayBean(new FieldsToDisplayBean());
        savedQuery1.getMasterFoodFilterParameters().getCakeUse().getAndValues()
                .add("MOCK_CAKE_USE");
        savedQuery1.getFieldsToDisplayBean().setCakeUse(Boolean.TRUE);
        querys.put(SAMPLE_MOCK_QUERY_1, savedQuery1);
    }

    public Collection getGroupQueries(AuthenticatedUser authenticatedUser) {

        return new ArrayList();
    }

    public Collection getUserQueries(AuthenticatedUser authenticatedUser) {
        return new ArrayList(querys.values());

    }

    public Map getQuerys() {
        return querys;
    }
}