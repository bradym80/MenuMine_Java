/*
 * Created on May 5, 2006 by Reid
 */
package com.fsrin.menumine.core.menumine.webwork.util;

import com.fsrin.menumine.common.AbstractSpringObjectFactory;

public class GraphWriterUtilFactory extends AbstractSpringObjectFactory {

    public static String SPRING_BEAN_NAME = "graphWriterUtil";
    
    public GraphWriterUtil build() {
        return (GraphWriterUtil) super.build(SPRING_BEAN_NAME);
    }
}
