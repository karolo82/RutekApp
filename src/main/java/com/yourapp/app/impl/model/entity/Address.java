package com.yourapp.app.impl.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yourapp.app.gui.enums.AddressType;


@SuppressWarnings("serial")
@Entity
@Table(name = "address")
public class Address extends Identifier{
	@Column(nullable = true, length = 50)
	private String street;
	@Column(nullable = false, length = 3)
	private String noHouse;
	@Column(nullable = true, length = 3)
	private String noFlat;
	@Column(nullable = false, length = 6)
	private String postalCode;
	@Column(nullable = false, length = 100)
	private String post;
	@Column(nullable = false, length = 100)
	private String city;
	@Column(nullable = true, length = 50)
	private String province;
	@Column(nullable = true, length = 20)
	private AddressType addressType;
	
	public Address (){
		
	}
	
	public Address(String street, String noHouse, String noFlat,
			String postalCode, String city, String province, AddressType addressType, String post) {
		super();
		this.street = street;
		this.noHouse = noHouse;
		this.noFlat = noFlat;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
		this.addressType = addressType;
		this.post = post;
	}



	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNoHouse() {
		return noHouse;
	}

	public void setNoHouse(String noHouse) {
		this.noHouse = noHouse;
	}

	public String getNoFlat() {
		return noFlat;
	}

	public void setNoFlat(String noFlat) {
		this.noFlat = noFlat;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

}
