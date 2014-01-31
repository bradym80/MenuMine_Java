/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.Collection;

/**
 * @author Reid
 *  
 */
public interface SavedQueryDao {

    public static final String SPRING_BEAN_NAME = "savedQueryDao";

    public static final SavedQueryDaoFactory factory = new SavedQueryDaoFactory();

    public abstract SavedQuery update(SavedQuery savedQuery);
    
    public abstract SavedQuery saveNew(SavedQuery savedQuery);

    public abstract SavedQuery get(Long id);

    public abstract Collection search(
            final SavedQueryFilterParameters parameters);

    public abstract void delete(SavedQuery masterFood);

    public abstract void delete(Long id);

    //    public abstract Collection find(MasterFoodFilterParameters params)
    //            throws DAOException;

}