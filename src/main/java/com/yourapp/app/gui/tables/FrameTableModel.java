package com.yourapp.app.gui.tables;

import java.util.ArrayList;
import java.util.List;

import com.yourapp.app.impl.model.entity.Frame;

@SuppressWarnings("serial")
public class FrameTableModel extends BaseTableDataModel<Frame>{

	public FrameTableModel(List<Frame> data) {
		super(data);
	}

	@Override
	public List<TableColumn> getColumns() {
		List<TableColumn> columns = new ArrayList<TableColumn>();
		columns.add(new TableColumn("mark","Marka"));
		columns.add(new TableColumn("model","Model"));
		columns.add(new TableColumn("color", "Kolor"));
		columns.add(new TableColumn("nettoValue", "Cena netto"));
		return columns;
	}

}
