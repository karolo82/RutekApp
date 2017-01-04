package com.yourapp.app.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yourapp.app.api.manager.PersonManager;
import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.gui.tables.PersonTableModel;
import com.yourapp.app.impl.model.entity.Person;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class PersonSearch extends JPanelBase {
	private JTextField txtName;
	private JTextField txtSurname;
	private JFormattedTextField ftxtPesel;
	private PersonTableModel personTableModel;
	private JTable searchResaultTable;
	@Autowired
	private PersonManager personManager;
	@Autowired
	private WindowManager windowManager;

	/**
	 * Create the panel.
	 */
	public PersonSearch() {
		initGUI();
	}

	@Override
	public void initGUI() {
		JPanel searchFormPanel = new JPanel();
		searchFormPanel.setBorder(BorderFactory
				.createTitledBorder("Formularz wyszukiwania osoby"));

		JPanel resaultPanel = new JPanel();
		resaultPanel.setBorder(BorderFactory
				.createTitledBorder("Wyniki wyszukiwania"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																resaultPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																searchFormPanel,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																682,
																Short.MAX_VALUE))
										.addGap(15)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGap(15)
						.addComponent(searchFormPanel,
								GroupLayout.PREFERRED_SIZE, 178,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(resaultPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		List<Person> persons = new ArrayList<Person>();

		personTableModel = new PersonTableModel(persons);
		searchResaultTable = new JTable();
		searchResaultTable.setModel(personTableModel);
		JScrollPane scrollPane = new JScrollPane(searchResaultTable);

		JButton btnAdd = new JButton("Dodaj");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.showPanel(Panel.PERSON_ADD_PANEL);
			}
		});

		JButton btnEdit = new JButton("Wybierz");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = searchResaultTable.getSelectedRow();
				if (selectedRow >= 0) {
					Person person = personTableModel.getElementAt(selectedRow);
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("personId", person.getId());
					windowManager.showPanel(Panel.PERSON_ADD_PANEL, params);
				}
			}
		});

		JButton btnDelete = new JButton("Usuń");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = searchResaultTable.getSelectedRow();
				if (selectedRow >= 0) {
					Person person = personTableModel.getElementAt(selectedRow);
					personManager.remove(person);
					List<Person> people = personManager.getAll();
					personTableModel.setData(people);
					personTableModel.fireTableDataChanged();
				}
			}
		});

		JButton btnMagazyn = new JButton("Magazyn");
		btnMagazyn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.showPanel(Panel.FRAME_SEARCH);
			}
		});

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		GroupLayout gl_resaultPanel = new GroupLayout(resaultPanel);
		gl_resaultPanel
				.setHorizontalGroup(gl_resaultPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_resaultPanel
										.createSequentialGroup()
										.addGroup(
												gl_resaultPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																656,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_resaultPanel
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				btnAdd)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnEdit)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnDelete)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				separator,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnMagazyn)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_resaultPanel
				.setVerticalGroup(gl_resaultPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_resaultPanel
										.createSequentialGroup()
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												260, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_resaultPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnMagazyn,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																separator,
																GroupLayout.DEFAULT_SIZE,
																23,
																Short.MAX_VALUE)
														.addGroup(
																gl_resaultPanel
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				btnEdit,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnDelete)
																		.addComponent(
																				btnAdd,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		resaultPanel.setLayout(gl_resaultPanel);

		JLabel lblName = new JLabel("Imię");

		txtName = new JTextField();
		txtName.setColumns(20);

		JLabel lblSurname = new JLabel("Nazwisko");

		txtSurname = new JTextField();
		txtSurname.setColumns(20);

		JLabel lblPesel = new JLabel("PESEL");

		ftxtPesel = new JFormattedTextField();
		ftxtPesel.setColumns(20);

		JButton btnSearch = new JButton("Szukaj");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personTableModel.setData(personManager.getPersonByCriteria(
						txtName.getText(), txtSurname.getText(),
						ftxtPesel.getText()));
				personTableModel.fireTableDataChanged();
			}
		});

		JButton btnClear = new JButton("Wyczyść");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtSurname.setText("");
				ftxtPesel.setText("");
			}
		});
		GroupLayout gl_searchFormPanel = new GroupLayout(searchFormPanel);
		gl_searchFormPanel
				.setHorizontalGroup(gl_searchFormPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_searchFormPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_searchFormPanel
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_searchFormPanel
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addGroup(
																				gl_searchFormPanel
																						.createSequentialGroup()
																						.addComponent(
																								lblName)
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtName,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				gl_searchFormPanel
																						.createSequentialGroup()
																						.addGroup(
																								gl_searchFormPanel
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												lblSurname)
																										.addComponent(
																												lblPesel))
																						.addGap(18)
																						.addGroup(
																								gl_searchFormPanel
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												ftxtPesel,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												txtSurname,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																gl_searchFormPanel
																		.createSequentialGroup()
																		.addComponent(
																				btnSearch)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnClear)))
										.addContainerGap(410, Short.MAX_VALUE)));
		gl_searchFormPanel
				.setVerticalGroup(gl_searchFormPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_searchFormPanel
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_searchFormPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblName)
														.addComponent(
																txtName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_searchFormPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblSurname)
														.addComponent(
																txtSurname,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_searchFormPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblPesel)
														.addComponent(
																ftxtPesel,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 37,
												Short.MAX_VALUE)
										.addGroup(
												gl_searchFormPanel
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnSearch)
														.addComponent(btnClear))
										.addContainerGap()));
		searchFormPanel.setLayout(gl_searchFormPanel);
		setLayout(groupLayout);

	}
}
