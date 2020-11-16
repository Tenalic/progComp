package org.tp.progComp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tp.progComp.services.ProduitService;

class TestProduit {

	@Autowired
	ProduitService ps;
	
	@Test
	void test() {
		//Produit produit = ps.find
	}

}
