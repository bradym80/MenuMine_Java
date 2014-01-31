package com.fstx.stdlib2.authen.users;

import java.util.Collection;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fsrin.menumine.common.dao.GenericDAOFactory;

/**
 * @version 2004-05-26
 * @author Reid
 * @author Nick
 *  
 */
public class GroupRightDao extends HibernateDaoSupport {

    public static final String SPRING_BEAN_NAME = "groupRightLiveDao";

    public static final GroupRightDaoFactory factory = new GroupRightDaoFactory();

    public GroupRight save(GroupRight u) throws DaoException {
        this.getHibernateTemplate().saveOrUpdate(u);
        return u;

    }

    public GroupRight find(Long id) {
        return (GroupRight) this.getHibernateTemplate().get(GroupRight.class,
                id);
    }

    public void delete(GroupRight u) {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) throws DaoException {
        delete(this.find(id));
    }

    /**
     * Returns a list of <code>GroupRights</code> s using the query specified
     * by the <code>query</code> key.
     * 
     * @param query
     *            the query key
     * @param value
     *            the value to put into the query statement. May be null
     * @return List
     * @throws DaoException
     */
    public List find(String query, Object value) {
        //return retrieveObjs(query, value);
        return this.getHibernateTemplate().find(query, value);

    }

    public Collection find(UserGroup userGroup) {
//        return find(SELECT_BY_GROUP, userGroup.getId());
        return GenericDAOFactory.factory.buildAdmin().find(SELECT_BY_GROUP, userGroup);
    }

    public static final String SELECT_BY_GROUP = "from com.fstx.stdlib2.authen.users.GroupRight as rights where rights.groupId = :id";

    public static final String SELECT_ALL_BY_GROUP_ID = "from com.fstx.stdlib2.authen.users.GroupRight as rights where rights.groupId = ?";

    //	grouprights.selectByUser=select rights from
    // com.fstx.stdlib.authen.users.UserGroup as
    // grp,com.fstx.stdlib.authen.users.GroupRights as rights where
    // rights.groupId = grp.id and grp.name=?
    //	grouprights.select.by.group=from rights in class
    // com.fstx.stdlib.authen.users.GroupRights where rights.groupId = ?

}