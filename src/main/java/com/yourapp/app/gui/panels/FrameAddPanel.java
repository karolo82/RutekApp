package com.yourapp.app.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yourapp.app.api.manager.FrameManager;
import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.impl.model.entity.Frame;
import com.yourapp.app.utils.ConvertTypeUtil;
import com.yourapp.app.utils.ConvertValueException;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class FrameAddPanel extends JPanelBase {
	private JTextField txtColor;
	private JTextField txtModel;
	private JTextField txtMark;
	@Autowired
	private FrameManager frameManager;
	@Autowired
	private WindowManager windowManager;
	private JTextField txtNettoPrice;
	private JTextField txtId;
	private Long frameId;
	private Frame frame;
	private Long orderId;
	private Long personId;

	/**
	 * Create the panel.
	 */
	public FrameAddPanel() {
		//initGUI();
	}

	@Override
	public void initGUI() {

		JPanel panAddFrame = new JPanel();
		panAddFrame.setBorder(BorderFactory.createTitledBorder("Dane oprawy"));

		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id;
				if (frame == null) {
					frame = new Frame();
				}
				frame.setMark(txtMark.getText());
				frame.setModel(txtModel.getText());
				frame.setColor(txtColor.getText());
				try {
					frame.setNettoValue(ConvertTypeUtil.getBigDecimalFromFieldValue(txtNettoPrice));
				} catch (ConvertValueException e1) {
					return;
				}
				id = frameManager.saveFrame(frame);
				txtId.setText(id.toString());
			}
		});

		String etykieta = "Anuluj";
		if (orderId != null) {
			etykieta = "Powrót";
		}
		JButton btnAnuluj = new JButton(etykieta);
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (orderId != null) {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("personId", personId);
					params.put("orderId", orderId);
					windowManager.showPanel(Panel.ORDER_ADD, params);
				} else {
					windowManager.showPanel(Panel.FRAME_SEARCH);
				}
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
																panAddFrame,
																GroupLayout.DEFAULT_SIZE,
																741,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnZapisz)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnAnuluj)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						groupLayout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(panAddFrame,
										GroupLayout.PREFERRED_SIZE, 198,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										groupLayout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnZapisz)
												.addComponent(btnAnuluj))
								.addContainerGap(286, Short.MAX_VALUE)));

		JLabel lblMarka = new JLabel("Marka");

		JLabel lblModel = new JLabel("Model");

		JLabel lblKolor = new JLabel("Kolor");

		txtColor = new JTextField();
		txtColor.setColumns(10);

		txtModel = new JTextField();
		txtModel.setColumns(40);

		txtMark = new JTextField();
		txtMark.setColumns(40);

		JLabel lblCenaNetto = new JLabel("Cena netto");

		txtNettoPrice = new JTextField();
		txtNettoPrice.setColumns(10);

		JLabel lblId = new JLabel("ID");

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);

		GroupLayout gl_panAddFrame = new GroupLayout(panAddFrame);
		gl_panAddFrame
				.setHorizontalGroup(gl_panAddFrame
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panAddFrame
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panAddFrame
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panAddFrame
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addComponent(
																				lblKolor,
																				GroupLayout.DEFAULT_SIZE,
																				76,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblModel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblMarka,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																lblCenaNetto,
																GroupLayout.PREFERRED_SIZE,
																80,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblId))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panAddFrame
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																txtId,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtMark,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtModel,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panAddFrame
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addComponent(
																				txtNettoPrice,
																				Alignment.LEADING)
																		.addComponent(
																				txtColor,
																				Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE,
																				235,
																				Short.MAX_VALUE)))
										.addContainerGap(305, Short.MAX_VALUE)));
		gl_panAddFrame
				.setVerticalGroup(gl_panAddFrame
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panAddFrame
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panAddFrame
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
												gl_panAddFrame
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
												gl_panAddFrame
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblKolor)
														.addComponent(
																txtColor,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panAddFrame
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblCenaNetto)
														.addComponent(
																txtNettoPrice,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panAddFrame
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblId)
														.addComponent(
																txtId,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(45, Short.MAX_VALUE)));
		panAddFrame.setLayout(gl_panAddFrame);
		setLayout(groupLayout);

		if (frameId != null) {
			frame = frameManager.getFrameById(frameId);
			txtColor.setText(frame.getColor());
			txtId.setText(frame.getId().toString());
			txtMark.setText(frame.getMark());
			txtModel.setText(frame.getModel());
			txtNettoPrice.setText(frame.getNettoValue().toString());
		}
	}
}
