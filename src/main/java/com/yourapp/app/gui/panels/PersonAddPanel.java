package com.yourapp.app.gui.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yourapp.app.api.manager.AddressManager;
import com.yourapp.app.api.manager.OrderManager;
import com.yourapp.app.api.manager.PersonManager;
import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.gui.enums.AddressType;
import com.yourapp.app.gui.enums.PanelMode;
import com.yourapp.app.gui.enums.Province;
import com.yourapp.app.gui.tables.AddressTableModel;
import com.yourapp.app.gui.tables.OrderTableModel;
import com.yourapp.app.impl.model.entity.Address;
import com.yourapp.app.impl.model.entity.Order;
import com.yourapp.app.impl.model.entity.Person;
import java.awt.ComponentOrientation;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class PersonAddPanel extends JPanelBase {

	// panel PersonData
	private PersonData personData;
	private Long personId;
	private Person person;
	@Autowired
	private PersonManager personManager;
	@Autowired
	private AddressManager addressManager;
	@Autowired
	private WindowManager windowManager;
	@Autowired
	private OrderManager orderManager;
	private JFormattedTextField txtPostalCode;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtHouseNo;
	private JTextField txtFlatNo;
	private AddressTableModel addressTableModel;
	private OrderTableModel orderTableModel;
	private JComboBox<String> cbAddressType;
	private JComboBox<String> cbProvince;
	private JTable addressTable;
	private JTable orderTable;
	private JTextField txtPost;
	private JPanelMode panAddAddress;
	private Address editedAddres;

	/**
	 * Create the panel.
	 */
	public PersonAddPanel() {
		initGUI();
	}

	public void setDataByPanelMode() {
		if (getMode() == PanelMode.PARAMS) {
			person = personManager.getFullPersonById(personId);
			personData = new PersonData(person);
		} else {
			personData = new PersonData();
		}
	}

	public void savePerson() {
		if (this.person == null) {
			this.person = new Person();
		}
		Person person = personData.getPerson();
		this.person.setName(person.getName());
		this.person.setSurname(person.getSurname());
		this.person.setBirthDate(person.getBirthDate());
		this.person.setPesel(person.getPesel());
		this.person.setSex(person.getSex());
		this.person.setPhone(person.getPhone());
		this.person.setEmail(person.getEmail());
		this.person.setNotes(person.getNotes());
		personManager.savePerson(this.person);
	}

	public void addAddress() {
		Address address = null;
		if (editedAddres != null) {
			address = editedAddres;
		} else {
			address = new Address();
		}
		address.setAddressType(AddressType.getAddresTypeName(cbAddressType.getSelectedItem().toString()));
		address.setCity(txtCity.getText());
		address.setNoFlat(txtFlatNo.getText());
		address.setNoHouse(txtHouseNo.getText());
		address.setPostalCode(txtPostalCode.getText());
		address.setProvince(Province.getProvinceName(cbProvince.getSelectedItem().toString()));
		address.setStreet(txtStreet.getText());
		address.setPost(txtPost.getText());
		if (this.person == null) {
			this.person = new Person();
		}
		person.addaddress(address);
		refreshAddressTable(person);
		hidePanAddAddress();
		personManager.savePerson(this.person);
		editedAddres = null;
	}

	public void showPanAddAddress() {
		panAddAddress.setVisible(true);
	}

	public void hidePanAddAddress() {
		panAddAddress.setVisible(false);
		clearAddressDataInputs();
	}

	public void clearAddressDataInputs() {
		txtCity.setText(null);
		txtFlatNo.setText(null);
		txtHouseNo.setText(null);
		txtPostalCode.setText(null);
		txtStreet.setText(null);
		txtPost.setText(null);
	}

	public void fillAddressDataInputs(Address address) {
		editedAddres = address;
		txtCity.setText(address.getCity());
		txtFlatNo.setText(address.getNoFlat());
		txtHouseNo.setText(address.getNoHouse());
		txtPostalCode.setText(address.getPostalCode());
		txtStreet.setText(address.getStreet());
		cbAddressType.setSelectedItem(address.getAddressType().getName());
		cbProvince.setSelectedItem(address.getProvince().getName());
		txtPost.setText(address.getPost());
	}

	public void refreshAddressTable(Person person) {
		addressTableModel.setData(person.getAdresses());
		addressTableModel.fireTableDataChanged();
	}

	public void refreshOrderTable(Person person) {
		orderTableModel.setData(person.getOrders());
		orderTableModel.fireTableDataChanged();
	}

	private Order getSelectedOrder() {
		int selectedRow = orderTable.getSelectedRow();
		if (selectedRow >= 0) {
			Order selectedOrder = orderTableModel.getElementAt(selectedRow);
			return selectedOrder;
		}
		return null;
	}

	@Override
	public void initGUI() {
		removeAll();
		setLayout(new BorderLayout(0, 0));

		setDataByPanelMode();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GroupLayout groupLayout = new GroupLayout(this);

		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(22)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addGap(32)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(60, Short.MAX_VALUE)));

		tabbedPane.addTab("Dane osobowe", null, personData, null);

		personData.getSaveBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePerson();
			}
		});

		personData.getCancelBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.showPanel(Panel.PERSON_SEARCH);
			}
		});

		Set<Address> addresses = new HashSet<Address>();
		if (person != null) {
			addresses = person.getAdresses();
		}
		addressTableModel = new AddressTableModel(addresses);

		// poczatek panel dane adresowe

		JPanel panAddressData = new JPanel();
		tabbedPane.addTab("Dane adresowe", null, panAddressData, null);
		addressTable = new JTable();
		addressTable.setModel(addressTableModel);
		JScrollPane scrollPane = new JScrollPane(addressTable);

		panAddAddress = new JPanelMode();
		panAddAddress.setBorder(BorderFactory.createTitledBorder("Dane adresowe"));
		panAddAddress.setVisible(false);

		JButton btnAddAddress = new JButton("Dodaj");
		btnAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panAddAddress.setMode(PanelMode.STANDARD);
				showPanAddAddress();
			}
		});

		JButton btnEditAddress = new JButton("Edytuj");
		btnEditAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = addressTable.getSelectedRow();
				if (selectedRow >= 0) {
					Address address = addressTableModel.getElementAt(selectedRow);
					fillAddressDataInputs(address);
				}
				panAddAddress.setMode(PanelMode.PARAMS);
				showPanAddAddress();
			}
		});

		JButton btnRemoveAddress = new JButton("Usuń");
		btnRemoveAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = JOptionPane.showConfirmDialog(null, "Czy napewno usunąć wybrany adres?", "Usuwanie adresu",
						JOptionPane.YES_NO_OPTION);
				if (value == 0) {
					int selectedRow = addressTable.getSelectedRow();
					if (selectedRow >= 0) {
						Address address = addressTableModel.getElementAt(selectedRow);
						person.getAdresses().remove(address);
						refreshAddressTable(person);
						personManager.savePerson(person);
					} else {
						JOptionPane.showMessageDialog(null, "Nie wybrano żadnego rekordu.", "Błąd",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		GroupLayout gl_panAddressData = new GroupLayout(panAddressData);
		gl_panAddressData.setHorizontalGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panAddressData.createSequentialGroup().addContainerGap().addGroup(gl_panAddressData
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(panAddAddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING,
								gl_panAddressData.createSequentialGroup().addComponent(btnAddAddress)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEditAddress)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRemoveAddress)))
						.addContainerGap()));
		gl_panAddressData.setVerticalGroup(gl_panAddressData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panAddressData.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panAddressData.createParallelGroup(Alignment.BASELINE).addComponent(btnAddAddress)
								.addComponent(btnEditAddress).addComponent(btnRemoveAddress))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panAddAddress, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
						.addContainerGap()));

		JLabel lblAddressType = new JLabel("Klasyfikacja");
		lblAddressType.setBounds(18, 30, 96, 14);

		cbAddressType = new JComboBox<String>();
		cbAddressType.setBounds(124, 27, 150, 20);
		cbAddressType.setModel(new DefaultComboBoxModel<String>(AddressType.getNames()));

		JLabel lblPostalCode = new JLabel("Kod pocztowy");
		lblPostalCode.setBounds(18, 56, 96, 14);

		txtPostalCode = new JFormattedTextField();
		txtPostalCode.setBounds(124, 53, 150, 20);
		txtPostalCode.setColumns(15);

		JLabel lblWojewdztwo = new JLabel("Województwo");
		lblWojewdztwo.setBounds(308, 30, 102, 14);

		cbProvince = new JComboBox<String>();
		cbProvince.setBounds(420, 27, 180, 20);
		cbProvince.setModel(new DefaultComboBoxModel<String>(Province.getNames()));

		JLabel lblPoczta = new JLabel("Poczta");
		lblPoczta.setBounds(308, 56, 70, 14);

		txtPost = new JTextField();
		txtPost.setBounds(420, 53, 150, 20);
		txtPost.setColumns(15);

		JLabel lblCity = new JLabel("Miejscowość");
		lblCity.setBounds(18, 82, 96, 14);

		txtCity = new JTextField();
		txtCity.setBounds(124, 79, 150, 20);
		txtCity.setColumns(15);

		JLabel lblStreet = new JLabel("Ulica");
		lblStreet.setBounds(308, 82, 70, 14);

		txtStreet = new JTextField();
		txtStreet.setBounds(420, 79, 150, 20);
		txtStreet.setColumns(15);

		JLabel lblHouseNo = new JLabel("Numer domu");
		lblHouseNo.setBounds(18, 108, 96, 14);

		txtHouseNo = new JTextField();
		txtHouseNo.setBounds(124, 105, 126, 20);
		txtHouseNo.setColumns(15);

		JLabel lblFlatNo = new JLabel("Numer lokalu");
		lblFlatNo.setBounds(308, 108, 102, 14);

		txtFlatNo = new JTextField();
		txtFlatNo.setBounds(420, 105, 126, 20);
		txtFlatNo.setColumns(15);

		JButton btnSaveAddr = new JButton("Zapisz");
		btnSaveAddr.setBounds(18, 143, 80, 23);
		btnSaveAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAddress();
				hidePanAddAddress();
			}
		});

		JButton btnCancel = new JButton("Anuluj");
		btnCancel.setBounds(105, 143, 80, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hidePanAddAddress();
			}
		});
		panAddAddress.setLayout(null);
		panAddAddress.add(lblHouseNo);
		panAddAddress.add(lblPostalCode);
		panAddAddress.add(lblCity);
		panAddAddress.add(txtCity);
		panAddAddress.add(txtHouseNo);
		panAddAddress.add(cbAddressType);
		panAddAddress.add(txtPostalCode);
		panAddAddress.add(lblAddressType);
		panAddAddress.add(lblWojewdztwo);
		panAddAddress.add(lblPoczta);
		panAddAddress.add(lblStreet);
		panAddAddress.add(lblFlatNo);
		panAddAddress.add(txtFlatNo);
		panAddAddress.add(txtStreet);
		panAddAddress.add(txtPost);
		panAddAddress.add(cbProvince);
		panAddAddress.add(btnSaveAddr);
		panAddAddress.add(btnCancel);

		panAddressData.setLayout(gl_panAddressData);

		// koniec panel dane adresowe
		// początek panela order data
		JPanel panOrderData = new JPanel();
		tabbedPane.addTab("Zamówienia", null, panOrderData, null);

		Set<Order> orders = new HashSet<Order>();
		if (person != null) {
			orders = person.getOrders();
		}
		orderTableModel = new OrderTableModel(orders);
		orderTable = new JTable();
		orderTable.setModel(orderTableModel);
		JScrollPane scrollPane_1 = new JScrollPane(orderTable);

		JButton btnAddOrder = new JButton("Dodaj zamówienie");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("personId", person.getId());
				windowManager.showPanel(Panel.ORDER_ADD, params);
			}
		});

		JButton btnDeleteOrder = new JButton("Usuń zamówienie");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = JOptionPane.showConfirmDialog(null, "Czy napewno usunąć wybrane zamówienie?",
						"Usuwanie zamówienia", JOptionPane.YES_NO_OPTION);
				if (value == 0) {
					Order selectedOrder = getSelectedOrder();
					if (selectedOrder != null) {
						orderManager.removeOrder(selectedOrder);
						person = personManager.getFullPersonById(personId);
						refreshOrderTable(person);
					} else {
						JOptionPane.showMessageDialog(null, "Nie wybrano żadnego rekordu.", "Błąd",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		JButton btnShowOrder = new JButton("Podgląd zamówienia");
		btnShowOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("personId", person.getId());
				Order selectedOrder = getSelectedOrder();
				if (selectedOrder != null) {
					params.put("orderId", selectedOrder.getId());
					windowManager.showPanel(Panel.ORDER_ADD, params);
				} else {
					JOptionPane.showMessageDialog(null, "Nie wybrano żadnego rekordu.", "Błąd",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		GroupLayout gl_panOrderData = new GroupLayout(panOrderData);
		gl_panOrderData.setHorizontalGroup(gl_panOrderData.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panOrderData.createSequentialGroup().addContainerGap()
						.addGroup(gl_panOrderData.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
								.addGroup(gl_panOrderData.createSequentialGroup().addComponent(btnAddOrder)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnShowOrder)
										.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
										.addComponent(btnDeleteOrder)))
						.addContainerGap()));
		gl_panOrderData.setVerticalGroup(gl_panOrderData.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panOrderData.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
						.addGap(18).addGroup(gl_panOrderData.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddOrder).addComponent(btnDeleteOrder).addComponent(btnShowOrder))
						.addContainerGap()));
		panOrderData.setLayout(gl_panOrderData);
		setLayout(groupLayout);
		// koniec panela order data
	}
}
