/*
 * Created on Feb 6, 2006 by Reid
 */
package com.fsrin.menumine.core.menubook;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class MenuBookBuilderFactory extends AbstractSpringObjectFactory {
    
    public static MenuBookBuilderFactory factory = new MenuBookBuilderFactory();
    
    public MenuBookBuilder build() {
        return (MenuBookBuilder) this.build(MenuBookBuilder.SPRING_BEAN_NAME);
    }

}
