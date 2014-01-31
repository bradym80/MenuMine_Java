/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.common;

/**
 * @author Reid
 *  
 */
public interface FilterParameterDao {

    public static final String SPRING_BEAN_NAME = "filterParameterDao";

    public static final FilterParameterDaoFactory factory = new FilterParameterDaoFactory();

    public abstract FilterParameter save(FilterParameter masterFood);

    public abstract FilterParameter get(Long id);

    public abstract void delete(FilterParameter masterFood);

    public abstract void delete(Long id);

    //    public abstract Collection find(MasterFoodFilterParameters params)
    //            throws DAOException;

}