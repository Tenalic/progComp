package org.tp.progComp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

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
