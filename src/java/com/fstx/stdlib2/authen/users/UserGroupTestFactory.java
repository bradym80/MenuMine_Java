/*
 * Created on Dec 2, 2003
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author REID
 *  
 */
public class UserGroupTestFactory {

    private static int count = 0;

    public static final UserGroupTestFactory singleton = new UserGroupTestFactory();

    private static UserGroupDao getDao() {
        return (UserGroupDao) SpringBeanBroker.getBeanFactory().getBean(
                "userGroupLiveDao");
    }

    public static UserGroup getPersisted() throws Exception {
        count++;
        UserGroup ret = new UserGroup();

        ret.setName("groupname" + count);
        ret = getDao().save(ret);

        return ret;
    }

    public static UserGroup getPersistedSystemGroup() throws Exception {
        UserGroupFilterParameters params = new UserGroupFilterParameters();
        params.setName("system");
        Collection groups = getDao().find(params);

        if (groups.size() == 0) {
            UserGroup ret = new UserGroup();

            ret.setName("system");
            ret = getDao().save(ret);

            return ret;
        } else {

            return (UserGroup) groups.toArray()[0];
        }

    }
}