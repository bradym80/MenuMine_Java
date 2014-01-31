/*
 * Created on Jan 28, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.masterfood;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class MasterFoodServiceDelegateFactory extends AbstractSpringObjectFactory {

    public static final String SPRING_BEAN_NAME="masterFoodServiceDelegate";
    
    public static final MasterFoodServiceDelegateFactory factory = new MasterFoodServiceDelegateFactory();
    
    public MasterFoodServiceDelegate build() {
        return (MasterFoodServiceDelegate) this.build(SPRING_BEAN_NAME);
    }
}
