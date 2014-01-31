/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fsrin.menumine.core.minefields.MineField;

/**
 * @author Nick
 * 
 *  
 */
public class CannedSchematicImpl extends CannedSchematic {
    private Long id;

    private Collection fields;

    private Collection fieldKeys;

    private String userName;

    private String groupName;

    public CannedSchematicImpl() {
        super();

    }

    /*
     * This should be a collection of MineFields that are to be in the Canned
     * Report
     * 
     * (non-Javadoc)
     * 
     * @see com.fsrin.menumine.core.menumine.natlaccountbench.CannedSchematic#getFields()
     */
    public Collection getFields() {
        if (this.fields == null && fieldKeys != null) {
            this.fields = new ArrayList();
            for (Iterator iter = fieldKeys.iterator(); iter.hasNext();) {
                String element = (String) iter.next();
                MineField mf = this.getMineFields().findByOgnlName(element);
                this.fields.add(mf);
            }
        }

        return fields;
    }

    /*
     * The FieldKeys are a collection of strings for each field.
     */
    public void setFieldKeys(Collection fieldKeys) {
        this.fieldKeys = fieldKeys;
    }

    public Collection getFieldKeys() {
        return fieldKeys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}