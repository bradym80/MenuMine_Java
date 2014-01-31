/*
 * Created on Aug 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.express;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.authorization.AuthorizationBean;
import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * 
 *  
 */
public class AuthorizationBeanMockImpl extends AuthorizationBean {

    public AuthorizationBeanMockImpl(Collection tokens) {
        super(tokens);

    }

    public AuthorizationBeanMockImpl() {
        super(new ArrayList());
    }

    public boolean isAuthorized(MineFields targetMine) {

        return true;
    }

    public boolean isBeverageMine() {

        return true;
    }

    public boolean isBreakfastMine() {

        return true;
    }

    public boolean isDessertMine() {

        return true;
    }

    public boolean isIngredientMine() {

        return true;
    }

    public boolean isJustNationalAccountBenchmark() {

        return false;
    }

    public boolean isMenumine() {

        return true;
    }

    public boolean isNationalAccountBenchmark() {

        return true;
    }

}