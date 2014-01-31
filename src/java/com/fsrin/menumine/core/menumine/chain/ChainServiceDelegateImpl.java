
package com.fsrin.menumine.core.menumine.chain;

import java.util.Collection;

import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.core.chainstat.ChainStat;

/**
 * @author Nick
 * 
 * This class is basicaly a wrapper for the DAO.
 * 
 * This makes it easier if we change Data sources and have to create a new DAO.
 */
public class ChainServiceDelegateImpl implements ChainServiceDelegate,
        ChainDaoAware {

    private ChainDao chainDAO;

    public ChainServiceDelegateImpl() {
        super();

    }

    public Collection search(ChainFilterParameters filterParameters) {

        Collection col = this.getChainDAO().find(filterParameters);

        return col;

    }

    public void setChainDAO(ChainDao masterFoodDAO) {
        this.chainDAO = masterFoodDAO;
    }

    private ChainDao getChainDAO() {
        return chainDAO;
    }



    public ChainStat find(String chainName) {
        
        Chain options = new Chain();
        options.setOperationName(chainName);
        
        String q = "from " + ChainStat.class.getName() + " as c where c.operationName = :operationName ";
        
        Collection c = GenericDAOFactory.factory.buildData().find(q, options);
        
        if (c.size() == 1)
            return (ChainStat) c.toArray()[0];
        
        return null;
    }

}