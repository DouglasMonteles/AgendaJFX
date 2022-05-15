package com.doug.agenda.model;

public class City {

	private Long id;
	
	private String description;
	
	private String uf;
	
	private String cep;
	
	public City() {}

	public City(Long id, String description, String uf, String cep) {
		super();
		this.id = id;
		this.description = description;
		this.uf = uf;
		this.cep = cep;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
