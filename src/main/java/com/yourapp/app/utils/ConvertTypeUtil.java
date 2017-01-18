package com.yourapp.app.utils;

import java.awt.Color;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConvertTypeUtil {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String DATE_FORMAT_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
	
	public static Integer getIntegerFromFieldValue(JTextField field) throws ConvertValueException {
		if (field == null || field.getText() == null || field.getText().isEmpty()) {
			return null;
		}
		String value = field.getText();
		Integer res = null;
		try {
			field.setBackground(Color.WHITE);
			res = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			field.setBackground(Color.RED);
			JOptionPane
            .showMessageDialog(
                    null,
                    "Proszę wprowadzić wartość liczbową w formacie: \"123\". Błędna wartość została zaznaczona kolorem czerwonym.",
                    "Błąd wartości liczbowej",
                    JOptionPane.ERROR_MESSAGE);
			throw new ConvertValueException();
		}
		return res;
	}
	
	public static BigDecimal getBigDecimalFromFieldValue(JTextField field) throws ConvertValueException {
		if (field == null || field.getText() == null || field.getText().isEmpty()) {
			return new BigDecimal("0");
		}
		String value = field.getText().replace(',', '.');
		BigDecimal res = null;
		try {
			field.setBackground(Color.WHITE);
			res = new BigDecimal(value);
		} catch (NumberFormatException e) {
			field.setBackground(Color.RED);
			JOptionPane
			.showMessageDialog(
					null,
					"Proszę wprowadzić wartość liczbową w formacie: \"123.21\". Błędna wartość została zaznaczona kolorem czerwonym.",
					"Błąd wartości liczbowej",
					JOptionPane.ERROR_MESSAGE);
			throw new ConvertValueException();
		}
		return res;
	}
	
	public static Float getFloatFromFieldValue(JTextField field) throws ConvertValueException {
		if (field == null || field.getText() == null || field.getText().isEmpty()) {
			return null;
		}
		String value = field.getText().replace(',', '.');
		Float res = null;
		try {
			field.setBackground(Color.WHITE);
			res = Float.valueOf(value);
		} catch (NumberFormatException e) {
			field.setBackground(Color.RED);
			JOptionPane
			.showMessageDialog(
					null,
					"Proszę wprowadzić wartość liczbową w formacie: \"123.12\". Błędna wartość została zaznaczona kolorem czerwonym.",
					"Błąd wartości liczbowej",
					JOptionPane.ERROR_MESSAGE);
			throw new ConvertValueException();
		}
		return res;
	}
	
	public static String getStringFromDateWoTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}
	
	public static Date getDateFromDateWoTime(Date date) {
		if (date == null) return null;
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
	
	public static String toString(BigDecimal value) {
		if (value == null) return null;
		return value.toString();
	}

	public static String toString(Float value) {
		if (value == null) return null;
		return value.toString();
	}

	public static Date getDateFromDateWithTime(Date date) {
		if (date == null) return null;
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
