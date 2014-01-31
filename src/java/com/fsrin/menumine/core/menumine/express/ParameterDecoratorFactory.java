/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express;

import com.fsrin.menumine.common.SpringBeanBroker;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;

public class ParameterDecoratorFactory {

    public static final String SPRING_BEAN_NAME_EXPRESSQUERY = "expressQueryParameterDecorator";
    
    

    public static final ParameterDecoratorFactory factory = new ParameterDecoratorFactory();
    
    public ParameterDecorator buildExpressItemDescription(MasterFoodFilterParameters target) {
        
        /*
         * 2006-03-30 RSC Don't really need to Spring this.
         */
        ParameterDecorator ret =  (ParameterDecorator) SpringBeanBroker.getBeanFactory().getBean(
                SPRING_BEAN_NAME_EXPRESSQUERY);
        
        ret.setTargetParameters(target);
        
        return ret;
    }
    
    public ParameterDecorator buildExpressKeywords(MasterFoodFilterParameters target) {
        ParameterDecorator ret =  new ParameterDecoratorExpressQueryKeywordsImpl();
        
        ret.setTargetParameters(target);
        
        return ret;
    }
}
