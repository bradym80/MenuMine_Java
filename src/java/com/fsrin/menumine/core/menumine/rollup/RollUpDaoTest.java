/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpDaoTest extends AbstractNonInitializingMenuMineTestCase {

    public void testFilterDAO() throws Exception {

        RollUpServiceDelegate rusd = RollUpServiceDelegate.factory.build();
        RollUpOptions option = new RollUpOptions();
        option.setName("Test Roll Up");
        option.setPermission(1);
        option.setUserName("nick");

        RollUpElement element = new RollUpElement();
        element.setLabel("Beef nick");
        element.setTerm("Beef");

        option.getRollUpElements().add(element);

        rusd.save(option);

        assertNotNull(option.getId());

        Collection col = rusd.getByUser("nick");
        assertTrue(col.size() > 0);

        RollUpOptions optionsReload = null;
        for (Iterator iter = col.iterator(); iter.hasNext();) {
            RollUpOptions rollUpOptTemp = (RollUpOptions) iter.next();
            if (rollUpOptTemp.getName().equals("Test Roll Up")) {
                optionsReload = rollUpOptTemp;
            }
        }

        assertNotNull(optionsReload);
        assertEquals(1, optionsReload.getRollUpElements().size());

        RollUpElement elementRollUp = (RollUpElement) optionsReload
                .getRollUpElements().toArray()[0];

        assertEquals("Beef nick", elementRollUp.getLabel());
        assertEquals("Beef", elementRollUp.getTerm());
        
        rusd.delete(option);
    }

//    protected void setUp() throws Exception {
//        super.setUp();
//        JunitSettings.initilizeTestSystemDropSchema();
//
//    }
}