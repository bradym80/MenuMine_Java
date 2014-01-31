/*
 * Created on Oct 29, 2003
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.fsrin.menumine.common.ServiceDelegateException;

/**
 * @author Nick
 *  
 */
public class UserServiceDelegateImpl implements UserServiceDelegate {

    private UserDao userDao;

    public UserServiceDelegateImpl() {
        super();
    }

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
            return null;
        } else if (collection.size() > 1) {
            throw new NotSingleUserException();
        }
        return null;
    }

    public User getByUsername(String username)
            throws UserServiceDelegateException {
        User ret = null;

        UserFilterParameters filter = new UserFilterParameters();
        filter.setUsername(username);

        try {
            ret = getSingleUser(this.getUserDao().find(filter));
        } catch (Exception e) {
            throw new UserServiceDelegateException(e);
        }

        return ret;
    }

    public User getUserByEmail(String email)
            throws UserServiceDelegateException {
        List u = this.getUserDao().searchUsers(UserDao.SELECT_BY_EMAIL, email);

        //        if (u.size() == 0)
        //            throw new DaoException("user not found");
        //
        //        if (u.size() > 1)
        //            throw new DaoException(
        //                    "Somehow we have more than one user with this email");
        //
        User ret;
        try {
            ret = getSingleUser(u);
        } catch (Exception e) {
            throw new UserServiceDelegateException(e);

        }
        return ret;
    }

    /**
     * @param string
     * @param string2
     * @param string3
     */
    public User addUser(String username, String password, String email)
            throws UserServiceDelegateException {
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
    public Collection getAll() throws UserServiceDelegateException {
        UserFilterParameters params = new UserFilterParameters();
        return this.getUserDao().find(params);

    }

    public Collection getAllExpiredUsers() throws UserServiceDelegateException {
        
        UserFilterParameters p = new UserFilterParameters();
        p.setExpiresBefore(new Date());
       
        Collection ret = this.getUserDao().find(p);
        
        return ret;
    }

    public Collection getAllCurrentUsers() throws UserServiceDelegateException {
        
        UserFilterParameters p = new UserFilterParameters();
        p.setExpiresOnOrAfter(new Date());
        
        Collection ret = this.getUserDao().find(p);
        
        return ret;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserDaoAware#getUserDAP()
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @return
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserServiceDelegate#authenticate(java.lang.String,
     *      java.lang.String)
     */
    public User authenticate(String username, String password)
            throws UserServiceDelegateException {

        User ret;
        try {
            ret = this.getUserDao().authenticateUser(username, password);
        } catch (DaoException e) {
            throw new UserServiceDelegateException(e);
        }

        return ret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserServiceDelegate#find(java.lang.Long)
     */
    public User find(Long target) {

        return this.getUserDao().getUser(target);

    }
    
    public Collection find(UserFilterParameters userFilterParameters) {
        return this.getUserDao().find(userFilterParameters);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserServiceDelegate#save(com.fstx.stdlib2.authen.users.User)
     */
    public void save(User user) {
        this.getUserDao().saveUser(user);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.fstx.stdlib2.authen.users.UserServiceDelegate#getByGroup(com.fstx.stdlib2.authen.users.UserGroup)
     */
    public Collection getByGroup(UserGroup userGroup) {
        return this.getUserDao().getUsersByGroup(userGroup);
    }

    public void delete(User targetUser) throws ServiceDelegateException {

        UserGroupServiceDelegate.factory.build().leaveAll(targetUser);

        this.getUserDao().delete(targetUser);
    }

}