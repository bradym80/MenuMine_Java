package com.fsrin.menumine.common.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalanderUtility {
	public static int getCurrentYear()
	{
		Calendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		
		return year;
	}
}
