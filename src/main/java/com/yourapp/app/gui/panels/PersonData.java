package com.yourapp.app.gui.panels;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.yourapp.app.gui.enums.Sex;
import com.yourapp.app.impl.model.entity.Person;
import com.yourapp.app.utils.ConvertTypeUtil;

@SuppressWarnings("serial")
public class PersonData extends JPanel {
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPesel;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextArea taNotes;
	private JComboBox<String> cbSex;
	private JButton btnSave;
	private JButton btnCancel;
	private Person person;
	private JDateChooser dcBirthDate;

	public PersonData(Person person) {
		this.person = person;
		initPanel();
		setPersonData();
	}

	/**
	 * Create the panel.
	 */
	public PersonData() {
		initPanel();
	}

	public void setPersonData() {
		txtName.setText(person.getName());
		txtSurname.setText(person.getSurname());
		txtPesel.setText(person.getPesel());
		txtEmail.setText(person.getEmail());
		txtPhone.setText(person.getPhone());
		taNotes.setText(person.getNotes());
		dcBirthDate.setDate(person.getBirthDate());
		cbSex.setSelectedItem(person.getSex().getName());
	}

	public void initPanel() {

		JLabel lblName = new JLabel("Imię");
		lblName.setBounds(10, 34, 80, 14);

		txtName = new JTextField();
		txtName.setBounds(149, 31, 126, 20);
		txtName.setColumns(15);

		JLabel lblSurname = new JLabel("Nazwisko");
		lblSurname.setBounds(316, 34, 80, 14);

		txtSurname = new JTextField();
		txtSurname.setBounds(403, 31, 126, 20);
		txtSurname.setColumns(15);

		JLabel lblBirthDate = new JLabel("Data urodzenia");
		lblBirthDate.setBounds(10, 60, 118, 14);

		dcBirthDate = new JDateChooser();
		dcBirthDate.setBounds(149, 57, 126, 20);

		JLabel lblPesel = new JLabel("PESEL");
		lblPesel.setBounds(316, 60, 80, 14);

		txtPesel = new JTextField();
		txtPesel.setBounds(403, 57, 126, 20);
		txtPesel.setColumns(15);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(316, 112, 80, 14);

		txtEmail = new JTextField();
		txtEmail.setBounds(403, 109, 126, 20);
		txtEmail.setColumns(15);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(10, 112, 80, 14);

		txtPhone = new JTextField();
		txtPhone.setBounds(149, 109, 126, 20);
		txtPhone.setColumns(15);

		JLabel lblSex = new JLabel("Płeć");
		lblSex.setBounds(10, 86, 80, 14);

		cbSex = new JComboBox<String>();
		cbSex.setBounds(149, 83, 126, 20);
		cbSex.setModel(new DefaultComboBoxModel<String>(Sex.getNames()));

		JLabel lblNotatki = new JLabel("Notatki");
		lblNotatki.setBounds(10, 137, 80, 14);

		taNotes = new JTextArea();
		taNotes.setBounds(149, 137, 380, 212);
		taNotes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		taNotes.setColumns(25);
		taNotes.setRows(3);

		btnSave = new JButton("Zapisz");
		btnSave.setBounds(10, 360, 80, 23);

		btnCancel = new JButton("Powrót");
		btnCancel.setBounds(100, 360, 80, 23);
		setLayout(null);
		add(lblName);
		add(txtName);
		add(lblBirthDate);
		add(lblSex);
		add(cbSex);
		add(dcBirthDate);
		add(txtPhone);
		add(lblTelefon);
		add(lblSurname);
		add(lblPesel);
		add(lblEmail);
		add(txtEmail);
		add(txtPesel);
		add(txtSurname);
		add(lblNotatki);
		add(taNotes);
		add(btnSave);
		add(btnCancel);
	}

	public JButton getSaveBtn() {
		return btnSave;
	}

	public JButton getCancelBtn() {
		return btnCancel;
	}

	public Person getPerson() {
		Person person = new Person();
		person.setName(txtName.getText());
		person.setSurname(txtSurname.getText());
		person.setPesel(txtPesel.getText());
		person.setBirthDate(ConvertTypeUtil.getDateFromDateWoTime(dcBirthDate.getDate()));
		person.setEmail(txtEmail.getText());
		person.setNotes(taNotes.getText());
		person.setSex(Sex.getSexName(cbSex.getSelectedItem().toString()));
		person.setPhone(txtPhone.getText());
		return person;
	}

}
