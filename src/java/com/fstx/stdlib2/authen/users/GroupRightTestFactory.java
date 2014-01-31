/*
 * Created on Dec 2, 2003
 *
 */
package com.fstx.stdlib2.authen.users;

import com.fsrin.menumine.common.SpringBeanBroker;

/**
 * @author REID
 *  
 */
public class GroupRightTestFactory {

    private static int count = 0;

    private static GroupRightDao getDao() {
        return (GroupRightDao) SpringBeanBroker.getBeanFactory().getBean(
                "groupRightLiveDao");
    }

    public static GroupRight getPersisted(UserGroup userGroup) throws Exception {
        count++;
        String right = "right" + count;
        return getPersisted(userGroup, right);
    }

    public static GroupRight getPersisted(UserGroup userGroup, String rightCode)
            throws Exception {

        GroupRight groupRights = new GroupRight();

        groupRights.setGroupId(userGroup.getId());
        groupRights.setRightCode(rightCode);

        groupRights = getDao().save(groupRights);

        return groupRights;
    }
}