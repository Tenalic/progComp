package org.tp.progComp.bdd;

import org.springframework.data.repository.CrudRepository;
import org.tp.progComp.entities.Compte;

public interface CompteRepository extends CrudRepository<Compte, Integer>, CompteRepositoryCustom {
	
		Compte findByEmail(String email);
		
		Compte findBySpeudo(String speudo);

}
