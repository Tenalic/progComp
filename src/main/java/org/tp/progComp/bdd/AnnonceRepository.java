package org.tp.progComp.bdd;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;

public interface AnnonceRepository extends CrudRepository<Annonce, Integer> {

	//public ArrayList<Annonce> findAllAnnonceById();
	
	public Annonce findAnnonceById(int id);
	
	public ArrayList<Annonce> findAllAnnonceByVendeur(Compte vendeur);
	
	//public ArrayList<Annonce> finAllAnnonceByProduit(Produit produit);
}
