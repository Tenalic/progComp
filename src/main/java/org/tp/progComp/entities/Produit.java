package org.tp.progComp.entities;

public class Produit {

	private String categorie;

	private String miniCategorie;

	public Produit() {

	}

	public Produit(String categorie, String miniCategorie) {
		super();
		this.categorie = categorie;
		this.miniCategorie = miniCategorie;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMiniCategorie() {
		return miniCategorie;
	}

	public void setMiniCategorie(String miniCategorie) {
		this.miniCategorie = miniCategorie;
	}

}
