/*
 * Created on Mar 8, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood.legacy;

import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodDao;

/**
 * @author Nick
 * 
 *  
 */
public class MasterFoodPageableResultsIterator implements Iterator {

    private int PAGE_SIZE = 5000;

    private MasterFoodFilterParametersImpl params;

    private MasterFoodDao dao;

    private Collection current;

    private Iterator currentIter;

    private int currentIndex = 0;

    private boolean done = false;

    private boolean loop = true;

    public MasterFoodPageableResultsIterator() {
        super();
        init();

    }

    public MasterFoodPageableResultsIterator(
            MasterFoodFilterParametersImpl params, MasterFoodDao dao) {
        this.params = params;
        this.dao = dao;
        init();
    }

    public void remove() {
        throw new RuntimeException("Not Impl");
    }

    public boolean hasNext() {

        if (!done) {
            return true;
        } else {
            return currentIter.hasNext();
        }

    }

    private int count = 0;

    public Object next() {

        if (!currentIter.hasNext()) {
            this.update();
        }
        count++;
        return currentIter.next();
    }

    private void init() {

        if (currentIter == null) {
            update();

        }
    }

    private void update() {

        params.setFirstResult(new Long(currentIndex));
        params.setLimit(new Long(PAGE_SIZE));

        current = dao.findUsingCriteria(params);
        currentIter = current.iterator();

        loop = current.size() == PAGE_SIZE;
        if (currentIndex > PAGE_SIZE * 4) {
            loop = false;
        }

        currentIndex += PAGE_SIZE;
        if (!loop) {
            done = true;
        }
    }

}