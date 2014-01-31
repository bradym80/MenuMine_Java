package com.fsrin.menumine.common.util;

import java.io.*;

public class ActionPanelUtil {
	
	
	private static boolean Excel = true;
	
	public static boolean getExcel() {
		
		return Excel;
	}
	
	public static void setExcel(String val){
    	Excel = val.equals("true");
    }
}
