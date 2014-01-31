/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.chain;

import java.util.Collection;


/**
 * @author Reid
 *  
 */
public interface ChainDao {

    public static final String SPRING_BEAN_NAME = "chainDao";

    public static final ChainDaoFactory factory = new ChainDaoFactory();

    public abstract Chain save(Chain chain);

    public abstract Chain get(Long id);

    public abstract void delete(Chain chain);

    public abstract void delete(Long id);

    public abstract Collection find(ChainFilterParameters params);

}