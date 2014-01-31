/*
 * Created on Apr 4, 2006 by Reid
 */
package com.fsrin.menumine.updates.p20060404;

import java.util.Collection;
import java.util.Iterator;

import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupDao;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.fstx.stdlib2.authen.users.UserServiceDelegate;

public class UpdateUserCompanyFieldWithGroupNameCommand {

    public void execute() throws Exception {
        
        UserGroupServiceDelegate groupServiceDelegate = UserGroupServiceDelegate.factory.build();
        
        UserServiceDelegate userServiceDelegate = UserServiceDelegate.factory.build();
        
        Collection  groups = groupServiceDelegate.getAll();
        
        for (Iterator iter = groups.iterator(); iter.hasNext();) {
            UserGroup element = (UserGroup) iter.next();
            
            Collection members = userServiceDelegate.getByGroup(element);
            
            for (Iterator iterator = members.iterator(); iterator.hasNext();) {
                User currentUser = (User) iterator.next();
                currentUser.setCompany(element.getName());
                userServiceDelegate.save(currentUser);
            }
            
            
        }
        
        
        
    }
}
