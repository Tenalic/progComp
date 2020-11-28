package org.tp.progComp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tp.progComp.bdd.VenteRepository;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.entities.Produit;
import org.tp.progComp.entities.Vente;

@Service
public class VenteServiceImpl implements VenteService {

	@Autowired
	private VenteRepository venteRepository;

	@Autowired
	private CompteService compteService;

	@Autowired
	private AnnonceService annonceService;

	@Autowired
	private ProduitServiceInterface produitService;

	@Transactional
	public Vente createVente(String pseudoAcheteur, int IdAnnonce) {
		Annonce annonce = annonceService.getAnnonce(IdAnnonce);
		if (annonce != null) {
			Compte compteVendeur = compteService.findCompteBySpeudo(annonce.getProduit().getPseudoVendeur());
			Compte compteAcheteur = compteService.findCompteBySpeudo(pseudoAcheteur);
			Produit produit = produitService.findById(annonce.getProduit().getId());
			if (produit != null && compteVendeur != null && compteAcheteur != null) {
				return venteRepository.save(new Vente(1, annonce.getPrix(), produit, compteAcheteur, compteVendeur));
			}
		}
		return null;
	}

}
