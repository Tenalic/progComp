package org.tp.progComp.services;

import org.tp.progComp.entities.Annonce;

public interface AnnonceService {
	
	public Iterable<Annonce> getAllAnnonce();
	
	public Annonce getAnnonce(int id);
	
	public Annonce createAnnonce(Annonce annonce);
	
	public int deleteAnnonce(Annonce annonce);
	
	public int deleteAnnonce(int idAnnonce);
	
	public int supprimerAnnonce(int idAnnonce, String pseudo);
	
	public int acheterAnnonce(String pseudoCompte, int idAnnonceInt);
	
	public int encherir(String pseudoCompte, int idAnnonceInt, float valeurEnchere);
	
	public int acheterAnnonce(String pseudoCompte, Annonce annonce);

}
