package org.tp.progComp.services;

import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Vente;

public interface Utils {
	
	public String generateHash(String data);
	
	public Iterable<Annonce> changerPrixAnnonce(Iterable<Annonce> listeAnnonce, String devise);
	
	public Iterable<Vente> changerPrixVente(Iterable<Vente> listeVente, String devise);
	
}
