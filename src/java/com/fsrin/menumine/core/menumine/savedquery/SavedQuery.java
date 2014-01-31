/*
 * Created on Feb 21, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.savedquery;

import java.util.Date;
import java.util.Iterator;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.core.menumine.FieldsToDisplayBean;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersDecorator;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.minefields.MineFieldsFactory;

/**
 * @author Nick
 * 
 * 
 */
public class SavedQuery implements Cloneable {

    public static Integer USER_QUERY_PERMISSION = new Integer(1);

    public static Integer GROUP_QUERY_PERMISSION = new Integer(2);
    
    public static Integer CUSTOM_TEMPLATE_PERMISSION = new Integer(3);

    private Long id;

    private MasterFoodFilterParameters masterFoodFilterParameters = new MasterFoodFilterParametersImpl();

    private FieldsToDisplayBean fieldsToDisplayBean = new FieldsToDisplayBean();

    private String userName;

    private String groupName;

    private int permission;

    private String mineType;

    private String name;
    
    private String templateGroup;

    private boolean simple;
    
    private Date timestamp;



    public SavedQuery() {
        super();
    }

    /*
     * 2006-02-06 Added for simple implementation.
     */
    public SavedQuery(Long id, String name, String mineType, String userName,
            String groupName, Date timestamp) {
        this.id = id;
        this.name = name;
        this.mineType = mineType;
        this.userName = userName;
        this.groupName = groupName;
        this.timestamp = timestamp;
        this.setSimple(true);
    }
    
    public SavedQuery(Long id, String name, String mineType, String userName,
            String groupName, Date timestamp, String templateGroup) {
        this.id = id;
        this.name = name;
        this.mineType = mineType;
        this.userName = userName;
        this.groupName = groupName;
        this.timestamp = timestamp;
        this.setSimple(true);
        this.templateGroup = templateGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public MasterFoodFilterParameters getMasterFoodFilterParameters() {
        return masterFoodFilterParameters;
    }

    public void setMasterFoodFilterParameters(
            MasterFoodFilterParameters masterFoodFilterParameters) {
        this.masterFoodFilterParameters = masterFoodFilterParameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public FieldsToDisplayBean getFieldsToDisplayBean() {
        return fieldsToDisplayBean;
    }

    public void setFieldsToDisplayBean(FieldsToDisplayBean fieldsToDisplayBean) {
        this.fieldsToDisplayBean = fieldsToDisplayBean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMineType() {
        if (mineType == null || mineType.length() == 0) {
            calculateMineType();
        }

        return mineType;
    }

    /*
     * Since we are transitioning to segregating querys my mineType, pre old
     * querys will not have a mine type and we need to be able to figure out
     * based on what params are used.
     * 
     * If we can't tell for sure we leave teh mineType as null and expect it to
     * be included in all mines.
     */
    private void calculateMineType() {
        if (this.getMasterFoodFilterParameters() == null) {
            /*
             * Nothing to see here.
             */
            return;
        }

        /*
         * Dessert is easy as this will always be set.
         */
        if (this.getMasterFoodFilterParameters().getDayPartCategory()
                .getAndValues().contains("Dessert")) {
            mineType = MineFieldsFactory.MINE_TYPE_DESSERT;

        } else

        /*
         * We changed this later so a lot of querys will not have this set.
         */
        if (this.getMasterFoodFilterParameters().getDayPartCategory()
                .getNotValues().contains("Dessert")) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        /*
         * Lets go through the fields unique to menumine if one in not empty, it
         * must be a menumine query!
         */
        if (!this.getMasterFoodFilterParameters().getBasicProtein()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }

        else

        if (!this.getMasterFoodFilterParameters().getCuisineFamily()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getProteinTypeCut()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getVeggieFruitMM()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getCarboMM().isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else
        	
        if (!this.getMasterFoodFilterParameters().getCarboAll().isFilterEmpty()) {
                mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getSideOrAccomp()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getBreadBakeGoodsMM()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getBreadUse().isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getHealthyTerm()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else

        if (!this.getMasterFoodFilterParameters().getSauceCondDressMarMM()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else if (!this.getMasterFoodFilterParameters().getFlavApplication()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else if (!this.getMasterFoodFilterParameters()
                .getFlavEnhancSeasBrdgDesIngredMM().isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else if (!this.getMasterFoodFilterParameters().getTopFillIngredMM()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else if (!this.getMasterFoodFilterParameters().getCheeseMM()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else if (!this.getMasterFoodFilterParameters().getFlavorSoup()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else if (!this.getMasterFoodFilterParameters().getGenCookMeth()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        } else if (!this.getMasterFoodFilterParameters().getCookMeth()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }
        //JDL 05-21-08
        else if (!this.getMasterFoodFilterParameters().getBevMenuItem()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }else if (!this.getMasterFoodFilterParameters().getSideAccompDisFlavor()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }else if (!this.getMasterFoodFilterParameters().getCookieTypeSource()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }else if (!this.getMasterFoodFilterParameters().getCreamyTop()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }else if (!this.getMasterFoodFilterParameters().getCreamyFill()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }else if (!this.getMasterFoodFilterParameters().getTextureAttrib()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }else if (!this.getMasterFoodFilterParameters().getQualityStyle()
                .isFilterEmpty()) {
            mineType = MineFieldsFactory.MINE_TYPE_MENU;
        }

    }

    public void setMineType(String mineType) {
        this.mineType = mineType;
    }

    public boolean isSimple() {
        return simple;
    }

    public void setSimple(boolean simple) {
        this.simple = simple;
    }

    /*
     * 2006-03-08 a bit of a hack to ensure updating a query works. This is an
     * inefficient way of handling it, but it allows us to forget about handling
     * the filterparametes from the main form in a new way.
     * 
     * 2006-03-16 doing a bit of a work around to see about cloning the MFFP.
     */
    public void resetIds() {
        this.setId(null);

        this.getFieldsToDisplayBean().setId(null);
        // this.getMasterFoodFilterParameters().setId(null);

        this.setMasterFoodFilterParameters(this.getMasterFoodFilterParameters()
                .clone());

        for (Iterator iter = this.getMasterFoodFilterParameters()
                .getFilterParameters().iterator(); iter.hasNext();) {
            FilterParameter element = (FilterParameter) iter.next();
            element.setId(null);

        }
    }

    public SavedQuery clone() {

        SavedQuery ret = new SavedQuery();

        ret.setFieldsToDisplayBean(this.getFieldsToDisplayBean().clone());
        ret.setMasterFoodFilterParameters(this.getMasterFoodFilterParameters()
                .clone());
        ret.setGroupName(this.getGroupName());
        ret.setMineType(this.getMineType());
        ret.setName(this.getName());
        ret.setPermission(this.getPermission());
        ret.setSimple(this.isSimple());
        ret.setUserName(this.getUserName());
        ret.setTimestamp(this.getTimestamp());
        
        return ret;
    }

    public void synchSelectedFields() {

        try {
            new MasterFoodFilterParametersDecorator()
                    .decorateSelect(this.getMasterFoodFilterParameters(), this
                            .getFieldsToDisplayBean());
        } catch (Exception e) {
            
            throw new RuntimeException("Unable to synch selected fields for this query.", e);
        }
    }
    
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTemplateGroup() {
        return templateGroup;
    }

    public void setTemplateGroup(String templateGroup) {
        this.templateGroup = templateGroup;
    }

}