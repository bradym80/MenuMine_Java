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
 * We don't need this. 2005.6.27
 */
public class MasterFoodPageableResults implements Collection {

    private MasterFoodFilterParametersImpl params;

    private MasterFoodDao dao;

    public MasterFoodPageableResults(MasterFoodFilterParametersImpl params,
            MasterFoodDao dao) {
        this.params = params;
        this.dao = dao;
    }

    public int size() {

        try {
            return dao.getCount(params).intValue();
        } catch (Exception e) {

            e.printStackTrace();
            return -1;
        }

    }

    public void clear() {
        this.params = null;
    }

    public boolean isEmpty() {

        return this.size() == 0;
    }

    public Object[] toArray() {

        throw new RuntimeException("Not Impl");
    }

    public boolean add(Object o) {
        throw new RuntimeException("Not Impl");
    }

    public boolean contains(Object o) {
        throw new RuntimeException("Not Impl");
    }

    public boolean remove(Object o) {
        throw new RuntimeException("Not Impl");
    }

    public boolean addAll(Collection c) {
        throw new RuntimeException("Not Impl");
    }

    public boolean containsAll(Collection c) {
        throw new RuntimeException("Not Impl");
    }

    public boolean removeAll(Collection c) {
        throw new RuntimeException("Not Impl");
    }

    public boolean retainAll(Collection c) {
        throw new RuntimeException("Not Impl");
    }

    public Iterator iterator() {
        return new MasterFoodPageableResultsIterator(params, dao);
    }

    public Object[] toArray(Object[] a) {

        throw new RuntimeException("Not Impl");
    }

}