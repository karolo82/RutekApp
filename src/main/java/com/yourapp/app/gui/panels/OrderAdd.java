package com.yourapp.app.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.toedter.calendar.JDateChooser;
import com.yourapp.app.api.manager.FrameManager;
import com.yourapp.app.api.manager.OrderManager;
import com.yourapp.app.api.manager.PersonManager;
import com.yourapp.app.api.manager.WindowManager;
import com.yourapp.app.gui.Panel;
import com.yourapp.app.gui.enums.Status;
import com.yourapp.app.gui.tables.FrameTableModel;
import com.yourapp.app.impl.model.entity.Examination;
import com.yourapp.app.impl.model.entity.Frame;
import com.yourapp.app.impl.model.entity.Order;
import com.yourapp.app.impl.model.entity.Person;
import com.yourapp.app.utils.ConvertTypeUtil;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class OrderAdd extends JPanelBase {
    private Long personId;
    private Long orderId;
    private Person person;
    private Order order;
    private Frame frame;
    private Examination examination;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private FrameManager frameManager;
    @Autowired
    private OrderManager orderManager;
    @Autowired
    private WindowManager windowManager;
    private JTextField txtPersonName;
    private JTextField txtPersonSurname;
    private JTextField txtPersonPesel;
    private JTextField txtPersonPhoneNo;
    private JTextField txtBoxNo;
    private JTextField txtOrderValue;
    private JTextField txtPaymentOnAccount;
    private JTextField txtPaymentLeft;
    private JDateChooser daStartDate;
    private JDateChooser daEndDate;
    private JTextField txtFrameMark;
    private JTextField txtFrameModel;
    private JTextField txtFrameColor;
    private JTextField txtExaminationELCorrection;
    private JTextField txtExaminationELVisus;
    private JTextField txtExaminationELVisusAx;
    private JTextField txtExaminationELAdd;
    private JTextField txtExaminationERCorrection;
    private JTextField txtExaminationERVisus;
    private JTextField txtExaminationERVisusAx;
    private JTextField txtExaminationERAdd;
    private JTextField txtExaminationPrice;
    private JTextField txtExaminationDiscount;
    private JTextField txtExaminationValue;
    private FrameTableModel frameTableModel;
    private JTable frameTable;
    private JComboBox<Status> cbOrderStatus;
    private JTextArea txtOrderNote;
    private JTextArea txtExaminationNote;
    private JCheckBox chckbxMyExamination;
    private JTextField txtOrderNumber;
    private JTextField txtRightLensMark;
    private JTextField txtRightLensModel;
    private JTextField txtRightLensIndex;
    private JTextField txtColourER;
    private JTextField txtRightLensPower;
    private JTextField txtRightLensPrice;
    private JTextField txtRightLensDiscount;
    private JTextField txtRightLensValue;
    private JTextField txtRightLensVisus;
    private JTextField txtRightLensVisusAx;
    private JTextField txtLeftLensPower;
    private JTextField txtLeftLensPrice;
    private JTextField txtLeftLensDiscount;
    private JTextField txtLeftLensValue;
    private JTextField txtLeftLensVisus;
    private JTextField txtLeftLensVisusAx;
    private JTextField txtLeftLensMark;
    private JTextField txtLeftLensModel;
    private JTextField txtLeftLensIndex;
    private JTextField txtColourEL;
    private JTextField txtFramePrice;
    private JTextField txtFrameDiscount;
    private JTextField txtFrameValue;
    private JTextField txtSelMark;
    private JTextField txtSelModel;
    private JTextField txtSelColour;
    private JTextField txtPdR;
    private JTextField txtHeightR;
    private JTextField txtPdL;
    private JTextField txtHeightL;

    /**
     * Create the panel.
     */
    public OrderAdd() {
        initGUI();
    }

    private void fillInPersonData(Person person) {
        txtPersonName.setText(person.getName());
        txtPersonSurname.setText(person.getSurname());
        txtPersonPesel.setText(person.getPesel());
        txtPersonPhoneNo.setText(person.getPhone());
        if (order == null) {
            txtOrderNumber.setText(orderManager.getMaxOrderNumber().toString());
        } else {
            txtOrderNumber.setText(order.getOrderNumber().toString());
        }
    }

    private void fillInOrderData(Order order) {

        cbOrderStatus.setSelectedItem(order.getStatus());
        txtBoxNo.setText(order.getBoxNumber());
        txtOrderValue.setText(order.getOrderValue());
        txtPaymentOnAccount.setText(order.getPaymentOnAccount());
        txtPaymentLeft.setText(order.getPaymentLeft());
        daStartDate.setDate(order.getStartDate());
        daEndDate.setDate(order.getEndDate());
        if (order.getFrame() != null) {
            frame = order.getFrame();
            txtSelMark.setText(frame.getMark());
            txtSelModel.setText(frame.getModel());
            txtSelColour.setText(frame.getColor());
        }
        txtFramePrice.setText(order.getFramePrice());
        txtFrameDiscount.setText(order.getFrameDiscount());
        txtFrameValue.setText(order.getFrameSellPrice());
        txtRightLensMark.setText(order.getLensMarkER());
        txtRightLensModel.setText(order.getLensModelER());
        txtRightLensIndex.setText(order.getLensIndexER());
        txtRightLensDiscount.setText(order.getLensDiscountER());
        txtRightLensPower.setText(order.getLensPowerER());
        txtRightLensPrice.setText(order.getLensPriceER());
        txtRightLensValue.setText(order.getLensSellPriceER());
        txtRightLensVisus.setText(order.getLensCylinderER());
        txtRightLensVisusAx.setText(order.getLensAxisER());
        txtLeftLensMark.setText(order.getLensMarkEL());
        txtLeftLensModel.setText(order.getLensModelEL());
        txtLeftLensIndex.setText(order.getLensIndexEL());
        txtLeftLensDiscount.setText(order.getLensDiscountEL());
        txtLeftLensPower.setText(order.getLensPowerEL());
        txtLeftLensPrice.setText(order.getLensPriceEL());
        txtLeftLensValue.setText(order.getLensSellPriceEL());
        txtLeftLensVisus.setText(order.getLensCylinderEL());
        txtLeftLensVisusAx.setText(order.getLensAxisEL());
        txtColourER.setText(order.getColourLensER());
        txtColourEL.setText(order.getColourLensEL());
        if (order.getPdRight() != null) {
        	txtPdR.setText(order.getPdRight().toString());
        }
        
        if (order.getPdLeft() != null) {
        	txtPdL.setText(order.getPdLeft().toString());
        }
        
        txtHeightR.setText(order.getHeightRight());
        txtHeightL.setText(order.getHeightLeft());
        
        if (order.getExamination() != null) {
            examination = order.getExamination();
            txtExaminationERCorrection.setText(examination.getErPower());
            txtExaminationERVisus.setText(examination.getErCylinder());
            txtExaminationERVisusAx.setText(examination.getErOs());
            txtExaminationERAdd.setText(examination.getErAdd());
            txtExaminationELCorrection.setText(examination.getElPower());
            txtExaminationELVisus.setText(examination.getElCylinder());
            txtExaminationELVisusAx.setText(examination.getElOs());
            txtExaminationELAdd.setText(examination.getElAdd());
            txtExaminationNote.setText(examination.getNote());
            chckbxMyExamination.setSelected(examination.getIsMyExamination());
            txtExaminationPrice.setText(order.getExaminationPrice());
            txtExaminationValue.setText(order.getExaminationSellPrice());
            txtExaminationDiscount.setText(order.getExaminationDiscount());
        }
        txtOrderNote.setText(order.getNote());
    }

    private void fillInFrameData(Frame selFrame) {
        txtSelMark.setText(selFrame.getMark());
        txtSelModel.setText(selFrame.getModel());
        txtSelColour.setText(selFrame.getColor());
        txtFramePrice.setText(null);
        txtFrameDiscount.setText(null);
        txtFrameValue.setText(null);
    }

    // Zapis zlecenia
    public long saveOrder() {
        if (order == null) {
            order = new Order();
            order.setOrderNumber(orderManager.getMaxOrderNumber());
            order.setPerson(person);
        }
        order.setStatus((Status) cbOrderStatus.getSelectedItem());
        order.setBoxNumber(txtBoxNo.getText());
        order.setStartDate(daStartDate.getDate());
        order.setEndDate(daEndDate.getDate());
        order.setPaymentOnAccount(txtPaymentOnAccount.getText());
        order.setOrderValue(txtOrderValue.getText());
        order.setPaymentLeft(txtPaymentLeft.getText());
        order.setFrame(frame);
        order.setFramePrice(txtFramePrice.getText());
        order.setFrameDiscount(txtFrameDiscount.getText());
        order.setFrameSellPrice(txtFrameValue.getText());
        order.setLensMarkER(txtRightLensMark.getText());
        order.setLensModelER(txtRightLensModel.getText());
        order.setLensIndexER(txtRightLensIndex.getText());
        order.setLensPowerER(txtRightLensPower.getText());
        order.setLensCylinderER(txtRightLensVisus.getText());
        order.setLensAxisER(txtRightLensVisusAx.getText());
        order.setLensDiscountER(txtRightLensDiscount.getText());
        order.setLensPriceER(txtRightLensPrice.getText());
        order.setLensSellPriceER(txtRightLensValue.getText());
        order.setColourLensER(txtColourER.getText());
        order.setLensMarkEL(txtLeftLensMark.getText());
        order.setLensModelEL(txtLeftLensModel.getText());
        order.setLensIndexEL(txtLeftLensIndex.getText());
        order.setLensPowerEL(txtLeftLensPower.getText());
        order.setLensCylinderEL(txtLeftLensVisus.getText());
        order.setLensAxisEL(txtLeftLensVisusAx.getText());
        order.setLensDiscountEL(txtLeftLensDiscount.getText());
        order.setLensPriceEL(txtLeftLensPrice.getText());
        order.setLensSellPriceEL(txtLeftLensValue.getText());
        order.setColourLensEL(txtColourEL.getText());
        order.setNote(txtOrderNote.getText());
        order.setExaminationPrice(txtExaminationPrice.getText());
        order.setExaminationDiscount(txtExaminationDiscount.getText());
        order.setExaminationSellPrice(txtExaminationValue.getText());
        if (!txtExaminationELAdd.getText().isEmpty()
                || !txtExaminationELVisus.getText().isEmpty()
                || !txtExaminationELVisusAx.getText().isEmpty()
                || !txtExaminationELCorrection.getText().isEmpty()
                || !txtExaminationERAdd.getText().isEmpty()
                || !txtExaminationERVisus.getText().isEmpty()
                || !txtExaminationERVisusAx.getText().isEmpty()
                || !txtExaminationERCorrection.getText().isEmpty()
                || !txtExaminationNote.getText().isEmpty()) {
            if (examination == null) {
                examination = new Examination();
            }
            examination.setElAdd(txtExaminationELAdd.getText());
            examination.setElCylinder(txtExaminationELVisus.getText());
            examination.setElOs(txtExaminationELVisusAx.getText());
            examination.setElPower(txtExaminationELCorrection.getText());
            examination.setErAdd(txtExaminationERAdd.getText());
            examination.setErCylinder(txtExaminationERVisus.getText());
            examination.setErOs(txtExaminationERVisusAx.getText());
            examination.setErPower(txtExaminationERCorrection.getText());
            examination.setIsMyExamination(chckbxMyExamination.isSelected());
            examination.setNote(txtExaminationNote.getText());
            examination.setOrder(order);
            order.setExamination(examination);
        }
        order.setPdRight(ConvertTypeUtil.getIntegerFromString(txtPdR.getText()));
        order.setPdLeft(ConvertTypeUtil.getIntegerFromString(txtPdL.getText()));
        order.setHeightRight(txtHeightR.getText());
        order.setHeightLeft(txtHeightL.getText());
        long orderId = orderManager.saveOrder(order);
        order.setId(orderId);
        return orderId;
    }

    // Aktualizuje pole tekstowe wartość każdego produktu
    public void refreshPositionValue(JTextField txtValueWoDiscount,
                                     JTextField txtDiscount, JTextField txtValueWtDiscount) {
        BigDecimal valueWoDiscount = getBigDecimalValue(txtValueWoDiscount);
        BigDecimal discountValue = getBigDecimalValue(txtDiscount);
        txtValueWtDiscount.setText((valueWoDiscount.subtract(discountValue))
                .toString());
    }

    private BigDecimal getBigDecimalValue(JTextField txtField) {
        BigDecimal res = new BigDecimal("0");
        if (!txtField.getText().isEmpty()) {
            try {
                res = new BigDecimal(txtField.getText());
            } catch (Exception e) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Proszę wprowadzić wartość liczbową w formacie: 123.45",
                                "Błąd wartości liczbowej",
                                JOptionPane.ERROR_MESSAGE);
            }
        }
        return res;
    }

    private void refreshOrderValue() {
        BigDecimal frameValue = getBigDecimalValue(txtFrameValue);
        BigDecimal leftLensValue = getBigDecimalValue(txtRightLensValue);
        BigDecimal rightLensValue = getBigDecimalValue(txtLeftLensValue);
        BigDecimal examinationValue = getBigDecimalValue(txtExaminationValue);
        txtOrderValue.setText((frameValue.add(leftLensValue)
                .add(rightLensValue).add(examinationValue)).toString());
    }

    @Override
    public void initGUI() {

        person = personManager.getPersonById(personId);

        if (orderId != null) {
            order = orderManager.getOrderById(orderId);
        }

        JPanel panPersonData = new JPanel();
        panPersonData.setBorder(BorderFactory.createTitledBorder("Dane osoby"));

        JPanel panOrderData = new JPanel();
        panOrderData.setBorder(BorderFactory
                .createTitledBorder("Dane zamówienia"));

        JPanel panPaymentData = new JPanel();
        panPaymentData.setBorder(BorderFactory
                .createTitledBorder("Dane płatności"));

        JPanel panOrder = new JPanel();
        panOrder.setBorder(BorderFactory.createTitledBorder("Zamówienie"));

        JButton btnSave = new JButton("Zapisz");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long id = saveOrder();
                if (id > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Zlecenie zostało zapisane pomyślnie.", "Zapis OK",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Zapis nie powiódł się.", "Błąd zapisu",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnPrint = new JButton("Drukuj");
        btnPrint.setEnabled(false);

        JButton btnCloseWindow = new JButton("Zamknij");
        btnCloseWindow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Map<String, Object> params = new HashMap<String, Object>();
                // clearForm();
                params.put("personId", person.getId());
                windowManager.showPanel(Panel.PERSON_ADD_PANEL, params);
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
                                                                panOrder,
                                                                Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                884,
                                                                Short.MAX_VALUE)
                                                        .addGroup(
                                                                groupLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                btnSave)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                btnPrint)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                btnCloseWindow))
                                                        .addComponent(
                                                                panPaymentData,
                                                                Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                884,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                panOrderData,
                                                                Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                884,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                panPersonData,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                884,
                                                                Short.MAX_VALUE))
                                        .addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
                Alignment.LEADING)
                .addGroup(
                        groupLayout
                                .createSequentialGroup()
                                .addGap(6)
                                .addComponent(panPersonData,
                                        GroupLayout.PREFERRED_SIZE, 51,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panOrderData,
                                        GroupLayout.PREFERRED_SIZE, 47,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panPaymentData,
                                        GroupLayout.PREFERRED_SIZE, 51,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panOrder,
                                        GroupLayout.PREFERRED_SIZE, 575,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGroup(
                                        groupLayout
                                                .createParallelGroup(
                                                        Alignment.BASELINE)
                                                .addComponent(btnSave)
                                                .addComponent(btnPrint)
                                                .addComponent(btnCloseWindow))
                                .addContainerGap()));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        GroupLayout gl_panOrder = new GroupLayout(panOrder);
        gl_panOrder.setHorizontalGroup(gl_panOrder.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panOrder
                        .createSequentialGroup()
                        .addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE,
                                696, Short.MAX_VALUE).addContainerGap()));
        gl_panOrder.setVerticalGroup(gl_panOrder.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panOrder
                        .createSequentialGroup()
                        .addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE,
                                549, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));

        JPanel panFrame = new JPanel();
        tabbedPane.addTab("Wyszukiwarka opraw", null, panFrame, null);

        JPanel panFrames = new JPanel();
        panFrames.setBounds(10, 11, 836, 303);
        panFrames.setBorder(BorderFactory.createTitledBorder("Oprawa"));

        JPanel panel = new JPanel();
        panel.setBounds(10, 325, 836, 185);
        panel.setBorder(BorderFactory.createTitledBorder("Oprawa"));
        panel.setLayout(null);

        JLabel label_7 = new JLabel("Marka");
        label_7.setBounds(10, 24, 41, 14);
        panel.add(label_7);

        txtSelMark = new JTextField();
        txtSelMark.setBounds(81, 18, 246, 20);
        txtSelMark.setEditable(false);
        txtSelMark.setColumns(30);
        panel.add(txtSelMark);

        JLabel label_8 = new JLabel("Model");
        label_8.setBounds(10, 49, 41, 14);
        panel.add(label_8);

        txtSelModel = new JTextField();
        txtSelModel.setBounds(81, 43, 246, 20);
        txtSelModel.setEditable(false);
        txtSelModel.setColumns(30);
        panel.add(txtSelModel);

        JLabel label_9 = new JLabel("Kolor");
        label_9.setBounds(10, 74, 41, 14);
        panel.add(label_9);

        txtSelColour = new JTextField();
        txtSelColour.setBounds(81, 68, 246, 20);
        txtSelColour.setEditable(false);
        txtSelColour.setColumns(30);
        panel.add(txtSelColour);

        JLabel label_4 = new JLabel("Cena");
        label_4.setBounds(10, 99, 41, 14);
        panel.add(label_4);

        txtFramePrice = new JTextField();
        txtFramePrice.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtFramePrice, txtFrameDiscount,
                        txtFrameValue);
            }
        });
        txtFramePrice.setBounds(81, 93, 86, 20);
        txtFramePrice.setColumns(10);
        panel.add(txtFramePrice);

        JLabel label_5 = new JLabel("Rabat");
        label_5.setBounds(10, 124, 41, 14);
        panel.add(label_5);

        txtFrameDiscount = new JTextField();
        txtFrameDiscount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtFramePrice, txtFrameDiscount,
                        txtFrameValue);
            }
        });
        txtFrameDiscount.setBounds(81, 118, 86, 20);
        txtFrameDiscount.setColumns(10);
        panel.add(txtFrameDiscount);

        JLabel label_6 = new JLabel("Wartość");
        label_6.setBounds(10, 149, 60, 14);
        panel.add(label_6);

        txtFrameValue = new JTextField();
        txtFrameValue.getDocument().addDocumentListener(new DocumentListener() {

            public void removeUpdate(DocumentEvent e) {
                refreshOrderValue();
            }

            public void insertUpdate(DocumentEvent e) {
                refreshOrderValue();
            }

            public void changedUpdate(DocumentEvent e) {
                refreshOrderValue();
            }
        });

        txtFrameValue.setBounds(81, 143, 86, 20);
        txtFrameValue.setEditable(false);
        txtFrameValue.setColumns(10);
        panel.add(txtFrameValue);

        JLabel lblMark = new JLabel("Marka");
        lblMark.setBounds(8, 17, 41, 14);

        txtFrameMark = new JTextField();
        txtFrameMark.setBounds(47, 16, 166, 20);
        txtFrameMark.setEditable(true);
        txtFrameMark.setColumns(20);

        JLabel lblModel = new JLabel("Model");
        lblModel.setBounds(8, 43, 41, 14);

        txtFrameModel = new JTextField();
        txtFrameModel.setBounds(47, 42, 166, 20);
        txtFrameModel.setEditable(true);
        txtFrameModel.setColumns(10);

        JLabel lblColor = new JLabel("Kolor");
        lblColor.setBounds(8, 69, 35, 14);

        txtFrameColor = new JTextField();
        txtFrameColor.setBounds(47, 68, 166, 20);
        txtFrameColor.setEditable(true);
        txtFrameColor.setColumns(10);

        List<Frame> frames = new ArrayList<Frame>();
        frameTableModel = new FrameTableModel(frames);
        frameTable = new JTable();
        frameTable.setModel(frameTableModel);

        JScrollPane spanFrames = new JScrollPane(frameTable);
        spanFrames.setBounds(8, 124, 810, 134);
        panFrame.setLayout(null);
        panFrame.add(panel);

        panFrame.add(panFrames);
        panFrames.setLayout(null);
        panFrames.add(spanFrames);
        panFrames.add(lblMark);
        panFrames.add(txtFrameMark);
        panFrames.add(lblModel);
        panFrames.add(txtFrameModel);
        panFrames.add(lblColor);
        panFrames.add(txtFrameColor);

        JButton btnWybierz = new JButton("Wybierz");
        btnWybierz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = frameTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Frame selectedFrame = frameTableModel
                            .getElementAt(selectedRow);
                    frame = selectedFrame;
                    fillInFrameData(selectedFrame);
                }
            }
        });
        btnWybierz.setBounds(8, 269, 89, 23);
        panFrames.add(btnWybierz);

        JButton btnDodaj = new JButton("Dodaj oprawę");
        btnDodaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveOrder();
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("personId", personId);
                params.put("orderId", order.getId());
                windowManager.showPanel(Panel.FRAME_ADD, params);
            }
        });
        btnDodaj.setBounds(107, 269, 120, 23);
        panFrames.add(btnDodaj);

        JButton btnSzukaj = new JButton("Szukaj");
        btnSzukaj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameTableModel.setData(frameManager.getFrameByCriteria(
                        txtFrameMark.getText(), txtFrameModel.getText(),
                        txtFrameColor.getText()));
                frameTableModel.fireTableDataChanged();
            }
        });
        btnSzukaj.setBounds(8, 94, 89, 23);
        panFrames.add(btnSzukaj);

        JPanel panLenses = new JPanel();
        tabbedPane.addTab("Soczewki", null, panLenses, null);

        JPanel panRightLens = new JPanel();
        panRightLens.setBounds(10, 11, 836, 184);
        panRightLens.setBorder(BorderFactory
                .createTitledBorder("Prawa soczewka"));

        JLabel label_3 = new JLabel("Barwienie");
        label_3.setBounds(8, 95, 60, 14);

        JLabel lblRightLensModel = new JLabel("Model");
        lblRightLensModel.setBounds(8, 45, 45, 14);

        JLabel lblRightLensMark = new JLabel("Marka");
        lblRightLensMark.setBounds(8, 19, 45, 14);

        txtRightLensMark = new JTextField();
        txtRightLensMark.setBounds(72, 16, 406, 20);
        txtRightLensMark.setColumns(50);

        txtRightLensModel = new JTextField();
        txtRightLensModel.setBounds(72, 42, 406, 20);
        txtRightLensModel.setColumns(50);

        JLabel lbRightLensIndex = new JLabel("Indeks");
        lbRightLensIndex.setBounds(8, 70, 50, 14);

        txtRightLensIndex = new JTextField();
        txtRightLensIndex.setBounds(72, 67, 86, 20);
        txtRightLensIndex.setColumns(10);

        txtColourER = new JTextField();
        txtColourER.setBounds(72, 92, 406, 20);
        txtColourER.setColumns(10);

        txtRightLensPower = new JTextField();
        txtRightLensPower.setBounds(72, 117, 86, 20);
        txtRightLensPower.setColumns(10);

        JLabel lblRightLensVisus = new JLabel("Cylinder");
        lblRightLensVisus.setBounds(168, 123, 50, 14);

        txtRightLensPrice = new JTextField();
        txtRightLensPrice.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtRightLensPrice, txtRightLensDiscount,
                        txtRightLensValue);
            }
        });
        txtRightLensPrice.setBounds(72, 142, 86, 20);
        txtRightLensPrice.setColumns(10);

        JLabel lblRightLensDiscount = new JLabel("Rabat");
        lblRightLensDiscount.setBounds(168, 148, 45, 14);

        txtRightLensDiscount = new JTextField();
        txtRightLensDiscount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtRightLensPrice, txtRightLensDiscount,
                        txtRightLensValue);
            }
        });
        txtRightLensDiscount.setBounds(217, 142, 86, 20);
        txtRightLensDiscount.setColumns(10);

        JLabel lblRightLensRealPrice = new JLabel("Wartość");
        lblRightLensRealPrice.setBounds(315, 145, 50, 14);

        txtRightLensValue = new JTextField();
        txtRightLensValue.getDocument().addDocumentListener(
                new DocumentListener() {

                    public void removeUpdate(DocumentEvent e) {
                        refreshOrderValue();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        refreshOrderValue();
                    }

                    public void changedUpdate(DocumentEvent e) {
                        refreshOrderValue();
                    }
                });

        txtRightLensValue.setBounds(365, 142, 86, 20);
        txtRightLensValue.setEditable(false);
        txtRightLensValue.setColumns(10);

        txtRightLensVisus = new JTextField();
        txtRightLensVisus.setBounds(217, 117, 86, 20);
        txtRightLensVisus.setColumns(10);

        JLabel lblRightLensVisusAx = new JLabel("Oś");
        lblRightLensVisusAx.setBounds(313, 120, 25, 14);

        txtRightLensVisusAx = new JTextField();
        txtRightLensVisusAx.setBounds(365, 117, 86, 20);
        txtRightLensVisusAx.setColumns(10);

        JLabel lblRightLensPower = new JLabel("Moc");
        lblRightLensPower.setBounds(8, 120, 40, 14);

        JLabel lblRightLensPrice = new JLabel("Cena");
        lblRightLensPrice.setBounds(8, 145, 40, 14);

        JPanel panLeftLens = new JPanel();
        panLeftLens.setBounds(10, 206, 836, 184);
        panLeftLens
                .setBorder(BorderFactory.createTitledBorder("Lewa soczewka"));

        JLabel label_19 = new JLabel("Barwienie");
        label_19.setBounds(8, 93, 60, 14);

        JLabel lblLeftLensModel = new JLabel("Model");
        lblLeftLensModel.setBounds(8, 45, 45, 14);

        JLabel lblLeftLensMark = new JLabel("Marka");
        lblLeftLensMark.setBounds(8, 19, 45, 14);

        JLabel lblLeftLensPower = new JLabel("Moc");
        lblLeftLensPower.setBounds(8, 118, 45, 14);

        JLabel lblLeftLensPrice = new JLabel("Cena");
        lblLeftLensPrice.setBounds(8, 143, 45, 14);

        txtLeftLensPower = new JTextField();
        txtLeftLensPower.setBounds(72, 115, 86, 20);
        txtLeftLensPower.setColumns(10);

        txtLeftLensPrice = new JTextField();
        txtLeftLensPrice.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtLeftLensPrice, txtLeftLensDiscount,
                        txtLeftLensValue);
            }
        });
        txtLeftLensPrice.setBounds(72, 140, 86, 20);
        txtLeftLensPrice.setColumns(10);

        JLabel lblLeftLensVisus = new JLabel("Cylinder");
        lblLeftLensVisus.setBounds(168, 118, 50, 14);

        JLabel lblLeftLensDiscount = new JLabel("Rabat");
        lblLeftLensDiscount.setBounds(168, 143, 50, 14);

        txtLeftLensDiscount = new JTextField();
        txtLeftLensDiscount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtLeftLensPrice, txtLeftLensDiscount,
                        txtLeftLensValue);
            }
        });
        txtLeftLensDiscount.setBounds(217, 140, 86, 20);
        txtLeftLensDiscount.setColumns(10);

        JLabel lblLeftLensRealPrice = new JLabel("Wartość");
        lblLeftLensRealPrice.setBounds(313, 143, 50, 14);

        txtLeftLensValue = new JTextField();
        txtLeftLensValue.getDocument().addDocumentListener(
                new DocumentListener() {

                    public void removeUpdate(DocumentEvent e) {
                        refreshOrderValue();

                    }

                    public void insertUpdate(DocumentEvent e) {
                        refreshOrderValue();

                    }

                    public void changedUpdate(DocumentEvent e) {
                        refreshOrderValue();

                    }
                });

        txtLeftLensValue.setBounds(365, 140, 86, 20);
        txtLeftLensValue.setEditable(false);
        txtLeftLensValue.setColumns(10);

        txtLeftLensVisus = new JTextField();
        txtLeftLensVisus.setBounds(217, 115, 86, 20);
        txtLeftLensVisus.setColumns(10);

        JLabel lblLeftLensVisusAx = new JLabel("Oś");
        lblLeftLensVisusAx.setBounds(313, 118, 25, 14);

        txtLeftLensVisusAx = new JTextField();
        txtLeftLensVisusAx.setBounds(365, 115, 86, 20);
        txtLeftLensVisusAx.setColumns(10);

        txtLeftLensMark = new JTextField();
        txtLeftLensMark.setBounds(72, 16, 406, 20);
        txtLeftLensMark.setColumns(50);

        txtLeftLensModel = new JTextField();
        txtLeftLensModel.setBounds(72, 42, 406, 20);
        txtLeftLensModel.setColumns(50);

        JLabel lblLeftLensIndex = new JLabel("Indeks");
        lblLeftLensIndex.setBounds(8, 70, 45, 14);

        txtLeftLensIndex = new JTextField();
        txtLeftLensIndex.setBounds(72, 67, 86, 20);
        txtLeftLensIndex.setColumns(10);

        txtColourEL = new JTextField();
        txtColourEL.setBounds(72, 90, 406, 20);
        txtColourEL.setColumns(10);
        panLenses.setLayout(null);
        panLenses.add(panRightLens);
        panRightLens.setLayout(null);
        panRightLens.add(label_3);
        panRightLens.add(lblRightLensModel);
        panRightLens.add(lblRightLensMark);
        panRightLens.add(txtRightLensMark);
        panRightLens.add(txtRightLensModel);
        panRightLens.add(lbRightLensIndex);
        panRightLens.add(txtRightLensIndex);
        panRightLens.add(txtColourER);
        panRightLens.add(txtRightLensPower);
        panRightLens.add(lblRightLensVisus);
        panRightLens.add(txtRightLensPrice);
        panRightLens.add(lblRightLensDiscount);
        panRightLens.add(txtRightLensDiscount);
        panRightLens.add(lblRightLensRealPrice);
        panRightLens.add(txtRightLensValue);
        panRightLens.add(txtRightLensVisus);
        panRightLens.add(lblRightLensVisusAx);
        panRightLens.add(txtRightLensVisusAx);
        panRightLens.add(lblRightLensPower);
        panRightLens.add(lblRightLensPrice);

        JButton btnMove = new JButton("Przenieś");
        btnMove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtLeftLensMark.setText(txtRightLensMark.getText());
                txtLeftLensModel.setText(txtRightLensModel.getText());
                txtLeftLensIndex.setText(txtRightLensIndex.getText());
                txtLeftLensDiscount.setText(txtRightLensDiscount.getText());
                // txtLeftLensPower.setText(txtRightLensPower.getText());
                txtLeftLensPrice.setText(txtRightLensPrice.getText());
                txtLeftLensValue.setText(txtRightLensValue.getText());
                // txtLeftLensVisus.setText(txtRightLensVisus.getText());
                // txtLeftLensVisusAx.setText(txtRightLensVisusAx.getText());
                txtColourEL.setText(txtColourER.getText());
            }
        });
        btnMove.setBounds(496, 144, 89, 23);
        panRightLens.add(btnMove);
        
        JLabel lblPd = new JLabel("PD");
        lblPd.setBounds(461, 120, 25, 14);
        panRightLens.add(lblPd);
        
        txtPdR = new JTextField();
        txtPdR.setBounds(496, 117, 86, 20);
        panRightLens.add(txtPdR);
        txtPdR.setColumns(10);
        
        JLabel lblH = new JLabel("H");
        lblH.setBounds(592, 120, 25, 14);
        panRightLens.add(lblH);
        
        txtHeightR = new JTextField();
        txtHeightR.setBounds(627, 117, 86, 20);
        panRightLens.add(txtHeightR);
        txtHeightR.setColumns(10);
        panLenses.add(panLeftLens);
        panLeftLens.setLayout(null);
        panLeftLens.add(label_19);
        panLeftLens.add(lblLeftLensModel);
        panLeftLens.add(lblLeftLensMark);
        panLeftLens.add(lblLeftLensPower);
        panLeftLens.add(lblLeftLensPrice);
        panLeftLens.add(txtLeftLensPower);
        panLeftLens.add(txtLeftLensPrice);
        panLeftLens.add(lblLeftLensVisus);
        panLeftLens.add(lblLeftLensDiscount);
        panLeftLens.add(txtLeftLensDiscount);
        panLeftLens.add(lblLeftLensRealPrice);
        panLeftLens.add(txtLeftLensValue);
        panLeftLens.add(txtLeftLensVisus);
        panLeftLens.add(lblLeftLensVisusAx);
        panLeftLens.add(txtLeftLensVisusAx);
        panLeftLens.add(txtLeftLensMark);
        panLeftLens.add(txtLeftLensModel);
        panLeftLens.add(lblLeftLensIndex);
        panLeftLens.add(txtLeftLensIndex);
        panLeftLens.add(txtColourEL);
        
        JLabel lblPd_1 = new JLabel("PD");
        lblPd_1.setBounds(461, 118, 25, 14);
        panLeftLens.add(lblPd_1);
        
        txtPdL = new JTextField();
        txtPdL.setBounds(496, 115, 86, 20);
        panLeftLens.add(txtPdL);
        txtPdL.setColumns(10);
        
        JLabel lblH_1 = new JLabel("H");
        lblH_1.setBounds(592, 118, 25, 14);
        panLeftLens.add(lblH_1);
        
        txtHeightL = new JTextField();
        txtHeightL.setBounds(627, 115, 86, 20);
        panLeftLens.add(txtHeightL);
        txtHeightL.setColumns(10);

        JPanel panExamination = new JPanel();
        panExamination.setSize(new Dimension(50, 10));
        tabbedPane.addTab("Badanie", null, panExamination, null);

        JPanel panCorrection = new JPanel();
        panCorrection.setBorder(BorderFactory.createTitledBorder("Korekcja"));

        JPanel panNote = new JPanel();
        panNote.setBorder(BorderFactory.createTitledBorder("Notatka"));

        JPanel panOtherData = new JPanel();
        panOtherData.setBorder(BorderFactory
                .createTitledBorder("Pozostałe dane"));
        GroupLayout gl_panExamination = new GroupLayout(panExamination);
        gl_panExamination
                .setHorizontalGroup(gl_panExamination
                        .createParallelGroup(Alignment.TRAILING)
                        .addGroup(
                                gl_panExamination
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_panExamination
                                                        .createParallelGroup(
                                                                Alignment.TRAILING)
                                                        .addComponent(
                                                                panOtherData,
                                                                Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                638,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                panNote,
                                                                Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                638,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                panCorrection,
                                                                Alignment.LEADING,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                638,
                                                                Short.MAX_VALUE))
                                        .addContainerGap()));
        gl_panExamination.setVerticalGroup(gl_panExamination
                .createParallelGroup(Alignment.LEADING).addGroup(
                        gl_panExamination
                                .createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panCorrection,
                                        GroupLayout.PREFERRED_SIZE, 97,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panNote,
                                        GroupLayout.PREFERRED_SIZE, 116,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panOtherData,
                                        GroupLayout.PREFERRED_SIZE, 84,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(89, Short.MAX_VALUE)));

        chckbxMyExamination = new JCheckBox("Nasze badanie");

        JLabel lblCena = new JLabel("Cena");

        txtExaminationPrice = new JTextField();
        txtExaminationPrice.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtExaminationPrice,
                        txtExaminationDiscount, txtExaminationValue);
            }
        });
        txtExaminationPrice.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Rabat");

        txtExaminationDiscount = new JTextField();
        txtExaminationDiscount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                refreshPositionValue(txtExaminationPrice,
                        txtExaminationDiscount, txtExaminationValue);
            }
        });
        txtExaminationDiscount.setColumns(10);

        JLabel lblWarto = new JLabel("Wartość");

        txtExaminationValue = new JTextField();
        txtExaminationValue.getDocument().addDocumentListener(
                new DocumentListener() {

                    public void removeUpdate(DocumentEvent e) {
                        refreshOrderValue();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        refreshOrderValue();
                    }

                    public void changedUpdate(DocumentEvent e) {
                        refreshOrderValue();
                    }
                });

        txtExaminationValue.setEditable(false);
        txtExaminationValue.setColumns(10);
        GroupLayout gl_panOtherData = new GroupLayout(panOtherData);
        gl_panOtherData
                .setHorizontalGroup(gl_panOtherData
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panOtherData
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_panOtherData
                                                        .createParallelGroup(
                                                                Alignment.LEADING)
                                                        .addComponent(
                                                                chckbxMyExamination)
                                                        .addGroup(
                                                                gl_panOtherData
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                lblCena)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                txtExaminationPrice,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                lblNewLabel_1)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                txtExaminationDiscount,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                lblWarto)
                                                                        .addPreferredGap(
                                                                                ComponentPlacement.RELATED)
                                                                        .addComponent(
                                                                                txtExaminationValue,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(256, Short.MAX_VALUE)));
        gl_panOtherData
                .setVerticalGroup(gl_panOtherData
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panOtherData
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(chckbxMyExamination)
                                        .addPreferredGap(
                                                ComponentPlacement.UNRELATED)
                                        .addGroup(
                                                gl_panOtherData
                                                        .createParallelGroup(
                                                                Alignment.BASELINE)
                                                        .addComponent(lblCena)
                                                        .addComponent(
                                                                txtExaminationPrice,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                lblNewLabel_1)
                                                        .addComponent(
                                                                txtExaminationDiscount,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblWarto)
                                                        .addComponent(
                                                                txtExaminationValue,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(68, Short.MAX_VALUE)));
        panOtherData.setLayout(gl_panOtherData);

        txtExaminationNote = new JTextArea();
        GroupLayout gl_panNote = new GroupLayout(panNote);
        gl_panNote.setHorizontalGroup(gl_panNote.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panNote
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtExaminationNote,
                                GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                        .addContainerGap()));
        gl_panNote.setVerticalGroup(gl_panNote.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panNote
                        .createSequentialGroup()
                        .addComponent(txtExaminationNote,
                                GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addContainerGap()));
        panNote.setLayout(gl_panNote);

        JLabel lblOl = new JLabel("OL");

        JLabel lblOp = new JLabel("OP");

        txtExaminationELCorrection = new JTextField();
        txtExaminationELCorrection.setColumns(10);

        txtExaminationERCorrection = new JTextField();
        txtExaminationERCorrection.setColumns(10);

        JLabel lblCylinder = new JLabel("Cylinder");

        JLabel lblCylinder_1 = new JLabel("Cylinder");

        txtExaminationELVisus = new JTextField();
        txtExaminationELVisus.setColumns(10);

        txtExaminationERVisus = new JTextField();
        txtExaminationERVisus.setColumns(10);

        JLabel lblO = new JLabel("Oś");

        JLabel lblO_1 = new JLabel("Oś");

        txtExaminationELVisusAx = new JTextField();
        txtExaminationELVisusAx.setColumns(10);

        txtExaminationERVisusAx = new JTextField();
        txtExaminationERVisusAx.setColumns(10);

        JLabel lblAdd = new JLabel("ADD");

        JLabel lblNewLabel = new JLabel("ADD");

        txtExaminationELAdd = new JTextField();
        txtExaminationELAdd.setColumns(10);

        txtExaminationERAdd = new JTextField();
        txtExaminationERAdd.setColumns(10);
        GroupLayout gl_panCorrection = new GroupLayout(panCorrection);
        gl_panCorrection
                .setHorizontalGroup(gl_panCorrection
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panCorrection
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_panCorrection
                                                        .createParallelGroup(
                                                                Alignment.LEADING)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                lblOp)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationERCorrection,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                lblCylinder_1)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationERVisus,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                lblO_1)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationERVisusAx,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18)
                                                                        .addComponent(
                                                                                lblNewLabel)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationERAdd,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                lblOl)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationELCorrection,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                lblCylinder)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationELVisus,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                lblO)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationELVisusAx,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18)
                                                                        .addComponent(
                                                                                lblAdd)
                                                                        .addGap(4)
                                                                        .addComponent(
                                                                                txtExaminationELAdd,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(138, Short.MAX_VALUE)));
        gl_panCorrection
                .setVerticalGroup(gl_panCorrection
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panCorrection
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                gl_panCorrection
                                                        .createParallelGroup(
                                                                Alignment.LEADING)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblOp))
                                                        .addComponent(
                                                                txtExaminationERCorrection,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblCylinder_1))
                                                        .addComponent(
                                                                txtExaminationERVisus,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblO_1))
                                                        .addComponent(
                                                                txtExaminationERVisusAx,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblNewLabel))
                                                        .addComponent(
                                                                txtExaminationERAdd,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                ComponentPlacement.UNRELATED)
                                        .addGroup(
                                                gl_panCorrection
                                                        .createParallelGroup(
                                                                Alignment.LEADING)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblOl))
                                                        .addComponent(
                                                                txtExaminationELCorrection,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblCylinder))
                                                        .addComponent(
                                                                txtExaminationELVisus,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblO))
                                                        .addComponent(
                                                                txtExaminationELVisusAx,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(
                                                                gl_panCorrection
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblAdd))
                                                        .addComponent(
                                                                txtExaminationELAdd,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)));
        panCorrection.setLayout(gl_panCorrection);
        panExamination.setLayout(gl_panExamination);

        JPanel panOrderNote = new JPanel();
        tabbedPane.addTab("Notatka", null, panOrderNote, null);

        txtOrderNote = new JTextArea();
        GroupLayout gl_panOrderNote = new GroupLayout(panOrderNote);
        gl_panOrderNote.setHorizontalGroup(gl_panOrderNote.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panOrderNote
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtOrderNote, GroupLayout.DEFAULT_SIZE,
                                678, Short.MAX_VALUE).addContainerGap()));
        gl_panOrderNote.setVerticalGroup(gl_panOrderNote.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panOrderNote
                        .createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtOrderNote, GroupLayout.PREFERRED_SIZE,
                                319, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(120, Short.MAX_VALUE)));
        panOrderNote.setLayout(gl_panOrderNote);
        panOrder.setLayout(gl_panOrder);

        JLabel lblZaliczka = new JLabel("Wartość zamówienia");

        txtOrderValue = new JTextField();
        txtOrderValue.setEditable(false);
        txtOrderValue.setColumns(10);

        JLabel lblZaliczka_1 = new JLabel("Wpłata");

        txtPaymentOnAccount = new JTextField();
        txtPaymentOnAccount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                txtPaymentLeft.setText((getBigDecimalValue(txtOrderValue)
                        .subtract(getBigDecimalValue(txtPaymentOnAccount))
                        .toString()));
            }
        });
        txtPaymentOnAccount.setColumns(10);

        JLabel lblPozostaoDoZaplaty = new JLabel("Pozostało do zaplaty");

        txtPaymentLeft = new JTextField();
        txtPaymentLeft.setEditable(false);
        txtPaymentLeft.setColumns(10);
        GroupLayout gl_panPaymentData = new GroupLayout(panPaymentData);
        gl_panPaymentData.setHorizontalGroup(gl_panPaymentData
                .createParallelGroup(Alignment.LEADING).addGroup(
                        gl_panPaymentData
                                .createSequentialGroup()
                                .addComponent(lblZaliczka)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtOrderValue,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblZaliczka_1)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtPaymentOnAccount,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblPozostaoDoZaplaty)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txtPaymentLeft,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(351, Short.MAX_VALUE)));
        gl_panPaymentData
                .setVerticalGroup(gl_panPaymentData
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panPaymentData
                                        .createSequentialGroup()
                                        .addGroup(
                                                gl_panPaymentData
                                                        .createParallelGroup(
                                                                Alignment.BASELINE)
                                                        .addComponent(
                                                                lblZaliczka)
                                                        .addComponent(
                                                                txtOrderValue,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                lblZaliczka_1)
                                                        .addComponent(
                                                                txtPaymentOnAccount,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                lblPozostaoDoZaplaty)
                                                        .addComponent(
                                                                txtPaymentLeft,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(19, Short.MAX_VALUE)));
        panPaymentData.setLayout(gl_panPaymentData);

        JLabel lblNumerTacy = new JLabel("Numer tacy");

        txtBoxNo = new JTextField();
        txtBoxNo.setColumns(10);

        JLabel lblStatusZamowienia = new JLabel("Status zamowienia");

        cbOrderStatus = new JComboBox<Status>();
        cbOrderStatus
                .setModel(new DefaultComboBoxModel<Status>(Status.values()));

        JLabel lblDataZlecenia = new JLabel("Data zlecenia");

        daStartDate = new JDateChooser(new Date());

        JLabel lblDataWydania = new JLabel("Data wydania");

        daEndDate = new JDateChooser();

        JLabel lblNumerZamwienia = new JLabel("Numer zamówienia");

        txtOrderNumber = new JTextField();
        txtOrderNumber.setEditable(false);
        txtOrderNumber.setColumns(10);
        GroupLayout gl_panOrderData = new GroupLayout(panOrderData);
        gl_panOrderData.setHorizontalGroup(gl_panOrderData.createParallelGroup(
                Alignment.LEADING).addGroup(
                gl_panOrderData
                        .createSequentialGroup()
                        .addComponent(lblStatusZamowienia)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(cbOrderStatus,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lblNumerTacy)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(txtBoxNo, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lblDataZlecenia)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(daStartDate, GroupLayout.PREFERRED_SIZE,
                                99, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lblDataWydania)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(daEndDate, GroupLayout.PREFERRED_SIZE,
                                103, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lblNumerZamwienia)
                        .addGap(4)
                        .addComponent(txtOrderNumber,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        gl_panOrderData
                .setVerticalGroup(gl_panOrderData
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panOrderData
                                        .createSequentialGroup()
                                        .addGroup(
                                                gl_panOrderData
                                                        .createParallelGroup(
                                                                Alignment.LEADING)
                                                        .addGroup(
                                                                gl_panOrderData
                                                                        .createParallelGroup(
                                                                                Alignment.BASELINE)
                                                                        .addComponent(
                                                                                lblStatusZamowienia)
                                                                        .addComponent(
                                                                                cbOrderStatus,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(
                                                                                lblNumerTacy)
                                                                        .addComponent(
                                                                                txtBoxNo,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(
                                                                                lblDataZlecenia)
                                                                        .addComponent(
                                                                                daStartDate,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(
                                                                                lblDataWydania)
                                                                        .addComponent(
                                                                                daEndDate,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                gl_panOrderData
                                                                        .createSequentialGroup()
                                                                        .addGap(3)
                                                                        .addComponent(
                                                                                lblNumerZamwienia))
                                                        .addComponent(
                                                                txtOrderNumber,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)));
        panOrderData.setLayout(gl_panOrderData);

        JLabel label = new JLabel("Imię");

        txtPersonName = new JTextField();
        txtPersonName.setEditable(false);
        txtPersonName.setColumns(10);

        JLabel label_1 = new JLabel("Nazwisko");

        txtPersonSurname = new JTextField();
        txtPersonSurname.setEditable(false);
        txtPersonSurname.setColumns(10);

        JLabel label_2 = new JLabel("Pesel");

        txtPersonPesel = new JTextField();
        txtPersonPesel.setEditable(false);
        txtPersonPesel.setColumns(10);

        JLabel lblTelefon = new JLabel("Telefon");

        txtPersonPhoneNo = new JTextField();
        txtPersonPhoneNo.setEditable(false);
        txtPersonPhoneNo.setColumns(10);
        GroupLayout gl_panPersonData = new GroupLayout(panPersonData);
        gl_panPersonData
                .setHorizontalGroup(gl_panPersonData.createParallelGroup(
                        Alignment.LEADING)
                        .addGroup(
                                gl_panPersonData
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(txtPersonName,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(label_1)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(txtPersonSurname,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(label_2)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(txtPersonPesel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(lblTelefon)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(txtPersonPhoneNo,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(361)));
        gl_panPersonData
                .setVerticalGroup(gl_panPersonData
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(
                                gl_panPersonData
                                        .createSequentialGroup()
                                        .addGap(5)
                                        .addGroup(
                                                gl_panPersonData
                                                        .createParallelGroup(
                                                                Alignment.BASELINE)
                                                        .addComponent(label)
                                                        .addComponent(
                                                                txtPersonName,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label_1)
                                                        .addComponent(
                                                                txtPersonSurname,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label_2)
                                                        .addComponent(
                                                                txtPersonPesel,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                lblTelefon)
                                                        .addComponent(
                                                                txtPersonPhoneNo,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))));
        panPersonData.setLayout(gl_panPersonData);
        setLayout(groupLayout);

        fillInPersonData(person);
        if (order != null) {
            fillInOrderData(order);
        }
    }
}
