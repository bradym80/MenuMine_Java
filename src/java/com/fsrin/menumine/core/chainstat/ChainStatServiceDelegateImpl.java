/*
 * Created on Jan 17, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainstat;

import java.util.Collection;

/**
 * @author Nick
 * 
 * This class is basicaly a wrapper for the DAO.
 * 
 * This makes it easier if we change Data sources and have to create a new DAO.
 */
public class ChainStatServiceDelegateImpl implements ChainStatServiceDelegate,
        ChainStatDaoAware {

    private ChainStatDao chainStatDAO;

    public ChainStatServiceDelegateImpl() {
        super();

    }

    public Collection find(ChainStatFilterParameters filterParameters)
            throws ChainStatSearchException {

        Collection col = this.getChainStatDao().find(filterParameters);

        return col;

    }

    public void setChainStatDao(ChainStatDao chainStatDAO) {
        this.chainStatDAO = chainStatDAO;
    }

    private ChainStatDao getChainStatDao() {
        return chainStatDAO;
    }

    public Collection getDistinctSegments() {

        return this.getChainStatDao().getDistinct(
                ChainStatDaoImpl.SELECT_MARKET_SEGMENT_BY_DISTINCT);
    }

    public Collection getDistinctSectorNames() {

        return this.getChainStatDao().getDistinct(
                ChainStatDaoImpl.SELECT_MARKET_SECTOR_BY_DISTINCT);

    }

    public Collection getDistinctOperationNames() {

        return this.getChainStatDao().getDistinct(
                ChainStatDaoImpl.SELECT_OPERATION_NAME_BY_DISTINCT);

    }

    public ChainStat getById(Long target)
            throws ChainStatServiceDelegateException {

        return this.getChainStatDao().get(target);

    }

    public void save(ChainStat chainStat)
            throws ChainStatServiceDelegateException {

        this.getChainStatDao().save(chainStat);

    }

}