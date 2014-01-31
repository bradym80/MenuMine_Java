/*
 * Created on Feb 22, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

/**
 * @author Nick
 * 
 *  
 */
public class RollUpFilterParameters {

    private String userName;

    private String groupName;

    private Integer permission;

    private String name;

    public RollUpFilterParameters() {
        super();

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public Integer getPermission() {
        return permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}