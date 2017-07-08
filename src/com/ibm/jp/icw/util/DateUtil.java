package com.ibm.jp.icw.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static String getNowTime(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 11);
		if(calendar.get(Calendar.MINUTE) % 2 != 0){
			calendar.add(Calendar.MINUTE, -1);
		}

		return new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(calendar.getTime());
	}

	public static String getTodayMinTime(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 11);
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(calendar.getTime());
	}

	public static String getTodayMaxTime(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 11);
		calendar.set(Calendar.HOUR_OF_DAY, 14);
		calendar.set(Calendar.MINUTE, 58);
		calendar.set(Calendar.SECOND, 00);

		return new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(calendar.getTime());
	}

	public static String getYestedayMinTime(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 11);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(calendar.getTime());
	}

	public static String getYesterdayMaxTime(){

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 14);
		calendar.set(Calendar.MINUTE, 58);
		calendar.set(Calendar.SECOND, 00);

		return new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(calendar.getTime());
	}

	public static String getYearMinTime(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(calendar.getTime());
	}

	public static String getYearMaxTime(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 12);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(calendar.getTime());
	}
}
