/*
 * Created on Jun 14, 2005
 *
 * 
 */
package com.fsrin.menumine.authorization;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.minefields.MineFields;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;
import com.fstx.stdlib2.authen.users.GroupRight;
import com.fstx.stdlib2.author.SecuredActionEnum;

/**
 * @author Nick This bean is used to build the display with respect to the users
 *         authorization.
 * 
 * It is rebuild for each request in the xwork.AuthorizationBeanInterceptor.java
 * By rebuilding it we can be sure that we accuratly reflect the current rights.
 *  
 */
public class AuthorizationBean implements Serializable {

    private boolean dessertMine;

    private boolean menumine;

    private boolean ingredientMine;

    private boolean breakfastMine;

    private boolean beverageMine;

    private boolean nationalAccountBenchmark;

    protected AuthorizationBean(Collection tokens) {
        super();
        this.setAuthorizationTokens(tokens);
    }

    private void setAuthorizationTokens(Collection tokens) {
        for (Iterator iter = tokens.iterator(); iter.hasNext();) {
            GroupRight element = (GroupRight) iter.next();
            if (element.getRightCode().equals(
                    SecuredActionEnum.DESSERT_MENU_MINE.getActionName())) {
                this.dessertMine = true;
            }
            if (element.getRightCode().equals(
                    SecuredActionEnum.MENU_MINE.getActionName())) {
                this.menumine = true;
            }
            if (element.getRightCode().equals(
                    SecuredActionEnum.NATIONAL_ACCOUNT_BENCHMARK
                            .getActionName())) {
                this.nationalAccountBenchmark = true;
            }

            if (element.getRightCode().equals(
                    SecuredActionEnum.INGREDIENT.getActionName())) {
                this.ingredientMine = true;
            }

            if (element.getRightCode().equals(
                    SecuredActionEnum.BEVERAGE.getActionName())) {
                this.beverageMine = true;
            }

            if (element.getRightCode().equals(
                    SecuredActionEnum.BREAKFAST.getActionName())) {
                this.breakfastMine = true;
            }

        }
    }

    public boolean isDessertMine() {
        return dessertMine;
    }

    public boolean isMenumine() {
        return menumine;
    }

    public boolean isNationalAccountBenchmark() {
        return nationalAccountBenchmark;
    }

    public void setNationalAccountBenchmark(boolean nationalAccountBenchmark) {
        this.nationalAccountBenchmark = nationalAccountBenchmark;
    }

    public boolean isJustNationalAccountBenchmark() {
        return !dessertMine && !menumine && nationalAccountBenchmark;
    }

    public boolean isIngredientMine() {
        return ingredientMine;
    }

    public boolean isBeverageMine() {
        return beverageMine;
    }

    public boolean isBreakfastMine() {
        return breakfastMine;
    }

    public boolean isAuthorized(MineFields targetMine) {

        if (targetMine.getMineType()
                .equals(MineFieldsFactory.MINE_TYPE_DESSERT)) {
            return this.isDessertMine();
        }
        if (targetMine.getMineType().equals(MineFieldsFactory.MINE_TYPE_MENU)) {
            return this.isMenumine();
        }

        if (targetMine.getMineType().equals(
                MineFieldsFactory.MINE_TYPE_INGREDIENT)) {
            return this.isIngredientMine();
        }

        if (targetMine.getMineType().equals(
                MineFieldsFactory.MINE_TYPE_BEVERAGE)) {
            return this.isBeverageMine();
        }

        if (targetMine.getMineType().equals(
                MineFieldsFactory.MINE_TYPE_BREAKFAST)) {
            return this.isBreakfastMine();
        }

        return false;
    }
}