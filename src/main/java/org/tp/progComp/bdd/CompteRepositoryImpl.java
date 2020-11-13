package org.tp.progComp.bdd;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CompteRepositoryImpl implements CompteRepositoryCustom {

	@PersistenceContext
	EntityManager em;
	
}
