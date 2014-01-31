/*
 * Created on Mar 18, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menubook;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.chain.ChainServiceDelegateFactory;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodSearchException;
import com.fsrin.menumine.core.menumine.masterfood.MasterFoodServiceDelegate;

/**
 * @author Nick
 * 
 *  
 */
public class MenuBookBuilder {

    public static final String SPRING_BEAN_NAME = "menuBookBuilder";

    private MasterFoodServiceDelegate masterFoodServiceDelegate;

    public MenuBook build(Collection results) {
        MenuBook menuBook = new MenuBook();

        menuBook.addAll(results);

        return menuBook;
    }

    public MenuBook build(String chainName) throws MenuBookBuilderException {

        Collection results = null;
        try {
            /*
             * 2006-03-07 RSC Switching to the HQL Query.
             */

            results = this.getMasterFoodServiceDelegate().searchMasterFoodByHQLConjunction(
                    this.buildMasterFoodFilterParameters(chainName));
        } catch (MasterFoodSearchException e) {

            e.printStackTrace();
            throw new MenuBookBuilderException(
                    "Error searching for menu items", e);
        }

        
        MenuBook ret = build(results);
        ret.setChain(ChainServiceDelegateFactory.factory.build().find(chainName));
        
        return ret;
    }

    private MasterFoodFilterParameters buildMasterFoodFilterParameters(
            String chainName) {
        MasterFoodFilterParameters params = new MasterFoodFilterParametersImpl();
        

        params.getOperationName().getAndValues().add(chainName);
        
        params.getOperationName().setSelect(true);
        params.getGenMenuPart().setSelect(true);
        params.getMenuItem().setSelect(true);
        params.getPrice1996().setSelect(true);
        params.getPrice1997().setSelect(true);
        params.getPrice1998().setSelect(true);
        params.getPrice1999().setSelect(true);
        params.getPrice2000().setSelect(true);
        params.getPrice2001().setSelect(true);
        params.getPrice2002().setSelect(true);
        params.getPrice2003().setSelect(true);
        params.getPrice2004().setSelect(true);
        params.getPrice2005().setSelect(true);
        params.getPrice2006().setSelect(true);
        params.getPrice2007().setSelect(true);
        params.getPrice2008().setSelect(true);
        params.getPrice2009().setSelect(true);
        // MJB 11-12-2009 Added 2010
        params.getPrice2010().setSelect(true);
      //JDL 10-5-07
       // params.getPrice2006().setEmpty(Boolean.FALSE);
        // MJB 10-06-10 Set year below to 2010
        //params.getPrice2009().setEmpty(Boolean.FALSE);
        params.getPrice2011().setSelect(true);

        
        // DBB 1-20-2009 Add 2008, 2009
        
        params.setSortAsc(true);
        params.setOrderBy(FieldEnum.MENU_ITEM_NAME.getOgnlName());
        
        return params;
    }

    public MasterFoodServiceDelegate getMasterFoodServiceDelegate() {
        return masterFoodServiceDelegate;
    }

    public void setMasterFoodServiceDelegate(
            MasterFoodServiceDelegate masterFoodServiceDelegate) {
        this.masterFoodServiceDelegate = masterFoodServiceDelegate;
    }

}