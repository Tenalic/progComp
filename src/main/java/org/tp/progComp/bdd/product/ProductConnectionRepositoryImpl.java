package org.tp.progComp.bdd.product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductConnectionRepositoryImpl implements ProductConnectionRepositoryCustom{

	
	@PersistenceContext
	EntityManager em;
}
