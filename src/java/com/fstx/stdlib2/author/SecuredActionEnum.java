/*
 * Created on May 27, 2004
 *
 */
package com.fstx.stdlib2.author;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.enums.Enum;

/**
 * @author Reid When adding a SecuredAction, update the SecuredActionFinder,
 *         this is used by the commen elements to make use it can be added to
 *         the parent.
 *  
 */
public class SecuredActionEnum extends Enum {

    public static final SecuredAction MENU_MINE = SecuredAction.factory
            .build("MENU_MINE");

    public static final SecuredAction DESSERT_MENU_MINE = SecuredAction.factory
            .build("DESSERT_MENU_MINE");

    public static final SecuredAction NATIONAL_ACCOUNT_BENCHMARK = SecuredAction.factory
            .build("NATIONAL_ACCOUNT_BENCHMARK");

    public static final SecuredAction INGREDIENT = SecuredAction.factory
            .build("INGREDIENT");

    public static final SecuredAction BEVERAGE = SecuredAction.factory
            .build("BEVERAGE");

    public static final SecuredAction BREAKFAST = SecuredAction.factory
            .build("BREAKFAST");

    /**
     * @param arg0
     */
    protected SecuredActionEnum(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public static Collection getAll() {

        Collection all = new ArrayList();

        all.add(MENU_MINE);
        all.add(DESSERT_MENU_MINE);
        all.add(NATIONAL_ACCOUNT_BENCHMARK);
        all.add(INGREDIENT);
        all.add(BREAKFAST);
        all.add(BEVERAGE);
        return all;

    }

    public static SecuredAction getByName(String name) {
        for (Iterator i = getAll().iterator(); i.hasNext();) {
            SecuredAction sa = (SecuredAction) i.next();
            if (sa.getActionName().equals(name)) {
                return sa;
            }
        }
        return null;
    }

}