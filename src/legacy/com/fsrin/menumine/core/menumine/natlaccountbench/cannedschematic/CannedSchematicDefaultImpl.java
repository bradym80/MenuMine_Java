/*
 * Created on Jul 7, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.core.minefields.MineFields;

/**
 * @author Nick
 * 
 *  
 */
public class CannedSchematicDefaultImpl extends CannedSchematic {

    Collection fields = new ArrayList();

    public CannedSchematicDefaultImpl(MineFields mineFields) {
        super();
        this.setMineFields(mineFields);
        fields.addAll(mineFields.getPrimaryFields());
        this.setName("Default Canned Schematic");

    }

    public Collection getFields() {
        //  Collection fields = new ArrayList();

        // fields.addAll(new MenuMineFields().getAllFields());

        return fields;
    }

    public Long getId() {
        return null;
    }

}