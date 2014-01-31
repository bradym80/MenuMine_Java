/*
 * Created on Mar 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menubook;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;
import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class MenuBookTest extends AbstractNonInitializingMenuMineTestCase {

//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystemDropSchema();
//    }

    public void testMenuBook() throws Exception {
        MenuBook menuBook = this.getMenuBookBuilder().build("Wendy's");

        assertEquals(this.getNumberOfMenuParts(), menuBook.getMenuParts()
                .size());

        int countMenuItems = 0;
        for (Iterator iter = menuBook.getMenuParts().iterator(); iter.hasNext();) {
            MenuBookMenuPart element = (MenuBookMenuPart) iter.next();
            countMenuItems += element.getMenuItems().size();
        }

        assertEquals(this.getWendysResults().size(), countMenuItems);

    }

    private int getNumberOfMenuParts() {

        Set set = new HashSet();

        for (Iterator iter = getWendysResults().iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            set.add(element.getGenMenuPart());
        }

        return set.size();
    }

    private Collection getWendysResults() {
        Collection results = this.getDao().findUsingCriteria(
                this.buildMasterFoodFilterParameters("Wendy's"));

        return results;

    }

    public MasterFoodDao getDao() {
        return (MasterFoodDao) SpringBeanBroker.getBeanFactory().getBean(
                MasterFoodDao.SPRING_BEAN_NAME);
    }

    public MenuBookBuilder getMenuBookBuilder() {
        return (MenuBookBuilder) SpringBeanBroker.getBeanFactory().getBean(
                MenuBookBuilder.SPRING_BEAN_NAME);
    }

    private MasterFoodFilterParameters buildMasterFoodFilterParameters(
            String chainName) {
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();
        params.getOperationName().getInValues().add(chainName);
//        params.getChain().getOperationName().getInValues().add(chainName);
        params.getPrice2004().setEmpty(Boolean.FALSE);

        return params;
    }

    Log log = LogFactory.getLog(MenuBookTest.class);
}