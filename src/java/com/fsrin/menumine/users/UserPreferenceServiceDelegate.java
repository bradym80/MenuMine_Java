/*
 * Created on Apr 13, 2006 by Reid
 */
package com.fsrin.menumine.users;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.util.AbstractServiceDelegate;

public class UserPreferenceServiceDelegate extends AbstractServiceDelegate {

    public static final UserPreferenceServiceDelegateFactory factory = new UserPreferenceServiceDelegateFactory();
    
    public Log log = LogFactory.getLog(UserPreferenceServiceDelegate.class);
    
    public Collection getUserPreferences(String username) {
        UserPreferenceCriteriaParameters p = new UserPreferenceCriteriaParameters();
        p.setUsername(username);
        
        Collection ret = this.getDao().find(p);
        
        return ret;
        
    }
    
    public UserPreference getUserPreference(String username, String key) {
        UserPreferenceCriteriaParameters p = new UserPreferenceCriteriaParameters();
        p.setUsername(username);
        p.setKey(key);
        
        UserPreference ret = null;
        
        Collection coll = this.getDao().find(p);
        
        if (coll.size() == 1) {
            ret = (UserPreference) coll.toArray()[0];
        } else if (coll.size() > 1) {
            log.warn("found more than one match for a username/key combination");
            throw new RuntimeException("found more than on amtch.");
        }
        
        return ret;
        
    }
    
    public UserPreference getOrCreateUserPreference(String username, String key) {

        UserPreference pref = null;
        
        pref = this.getUserPreference(username, key);
        
        if (pref == null) {
            pref = new UserPreference();
            pref.setUsername(username);
            pref.setKey(key);
        }
        
        return pref;
    }
    
    public void updateUserPreference(String username, String key, String value) {
        
        UserPreference pref = this.getOrCreateUserPreference(username,key);
        
        pref.setValue(value);
        
        this.getDao().save(pref);
    }
    
    public void incrementUserPreference(String username, String key) {
        UserPreference pref = this.getOrCreateUserPreference(username,key);
        
        if (pref.getValue() == null || pref.getValue().trim().length() == 0) {
            pref.setValue("1");
        } else {
            int c = 0;
            
            try {
                c = Integer.parseInt(pref.getValue());
            } catch (NumberFormatException e) {
                //do nothing;
            }
            c++;
            pref.setValue(""+c);
        }
        
        this.getDao().save(pref);  
    }
    
    public void resetPreferences(String username) {
        Collection c = this.getUserPreferences(username);

        this.getDao().deleteAll(c);
    }
    
}
