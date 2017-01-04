package com.yourapp.app.impl.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yourapp.app.gui.enums.Sex;

@SuppressWarnings("serial")
@Entity
@Table(name = "person")
public class Person extends Identifier {
	@Column(nullable = false, length = 30)
	private String name;
	@Column(nullable = false, length = 50)
	private String surname;
	@Column(nullable = true)
	private Date birthDate;
	@Column(nullable = true, length = 11)
	private String pesel;
	@Column(nullable = true, length = 50)
	private String email;
	@Column(nullable = true, length = 20)
	private String phone;
	@Column(nullable = true, length = 250)
	private String notes;
	@Column(nullable = true, length = 10)
	private Sex sex;
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name="personId")
	private Set<Address> adresses = new HashSet<Address>(0);
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL}, orphanRemoval=true)
	@JoinColumn(name="personId")
	private Set<Order> orders = new HashSet<Order>(0);

	public Person() {
	}

	public Person(String name, String surname, Date birthDate, String pesel,
			String email, String phone, String notes, Sex sex,
			Set<Address> adresses, Set<Order> orders) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.pesel = pesel;
		this.email = email;
		this.phone = phone;
		this.notes = notes;
		this.sex = sex;
		this.adresses = adresses;
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Set<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Address> adresses) {
		this.adresses = adresses;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public void addaddress(Address address){
		if(this.getAdresses()==null){
			this.setAdresses(new HashSet<Address>());
		}
		this.getAdresses().add(address);
	}
}
