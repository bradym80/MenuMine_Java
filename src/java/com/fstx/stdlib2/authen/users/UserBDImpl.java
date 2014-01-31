/*
 * Created on Oct 29, 2003
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;
import java.util.Date;

/**
 * @author Nick
 *  
 */
public class UserBDImpl implements UserBD {

    private UserDao userDao;

    public void changePassword(String username, String currentPassword,
            String newPassword) throws ChangePasswordException {
        /*
         * Get user Verify password Set users password to new password Save
         * user.
         */
        UserFilterParameters params = new UserFilterParameters();
        UserDao dao = this.getUserDao();
        //Should be unique.
        params.setUsername(username);
        try {
            User user = getSingleUser(dao.find(params));
            if (!(user.getPassword().equals(currentPassword))) {
                throw new ChangePasswordException("Current Password invalid.");
            }

            user.setPassword(newPassword);
            dao.saveUser(user);

        } catch (Exception e) {
            throw new ChangePasswordException();
        }

    }

    /*
     * This is a utility to get a user from a collection were it is necessary
     * that the collection has a single instance, thus an exception if not
     * single.
     */
    private User getSingleUser(Collection collection)
            throws EmptyUserCollectionException, NotSingleUserException {
        if (collection.size() == 1) {
            return (User) collection.iterator().next();
        } else if (collection.size() < 1) {
            throw new EmptyUserCollectionException();
        } else if (collection.size() > 1) {
            throw new NotSingleUserException();
        }
        return null;
    }

    public User getByUsername(String username) throws UserBDException {
        User ret = null;

        UserFilterParameters filter = new UserFilterParameters();
        filter.setUsername(username);

        try {
            ret = getSingleUser(this.getUserDao().find(filter));
        } catch (EmptyUserCollectionException e) {
            //e.printStackTrace();
            throw new UserBDException(e);
        } catch (NotSingleUserException e) {
            //e.printStackTrace();
            throw new UserBDException(e);
        }

        return ret;
    }
    
    

    public User getUserByEmail(String email) throws UserBDException {
        User ret;
        try {
            ret = this.getUserDao().getUserByEmail(email);
        } catch (DaoException e) {
            throw new UserBDException();
        }
        return ret;
    }

    /**
     * @param string
     * @param string2
     * @param string3
     */
    public User addUser(String username, String password, String email)
            throws UserBDException {
        User t = new User();

        t.setUsername(username);
        t.setPassword(password);
        t.setEmail(email);

        t = this.getUserDao().saveUser(t);

        return t;
    }

    /**
     * @return
     */
    public Collection getAll() throws UserBDException {
        UserFilterParameters params = new UserFilterParameters();

        return this.getUserDao().find(params);

    }
    
    

    /**
     * @return
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * @param userDAO
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib.authen.users.UserBD#updateUserEmail(java.lang.String)
     */
    public User updateUserEmail(String oldEmail, String newEmail)
            throws UserBDException {

        User user;

        user = this.getUserByEmail(oldEmail);

        if (!oldEmail.equals(newEmail)) {
            user.setEmail(newEmail);

            this.getUserDao().saveUser(user);
        }
        return user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib.authen.users.UserBD#changePassword(com.fstx.stdlib.authen.users.User,
     *      java.lang.String)
     */
    public void changePassword(User user, String newPassword)
            throws ChangePasswordException {
        user.setPassword(newPassword);

        this.getUserDao().saveUser(user);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib.authen.users.UserBD#makeInactive(com.fstx.stdlib.authen.users.User)
     */
    public User makeInactive(User user) throws UserBDException {

        user.setInactive(true);

        return this.getUserDao().saveUser(user);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib.authen.users.UserBD#makeActive(com.fstx.stdlib.authen.users.User)
     */
    public User makeActive(User user) throws UserBDException {
        user.setInactive(false);

        return this.getUserDao().saveUser(user);

    }

    public void delete(User user) throws UserBDException {
        this.getUserDao().delete(user);
    }

    public Collection getAllExpiredUsers() throws UserBDException {
        
        UserFilterParameters p = new UserFilterParameters();
        p.setExpiresBefore(new Date());
       
        Collection ret = this.getUserDao().find(p);
        
        return ret;
    }

    public Collection getAllCurrentUsers() throws UserBDException {
        
        UserFilterParameters p = new UserFilterParameters();
        p.setExpiresOnOrAfter(new Date());
        
        Collection ret = this.getUserDao().find(p);
        
        return ret;
    }
}