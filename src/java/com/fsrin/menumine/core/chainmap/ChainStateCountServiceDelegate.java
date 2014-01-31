/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import com.fsrin.menumine.common.ServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public interface ChainStateCountServiceDelegate extends ServiceDelegate {
    String SPRING_BEAN_NAME = "chainStateCountServiceDelegate";

    ChainStateCountServiceDelegateFactory factory = new ChainStateCountServiceDelegateFactory();

}