/*
 * Created on 2005-3-18
 *
 */
package com.fsrin.menumine.core.flare.xwork;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.flare.FlareImageService;
import com.fsrin.menumine.common.util.FileIOUtility;

/**
 * @author Nick
 * @version 1
 */

public class FlareProviderAction extends AbstractMenuMineSessionContextAwareAction {

//    private MenuMineSessionContextWrapper menuMineSessionContextWrapper;

    private FlareImageService flareImageService;

    public String execute() throws Exception {

    	if(FileIOUtility.isSiteUp()){
    		return SUCCESS;
    	}
    	return ERROR;
    }

    public String getRandomFlare() {
        String img = this.getFlareImageService().getRandomImagePath();

        return img;
        //  return "flare/nigiri.jpg";

    }

    public FlareImageService getFlareImageService() {
        return flareImageService;
    }

    public void setFlareImageService(FlareImageService flareImageService) {
        this.flareImageService = flareImageService;
    }

//    public MenuMineSessionContextWrapper getMenuMineSessionContextWrapper() {
//        return menuMineSessionContextWrapper;
//    }
//
//    public void setMenuMineSessionContextWrapper(
//            MenuMineSessionContextWrapper menuMineSessionContextWrapper) {
//        this.menuMineSessionContextWrapper = menuMineSessionContextWrapper;
//    }
}