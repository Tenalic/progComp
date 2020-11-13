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
	
	private String nomProduit;

	private String categorie;

	private String miniCategorie;
	
	private String pseudoVendeur;

	public Produit() {

	}

	
	
	public Produit(String nomProduit, String categorie, String miniCategorie, String pseudoVendeur) {
		super();
		this.nomProduit = nomProduit;
		this.categorie = categorie;
		this.miniCategorie = miniCategorie;
		this.pseudoVendeur = pseudoVendeur;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getPseudoVendeur() {
		return pseudoVendeur;
	}

	public void setPseudoVendeur(String pseudoVendeur) {
		this.pseudoVendeur = pseudoVendeur;
	}
	
	

}
