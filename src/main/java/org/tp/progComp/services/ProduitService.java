package org.tp.progComp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tp.progComp.bdd.product.ProductConnectionRepository;
import org.tp.progComp.entities.Produit;

@Service
public class ProduitService implements ProduitServiceInterface {

	@Autowired
	private ProductConnectionRepository productRepository;
	
	/*@Autowired
	public Produit findProduit(String name, String categorie,String miniCategorie, String nameVendeur) {
		return productRepository.findByNomProduitAndCategorieAndPseudoVendeur(name, categorie, nameVendeur);
	}*/
	
	/*@Transactional
	public Produit createProduit(String name, String categorie, String miniCategorie, String vendorsName) {
		if (findProduit(name, categorie, miniCategorie, vendorsName) == null) {
			return productRepository.save(new Produit(name, categorie, miniCategorie, vendorsName));
		} else {
			return null;
		}
	}*/

	@Transactional
	public Produit createProduit2(String name, String categorie, String miniCategorie, String vendorsName) {
		return productRepository.save(new Produit(name, categorie, miniCategorie, vendorsName));
	}

	@Override
	public Produit findByNomProduit(String nomProduit) {
		// TODO Auto-generated method stub
		return productRepository.findByNomProduit(nomProduit);
	}
	
	public Produit findById(int id) {
		return productRepository.findById(id);
	}
}
