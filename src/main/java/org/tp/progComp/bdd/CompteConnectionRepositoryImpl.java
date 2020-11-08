package org.tp.progComp.bdd;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CompteConnectionRepositoryImpl implements CompteConnectionRepositoryCustom {

	@PersistenceContext
	EntityManager em;
	
}
