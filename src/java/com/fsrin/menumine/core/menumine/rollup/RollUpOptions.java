/*
 * Created on May 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.rollup;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import com.fsrin.menumine.core.menumine.FieldEnum;

/**
 * @author Nick
 * 
 * 
 */
public class RollUpOptions implements Serializable {

    public static Integer USER_QUERY_PERMISSION = new Integer(1);

    public static Integer GROUP_QUERY_PERMISSION = new Integer(2);

    public static String OTHER_ITEM_ROLL_UP_TYPE_ROLL_UP_OTHERS = "rollUpOthers";

    public static String OTHER_ITEM_ROLL_UP_TYPE_NO_ROLL_UP_OTHERS = "noRollUpOthers";

    private Long id;

    private String name;

    private Collection rollUpElements = new HashSet();

    private String userName;

    private String groupName;

    private String targetFieldName;

    private int permission = 0;

    private String otherItemRollUpType = RollUpOptions.OTHER_ITEM_ROLL_UP_TYPE_NO_ROLL_UP_OTHERS;

    public RollUpOptions() {
        super();
    }

    /*
     * 2006-02-06 RSC Constructor is specific to the getSimple... method.
     */
    public RollUpOptions(Long id, String name, String targetFieldName,
            String username, String groupName) {
        super();
        this.id = id;
        this.name = name;
        this.targetFieldName = targetFieldName;
        this.userName = username;
        this.groupName = groupName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getRollUpElements() {
        return rollUpElements;
    }

    public void setRollUpElements(Collection rollUpElements) {
        this.rollUpElements = rollUpElements;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOtherItemRollUpType() {
        return otherItemRollUpType;
    }

    public void setOtherItemRollUpType(String otherItemRollUpType) {
        this.otherItemRollUpType = otherItemRollUpType;
    }

    public String getTargetFieldName() {
        return targetFieldName;
    }

    public void setTargetFieldName(String targetFieldName) {
        this.targetFieldName = targetFieldName;
    }

    /*
     * 2006-03-07 RSC Changed from getByName to getByOgnlName.
     */
    public FieldEnum getTargetField() {

        if (this.getTargetFieldName() == null)
            return null;
        
        FieldEnum ret = null;

        ret = FieldEnum.getByOgnlName(this.getTargetFieldName());

        if (ret == null) {
            /*
             * 2006-03-07 RSC just in case the target field name we have stored
             * is the old name and not the ognl name. I deprecated the method as
             * soon as I created it so it will always be flagged.
             */
            ret = FieldEnum.getByOldName(this.getTargetFieldName());
        }

        if (ret == null) {
            throw new RuntimeException(
                    "Rollup options: FieldEnum can't get by the field name ("
                            + this.getTargetFieldName() + ")");
        }
        
        return ret;
    }

    /*
     * This long name spcifies both the field and the name.
     */
    public String getLongName() {
        StringBuffer buffer = new StringBuffer();

        if (this.getTargetField() != null) {
            buffer.append(this.getTargetField().getFriendlyName());
            buffer.append(": ");
        }
        buffer.append(this.getName());

        return buffer.toString();
    }

}