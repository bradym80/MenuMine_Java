/*
 * Created on Jun 14, 2004
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;

/**
 * @author Reid
 *  
 */
public interface UserBD extends UserDaoAware {

    public static final String SPRING_BEAN_NAME = "userBD";

    public static final UserBDFactory factory = new UserBDFactory();

    public abstract void changePassword(String username,
            String currentPassword, String newPassword)
            throws ChangePasswordException;

    public abstract void changePassword(User user, String newPassword)
            throws ChangePasswordException;

    public abstract User getByUsername(String username) throws UserBDException;

    public abstract User getUserByEmail(String email) throws UserBDException;

    /**
     * @param string
     * @param string2
     * @param string3
     */
    public abstract User addUser(String username, String password, String email)
            throws UserBDException;

    /**
     * @return
     */
    public abstract Collection getAll() throws UserBDException;

    public abstract User updateUserEmail(String oldEmail, String newEmail)
            throws UserBDException;

    public abstract User makeInactive(User user) throws UserBDException;

    public abstract User makeActive(User user) throws UserBDException;

    public void delete(User user) throws UserBDException;

    public Collection getAllExpiredUsers() throws UserBDException;
    
    public Collection getAllCurrentUsers() throws UserBDException;
}