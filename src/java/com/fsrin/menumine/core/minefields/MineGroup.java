/*
 * Created on May 31, 2005
 *
 * 
 */
package com.fsrin.menumine.core.minefields;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nick
 * 
 *  
 */
public class MineGroup {

    private List mineFields = new ArrayList();

    private String image;

    private String cssClass;

    private String name;

    private String bgcolor;

    private boolean includeInMenu = true;
    
    private boolean forceNewColumn = false;
    
    private boolean forceExtraColumn = false;

    public MineGroup(String name) {
        this.name = name;
    }

    public List getMineFields() {
        return mineFields;
    }

    public void setMineFields(List mineFields) {
        this.mineFields = mineFields;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIncludeInMenu() {
        return includeInMenu;
    }

    public void setIncludeInMenu(boolean includeInMenu) {
        this.includeInMenu = includeInMenu;
    }

    /**
     * @return Returns the forceExtraColumn.
     */
    public boolean isForceExtraColumn() {
        return forceExtraColumn;
    }

    /**
     * @param forceExtraColumn The forceExtraColumn to set.
     */
    public void setForceExtraColumn(boolean forceExtraColumn) {
        this.forceExtraColumn = forceExtraColumn;
    }

    /**
     * @return Returns the forceNewColumn.
     */
    public boolean isForceNewColumn() {
        return forceNewColumn;
    }

    /**
     * @param forceNewColumn The forceNewColumn to set.
     */
    public void setForceNewColumn(boolean forceNewColumn) {
        this.forceNewColumn = forceNewColumn;
    }
}