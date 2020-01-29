package com.testjava.tuto.model;

public class Adresse {

	private String active;
	private String pays;
	private String conditions;
	
	public Adresse(String active, String pays) {
		this.active = active;
		this.pays = pays;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
}
