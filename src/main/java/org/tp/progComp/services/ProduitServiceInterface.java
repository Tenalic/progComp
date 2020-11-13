package org.tp.progComp.services;

import org.tp.progComp.entities.Produit;

public interface ProduitServiceInterface {
	
	Produit createProduit(String name, String categorie, String miniCategorie, String nameVendeur);

	Produit findProduct(String nameProduct, String categorie, String nameVendeur);
	
	
}
