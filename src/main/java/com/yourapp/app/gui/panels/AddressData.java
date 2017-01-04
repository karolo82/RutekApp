package com.yourapp.app.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.yourapp.app.gui.enums.AddressType;
import com.yourapp.app.gui.tables.AddressTableModel;
import com.yourapp.app.impl.model.entity.Address;
import com.yourapp.app.impl.model.entity.Person;

@SuppressWarnings("serial")
public class AddressData extends JPanel {
	
	private JTextField txtPostalCode;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtHouseNo;
	private JTextField txtFlatNo;
	private AddressTableModel tableDataModel;
	private JComboBox<AddressType> cbAddressType;
	private JComboBox<String> cbProvince;
	private JTable table;
	private JButton btnSaveAddr;
	private Person person;
	
	
	/**
	 * Create the panel.
	 */
	public AddressData() {
		
		JLabel lblPostalCode = new JLabel("Kod pocztowy");
		
		txtPostalCode = new JTextField();
		txtPostalCode.setColumns(15);
		
		JLabel lblAddressType = new JLabel("Klasyfikacja");
		
		cbAddressType = new JComboBox<AddressType>();
		cbAddressType.setModel(new DefaultComboBoxModel<AddressType>(AddressType.values()));
		
		JLabel lblCity = new JLabel("Miejscowość");
		
		txtCity = new JTextField();
		txtCity.setColumns(15);
		
		JLabel lblStreet = new JLabel("Ulica");
		
		txtStreet = new JTextField();
		txtStreet.setColumns(15);
		
		JLabel lblHouseNo = new JLabel("Numer domu");
		
		txtHouseNo = new JTextField();
		txtHouseNo.setColumns(15);
		
		JLabel lblFlatNo = new JLabel("Numer lokalu");
		
		txtFlatNo = new JTextField();
		txtFlatNo.setColumns(15);
		
		JLabel lblWojewdztwo = new JLabel("Województwo");
		
		cbProvince = new JComboBox<String>();
		cbProvince.setModel(new DefaultComboBoxModel<String>(new String[] {"", "warmińsko-mazurskie", "pomorskie"}));
		
		btnSaveAddr = new JButton("Zapisz");
		btnSaveAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//addAddress();	
			}
		});
		
		JButton btnRemove = new JButton("Usuń");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Set<Address > addresses;
		if(person!=null){
			addresses = person.getAdresses();
		} else {
			addresses = new HashSet<Address>();
		}
		tableDataModel = new AddressTableModel(addresses);
		table = new JTable();
		table.setModel(tableDataModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		GroupLayout gl_panAddressData = new GroupLayout(this);
		gl_panAddressData.setHorizontalGroup(
			gl_panAddressData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panAddressData.createSequentialGroup()
					.addGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panAddressData.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panAddressData.createSequentialGroup()
									.addGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPostalCode)
										.addComponent(lblAddressType)
										.addComponent(lblHouseNo)
										.addComponent(lblCity))
									.addGap(18)
									.addGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING)
										.addComponent(cbAddressType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panAddressData.createSequentialGroup()
											.addGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panAddressData.createSequentialGroup()
													.addGroup(gl_panAddressData.createParallelGroup(Alignment.TRAILING)
														.addComponent(txtPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING)
														.addComponent(lblWojewdztwo)
														.addComponent(lblStreet)))
												.addGroup(gl_panAddressData.createSequentialGroup()
													.addComponent(txtHouseNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(lblFlatNo)))
											.addGap(18)
											.addGroup(gl_panAddressData.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(txtFlatNo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtStreet, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbProvince, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_panAddressData.createSequentialGroup()
									.addComponent(btnSaveAddr)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRemove))))
						.addGroup(gl_panAddressData.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)))
					.addGap(97))
		);
		gl_panAddressData.setVerticalGroup(
			gl_panAddressData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panAddressData.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panAddressData.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddressType)
						.addComponent(cbAddressType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panAddressData.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPostalCode)
						.addComponent(txtPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWojewdztwo)
						.addComponent(cbProvince, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panAddressData.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStreet)
						.addComponent(lblCity)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panAddressData.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHouseNo)
						.addComponent(txtHouseNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFlatNo)
						.addComponent(txtFlatNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panAddressData.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveAddr)
						.addComponent(btnRemove))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		this.setLayout(gl_panAddressData);
	}
	
	public JButton getButtonSaveAddr(){
		return btnSaveAddr;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}

}
