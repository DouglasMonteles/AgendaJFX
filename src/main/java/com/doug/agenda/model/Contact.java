package com.doug.agenda.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@Column(length = 100, nullable = true)
	private String andress;
	
	@Column(name = "numero_residencia", nullable = true)
	private Integer number;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(nullable = true)
	private LocalDate birthDate;
	
	@Column(length = 11, nullable = false)
	private String phone1;
	
	@Column(length = 11, nullable = false)
	private String phone2;
	
	@Column(nullable = false)
	private Boolean active;
	
	@Column(length = 10, nullable = false)
	private String sex;
	
	@OneToOne
	private City city;
	
	@OneToOne
	private TypeContact typeContact;
	
	public Contact() {}

	public Contact(Long id, String description, String andress, Integer number, 
			String email, LocalDate birthDate, String phone1, String phone2, 
			Boolean active, String sex, City city, TypeContact typeContact) {
		super();
		this.id = id;
		this.description = description;
		this.andress = andress;
		this.number = number;
		this.email = email;
		this.birthDate = birthDate;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.active = active;
		this.sex = sex;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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
	
	public Boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
