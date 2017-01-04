package com.yourapp.app.gui.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.yourapp.app.api.manager.PersonManager;
import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.gui.enums.PanelMode;
import com.yourapp.app.impl.model.entity.Address;
import com.yourapp.app.impl.model.entity.Person;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class PersonAdd extends JPanelBase {
	private JTextField name;
	private JTextField surname;
	private JTextField birthDate;
	private Person person;
	@Autowired
	private PersonManager personManager;
	@Autowired
	private WindowManager windowManager;

	/**
	 * Create the panel.
	 */
	public PersonAdd() {
		initGUI();
	}

	public void addPerson() {
		Address adress = new Address();
		Person person = new Person();
		person.setName(name.getText());
		person.setSurname(surname.getText());
		person.setBirthDate(new Date());
		person.setEmail("dupa@o2.pl");
		person.setPesel("8134567890");
		person.setNotes("Notatka testowa");
		person.setPhone("791004166");
		adress.setCity("Gdańsk");
		adress.setNoFlat("3");
		adress.setNoHouse("5a");
		adress.setPostalCode("82-300");
		adress.setProvince("pomorskie");
		adress.setStreet("Kościuszki");
		person.getAdresses().add(adress);
		personManager.savePerson(person);
		windowManager.showPanel(Panel.PERSON_SEARCH);
	}

	// TODO - dodać metode edit person obsługującą zapis istniejącej osoby
	public void editPerson() {
		person.setName(name.getText());
		person.setSurname(surname.getText());
		// TODO dodać metodę save do managera
		// /personManager.addPerson(person);
		windowManager.showPanel(Panel.PERSON_SEARCH);
	}

	@Override
	public void initGUI() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblImi = new JLabel("Imię");
		panel.add(lblImi, "2, 2, right, default");

		name = new JTextField();
		panel.add(name, "4, 2, left, default");
		name.setColumns(10);

		JLabel lblNazwisko = new JLabel("Nazwisko");
		panel.add(lblNazwisko, "2, 4, right, default");

		surname = new JTextField();
		panel.add(surname, "4, 4, left, default");
		surname.setColumns(10);

		JLabel lblDataUrodzenia = new JLabel("Data urodzenia");
		panel.add(lblDataUrodzenia, "2, 6, right, default");

		birthDate = new JTextField();
		panel.add(birthDate, "4, 6, left, default");
		birthDate.setColumns(10);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Zapisz");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (getMode() == PanelMode.STANDARD) {
					addPerson();
				} else {
					editPerson();
				}

			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Anuluj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				windowManager.showPanel(Panel.PERSON_SEARCH);
			}
		});
		panel_1.add(btnNewButton_1);

		if (getMode() == PanelMode.PARAMS) {
			name.setText(person.getName());
			surname.setText(person.getSurname());
			birthDate.setText(person.getBirthDate().toString());
		}

	}
}
