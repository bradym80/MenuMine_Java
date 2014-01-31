/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class CannedSchematicServiceDelegateFactory {

    public CannedSchematicServiceDelegate build() {
        return (CannedSchematicServiceDelegate) SpringBeanBroker
                .getBeanFactory().getBean(
                        CannedSchematicServiceDelegate.SPRING_BEAN_NAME);
    }
}