package com.yourapp.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ConvertTypeUtil {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String DATE_FORMAT_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
	
	public static Integer getIntegerFromString(String value) {
		if (value == null) {
			return null;
		}
		Integer res = null;
		try {
			res = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			JOptionPane
            .showMessageDialog(
                    null,
                    "Proszę wprowadzić wartość liczbową w formacie: 123",
                    "Błąd wartości liczbowej",
                    JOptionPane.ERROR_MESSAGE);
		}
		return res;
	}
	
	public static String getStringFromDateWoTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}
	
	public static Date getDateFromDateWoTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String dd = sdf.format(date);
		Date res = date;
		try {
			 res = sdf.parse(dd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static Date getDateFromDateWithTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_WITH_TIME);
		String dd = sdf.format(date);
		Date res = date;
		try {
			res = sdf.parse(dd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return res;
	}

}
