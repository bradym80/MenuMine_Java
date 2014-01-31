/*
 * Created on Jan 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodBuilder;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;

/**
 * @author Reid
 * @author Nick
 * 
 * This class is basicaly a wrapper for the DAO.
 * 
 * This makes it easier if we change Data sources and have to create a new DAO.
 * 
 * 2006-01-24 RSC includes some experimental HQL words.
 */
public class MasterFoodServiceDelegateImpl implements
        MasterFoodServiceDelegate, MasterFoodDaoAware {

    private static Log log = LogFactory
            .getLog(MasterFoodServiceDelegateImpl.class);

    private MasterFoodDao masterFoodDAO;

    public MasterFoodServiceDelegateImpl() {
        super();

    }

    public Collection searchMasterFood(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        Collection col = this.getMasterFoodDao().findUsingCriteria(
                filterParameters);
        return col;

    }

//    public Collection searchMasterFoodExpress(
//            MasterFoodFilterParameters filterParameters)
//            throws MasterFoodSearchException {
//
//        Collection col = this.getMasterFoodDao().findExpressUsingCriteria(
//                filterParameters);
//        return col;
//
//    }

    public void setMasterFoodDao(MasterFoodDao masterFoodDAO) {
        this.masterFoodDAO = masterFoodDAO;
    }

    private MasterFoodDao getMasterFoodDao() {
        return masterFoodDAO;
    }

    public Long getCount(MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        try {
            return this.getMasterFoodDao().getCount(filterParameters);
        } catch (Exception e) {

            // throw new MasterFoodSearchException(e);
            LogFactory.getLog(this.getClass()).info("Error getting count!");
            LogFactory.getLog(this.getClass()).info(e.getMessage());
            LogFactory.getLog(this.getClass()).info(e.getStackTrace());
            return null;
        }
    }

//    public Collection searchMasterFoodKeywords(
//            MasterFoodKeywordFilterParameters parameters)
//            throws MasterFoodSearchException {
//
//        return this.getMasterFoodDao().find(parameters);
//    }

    public Collection searchMasterFoodByHQLConjunction(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        return this.getMasterFoodDao().findUsingHQLConjunction(filterParameters);

    }
    
    public Collection searchMasterFoodByHQLDisjunction(
            MasterFoodFilterParameters filterParameters)
            throws MasterFoodSearchException {

        return this.getMasterFoodDao().findUsingHQLDisjunction(filterParameters);

    }

    public Collection searchMasterFoodByHQL(String query,
            MasterFoodFilterParameters displaySettings)
            throws MasterFoodSearchException {

        Collection raw = GenericDAOFactory.factory.buildData().find(query);

        Collection c = new MasterFoodBuilder().buildFromObjectCollection(raw,
                displaySettings);

        return c;

    }

    public Collection searchMasterFoodByHQL(
            MasterFoodFilterParameters displayParameters,
            MasterFoodFilterParameters selectParameters)
            throws MasterFoodSearchException {

        StringBuffer query = new MasterFoodQueryBuilder()
                .getQueryWithSelectedFields(displayParameters, selectParameters);

        Collection raw = GenericDAOFactory.factory.buildData().find(
                query.toString());

        Collection c = new MasterFoodBuilder().buildFromObjectCollection(raw,
                displayParameters);

        return c;
    }

    // public Collection searchMasterFoodByHQL(
    // MasterFoodFilterParameters filterParameters,
    // FilterParameter[] extraParameters) throws MasterFoodSearchException {
    //
    // return this.getMasterFoodDao().findUsingHQL(filterParameters,
    // extraParameters);
    //
    // }

}