package org.tp.progComp.entities;

import java.util.List;

public class Compte {

	private String nom;

	private String prenom;

	private String email;

	private String speudo;

	private boolean acheteur;

	private boolean vendeur;

	private List<Vente> listeProduitEnVente;

	public Compte() {

	}

	public Compte(String nom, String prenom, String email, String speudo, boolean acheteur, boolean vendeur) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.speudo = speudo;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
	}

	public Compte(String nom, String prenom, String email, String speudo, boolean acheteur, boolean vendeur,
			List<Vente> listeProduitEnVente) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.speudo = speudo;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		this.listeProduitEnVente = listeProduitEnVente;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpeudo() {
		return speudo;
	}

	public void setSpeudo(String speudo) {
		this.speudo = speudo;
	}

	public boolean isAcheteur() {
		return acheteur;
	}

	public void setAcheteur(boolean acheteur) {
		this.acheteur = acheteur;
	}

	public boolean isVendeur() {
		return vendeur;
	}

	public void setVendeur(boolean vendeur) {
		this.vendeur = vendeur;
	}

	public List<Vente> getListeProduitEnVente() {
		return listeProduitEnVente;
	}

	public void setListeProduitEnVente(List<Vente> listeProduitEnVente) {
		this.listeProduitEnVente = listeProduitEnVente;
	}

}
