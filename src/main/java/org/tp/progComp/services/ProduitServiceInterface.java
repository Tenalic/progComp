package org.tp.progComp.services;

import java.util.ArrayList;

import org.tp.progComp.entities.Produit;

public interface ProduitServiceInterface {
	
	Produit createProduit(String name, String categorie, String miniCategorie, String nameVendeur);

	Produit findProduit(String nameProduct, String categorie, String nameVendeur);
	
	Produit findByNomProduit(String nomProduit);
	
	
}
