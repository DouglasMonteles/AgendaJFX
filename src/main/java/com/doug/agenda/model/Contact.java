package com.doug.agenda.model;

import java.util.Date;

public class Contact {

	private Long id;
	
	private String description;
	
	private String andress;
	
	private Integer number;
	
	private String email;
	
	private Date birthDate;
	
	private String phone1;
	
	private String phone2;
	
	private City city;
	
	private TypeContact typeContact;
	
	public Contact() {}

	public Contact(Long id, String description, String andress, Integer number, 
			String email, Date birthDate, String phone1, String phone2, City city, 
			TypeContact typeContact) {
		super();
		this.id = id;
		this.description = description;
		this.andress = andress;
		this.number = number;
		this.email = email;
		this.birthDate = birthDate;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.city = city;
		this.typeContact = typeContact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAndress() {
		return andress;
	}

	public void setAndress(String andress) {
		this.andress = andress;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public TypeContact getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(TypeContact typeContact) {
		this.typeContact = typeContact;
	}
	
}
