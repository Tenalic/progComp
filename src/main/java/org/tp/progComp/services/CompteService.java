package org.tp.progComp.services;

import org.tp.progComp.entities.Compte;

public interface CompteService {
	
	public Compte findCompteByEmail(String email);
	
	public Compte findCompteBySpeudo(String speudo);
	
	public String createCompte(String nom, String prenom, String email, String speudo, String motDePasse, Boolean vendeur);

}
