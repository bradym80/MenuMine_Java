/*
 * Created on Jan 17, 2005
 *
 * 
 */
package com.fstx.stdlib2.authen.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Nick
 * 
 *  
 */
public class UserRole {
    private static Collection all = new ArrayList();

    public static final UserRole STANDARD = new UserRole("STANDARD");

    public static final UserRole ADMIN = new UserRole("ADMIN");

    public static final UserRole FREE = new UserRole("FREE");
    
    public static final UserRole DEMO = new UserRole("DEMO");
    
    public static final UserRole PROMO = new UserRole("PROMO");

    private String name;

    public UserRole(String name) {
        super();
        this.name = name;
        all.add(this);
    }

    public static Collection getAll() {
        return all;
    }

    public static UserRole getByName(String name) {
        for (Iterator i = getAll().iterator(); i.hasNext();) {
            UserRole ur = (UserRole) i.next();
            if (ur.getName().equals(name)) {
                return ur;
            }
        }
        return null;
    }

    public String getFriendlyName() {
        String friendlyName = this.getName();
        friendlyName = friendlyName.toLowerCase();
        String[] tokens = friendlyName.split("_");
        friendlyName = "";
        //  friendlyName = friendlyName.replaceAll("_", " ");
        for (int i = 0; i < tokens.length; i++) {
            String capToken = "";
            String[] splitToken = tokens[i].split("");

            /*
             * Index 1 is white space.
             */
            capToken = splitToken[1].toUpperCase();

            for (int j = 2; j < splitToken.length; j++) {
                capToken += splitToken[j];
            }
            friendlyName += " " + capToken;
        }

        return friendlyName;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}