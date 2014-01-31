/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine;

/**
 * @author Reid
 *  
 */
public interface MasterFoodFilterParametersDao {

    public static final String SPRING_BEAN_NAME = "masterFoodfilterParametersDao";

    public static final MasterFoodFilterParametersDaoFactory factory = new MasterFoodFilterParametersDaoFactory();

    public abstract MasterFoodFilterParameters save(
            MasterFoodFilterParameters masterFood);

    public abstract MasterFoodFilterParameters get(Long id);

    public abstract void delete(MasterFoodFilterParameters masterFood);

    public abstract void delete(Long id);

    //    public abstract Collection find(MasterFoodFilterParameters params)
    //            throws DAOException;

}