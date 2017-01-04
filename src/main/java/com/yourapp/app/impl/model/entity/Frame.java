package com.yourapp.app.impl.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="frame")
public class Frame extends Identifier{

	@Column(nullable = true, length = 50)
	private String mark;
	@Column(nullable = true, length = 50)
	private String model;
	@Column(nullable = true, length = 50)
	private String code;
	@Column(nullable = true, length = 50)
	private String color;
	@Column(nullable = true, length = 10)
	private String nettoValue;
	
	public Frame() {

	}

	public Frame(String mark, String model, String code, String color, String nettoVal) {
		super();
		this.mark = mark;
		this.model = model;
		this.code = code;
		this.color = color;
		this.nettoValue = nettoVal;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}	
	
	public String getNettoValue() {
		return nettoValue;
	}

	public void setNettoValue(String val) {
		this.nettoValue = val;
	}
}
