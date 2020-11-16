package org.tp.progComp.bdd.product;

import org.springframework.data.repository.CrudRepository;
import org.tp.progComp.entities.Produit;

public interface ProductConnectionRepository extends  CrudRepository<Produit, Integer>, ProductConnectionRepositoryCustom {

	Produit findByNomProduit(String nomProduit);

	//ArrayList<Produit> findCategorieList(String categorie);
	
	Produit findByNomProduitAndCategorieAndPseudoVendeur(String nomProduit, String categorie, String pseudoVendeur);
	
	
	
}
