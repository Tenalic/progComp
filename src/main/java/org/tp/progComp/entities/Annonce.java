package org.tp.progComp.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Annonce {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	private String description;

	@OneToOne(fetch = FetchType.EAGER)
	private Produit produit;

	@OneToOne(fetch = FetchType.EAGER)
	private Compte vendeur;
	
	//TODO rajouter prix

	public Annonce() {

	}

	public Annonce(String description, Produit produit, Compte vendeur) {
		super();
		this.description = description;
		this.produit = produit;
		this.vendeur = vendeur;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Produit getProduit() {
		return produit;
	}

	public Compte getVendeur() {
		return vendeur;
	}

}
