/*
 * Created on Mar 29, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.sharetable;

import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 *  
 */
public interface StatisticalTableKeyFinder {

    public static String NOT_ON_MENU = "Not On Menu";

    public static StatisticalTableKeyFinderFactory factory = new StatisticalTableKeyFinderFactory();

    public Object getKey(MasterFood masterFood);

}