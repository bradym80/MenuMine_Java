/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

/**
 * 2006-02-06 RSC Original version was just a VO, changed
 * to extend the original.
 * 
 * @author Nick
 * 
 *  
 */
public class SavedQueryFilterParameters extends SavedQuery {

//    private String userName;
//
//    private String groupName;
//
    private Integer permissionObject;
//
//    public SavedQueryFilterParameters() {
//        super();
//
//    }
//
//    public String getGroupName() {
//        return groupName;
//    }
//
//    public void setGroupName(String groupName) {
//        this.groupName = groupName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
    public void setPermissionObject(Integer permission) {
        this.permissionObject = permission;
    }

    public Integer getPermissionObject() {
        return permissionObject;
    }
}