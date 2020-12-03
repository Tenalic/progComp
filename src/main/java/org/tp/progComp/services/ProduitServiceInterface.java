package org.tp.progComp.services;

import java.util.ArrayList;

import org.tp.progComp.entities.Produit;

public interface ProduitServiceInterface {
	
	//Produit createProduit(String name, String categorie, String miniCategorie, String nameVendeur);

	//Produit findProduit(String nameProduct, String categorie, String miniCategorie, String nameVendeur);
	
	Produit createProduit2(String nameProduct, String categorie, String miniCategorie, String pseudoVendeur);
	
	ArrayList<Produit> findByNomProduit(String nomProduit);
	
	Produit findById(int id);
	
	ArrayList<Produit> findByCategorie(String categorie);
	
	
}
