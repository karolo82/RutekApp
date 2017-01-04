package com.yourapp.app.gui.tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.yourapp.app.impl.model.entity.Order;

@SuppressWarnings("serial")
public class OrderTableModel extends BaseTableDataModel<Order> {

	public OrderTableModel(Set<Order> data) {
		super(new ArrayList<Order>(data));
	}

	@Override
	public List<TableColumn> getColumns() {
		List<TableColumn> columns = new ArrayList<TableColumn>();
		columns.add(new TableColumn("orderNumber", "Numer zam."));
		columns.add(new TableColumn("status", "Status"));
		columns.add(new TableColumn("orderValue", "Wartość"));
		columns.add(new TableColumn("startDate", "Data"));
		return columns;
	}
	
	public void setData(Set<Order> data) {
		super.setData(new ArrayList<Order>(data));
	}	
}
