package com.yourapp.app.gui.tables;

public class TableColumn {
	private String propertyName;
	private String columnName;
	
	public TableColumn(String propertyName, String columnName) {
		this.propertyName = propertyName;
		this.columnName = columnName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	
}
