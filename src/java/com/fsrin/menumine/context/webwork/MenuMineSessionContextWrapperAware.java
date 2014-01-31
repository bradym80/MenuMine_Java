/*
 * Created on 2005-1-14
 *
 */
package com.fsrin.menumine.context.webwork;

/**
 * Enabler for webwork to use.
 * 
 * @author Nick
 *  
 */
public interface MenuMineSessionContextWrapperAware {

    public void setMenuMineSessionContextWrapper(
            MenuMineSessionContextWrapper menuMineSessionContextWrapper);
}