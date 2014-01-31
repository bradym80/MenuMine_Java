/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import com.fsrin.menumine.common.ServiceDelegateException;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fstx.stdlib2.authen.users.User;
import com.fstx.stdlib2.authen.users.UserGroup;
import com.fstx.stdlib2.authen.users.UserGroupServiceDelegate;
import com.opensymphony.webwork.util.Sorter;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpServiceDelegateImpl implements RollUpServiceDelegate {

    private static String GET_SIMPLE_BY_USER = "select new "+RollUpOptions.class.getName()+ 
        " (r.id, r.name, r.targetFieldName, r.userName, r.groupName) " +
        " from RollUpOptions as r where r.userName = :userName"; 
    
//    private static String GET_SIMPLE_BY_GROUP = "select new "+RollUpOptions.class.getName()+ 
//    " (r.id, r.name, r.targetFieldName, r.userName, r.groupName) " +
//    " from RollUpOptions as r where r.groupName = :groupName";
    
    private RollUpDao rollUpDao;
    
    

    public RollUpServiceDelegateImpl() {
        super();

    }

    public Collection getByUser(User user)
            throws RollUpServiceDelegateException {
        return this.getByUser(user.getUsername());
    }

    public Collection getByUser(String userName)
            throws RollUpServiceDelegateException {

        RollUpFilterParameters params = new RollUpFilterParameters();
        params.setUserName(userName);

        return rollUpDao.search(params);

    }
    
    public Collection getSimpleByUser(String userName) throws RollUpServiceDelegateException {
        
        RollUpOptions options = new RollUpOptions();
        options.setUserName(userName);
        
        return GenericDAOFactory.factory.buildAdmin().find(GET_SIMPLE_BY_USER, options);
        
    }

    public RollUpOptions getByName(String name, String userName)
            throws RollUpServiceDelegateException {

        RollUpFilterParameters params = new RollUpFilterParameters();
        params.setName(name);
        params.setUserName(userName);

        Collection col;

        col = rollUpDao.search(params);

        if (col.size() > 0) {
            return (RollUpOptions) col.toArray()[0];
        } else {
            return null;
        }
    }

    /**
     * We will get all of the groups this user belongs to, then look up all of
     * the querys for each group. Most likly each user will have only one group,
     * but here we should be able to handle that case.
     */
    public Collection getByGroup(User user)
            throws RollUpServiceDelegateException {

        Collection groups = null;
        try {
            groups = UserGroupServiceDelegate.factory.build().getGroupsByUser(
                    user);
        } catch (ServiceDelegateException e1) {
            throw new RollUpServiceDelegateException(e1);
        }

        Collection querys = new TreeSet(new Sorter().getAscending("name"));
        for (Iterator iter = groups.iterator(); iter.hasNext();) {
            UserGroup element = (UserGroup) iter.next();
            Collection tempQuerys = this.getByGroup(element);
            querys.addAll(tempQuerys);
        }

        return querys;

    }

    private Collection getByGroup(UserGroup element)
            throws RollUpServiceDelegateException {
        RollUpFilterParameters params = new RollUpFilterParameters();
        params.setGroupName(element.getName());
        params.setPermission(RollUpOptions.GROUP_QUERY_PERMISSION);

        return rollUpDao.search(params);

    }

    public void save(RollUpOptions savedQuery)
            throws RollUpServiceDelegateException {

        this.getRollUpDao().save(savedQuery);

    }

    public RollUpDao getRollUpDao() {
        return rollUpDao;
    }

    public void setRollUpDao(RollUpDao rollUpDao) {
        this.rollUpDao = rollUpDao;
    }

    public Collection getByUserAndGroup(User user)
            throws RollUpServiceDelegateException {

        Collection userSpecific = this.getByUser(user);
        
        Collection groupSpecific = this.getByGroup(user);

        //        for (Iterator iter = userQuerys.iterator(); iter.hasNext();) {
        //            SavedQuery element = (SavedQuery) iter.next();

        //            for (Iterator iterator = element.getMasterFoodFilterParameters()
        //                    .getSummary().iterator(); iterator.hasNext();) {
        //                LastQuerySummaryElement mfsummary = (LastQuerySummaryElement)
        // iterator
        //                        .next();
        //                for (Iterator orIter = mfsummary.getOrValues().iterator(); orIter
        //                        .hasNext();) {
        //                    String or = (String) orIter.next();
        //                   
        //
        //                }
        //            }

        //   }

        TreeSet sorted = new TreeSet(new Sorter().getAscending("id"));
        sorted.addAll(userSpecific);
        sorted.addAll(groupSpecific);

        return sorted;
    }

    public void delete(Long id) {
        this.getRollUpDao().delete(id);

    }

    public void delete(RollUpOptions rollUp)
            throws RollUpServiceDelegateException {
        //  if(rollUp != null && rollUp.getId() != null){}
        this.getRollUpDao().delete(rollUp);
    }
}