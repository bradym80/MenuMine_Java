package com.fsrin.menumine.core.chainstat;

import java.util.Collection;

/*
 * Created on Jan 17, 2005
 *
 * 
 */

/**
 * @author Nick
 * 
 *  
 */
public interface ChainStatServiceDelegate {

    public static String SPRING_BEAN_NAME = "chainStatServiceDelegate";

    public static ChainStatServiceDelegateFactory factory = new ChainStatServiceDelegateFactory();

    public Collection find(ChainStatFilterParameters filterParameters)
            throws ChainStatSearchException;

    //public Long getCount(ChainStatFilterParameters filterParameters) throws
    // ChainStatSearchException;

    public Collection getDistinctSegments();

    public Collection getDistinctSectorNames();

    public Collection getDistinctOperationNames();

    public ChainStat getById(Long target)
            throws ChainStatServiceDelegateException;

    public void save(ChainStat chainStat)
            throws ChainStatServiceDelegateException;
}