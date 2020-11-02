package org.tp.progComp.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Compte {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	private String nom;

	private String prenom;

	private String email;

	private String speudo;

	private boolean acheteur;

	private boolean vendeur;

	@OneToMany(mappedBy = "vendeur")
	private Collection<Vente> listeProduitEnVente;

	@OneToMany(mappedBy = "acheteur")
	private Collection<Vente> listeAchat;

	@OneToMany(mappedBy = "vendeur")
	private Collection<Vente> listeVente;

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
		//this.listeProduitEnVente = listeProduitEnVente;
	}

	public Compte(String nom, String prenom, String email, String speudo, boolean acheteur, boolean vendeur,
			List<Vente> listeProduitEnVente, List<Vente> listeAchat, List<Vente> listeVente) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.speudo = speudo;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		//this.listeProduitEnVente = listeProduitEnVente;
		//this.listeAchat = listeAchat;
		//this.listeVente = listeVente;
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

	public Collection<Vente> getListeProduitEnVente() {
		return listeProduitEnVente;
	}

	public void setListeProduitEnVente(List<Vente> listeProduitEnVente) {
		this.listeProduitEnVente = listeProduitEnVente;
	}

	public Collection<Vente> getListeAchat() {
		return listeAchat;
	}

	public void setListeAchat(List<Vente> listeAchat) {
		this.listeAchat = listeAchat;
	}

	public Collection<Vente> getListeVente() {
		return listeVente;
	}

	public void setListeVente(List<Vente> listeVente) {
		this.listeVente = listeVente;
	}

	public int getId() {
		return id;
	}

}
