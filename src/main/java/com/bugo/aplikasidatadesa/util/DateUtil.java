package com.bugo.aplikasidatadesa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;


public class DateUtil {

	public static final String SIMPLE_DF_NO_SEPARATOR = "yyyyMMdd";
	public static final String SIMPLE_DF_WITH_SEPARATOR = "yyyy-MM-dd";

	public static SimpleDateFormat getDateFormat(String pattern) {
		if (null == pattern || pattern.isEmpty()) {
			pattern = SIMPLE_DF_NO_SEPARATOR;
		}

		return new SimpleDateFormat(pattern);
	}

	public static Calendar getTodaysCalendar() {
		return Calendar.getInstance();
	}

	public static Date getCurrentDate() {
		return getTodaysCalendar().getTime();
	}

	public static Date getParsedDate(String dateString, String pattern) {
		Date date = null;

		if (StringUtils.isBlank(dateString) || StringUtils.isBlank(pattern)) {
			date = getCurrentDate();
		} else {
			try {
				SimpleDateFormat dateFormat = getDateFormat(pattern);
				date = dateFormat.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return date;
	}

	public static String getFormattedDate(Date date, String pattern) {
		if (null == date) {
			date = getCurrentDate();
		}

		return getDateFormat(pattern).format(date);
	}

	public static Date getNextDaysDate(Date date, int days) {
		Calendar cal = getTodaysCalendar();

		if (null != date) {
			cal.setTime(date);
		}

		cal.add(Calendar.DAY_OF_MONTH, days);
		date = cal.getTime();

		return date;
	}

	public static Date getNextMonthsDate(Date date, int months) {
		Calendar cal = getTodaysCalendar();

		if (null != date) {
			cal.setTime(date);
		}

		cal.add(Calendar.MONTH, months);
		date = cal.getTime();

		return date;
	}

	public static String getFormattedNextDaysDate(Date date, int days, String pattern) {
		return getFormattedDate(getNextDaysDate(date, days), pattern);
	}

	public static String getFormattedNextMonthsDate(Date date, int months, String pattern) {
		return getFormattedDate(getNextMonthsDate(date, months), pattern);
	}

	public static String changeDateFormat(String dateString, String patternFrom, String patternTo) {
		String formattedDate = null;

		if (StringUtils.isNotBlank(dateString)
				&& StringUtils.isNotBlank(patternFrom) && StringUtils.isNotBlank(patternTo)) {

			SimpleDateFormat fromDf = getDateFormat(patternFrom);
			SimpleDateFormat toDf = getDateFormat(patternTo);

			if (null != fromDf && null != toDf) {
				try {
					formattedDate = toDf.format(fromDf.parse(dateString));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return formattedDate;
	}
	
	public static String convertDateToStringType2(Date date) {
		String sDate;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.ROOT);
		sDate = format.format(date);		
		return sDate;
	}
}
