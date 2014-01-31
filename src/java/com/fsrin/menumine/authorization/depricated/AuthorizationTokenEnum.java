/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization.depricated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.enums.Enum;

/**
 * @author Nick
 * 
 *  
 */
public class AuthorizationTokenEnum extends Enum {

    private static final Collection<AuthorizationTokenEnum> all = new ArrayList<AuthorizationTokenEnum>();

    public static final AuthorizationTokenEnum DESSERT_MENUMINE = new AuthorizationTokenEnum(
            "dessert.menumine");

    public static final AuthorizationTokenEnum MENUMINE = new AuthorizationTokenEnum(
            "menumine");

    public AuthorizationTokenEnum(String key) {
        super(key);
        all.add(this);
    }

    public static AuthorizationTokenEnum getByName(String tokenKey) {

        for (Iterator iter = getAll().iterator(); iter.hasNext();) {
            AuthorizationTokenEnum element = (AuthorizationTokenEnum) iter
                    .next();
            if (element.getName().equals(tokenKey)) {
                return element;
            }
        }
        return null;
    }

    public static Collection getAll() {
        return all;
    }

}