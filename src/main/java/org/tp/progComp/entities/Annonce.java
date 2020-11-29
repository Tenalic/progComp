package org.tp.progComp.entities;

import java.util.GregorianCalendar;

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

	private float prix;

	private boolean enchere;

	private GregorianCalendar dateMiseEnLigne;

	private GregorianCalendar dateDeFin;
	
	private String pseudoPlusHautEnchere; // todo dans constructeurs
	
	private int nombreEnchere; // todo dans constructeurs

	public Annonce() {

	}

	public Annonce(String description, Produit produit, Compte vendeur) {
		super();
		this.description = description;
		this.produit = produit;
		this.vendeur = vendeur;
		this.prix = 0;
		this.dateMiseEnLigne = new GregorianCalendar();
		this.dateDeFin = null;
	}

	public Annonce(String description, Produit produit, Compte vendeur, float prix) {
		super();
		this.description = description;
		this.produit = produit;
		this.vendeur = vendeur;
		this.prix = prix;
		this.enchere = false;
		this.dateMiseEnLigne = new GregorianCalendar();
		this.dateMiseEnLigne = null;
	}

	public Annonce(String description, Produit produit, Compte vendeur, float prix, boolean enchere) {
		super();
		this.description = description;
		this.produit = produit;
		this.vendeur = vendeur;
		this.prix = prix;
		this.enchere = enchere;
		this.dateMiseEnLigne = new GregorianCalendar();
		this.dateDeFin = (GregorianCalendar) dateMiseEnLigne.clone();
		if (enchere == true) {
			this.dateDeFin.add(GregorianCalendar.SECOND, 50);
		} else {
			this.dateDeFin = null;
		}
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public boolean isEnchere() {
		return enchere;
	}

	public void setEnchere(boolean enchere) {
		this.enchere = enchere;
	}

	public GregorianCalendar getDateMiseEnLigne() {
		return dateMiseEnLigne;
	}

	public void setDateMiseEnLigne(GregorianCalendar dateMiseEnLigne) {
		this.dateMiseEnLigne = dateMiseEnLigne;
	}

	public GregorianCalendar getDateDeFin() {
		return dateDeFin;
	}

	public void setDateDeFin(GregorianCalendar dateDeFin) {
		this.dateDeFin = dateDeFin;
	}
	
	public String toStringDate() {
		return dateDeFin.getTime().toString();
	}

	public String getPseudoPlusHautEnchere() {
		return pseudoPlusHautEnchere;
	}

	public void setPseudoPlusHautEnchere(String pseudoPlusHautEnchere) {
		this.pseudoPlusHautEnchere = pseudoPlusHautEnchere;
	}

	public int getNombreEnchere() {
		return nombreEnchere;
	}

	public void setNombreEnchere(int nombreEnchere) {
		this.nombreEnchere = nombreEnchere;
	}

}
