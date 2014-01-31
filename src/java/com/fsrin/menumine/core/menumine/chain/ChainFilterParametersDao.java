/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.chain;

/**
 * @author Reid
 *  
 */
public interface ChainFilterParametersDao {

    public static final String SPRING_BEAN_NAME = "chainfilterParametersDao";

    public static final ChainFilterParametersDaoFactory factory = new ChainFilterParametersDaoFactory();

    public abstract ChainFilterParameters save(ChainFilterParameters masterFood);

    public abstract ChainFilterParameters get(Long id);

    public abstract void delete(ChainFilterParameters masterFood);

    public abstract void delete(Long id);

    //    public abstract Collection find(MasterFoodFilterParameters params)
    //            throws DAOException;

}