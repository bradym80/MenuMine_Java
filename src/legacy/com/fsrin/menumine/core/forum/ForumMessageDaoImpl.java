package com.fsrin.menumine.core.forum;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Reid
 * 
 * @author Nick
 *  
 */
public class ForumMessageDaoImpl extends HibernateDaoSupport implements
        ForumMessageDao {

    public ForumMessage save(ForumMessage forumMessage) {
        this.getHibernateTemplate().save(forumMessage);

        return forumMessage;
    }

    public ForumMessage get(Long id) {
        return (ForumMessage) this.getHibernateTemplate().get(
                ForumMessage.class, id);
    }

    public void delete(ForumMessage forumMessage) {
        this.getHibernateTemplate().delete(forumMessage);
    }

    public void delete(Long id) {
        this.delete(this.get(id));
    }

    static Log log = LogFactory.getLog(ForumMessageDaoImpl.class.getName());

    public Collection search(final ForumMessageSearchParameters parameters) {

        HibernateTemplate hibernateTemplate = new HibernateTemplate(this
                .getSessionFactory());

        List ret = (List) hibernateTemplate
                .executeFind(new HibernateCallback() {
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        Criteria criteria = session
                                .createCriteria(ForumMessage.class);
                        Method[] methods = parameters.getClass().getMethods();
                        try {
                            for (int i = 0; i < methods.length; i++) {
                                if (methods[i].getName().indexOf("get") > -1) {
                                    String field = methods[i].getName()
                                            .substring(3);

                                    char[] chars = field.toCharArray();
                                    chars[0] += 32;
                                    field = new String(chars);
                                    if (field.equals("class")) {
                                        continue;
                                    }
                                    if (methods[i].invoke(parameters, null) != null) {
                                        criteria.add(Expression.eq(field,
                                                methods[i].invoke(parameters,
                                                       (Object[]) null)));
                                    }
                                }
                            }
                        } catch (Exception e) {
                            throw new HibernateException(
                                    "Error building criteria. ", e);
                        }

                        //                        if (parameters.getForumGroup() != null) {
                        //                            criteria.add(Expression.eq("forumGroup", parameters
                        //                                    .getForumGroup()));
                        //                        }
                        //                        if (parameters.getGroup() != null) {
                        //                            criteria.add(Expression.eq("group", parameters
                        //                                    .getGroup()));
                        //                        }
                        //                        if (parameters.getUser() != null) {
                        //                            criteria.add(Expression.eq("user", parameters
                        //                                    .getUser()));
                        //                        }
                        //                        if (parameters.getMessage() != null) {
                        //                            criteria.add(Expression.ilike("user", "%"
                        //                                    + parameters.getMessage() + "%"));
                        //                        }

                        List ret = criteria.list();

                        return ret;
                    }
                });

        return ret;

    }
}