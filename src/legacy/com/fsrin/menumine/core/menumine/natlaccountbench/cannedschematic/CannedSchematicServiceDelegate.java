/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic;

import com.fsrin.menumine.common.ServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public interface CannedSchematicServiceDelegate extends ServiceDelegate {
    String SPRING_BEAN_NAME = "cannedSchematicServiceDelegate";

    CannedSchematicServiceDelegateFactory factory = new CannedSchematicServiceDelegateFactory();

}