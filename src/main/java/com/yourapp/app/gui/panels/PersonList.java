package com.yourapp.app.gui.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yourapp.app.api.manager.PersonManager;
import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.gui.tables.BaseTableDataModel;
import com.yourapp.app.gui.tables.PersonTableModel;
import com.yourapp.app.impl.model.entity.Person;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class PersonList extends JPanelBase {
	private JTable table;
	private BaseTableDataModel<Person> tableDataModel;

	@Autowired
	private PersonManager personManager;
	@Autowired
	private WindowManager windowManager;
	private final JButton btnEdytuj = new JButton("Edytuj");

	/**
	 * Create the panel.
	 */
	public PersonList() {
		//initGUI();
	}

	public void initGUI() {
		removeAll();
		setLayout(new BorderLayout(0, 0));

		table = new JTable();
		
		tableDataModel = new PersonTableModel(personManager.getAll());
		table.setModel(tableDataModel);

		add(new JScrollPane(table), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.showPanel(Panel.PERSON_ADD_PANEL);
			}
		});
		panel.add(btnDodaj);

		JButton btnNewButton = new JButton("Usuń");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					Person person = tableDataModel.getElementAt(selectedRow);
					personManager.remove(person);
					List<Person> people = personManager.getAll();
					tableDataModel.setData(people);
					tableDataModel.fireTableDataChanged();
				}
			}
		});

		btnEdytuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					Person person = tableDataModel.getElementAt(selectedRow);
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("personId", person.getId());
					windowManager.showPanel(Panel.PERSON_ADD_PANEL, params);
				}
			}

		});
		panel.add(btnEdytuj);
		panel.add(btnNewButton);
	}
}
