package com.yourapp.app.impl.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="examination")
public class Examination extends Identifier{

	@Column(nullable=true)
	private String ErPower;
	@Column(nullable=true)
	private String ElPower;
	@Column(nullable=true)
	private String ErCylinder;
	@Column(nullable=true)
	private String ElCylinder;
	@Column(nullable=true)
	private String ErOs;
	@Column(nullable=true)
	private String ElOs;
	@Column(nullable=true)
	private String ErAdd;
	@Column(nullable=true)
	private String ElAdd;
	@Column(nullable=true)
	private String note;
	@Column(nullable=true)
	private Boolean isMyExamination;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Order order;
	
	public Examination(){
		
	}
	
	public Examination(String erPower, String elPower, String erCylinder,
			String elCylinder, String erOs, String elOs, String erAdd,
			String elAdd, String note, Boolean isMyExamination, Order order) {
		ErPower = erPower;
		ElPower = elPower;
		ErCylinder = erCylinder;
		ElCylinder = elCylinder;
		ErOs = erOs;
		ElOs = elOs;
		ErAdd = erAdd;
		ElAdd = elAdd;
		this.note = note;
		this.isMyExamination = isMyExamination;
		this.order = order;
	}

	public String getErPower() {
		return ErPower;
	}

	public void setErPower(String erPower) {
		ErPower = erPower;
	}

	public String getElPower() {
		return ElPower;
	}

	public void setElPower(String elPower) {
		ElPower = elPower;
	}

	public String getErCylinder() {
		return ErCylinder;
	}

	public void setErCylinder(String erCylinder) {
		ErCylinder = erCylinder;
	}

	public String getElCylinder() {
		return ElCylinder;
	}

	public void setElCylinder(String elCylinder) {
		ElCylinder = elCylinder;
	}

	public String getErOs() {
		return ErOs;
	}

	public void setErOs(String erOs) {
		ErOs = erOs;
	}

	public String getElOs() {
		return ElOs;
	}

	public void setElOs(String elOs) {
		ElOs = elOs;
	}

	public String getErAdd() {
		return ErAdd;
	}

	public void setErAdd(String erAdd) {
		ErAdd = erAdd;
	}

	public String getElAdd() {
		return ElAdd;
	}

	public void setElAdd(String elAdd) {
		ElAdd = elAdd;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getIsMyExamination() {
		return isMyExamination;
	}

	public void setIsMyExamination(Boolean isMyExamination) {
		this.isMyExamination = isMyExamination;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
