/*
 * Created on Jun 14, 2004
 *
 */
package com.fsrin.menumine.core.forum;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author Reid
 *  
 */
public class ForumMessageDaoFactory {

    public ForumMessageDao build() {
        return (ForumMessageDao) SpringBeanBroker.getBeanFactory().getBean(
                ForumMessageDao.SPRING_BEAN_NAME);
    }
}