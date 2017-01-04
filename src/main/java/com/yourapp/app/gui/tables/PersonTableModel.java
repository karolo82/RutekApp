package com.yourapp.app.gui.tables;

import java.util.ArrayList;
import java.util.List;

import com.yourapp.app.impl.model.entity.Person;

@SuppressWarnings("serial")
public class PersonTableModel extends BaseTableDataModel<Person> {

	public PersonTableModel(List<Person> data) {
		super(data);
	}

	@Override
	public List<TableColumn> getColumns() {
		List<TableColumn> columns = new ArrayList<TableColumn>();
		columns.add(new TableColumn("name","Imię"));
		columns.add(new TableColumn("surname","Nazwisko"));
		columns.add(new TableColumn("pesel", "PESEL"));
		columns.add(new TableColumn("birthDate","Data urodzenia"));
		return columns;
	}
}
