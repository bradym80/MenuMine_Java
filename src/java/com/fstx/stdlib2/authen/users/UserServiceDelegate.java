/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;

import com.fsrin.menumine.common.ServiceDelegateException;

/**
 * @author Reid
 *  
 */
public interface UserServiceDelegate extends UserDaoAware {

    public static final String SPRING_BEAN_NAME = "userServiceDelegate";

    public static final UserServiceDelegateFactory factory = new UserServiceDelegateFactory();

    public abstract void changePassword(String username,
            String currentPassword, String newPassword)
            throws ChangePasswordException;

    public abstract User getByUsername(String username)
            throws UserServiceDelegateException;

    public abstract User getUserByEmail(String email)
            throws UserServiceDelegateException;

    /**
     * @param string
     * @param string2
     * @param string3
     */
    public abstract User addUser(String username, String password, String email)
            throws UserServiceDelegateException;

    /**
     * @return
     */
    public abstract Collection getAll() throws UserServiceDelegateException;

    public Collection getAllExpiredUsers() throws UserServiceDelegateException;
    
    public Collection getAllCurrentUsers() throws UserServiceDelegateException;
    
    public abstract User authenticate(String username, String password)
            throws UserServiceDelegateException;

    /**
     * @param target
     * @return
     */
    public abstract User find(Long target);

    public abstract Collection find(UserFilterParameters userFilterParameters);
    
    public abstract void save(User user);

    public abstract Collection getByGroup(UserGroup userGroup);

    // public abstract Collection getByOrganization(Organization organization);

    public abstract void delete(User targetUser)
            throws ServiceDelegateException;

}