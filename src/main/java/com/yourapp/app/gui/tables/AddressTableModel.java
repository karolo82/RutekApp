package com.yourapp.app.gui.tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.yourapp.app.impl.model.entity.Address;

@SuppressWarnings("serial")
public class AddressTableModel extends BaseTableDataModel<Address>{

	public AddressTableModel(Set<Address> data) {
		super(new ArrayList<Address>(data));
	}

	@Override
	public List<TableColumn> getColumns() {
		List<TableColumn> columns = new ArrayList<TableColumn>();
		columns.add(new TableColumn("addressType","Typ adresu"));
		columns.add(new TableColumn("postalCode","Kod pocztowy"));
		columns.add(new TableColumn("city","Miasto"));
		columns.add(new TableColumn("street","Ulica"));
		columns.add(new TableColumn("province","Województwo"));
		return columns;
	}
	
	public void setData(Set<Address> data) {
		super.setData(new ArrayList<Address>(data));
	}

}
