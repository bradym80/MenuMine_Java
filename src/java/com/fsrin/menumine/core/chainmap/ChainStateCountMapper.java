/*
 * Created on Jul 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

/**
 * @author Nick
 * 
 *  
 */
public abstract class ChainStateCountMapper {

    public static ChainStateCountMapperFactory factory = new ChainStateCountMapperFactory();

    public ChainStateCountMapper() {
        super();

    }

    public abstract Object getKey();

    public abstract Long getValue(ChainStateCount chainStateCount);

    public abstract Object getStateKey();

}