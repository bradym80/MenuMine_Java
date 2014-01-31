/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.flavor;

import java.util.Collection;
import java.util.Iterator;

import ognl.Ognl;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.common.dao.GenericResultCounter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;
import com.fsrin.menumine.core.profiler.Profiler;
import com.fsrin.menumine.core.profiler.ProfilerFactory;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;
import com.fsrin.menumine.testutil.TimerUtil;

public class FlavorCountTest extends AbstractNonInitializingMenuMineTestCase {

    public void testFieldCountSpeed() throws Exception {
        
        Profiler flavor = ProfilerFactory.factory.buildFlavorProfiler();
        
        Collection targetFields = flavor.getTargetFields();
        
        assertNotNull(targetFields);
        
        assertTrue(targetFields.size() > 0);
        
        log.info(targetFields.size());
        
        MasterFoodServiceDelegate sd = MasterFoodServiceDelegateFactory.factory.build();
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("flavors");
        
        for (Iterator iter = targetFields.iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            
            MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
            
            FilterParameter f = (FilterParameter) Ognl.getValue(element.getOgnlName(),p);
            
            f.setSelect(true);
            f.getAndValues().add("garlic");
            
            log.info("count for " + element.getFriendlyName() + " = " + sd.getCount(p));
            
        }
        
        timer.stop();
        
    }
    
    public void testFieldPerOperatorNameCount() throws Exception {
        
        Profiler flavor = ProfilerFactory.factory.buildFlavorProfiler();
        
        Collection targetFields = flavor.getTargetFields();
        
        assertNotNull(targetFields);
        
        assertTrue(targetFields.size() > 0);
        
        log.info(targetFields.size());
        
        GenericResultCounter counter = new GenericResultCounter();
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("flavors");
        
        for (Iterator iter = targetFields.iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            
            MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
            
            FilterParameter f = (FilterParameter) Ognl.getValue(element.getOgnlName(),p);
            
            f.setSelect(true);
            f.getAndValues().add("garlic");
            
            log.info("count for " + element.getFriendlyName() + " = " + counter.getCount(new MasterFoodQueryBuilder().getQueryForCountDistinctChain(p).toString()));
            
        }
        
        timer.stop();
        
    }
    
    public void testFieldPerIDAndOperatorCount() throws Exception {
        
        Profiler flavor = ProfilerFactory.factory.buildFlavorProfiler();
        
        Collection targetFields = flavor.getTargetFields();
        
        assertNotNull(targetFields);
        
        assertTrue(targetFields.size() > 0);
        
        log.info(targetFields.size());
        
        GenericResultCounter counter = new GenericResultCounter();
        
        TimerUtil timer = TimerUtil.getInstanceAndStart("flavors");
        
        for (Iterator iter = targetFields.iterator(); iter.hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();
            
            MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();
            
            FilterParameter f = (FilterParameter) Ognl.getValue(element.getOgnlName(),p);
            
            f.setSelect(true);
            f.getAndValues().add("garlic");
            
            Integer[] counts = counter.getTwoCounts(new MasterFoodQueryBuilder().getQueryForProfileApplicationsCount(p).toString());
            log.info("count for " + element.getFriendlyName() + " = " + counts[0] + "(" + counts[1] + ")");
            
        }
        
        timer.stop();
        
    }
    
}
