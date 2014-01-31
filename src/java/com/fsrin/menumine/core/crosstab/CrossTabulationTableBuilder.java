/*
 * Created on Jan 31, 2006 by Reid
 */
package com.fsrin.menumine.core.crosstab;

import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;

import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodBuilder;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;
import com.fsrin.menumine.core.menumine.webwork.MenuMineCrossTabulationOptions;

public class CrossTabulationTableBuilder {

    public CrossTabulationTable build(MenuMineCrossTabulationOptions options) {

        CrossTabulationTable table = new CrossTabulationTable(options);

        MasterFoodFilterParameters selectParameters = new MasterFoodFilterParametersImpl();

        try {
            Ognl.setValue(options.getHorizontalField() + ".select",
                    selectParameters, Boolean.TRUE);
            Ognl.setValue(options.getVerticalField() + ".select",
                    selectParameters, Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("cross table table build failed.", e);
        }

        StringBuffer q = new MasterFoodQueryBuilder().getQueryForCrossTab(selectParameters, options.getFilter());
        
        Collection raw = GenericDAOFactory.factory.buildData().find(q.toString());
        
        Collection results = new MasterFoodBuilder().buildFromObjectCollection(raw,selectParameters);
        
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            table.addMasterFood(element);

        }

        return table;
    }
}
