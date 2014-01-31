/*
 * Created on Jul 13, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic;

import com.fsrin.menumine.common.dao.CriteriaParameters;

/**
 * @author Nick
 * 
 *  
 */
public class CannedSchematicCriteriaParamerters implements CriteriaParameters {

    private String userName;

    private String groupName;

    private String mineType;

    private String name;

    public CannedSchematicCriteriaParamerters() {
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

    public String getMineType() {
        return mineType;
    }

    public void setMineType(String mineType) {
        this.mineType = mineType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}