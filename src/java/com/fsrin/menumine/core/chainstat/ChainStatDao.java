/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.chainstat;

import java.util.Collection;

/**
 * @author Reid
 *  
 */
public interface ChainStatDao {

    public static final String SPRING_BEAN_NAME = "chainStatDao";

    public static final ChainStatDaoFactory factory = new ChainStatDaoFactory();

    public abstract ChainStat save(ChainStat ChainStat);

    public abstract ChainStat get(Long id);

    public abstract void delete(ChainStat ChainStat);

    public abstract void delete(Long id);

    public abstract Collection find(ChainStatFilterParameters params);

    public Collection getDistinct(String query);

}