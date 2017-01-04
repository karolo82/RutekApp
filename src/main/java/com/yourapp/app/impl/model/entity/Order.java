package com.yourapp.app.impl.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yourapp.app.gui.enums.Status;

@SuppressWarnings("serial")
@Entity
@Table(name = "orders")
public class Order extends Identifier {

	// Klient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personId", nullable = false)
	private Person person;
	// Status zamówienia
	@Column(nullable = false, length = 20)
	private Status status;
	// Numer tacy
	@Column(nullable = false, length = 10)
	private String boxNumber;
	// Data zapisu zlecenia
	@Column(nullable = false)
	private Date startDate;
	// Data wydania zlecenia
	@Column(nullable = true)
	private Date endDate;
	// Zaliczka
	@Column(nullable = true)
	private String paymentOnAccount;
	// Wartość zamówienia
	@Column(nullable = false)
	private String orderValue;
	// Pozostało do zapłaty
	@Column(nullable = true)
	private String paymentLeft;
	// Oprawa
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "frameId", nullable = true)
	private Frame frame;
	// Cena oprawy
	@Column(nullable = true)
	private String framePrice;
	// Zniżka na oprawę
	@Column(nullable = true)
	private String frameDiscount;
	// Cena po zniżce
	@Column(nullable = true)
	private String frameSellPrice;
	// Marka prawej soczewki
	@Column(nullable = true, length = 50)
	private String lensMarkER;
	// Model prawej soczewki
	@Column(nullable = true, length = 50)
	private String lensModelER;
	// Indeks prawej soczewki
	@Column(nullable = true, length = 10)
	private String lensIndexER;
	// Moc prawej soczewki
	@Column(nullable = true, length = 10)
	private String lensPowerER;
	// Cylinder prawej soczewki
	@Column(nullable = true, length = 10)
	private String lensCylinderER;
	// Oś prawej soczewki
	@Column(nullable = true, length = 5)
	private String lensAxisER;
	// Zniżka prawej soczewki
	@Column(nullable = true)
	private String lensDiscountER;
	// Cena prawej soczewki
	@Column(nullable = true)
	private String lensPriceER;
	// Cena po zniżce prawej soczewki
	@Column(nullable = true)
	private String lensSellPriceER;
	// Barwienie soczewski prawej
	@Column(nullable = true, length = 50)
	private String colourLensER;
	// Marka lewej soczewki
	@Column(nullable = true, length = 50)
	private String lensMarkEL;
	// Model lewej soczewki
	@Column(nullable = true, length = 50)
	private String lensModelEL;
	// Indeks lewej soczewki
	@Column(nullable = true, length = 10)
	private String lensIndexEL;
	// Moc lewej soczewki
	@Column(nullable = true, length = 10)
	private String lensPowerEL;
	// Cylinder lewej soczewki
	@Column(nullable = true, length = 10)
	private String lensCylinderEL;
	// Oś lewej soczewki
	@Column(nullable = true, length = 5)
	private String lensAxisEL;
	// Zniżka lewej soczewki
	@Column(nullable = true)
	private String lensDiscountEL;
	// Cena lewej soczewki
	@Column(nullable = true)
	private String lensPriceEL;
	// Cena po zniżce lewej soczewki
	@Column(nullable = true)
	private String lensSellPriceEL;
	// Barwienie soczewski lewej
	@Column(nullable = true, length = 50)
	private String colourLensEL;
	// Notatka
	@Column(nullable = true, length = 250)
	private String note;
	// Badanie
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Examination examination;
	@Column(nullable = true)
	// Cena badania
	private String examinationPrice;
	// Zniżka na badanie
	@Column(nullable = true)
	private String examinationDiscount;
	// Cena badania po zniżce
	@Column(nullable = true)
	private String examinationSellPrice;
	// Numer zlecenia
	@Column(nullable = false)
	private Integer orderNumber;
	// PD prawe
	@Column(nullable = true)
	private Integer PdRight;
	// PD lewe
	@Column(nullable = true)
	private Integer PdLeft;
	// wysokość prawa
	@Column(nullable = true)
	private String heightRight;
	// wysokość lewa
	@Column(nullable = true)
	private String heightLeft;

	public Order() {

	}

	public Order(Person person, Status status, String boxNumber,
			Date startDate, Date endDate, String paymentOnAccount,
			String orderValue, String paymentLeft, Frame frame,
			String framePrice, String frameDiscount, String frameSellPrice,
			String lensMarkER, String lensModelER, String lensIndexER,
			String lensPowerER, String lensCylinderER, String lensAxisER,
			String lensDiscountER, String lensPriceER, String lensSellPriceER,
			String colourLensER, String lensMarkEL, String lensModelEL,
			String lensIndexEL, String lensPowerEL, String lensCylinderEL,
			String lensAxisEL, String lensDiscountEL, String lensPriceEL,
			String lensSellPriceEL, String colourLensEL, String note,
			Examination examination, String examinationPrice,
			String examinationDiscount, String examinationSellPrice,
			Integer orderNumber) {
		super();
		this.person = person;
		this.status = status;
		this.boxNumber = boxNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paymentOnAccount = paymentOnAccount;
		this.orderValue = orderValue;
		this.paymentLeft = paymentLeft;
		this.frame = frame;
		this.framePrice = framePrice;
		this.frameDiscount = frameDiscount;
		this.frameSellPrice = frameSellPrice;
		this.lensMarkER = lensMarkER;
		this.lensModelER = lensModelER;
		this.lensIndexER = lensIndexER;
		this.lensPowerER = lensPowerER;
		this.lensCylinderER = lensCylinderER;
		this.lensAxisER = lensAxisER;
		this.lensDiscountER = lensDiscountER;
		this.lensPriceER = lensPriceER;
		this.lensSellPriceER = lensSellPriceER;
		this.colourLensER = colourLensER;
		this.lensMarkEL = lensMarkEL;
		this.lensModelEL = lensModelEL;
		this.lensIndexEL = lensIndexEL;
		this.lensPowerEL = lensPowerEL;
		this.lensCylinderEL = lensCylinderEL;
		this.lensAxisEL = lensAxisEL;
		this.lensDiscountEL = lensDiscountEL;
		this.lensPriceEL = lensPriceEL;
		this.lensSellPriceEL = lensSellPriceEL;
		this.colourLensEL = colourLensEL;
		this.note = note;
		this.examination = examination;
		this.examinationPrice = examinationPrice;
		this.examinationDiscount = examinationDiscount;
		this.examinationSellPrice = examinationSellPrice;
		this.orderNumber = orderNumber;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getStartDateStr() {
		if (startDate == null) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyy-mm-dd");
		return df.format(startDate);
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPaymentOnAccount() {
		return paymentOnAccount;
	}

	public void setPaymentOnAccount(String paymentOnAccount) {
		this.paymentOnAccount = paymentOnAccount;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}

	public String getPaymentLeft() {
		return paymentLeft;
	}

	public void setPaymentLeft(String paymentLeft) {
		this.paymentLeft = paymentLeft;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public String getFramePrice() {
		return framePrice;
	}

	public void setFramePrice(String framePrice) {
		this.framePrice = framePrice;
	}

	public String getFrameDiscount() {
		return frameDiscount;
	}

	public void setFrameDiscount(String frameDiscount) {
		this.frameDiscount = frameDiscount;
	}

	public String getFrameSellPrice() {
		return frameSellPrice;
	}

	public void setFrameSellPrice(String frameSellPrice) {
		this.frameSellPrice = frameSellPrice;
	}

	public String getLensMarkER() {
		return lensMarkER;
	}

	public void setLensMarkER(String lensMarkER) {
		this.lensMarkER = lensMarkER;
	}

	public String getLensModelER() {
		return lensModelER;
	}

	public void setLensModelER(String lensModelER) {
		this.lensModelER = lensModelER;
	}

	public String getLensIndexER() {
		return lensIndexER;
	}

	public void setLensIndexER(String lensIndexER) {
		this.lensIndexER = lensIndexER;
	}

	public String getLensPowerER() {
		return lensPowerER;
	}

	public void setLensPowerER(String lensPowerER) {
		this.lensPowerER = lensPowerER;
	}

	public String getLensCylinderER() {
		return lensCylinderER;
	}

	public void setLensCylinderER(String lensCylinderER) {
		this.lensCylinderER = lensCylinderER;
	}

	public String getLensAxisER() {
		return lensAxisER;
	}

	public void setLensAxisER(String lensAxisER) {
		this.lensAxisER = lensAxisER;
	}

	public String getLensDiscountER() {
		return lensDiscountER;
	}

	public void setLensDiscountER(String lensDiscountER) {
		this.lensDiscountER = lensDiscountER;
	}

	public String getLensPriceER() {
		return lensPriceER;
	}

	public void setLensPriceER(String lensPriceER) {
		this.lensPriceER = lensPriceER;
	}

	public String getLensSellPriceER() {
		return lensSellPriceER;
	}

	public void setLensSellPriceER(String lensSellPriceER) {
		this.lensSellPriceER = lensSellPriceER;
	}

	public String getColourLensER() {
		return colourLensER;
	}

	public void setColourLensER(String colourLensER) {
		this.colourLensER = colourLensER;
	}

	public String getLensMarkEL() {
		return lensMarkEL;
	}

	public void setLensMarkEL(String lensMarkEL) {
		this.lensMarkEL = lensMarkEL;
	}

	public String getLensModelEL() {
		return lensModelEL;
	}

	public void setLensModelEL(String lensModelEL) {
		this.lensModelEL = lensModelEL;
	}

	public String getLensIndexEL() {
		return lensIndexEL;
	}

	public void setLensIndexEL(String lensIndexEL) {
		this.lensIndexEL = lensIndexEL;
	}

	public String getLensPowerEL() {
		return lensPowerEL;
	}

	public void setLensPowerEL(String lensPowerEL) {
		this.lensPowerEL = lensPowerEL;
	}

	public String getLensCylinderEL() {
		return lensCylinderEL;
	}

	public void setLensCylinderEL(String lensCylinderEL) {
		this.lensCylinderEL = lensCylinderEL;
	}

	public String getLensAxisEL() {
		return lensAxisEL;
	}

	public void setLensAxisEL(String lensAxisEL) {
		this.lensAxisEL = lensAxisEL;
	}

	public String getLensDiscountEL() {
		return lensDiscountEL;
	}

	public void setLensDiscountEL(String lensDiscountEL) {
		this.lensDiscountEL = lensDiscountEL;
	}

	public String getLensPriceEL() {
		return lensPriceEL;
	}

	public void setLensPriceEL(String lensPriceEL) {
		this.lensPriceEL = lensPriceEL;
	}

	public String getLensSellPriceEL() {
		return lensSellPriceEL;
	}

	public void setLensSellPriceEL(String lensSellPriceEL) {
		this.lensSellPriceEL = lensSellPriceEL;
	}

	public String getColourLensEL() {
		return colourLensEL;
	}

	public void setColourLensEL(String colourLensEL) {
		this.colourLensEL = colourLensEL;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public String getExaminationPrice() {
		return examinationPrice;
	}

	public void setExaminationPrice(String examinationPrice) {
		this.examinationPrice = examinationPrice;
	}

	public String getExaminationDiscount() {
		return examinationDiscount;
	}

	public void setExaminationDiscount(String examinationDiscount) {
		this.examinationDiscount = examinationDiscount;
	}

	public String getExaminationSellPrice() {
		return examinationSellPrice;
	}

	public void setExaminationSellPrice(String examinationSellPrice) {
		this.examinationSellPrice = examinationSellPrice;
	}

	public Integer getPdRight() {
		return PdRight;
	}

	public void setPdRight(Integer pdRight) {
		PdRight = pdRight;
	}

	public Integer getPdLeft() {
		return PdLeft;
	}

	public void setPdLeft(Integer pdLeft) {
		PdLeft = pdLeft;
	}

	public String getHeightRight() {
		return heightRight;
	}

	public void setHeightRight(String heightRight) {
		this.heightRight = heightRight;
	}

	public String getHeightLeft() {
		return heightLeft;
	}

	public void setHeightLeft(String heightLeft) {
		this.heightLeft = heightLeft;
	}
	
}
