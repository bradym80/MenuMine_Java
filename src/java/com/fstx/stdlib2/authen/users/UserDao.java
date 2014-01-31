/*
 * Created on Aug 14, 2003
 *
 */
package com.fstx.stdlib2.authen.users;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fsrin.menumine.common.dao.GenericDAO;
import com.fsrin.menumine.common.dao.GenericDAOFactory;

/**
 * <p>
 * A basic user. Hooray.
 * 
 * @version 2004-05-26
 * @author Reid
 * @author Nick
 * 
 */
public class UserDao extends HibernateDaoSupport {

    public static final UserDaoFactory factory = new UserDaoFactory();

    // users.select.by.authenticate=select from users in class
    // com.fstx.stdlib.authen.users.User where users.username = ? and
    // users.password = ?
    // users.select.all=select from users in class
    // com.fstx.stdlib.authen.users.User where users.id > 0 order by
    // users.username
    // users.select.all.not.matched= from users in class
    // com.fstx.stdlib.authen.users.User where users.id not in ( ? )
    // users.select.by.email=select from users in class
    // com.fstx.stdlib.authen.users.User where users.email = ?

    static Log log = LogFactory.getLog(UserDao.class.getName());

    public static final String SELECT_ALL = "sfrom class com.fstx.stdlib2.authen.users.User as users where users.id > 0 order by users.username";

    public static final String SELECT_BY_AUTHENTICATE = "from com.fstx.stdlib2.authen.users.User as users where users.username = ? and users.password = ?";

    public static final String SELECT_BY_EMAIL = "from com.fstx.stdlib2.authen.users.User as users where users.email = ?";

    // public static final String SELECT_BY_GROUP = "from
    // com.fstx.stdlib2.authen.users.User as users,
    // com.fstx.stdlib2.authen.users.GroupMembership as groupMembership where
    // groupMembership.userId = users.id and groupMembership.groupId = ?";
    public static final String SELECT_BY_GROUP = "select users from com.fstx.stdlib2.authen.users.User as users, com.fstx.stdlib2.authen.users.GroupMembership as groupMembership where  groupMembership.userId = users.id and groupMembership.groupId = :id";

    // public static final String SELECT_BY_ORGANIZATION = "from class
    // com.fstx.stdlib2.authen.users.User as users, organizationMembership in
    // class com.fivesticks.cmms.core.system.OrganizationMembership as where
    // organizationMembership.userId = users.id and
    // organizationMembership.organizationId = ?";

    public User authenticateUser(String username, String password)
            throws DaoException {
        Object[] tokens = { username, password };

        List list = this.getHibernateTemplate().find(
                UserDao.SELECT_BY_AUTHENTICATE, tokens);
        if (list == null) {
            log.info("list is null");
            throw new DaoException();
        }
        if (list.size() != 1) {
            log.info("list size is not 1 " + list.size());
            throw new DaoException();

        }

        return (User) list.get(0);

    }

    public Collection find(final UserFilterParameters params) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        return (List) hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Criteria criteria = session.createCriteria(User.class);

                if (params.getId() != null) {
                    criteria.add(Expression.eq("id", params.getId()));
                }
                if (params.getUsername() != null) {
                    criteria.add(Expression
                            .eq("username", params.getUsername()));
                }
                if (params.getPassword() != null) {
                    criteria.add(Expression
                            .eq("password", params.getPassword()));
                }
                if (params.getEmail() != null) {
                    criteria.add(Expression.eq("email", params.getEmail()));
                } else if (params.getEmailLike() != null
                        && params.getEmailLike().trim().length() > 0) {
                    criteria.add(Expression.like("email", "%"
                            + params.getEmailLike() + "%"));
                }

                if (params.getCompanyLike() != null
                        && params.getCompanyLike().trim().length() > 0) {
                    criteria.add(Expression.like("company", "%"
                            + params.getCompanyLike() + "%"));
                }

                if (params.getRoleName() != null
                        && params.getRoleName().trim().length() > 0) {
                    criteria.add(Expression
                            .eq("roleName", params.getRoleName()));
                }

                if (params.getExpiresBefore() != null) {
                    criteria.add(Expression.lt("expirationDate", params
                            .getExpiresBefore()));
                }

                if (params.getExpiresOnOrAfter() != null) {
                    criteria.add(Expression.ge("expirationDate", params
                            .getExpiresOnOrAfter()));
                }

                if (params.getSortBy() != null
                        && params.getSortBy().trim().length() > 0) {
                    criteria.addOrder(Order.asc(params.getSortBy()));
                } else {
                    criteria.addOrder(Order.asc("username"));
                }

                log.info("criteria " + criteria);

                List ret = criteria.list();

                return ret;
            }
        });

    }

    public User getUser(Long id) {
        return (User) this.getHibernateTemplate().get(User.class, id);
    }

    public User getUserByEmail(String email) throws DaoException {
        List u = searchUsers(SELECT_BY_EMAIL, email);

        if (u.size() == 0)
            throw new DaoException("user not found");

        if (u.size() > 1)
            throw new DaoException(
                    "Somehow we have more than one user with this email");

        User ret = (User) u.get(0);

        return ret;
    }

    public Collection getUsersByGroup(UserGroup userGroup) {

        // List u = searchUsers(SELECT_BY_GROUP, userGroup.getId().toString());

        GenericDAO dao = GenericDAOFactory.factory.buildAdmin();

        Collection ret = dao.find(SELECT_BY_GROUP, userGroup);

        return ret;
    }

    public void removeUser(Long id) {
        removeUser(this.getUser(id));
    }

    public void removeUser(User u) {
        this.getHibernateTemplate().delete(u);
    }

    /*
     * Dao Execptions removed. None of these will ever throw one.
     */
    public User saveUser(User u) {
        this.getHibernateTemplate().saveOrUpdate(u);
        return u;
    }

    public List searchUsers(String query) throws DaoException {
        return this.getHibernateTemplate().find(query);
    }

    /**
     * Returns a list of <code>User</code> s using the query specified by the
     * <code>query</code> key.
     * 
     * @param query
     *            the query key
     * @param value
     *            the value to put into the query statement. May be null
     * @return List
     * @throws DaoException
     */
    public List searchUsers(String query, String value) {

        return this.getHibernateTemplate().find(query, value);

    }

    public void delete(User targetUser) {
        if (targetUser != null)
            this.removeUser(targetUser);
    }

}