package org.tp.progComp.bdd;

import org.springframework.data.repository.CrudRepository;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.entities.Vente;

public interface VenteRepository extends CrudRepository<Vente, Integer> {
	
	Vente findById(int id); 
	
	Vente findByVendeurVente(Compte vendeurVente);
	
	Vente findByacheteurVente(Compte acheteurVente);

}
