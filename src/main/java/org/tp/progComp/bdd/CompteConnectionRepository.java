package org.tp.progComp.bdd;

import org.springframework.data.repository.CrudRepository;
import org.tp.progComp.entities.CompteConnection;

public interface CompteConnectionRepository extends CrudRepository<CompteConnection, Integer>, CompteConnectionRepositoryCustom {

	CompteConnection findByEmail(String email);
	
}
