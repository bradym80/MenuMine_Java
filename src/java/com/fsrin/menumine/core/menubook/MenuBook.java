/*
 * Created on Mar 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menubook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.chainstat.ChainStat;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.masterfood.MasterFood;

/**
 * @author Nick
 * 
 * 
 */
public class MenuBook {

    private ChainStat chain;

    /* Collection of MenuBookMenuParts */
    private Map menuParts = new HashMap();

    public ChainStat getChain() {
        return chain;
    }

    public void setChain(ChainStat chain) {
        this.chain = chain;
    }

    public Collection getMenuParts() {
        TreeSet sorted = new TreeSet(new MMSorter().getDescending(
                "menuItems.size()", "name"));
        sorted.addAll(menuParts.values());
        return sorted;
    }

    public void addAll(Collection results) {
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            MasterFood element = (MasterFood) iter.next();
            if (this.chain == null) {
                // this.chain = element.getChain();
                this.chain = ChainServiceDelegateFactory.factory.build().find(
                        element.getOperationName());

            }
            this.add(element);
        }
    }

    public void add(MasterFood masterFood) {
        MenuBookMenuPart menuPart = (MenuBookMenuPart) menuParts.get(masterFood
                .getGenMenuPart());
        if (menuPart == null) {
            menuPart = new MenuBookMenuPart();
            menuPart.setName(masterFood.getGenMenuPart());
            menuParts.put(masterFood.getGenMenuPart(), menuPart);
        }

        menuPart.getMenuItems().add(masterFood);

    }
}