/*
 * Created on Jul 12, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.xwork;

import com.fsrin.menumine.core.menumine.natlaccountbench.cannedschematic.CannedSchematic;

/**
 * @author Nick
 * 
 *  
 */
public class CannedSchematicModifyContext {

    private CannedSchematic cannedSchematic;

    public CannedSchematicModifyContext() {
        super();
    }

    public CannedSchematic getCannedSchematic() {
        return cannedSchematic;
    }

    public void setCannedSchematic(CannedSchematic cannedSchematic) {
        this.cannedSchematic = cannedSchematic;
    }

    public int countOfCannedSchematics = 0;

    public int getCountOfCannedSchematics() {

        return countOfCannedSchematics;
    }

    public void setCountOfCannedSchematics(int countOfCannedSchematics) {
        this.countOfCannedSchematics = countOfCannedSchematics;
    }
}