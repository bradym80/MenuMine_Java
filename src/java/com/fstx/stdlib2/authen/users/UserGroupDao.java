package com.fstx.stdlib2.authen.users;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @version 2004-05-26
 * 
 * @author Reid
 * @author Nick
 *  
 */
public class UserGroupDao extends HibernateDaoSupport {

    public static String SPRING_BEAN_NAME = "userGroupLiveDao";

    public static final UserGroupDaoFactory factory = new UserGroupDaoFactory();

    public UserGroup save(UserGroup u) {
        this.getHibernateTemplate().saveOrUpdate(u);
        return u;
    }

    public UserGroup find(Long id) {
        return (UserGroup) this.getHibernateTemplate().get(UserGroup.class, id);
    }

    public void delete(UserGroup u) throws DaoException {
        this.getHibernateTemplate().delete(u);
    }

    public void delete(Long id) throws DaoException {
        this.getHibernateTemplate().delete(find(id));
    }

    /**
     * Returns a list of <code>Group</code> s using the query specified by the
     * <code>query</code> key.
     * 
     * @param query
     *            the query key
     * @param value
     *            the value to put into the query statement. May be null
     * @return List
     * @throws DaoException
     */
    public List searchUserGroups(String query, String value)
            throws DaoException {
        return this.getHibernateTemplate().find(query, value);
    }

    // Selects all of the groups based on the user name.
    // example: List l =
    // dao.searchGroups(EMSGroupDao.SELECT_BY_USER,user.getUsername());
    public static final String SELECT_BY_USER = "select emsGroup from com.fstx.stdlib2.authen.users.User as user, com.fstx.stdlib2.authen.users.GroupMembership as grpmem, com.fstx.stdlib2.authen.users.UserGroup as emsGroup where emsGroup.id = grpmem.groupId and grpmem.userId=user.id and user.username=?";

    public static final String SELECT_ALL = "from usergroup in class com.fstx.stdlib2.authen.users.UserGroup where usergroup.id > 0 order by usergroup.name";

    public Collection find(final UserGroupFilterParameters params) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        return (List) hibernateTemplate.executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException {
                Criteria criteria = session.createCriteria(UserGroup.class);

                if (params.getName() != null) {
                    criteria.add(Expression.eq("name", params.getName()));
                }

                criteria.addOrder(Order.asc("name"));
                
                List ret = criteria.list();

                return ret;
            }
        });

    }
}