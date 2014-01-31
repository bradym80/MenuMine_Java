/*
 * Created on Apr 13, 2006 by Reid
 */
package com.fsrin.menumine.users;

import java.util.Collection;

import com.fsrin.menumine.testutil.AbstractNonInitializingMenuMineTestCase;

public class UserPreferenceServiceDelegateTest extends
        AbstractNonInitializingMenuMineTestCase {

    public void testUpdate() throws Exception {
        
        UserPreferenceServiceDelegate sd = UserPreferenceServiceDelegateFactory.build();
        
        String sampleUsername = SAMPLE_USERNAME + "test";
        
        sd.resetPreferences(sampleUsername);
        
        Collection c = sd.getUserPreferences(sampleUsername);
        
        assertEquals(0,c.size());
        
        sd.updateUserPreference(sampleUsername,"oneKey", "oneValue");
        
        c = sd.getUserPreferences(sampleUsername);
        
        assertTrue(c.size() == 1);
        
        sd.resetPreferences(sampleUsername);
        
        c = sd.getUserPreferences(sampleUsername);
        
        assertTrue(c.size() == 0);
        
    }
    
    public void testUpdateWithValueChange() throws Exception {
        
        UserPreferenceServiceDelegate sd = UserPreferenceServiceDelegateFactory.build();
        
        String sampleUsername = SAMPLE_USERNAME + "test";
        
        sd.resetPreferences(sampleUsername);
        
        Collection c = sd.getUserPreferences(sampleUsername);
        
        assertEquals(0,c.size());
        
        sd.updateUserPreference(sampleUsername,"oneKey", "oneValue");
        
        c = sd.getUserPreferences(sampleUsername);
        
        assertTrue(c.size() == 1);
        
        UserPreference t1 = sd.getUserPreference(sampleUsername,"oneKey");
        
        assertNotNull(t1);
        
        assertEquals(t1.getValue(),"oneValue");
        
        sd.updateUserPreference(sampleUsername,"oneKey", "oneValueA");

        c = sd.getUserPreferences(sampleUsername);
        
        assertTrue(c.size() == 1);

        UserPreference t2 = sd.getUserPreference(sampleUsername,"oneKey");
        
        assertEquals(t2.getValue(),"oneValueA");
        
        
        sd.resetPreferences(sampleUsername);
        
        c = sd.getUserPreferences(sampleUsername);
        
        assertTrue(c.size() == 0);
        
    }
}
