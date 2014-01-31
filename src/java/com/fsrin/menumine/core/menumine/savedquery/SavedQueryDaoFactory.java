/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.menumine.savedquery;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class SavedQueryDaoFactory {

    public SavedQueryDao build() {
        return (SavedQueryDao) SpringBeanBroker.getBeanFactory().getBean(
                SavedQueryDao.SPRING_BEAN_NAME);
    }
}