/*
 * Created on May 1, 2006 by Reid
 */
package com.fsrin.menumine.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtilities {

    public static String getExceptionStackTrace(Throwable t) {
        
        
        StringWriter sw = new StringWriter();

        

        if (t != null) {
            t.printStackTrace(new PrintWriter(sw));

        }
        
        return sw.toString();
    }
}
