package org.tp.progComp.services;

import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Vente;

public interface VenteService {
		
	public Vente createVente(String pseudoAcheteur, int IdAnnonce);
	
	public Vente createVente(String pseudoAcheteur, Annonce annonce);

}
