/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine;

/**
 * @author Reid
 *  
 */
public interface FieldsToDisplayBeanDao {

    public static final String SPRING_BEAN_NAME = "fieldsToDisplayBeanDao";

    public static final FieldsToDisplayBeanDaoFactory factory = new FieldsToDisplayBeanDaoFactory();

    public abstract FieldsToDisplayBean save(FieldsToDisplayBean savedQuery);

    public abstract FieldsToDisplayBean get(Long id);

    public abstract void delete(FieldsToDisplayBean fieldsToDisplayBean);

    public abstract void delete(Long id);

    //    public abstract Collection find(MasterFoodFilterParameters params)
    //            throws DAOException;

}