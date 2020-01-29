package com.testjava.tuto.model;

public class Abonne {

	private int Id;
	private String canal;
	private Adresse adresse;

	public Abonne(int id, String canal, Adresse adresse) {
		this.Id = id;
		this.canal = canal;
		this.adresse = adresse;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
}
