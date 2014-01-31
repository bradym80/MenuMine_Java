package com.fstx.stdlib2.authen.users;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fsrin.menumine.common.dao.GenericDAOFactory;

/**
 * @author Nick
 * 
 */
public class GroupMembershipDao extends HibernateDaoSupport {

    private Log log = LogFactory.getLog(GroupMembershipDao.class);

    public GroupMembership save(GroupMembership u) throws DaoException {

        this.getHibernateTemplate().save(u);
        return u;
    }

    public GroupMembership find(Long id) throws DaoException {
        return (GroupMembership) this.getHibernateTemplate().get(
                GroupMembership.class, id);
    }

    public void delete(GroupMembership u) throws DaoException {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) throws DaoException {
        delete(this.find(id));
    }

    /**
     * Returns a list of <code>GroupMembership</code> s using the query
     * specified by the <code>query</code> key.
     * 
     * @param query
     *            the query key
     * @param value
     *            the value to put into the query statement. May be null
     * @return List
     * @throws DaoException
     */
    public List find(String query, String value) throws DaoException {
        return this.getHibernateTemplate().find(query, value);
    }

    public List find(String query, Object[] values) throws DaoException {
        HibernateTemplate hibernateTemplate;
        hibernateTemplate = this.getHibernateTemplate();

        return hibernateTemplate.find(query, values);
    }

    public Collection find(User user) throws DaoException {
        log.info("User should be " + user.getEmail() + " (" + user.getId()
                + ")");
        // return
        // this.getHibernateTemplate().find(SELECT_GROUPMEMBERSHIP_BY_USER,
        // user.getId());

        return GenericDAOFactory.factory.buildAdmin().find(
                SELECT_GROUPMEMBERSHIP_BY_USER, user);

    }

    public Collection find(UserGroup target) throws DaoException {
        // return this.getHibernateTemplate().find(
        // SELECT_GROUPMEMBERSHIP_BY_GROUP, target.getId().toString());

        return GenericDAOFactory.factory.buildAdmin().find(
                SELECT_GROUPMEMBERSHIP_BY_GROUP, target);

    }

    public static final String SELECT_GROUPMEMBERSHIP_BY_GROUP = "from com.fstx.stdlib2.authen.users.GroupMembership as groupmembership where groupmembership.groupId = :groupId";

    public static final String SELECT_GROUPMEMBERSHIP_BY_USER = "from com.fstx.stdlib2.authen.users.GroupMembership as groupmembership where groupmembership.userId = :id";

    /*
     * 2006-03-13 RSC Not in use.
     */
//    public static final String SELECT_BY_GROUP_USER_MEMBERSx = "select groupuser from com.fstx.stdlib2.authen.users.GroupMembership as membership, com.fstx.stdlib2.authen.users.User as groupuser where membership.userId = groupuser.id and membership.groupId = ?";

    // public static final String SELECT_BY_GROUP_AND_USER = "from
    // groupmembership in class com.fstx.stdlib2.authen.users.GroupMembership
    // where groupmembership.groupId = ? and groupmembership.userId = ?";
    public static final String SELECT_BY_GROUP_AND_USER = "from com.fstx.stdlib2.authen.users.GroupMembership as groupmembership where groupmembership.groupId = :groupId and groupmembership.userId = :userId";

    // group.membership.by.group=from groupmembership in class
    // com.fstx.stdlib.authen.users.GroupMembership where
    // groupmembership.groupId = ?
    // group.membership.by.user=from groupmembership in class
    // com.fstx.stdlib.authen.users.GroupMembership where groupmembership.userId
    // = ?
    // group.membership.by.group.user.members=select groupuser from
    // com.fstx.stdlib.authen.users.GroupMembership as membership,
    // com.fstx.stdlib.authen.users.User as groupuser where membership.userId =
    // groupuser.id and membership.groupId = ?
    // group.membership.by.group.and.user=from groupmembership in class
    // com.fstx.stdlib.authen.users.GroupMembership where
    // groupmembership.groupId = ? and groupmembership.userId = ?

}