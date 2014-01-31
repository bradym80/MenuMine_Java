/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.masterfood;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

/**
 * @author Reid
 *  
 */
public class MasterFoodDaoFactory extends AbstractSpringObjectFactory {

    public MasterFoodDao build() {
        return (MasterFoodDao) super.build(MasterFoodDao.SPRING_BEAN_NAME);
    }
}