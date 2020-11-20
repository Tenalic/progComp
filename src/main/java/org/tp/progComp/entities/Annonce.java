package org.tp.progComp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Annonce {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	private String description;

	@ManyToOne
	private Produit produit;

	@ManyToOne
	private Compte vendeur;

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
