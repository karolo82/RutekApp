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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yourapp.app.api.manager.FrameManager;
import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.gui.tables.FrameTableModel;
import com.yourapp.app.impl.model.entity.Frame;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class FrameSearchPanel extends JPanelBase {
	private JTextField txtMark;
	private JTextField txtModel;
	private JTextField txtColor;
	private FrameTableModel frameTableModel;
	private JTable searchReasultTable;
	@Autowired
	private FrameManager frameManager;
	@Autowired
	private WindowManager windowManager;

	/**
	 * Create the panel.
	 */
	public FrameSearchPanel() {
		//initGUI();
	}

	@Override
	public void initGUI() {

		JPanel panFrameSearch = new JPanel();
		panFrameSearch.setBorder(BorderFactory
				.createTitledBorder("Wyszukiwanie oprawy"));

		JButton btnSzukaj = new JButton("Szukaj");
		btnSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameTableModel.setData(frameManager.getFrameByCriteria(
						txtMark.getText(), txtModel.getText(),
						txtColor.getText()));
				frameTableModel.fireTableDataChanged();
			}
		});

		JPanel panSearchReasults = new JPanel();
		panSearchReasults.setBorder(BorderFactory
				.createTitledBorder("Wyniki wyszukiwania"));

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.showPanel(Panel.FRAME_ADD);
			}
		});

		JButton btnUstalCene = new JButton("Ustal cenę");
		btnUstalCene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnWprowadDoMagazynu = new JButton("Wprowadź do magazynu");

		JButton btnEdytuj = new JButton("Edytuj");
		btnEdytuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = searchReasultTable.getSelectedRow();
				if (selectedRow >= 0) {
					Frame frame = frameTableModel.getElementAt(selectedRow);
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("frameId", frame.getId());
					windowManager.showPanel(Panel.FRAME_ADD, params);
				}
			}
		});

		JButton btnPowrt = new JButton("Powrót");
		btnPowrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.showPanel(Panel.PERSON_SEARCH);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panFrameSearch,
																GroupLayout.DEFAULT_SIZE,
																731,
																Short.MAX_VALUE)
														.addComponent(btnSzukaj)
														.addComponent(
																panSearchReasults,
																GroupLayout.DEFAULT_SIZE,
																731,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnDodaj)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnEdytuj)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnWprowadDoMagazynu)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnUstalCene)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				288,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnPowrt)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(panFrameSearch,
										GroupLayout.PREFERRED_SIZE, 124,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSzukaj)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panSearchReasults,
										GroupLayout.PREFERRED_SIZE, 306,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnDodaj)
												.addComponent(btnEdytuj)
												.addComponent(
														btnWprowadDoMagazynu)
												.addComponent(btnUstalCene)
												.addComponent(btnPowrt))
								.addContainerGap(21, Short.MAX_VALUE)));

		List<Frame> frames = new ArrayList<Frame>();
		frameTableModel = new FrameTableModel(frames);
		searchReasultTable = new JTable();
		searchReasultTable.setModel(frameTableModel);
		JScrollPane scrollPane = new JScrollPane(searchReasultTable);
		GroupLayout gl_panSearchReasults = new GroupLayout(panSearchReasults);
		gl_panSearchReasults.setHorizontalGroup(gl_panSearchReasults
				.createParallelGroup(Alignment.LEADING).addComponent(
						scrollPane, GroupLayout.DEFAULT_SIZE, 715,
						Short.MAX_VALUE));
		gl_panSearchReasults.setVerticalGroup(gl_panSearchReasults
				.createParallelGroup(Alignment.LEADING).addComponent(
						scrollPane, GroupLayout.DEFAULT_SIZE, 282,
						Short.MAX_VALUE));
		panSearchReasults.setLayout(gl_panSearchReasults);

		JLabel lblMarka = new JLabel("Marka");

		JLabel lblModel = new JLabel("Model");

		JLabel lblKolor = new JLabel("Kolor");

		txtMark = new JTextField();
		txtMark.setColumns(40);

		txtModel = new JTextField();
		txtModel.setColumns(40);

		txtColor = new JTextField();
		txtColor.setColumns(20);
		GroupLayout gl_panFrameSearch = new GroupLayout(panFrameSearch);
		gl_panFrameSearch
				.setHorizontalGroup(gl_panFrameSearch
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panFrameSearch
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panFrameSearch
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panFrameSearch
																		.createSequentialGroup()
																		.addComponent(
																				lblMarka)
																		.addGap(18)
																		.addComponent(
																				txtMark,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panFrameSearch
																		.createSequentialGroup()
																		.addGroup(
																				gl_panFrameSearch
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblModel)
																						.addComponent(
																								lblKolor))
																		.addGap(18)
																		.addGroup(
																				gl_panFrameSearch
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtColor,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtModel,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(572, Short.MAX_VALUE)));
		gl_panFrameSearch
				.setVerticalGroup(gl_panFrameSearch
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panFrameSearch
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panFrameSearch
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblMarka)
														.addComponent(
																txtMark,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panFrameSearch
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblModel)
														.addComponent(
																txtModel,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panFrameSearch
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblKolor)
														.addComponent(
																txtColor,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(35, Short.MAX_VALUE)));
		panFrameSearch.setLayout(gl_panFrameSearch);
		setLayout(groupLayout);
	}
}
