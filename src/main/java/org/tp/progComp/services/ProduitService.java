package org.tp.progComp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tp.progComp.bdd.product.ProductConnectionRepository;
import org.tp.progComp.entities.Annonce;
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
	public ArrayList<Produit> findByNomProduit(String nomProduit) {
		// TODO Auto-generated method stub
		Iterable<Produit> itr = productRepository.findAll();
		ArrayList<Produit> a = new ArrayList<Produit>();
		for (Produit an : itr)
		{
			if(an.getNomProduit().contains(nomProduit))
			{
				a.add(an);
			}
		
		}
		return a;
	}
	
	public Produit findById(int id) {
		return productRepository.findById(id);
	}
	
	public ArrayList<Produit> findByCategorie(String categorie)
	{
		Iterable<Produit> itr = productRepository.findAll();
		ArrayList<Produit> a = new ArrayList<Produit>();
		for (Produit an : itr)
		{
			if(an.getCategorie().contains(categorie))
			{
				a.add(an);
			}
			
		}
		return a;
	}
}
