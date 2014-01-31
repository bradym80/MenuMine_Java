/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;

/**
 * @author Reid
 *  
 */
public interface RollUpDao {

    public static final String SPRING_BEAN_NAME = "rollUpDao";

    public static final RollUpDaoFactory factory = new RollUpDaoFactory();

    public abstract RollUpOptions save(RollUpOptions savedQuery);

    public abstract RollUpOptions get(Long id);

    public abstract Collection search(final RollUpFilterParameters parameters);

    public abstract void delete(RollUpOptions rollUpOptions);

    public abstract void delete(Long id);

    //    public abstract Collection find(MasterFoodFilterParameters params)
    //            throws DAOException;

}