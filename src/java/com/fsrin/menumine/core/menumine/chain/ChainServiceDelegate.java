package com.fsrin.menumine.core.menumine.chain;

import java.util.Collection;

import com.fsrin.menumine.core.chainstat.ChainStat;

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
public interface ChainServiceDelegate {

    public ChainStat find(String chainName);
    
   
    public Collection search(
            ChainFilterParameters filterParameters);
            

   

}