package org.tp.progComp.entities;

public class Vente {

	private int quantite;

	private float prix;

	private Produit produit;

	public Vente() {

	}

	public Vente(int quantite, float prix, Produit produit) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.produit = produit;
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

}
