/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.masterfood.hql;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersTestFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.testutil.TimerUtil;
import com.fsrin.menumine.util.GroupCounterVO;

public class MasterFoodQueryBuilder_WithGroupBy_Test extends
        AbstractNonInitializingMenuMineTestCase {

    private static Log log = LogFactory
            .getLog(MasterFoodQueryBuilder_WithGroupBy_Test.class);

    public void testBasicGroup() throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        /*
         * Why bacon? Because that's what Matt uses in his samples.
         * 
         * Group fields
         * 
         * Slow: genMenuPart Fast: basicProtein, carbo, dayPartCategory
         */
        p.getItemDescription().getAndValues().add("bacon");

        StringBuffer q = new MasterFoodQueryBuilder()
                .getQueryForCountWithGroupByConjunctive(p, p.getGenMenuPart()
                        .getFieldName());

        log.info("Heres the group by query. " + q.toString());

        Collection c = GenericDAOFactory.factory.buildData().find(q.toString());

        assertNotNull(c);
        assertTrue(c.size() > 1);

        assertTrue(c.toArray()[0] instanceof GroupCounterVO);

        GroupCounterVO first = (GroupCounterVO) c.toArray()[0];

        GroupCounterVO second = (GroupCounterVO) c.toArray()[1];

        assertTrue(first.getCount().intValue() > second.getCount().intValue());

        int i = 0;

        for (Iterator iter = c.iterator(); iter.hasNext();) {
            GroupCounterVO element = (GroupCounterVO) iter.next();
            log.info("row: " + element.getGroup() + ": " + element.getCount());
            if (i++ > 100)
                break;
        }

    }

    public void testExtraParameters() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();

        FilterParameter[] extraParameters = { new FilterParameter(
                FieldEnum.MARKET_SEGMENT) };

        extraParameters[0].getAndValues().add("casual");

        StringBuffer q = new MasterFoodQueryBuilder()
                .getQueryForCountWithGroupBy(p, p.getGenMenuPart()
                        .getFieldName(), extraParameters);

        log.info("Heres the group by query. " + q.toString());
        assertTrue(q.indexOf(FieldEnum.MARKET_SEGMENT.getOgnlName()) > 0);

        Collection c = GenericDAOFactory.factory.buildData().find(q.toString());



    }
    
    public void testExtraParametersAndCountDistinct() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();

        FilterParameter[] extraParameters = { new FilterParameter(
                FieldEnum.MARKET_SECTOR) };

        extraParameters[0].getInValues().add("Midscale Chain Sector");

        StringBuffer q = new MasterFoodQueryBuilder()
                .getQueryForCountWithGroupBy(p, FieldEnum.MARKET_SEGMENT.getOgnlName(), extraParameters, FieldEnum.OPERATION_CHAIN_ID);

        log.info("Heres the group by query. " + q.toString());
        assertTrue(q.indexOf(FieldEnum.MARKET_SECTOR.getOgnlName()) > 0);

        Collection c = GenericDAOFactory.factory.buildData().find(q.toString());

        assertTrue(c.toArray()[0] instanceof GroupCounterVO);
        
        GroupCounterVO first = (GroupCounterVO) c.toArray()[0];

        assertTrue(first.getDistinctCount().intValue() > 0);
        
        for (Iterator iter = c.iterator(); iter.hasNext();) {
            GroupCounterVO element = (GroupCounterVO) iter.next();
            log.info("name: " + element.getGroup() + ", count " + element.getCount() + ", distinct " + element.getDistinctCount());
        }

    }

    public void testGroupByForItemMenuIncidence() throws Exception {

        MasterFoodFilterParameters p = MasterFoodFilterParametersTestFactory.getItemDescriptionWithBacon();

        StringBuffer q = new MasterFoodQueryBuilder()
                .getQueryForItemsPerChainCount(p, new Integer(2000));

        log.info("Heres the group by query. " + q.toString());
        assertTrue(q.indexOf(FieldEnum.MARKET_SECTOR.getOgnlName()) > 0);

        TimerUtil query = TimerUtil.getInstanceAndStart("query");
        Collection c = GenericDAOFactory.factory.buildData().find(q.toString());
        query.stop();

        assertTrue(c.size() > 0);
        
        Object[] one = (Object[])c.toArray()[0];

    }
    
}
