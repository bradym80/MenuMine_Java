/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup.xwork.test;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.menumine.rollup.RollUpOptions;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegate;
import com.fsrin.menumine.core.menumine.rollup.RollUpServiceDelegateException;
import com.fstx.stdlib2.authen.users.User;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpServiceDelegateMockImpl implements RollUpServiceDelegate {

    public RollUpServiceDelegateMockImpl() {
        super();

    }

    public Collection getByUser(User user)
            throws RollUpServiceDelegateException {

        return null;
    }

    public Collection getByUser(String userName)
            throws RollUpServiceDelegateException {

        return null;
    }

    public Collection getByGroup(User user)
            throws RollUpServiceDelegateException {

        return null;
    }

    public Collection getByUserAndGroup(User user)
            throws RollUpServiceDelegateException {

        return null;
    }

    public void save(RollUpOptions rollUpOptions)
            throws RollUpServiceDelegateException {
    }

    public RollUpOptions getByName(String name, String userName)
            throws RollUpServiceDelegateException {

        return null;
    }

    public void delete(RollUpOptions rollUp)
            throws RollUpServiceDelegateException {
        this.deletedRollUps.add(rollUp);
    }

    private Collection deletedRollUps = new ArrayList();

    public Collection getDeletedRollUps() {
        return deletedRollUps;
    }

    public Collection getSimpleByUser(String userName) throws RollUpServiceDelegateException {
        
        return null;
    }
}