package org.tp.progComp.entities;

public class Vente {

	private int quantite;

	private float prix;

	private Produit produit;

	private Compte acheteur;

	private Compte vendeur;

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
		this.acheteur = acheteur;
		this.vendeur = vendeur;
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

	public Compte getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Compte acheteur) {
		this.acheteur = acheteur;
	}

	public Compte getVendeur() {
		return vendeur;
	}

	public void setVendeur(Compte vendeur) {
		this.vendeur = vendeur;
	}

}
