package org.tp.progComp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;

@Entity
public class Vente {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	private int quantite;

	private float prix;

	@OneToOne
	private Produit produit;

	@OneToOne()
	private Compte acheteurVente;

	@OneToOne()
	private Compte vendeurVente;

	public Vente() {

	}

	public Vente(int quantite, float prix, Produit produit) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.produit = produit;
	}

	public Vente(int quantite, float prix, Produit produit, Compte acheteur, Compte vendeur) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.produit = produit;
		this.acheteurVente = acheteur;
		this.vendeurVente = vendeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Compte getAcheteurVente() {
		return acheteurVente;
	}

	public void setAcheteurVente(Compte acheteur) {
		this.acheteurVente = acheteur;
	}

	public Compte getVendeurVente() {
		return vendeurVente;
	}

	public void setVendeurVente(Compte vendeur) {
		this.vendeurVente = vendeur;
	}

}
