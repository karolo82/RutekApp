package com.yourapp.app.gui.tables;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class BaseTableDataModel<T> extends AbstractTableModel {

	private List<T> data;

	private List<TableColumn> columns;

	public BaseTableDataModel(List<T> data) {
		this.data = data;
		this.columns = getColumns();
	}

	public abstract List<TableColumn> getColumns();

	public int getColumnCount() {
		return columns.size();
	}

	public int getRowCount() {
		return data.size();
	}

	@Override
	public String getColumnName(int column) {
		return columns.get(column).getColumnName();
	}

	public Object getValueAt(int row, int col) {
		T object = data.get(row);
		String prop = columns.get(col).getPropertyName();
		Field field;
		try {
			field = object.getClass().getDeclaredField(prop);
		} catch (NoSuchFieldException e1) {
			throw new RuntimeException(e1);
		}

		field.setAccessible(true);

		try {
			return field.get(object);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	public T getElementAt(int row) {
		return data.get(row);
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
