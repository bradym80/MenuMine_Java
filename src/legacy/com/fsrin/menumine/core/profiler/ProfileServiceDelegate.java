/*
 * Created on Apr 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.profiler;

import java.util.Collection;

/**
 * @author Nick
 * 
 *  
 */

public class ProfileServiceDelegate {

    private ProfileDao dao;

    public ProfileDao getDao() {
        return dao;
    }

    public void setDao(ProfileDao dao) {
        this.dao = dao;
    }

    public Long getCount(ProfileParameters profileParameters)
            throws ProfileException {
        return this.getDao().getCount(profileParameters);
    }

    public Collection find(ProfileParameters params) {
        return this.getDao().find(params);
    }

}