/*
 * Created on Nov 2, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.util;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class ExcelSupportFactory extends AbstractSpringObjectFactory {

    
    public  ExcelSupport build() {
        
        return (ExcelSupport) build("excelSupportUtil");
        
    }
    
    

}
