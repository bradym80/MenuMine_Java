/*
 * Created on Aug 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.fstx.stdlib2.authen.webwork;

import java.util.Date;

import com.fstx.stdlib2.authen.users.User;

/**
 * @author Nick
 * 
 *  
 */
public class UserParameters {

    private String passwordConfirm;

    private User user;

    public Long getId() {
        return user.getId();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getCompany() {
        return user.getCompany();
    }

    public void setCompany(String company) {
        user.setCompany(company);
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfConfirm) {
        this.passwordConfirm = passwordConfConfirm;
    }

    /*
     * This will prevent us from accidentaly returning an invalid User and
     * letting it be saved.
     */
    public User getUser() {
        if (this.isValid()) {
            return user;
        }
        return null;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isValid() {
        //        /*
        //         * nah 2005.3.14 If we are modifying we don't need to enter the
        //         * password.
        //         */
        //        if (this.user.getId() != null) {
        //            return true;
        //        }

//        if (this.getPassword() == null || this.getPasswordConfirm() == null) {
        if (this.getPassword() == null ) {
            return false;
        }

        if (this.getPassword().length() == 0) {
            return false;
        }

//        if (this.getPassword().equals(this.getPasswordConfirm())) {
//            return true;
//        }
        return true;
    }

    public String getRoleName() {
        return user.getRoleName();
    }

    public boolean isInactive() {
        return user.isInactive();
    }

    public void setInactive(boolean inactive) {
        user.setInactive(inactive);
    }

    public void setRoleName(String roleName) {
        user.setRoleName(roleName);
    }

    public Date getExpirationDate() {
        return user.getExpirationDate();
    }

    public void setExpirationDate(Date expirationDate) {
        user.setExpirationDate(expirationDate);
    }

    public void setId(Long id) {
        user.setId(id);
    }

    public String getComments() {
        return user.getComments();
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }

    public void setComments(String comments) {
        user.setComments(comments);
    }

    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    public String getCity() {
        return user.getCity();
    }

    public String getPhone() {
        return user.getPhone();
    }

    public String getState() {
        return user.getState();
    }

    public String getStreet1() {
        return user.getStreet1();
    }

    public String getStreet2() {
        return user.getStreet2();
    }

    public String getZip() {
        return user.getZip();
    }

    public void setCity(String city) {
        user.setCity(city);
    }

    public void setPhone(String phone) {
        user.setPhone(phone);
    }

    public void setState(String state) {
        user.setState(state);
    }

    public void setStreet1(String street1) {
        user.setStreet1(street1);
    }

    public void setStreet2(String street2) {
        user.setStreet2(street2);
    }

    public void setZip(String zip) {
        user.setZip(zip);
    }
    
    
}