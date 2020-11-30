package org.tp.progComp.services;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tp.progComp.bdd.AnnonceRepository;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Vente;

@Service
public class AnnonceServiceImpl<E> implements AnnonceService {

	@Autowired
	AnnonceRepository annonceRepository;

	@Autowired
	VenteService venteService;

	@Transactional
	public Iterable<Annonce> getAllAnnonce() {
		Iterable<Annonce> lAnnonce = annonceRepository.findAll();
		List<Annonce> response = new ArrayList<Annonce>();
		for (Annonce annonce : lAnnonce) {
			if (annonce.isEnchere() && !annonce.getDateDeFin().after(new GregorianCalendar())) {
				if (annonce.getPseudoPlusHautEnchere() != null) {
					acheterAnnonce(annonce.getPseudoPlusHautEnchere(), annonce.getId());
				} else {
					this.deleteAnnonce(annonce);
				}
			} else {
				response.add(annonce);
			}
		}
		return response;
	}

	@Transactional
	public Annonce getAnnonce(int id) {
		Annonce annonce = annonceRepository.findAnnonceById(id);
		if (annonce != null && annonce.isEnchere() && !annonce.getDateDeFin().after(new GregorianCalendar())) {
			if (annonce.getPseudoPlusHautEnchere() != null) {
				this.acheterAnnonce(annonce.getPseudoPlusHautEnchere(), annonce);
				return null;
			}
			this.deleteAnnonce(annonce);
			return null;
		}
		return annonce;
	}

	@Transactional
	public Annonce createAnnonce(Annonce annonce) {
		if (annonce != null) {
			return annonceRepository.save(annonce);
		}
		return null;
	}

	@Transactional
	public int deleteAnnonce(Annonce annonce) {
		if (annonce != null) {
			annonceRepository.delete(annonce);
		}
		return 0;
	}

	@Transactional
	public int acheterAnnonce(String pseudoCompte, int idAnnonceInt) {
		Vente vente = venteService.createVente(pseudoCompte, idAnnonceInt);
		if (vente != null) {
			deleteAnnonce(idAnnonceInt);
		}
		return 0;
	}
	
	@Transactional
	public int acheterAnnonce(String pseudoCompte, Annonce annonce) {
		Vente vente = venteService.createVente(pseudoCompte, annonce);
		if (vente != null) {
			deleteAnnonce(annonce.getId());
		}
		return 0;
	}

	@Transactional
	public int deleteAnnonce(int idAnnonce) {
		annonceRepository.deleteById(idAnnonce);
		return 0;
	}

	@Transactional
	public int supprimerAnnonce(int idAnnonce, String pseudo) {
		Annonce annonce = annonceRepository.findAnnonceById(idAnnonce);
		if (annonce != null && pseudo != null && pseudo.equals(annonce.getVendeur().getSpeudo())) {
			annonceRepository.deleteById(idAnnonce);
			return 0;
		}
		return 1;
	}

	@Transactional
	public int encherir(String pseudoCompte, int idAnnonceInt, float valeurEnchere) {
		Annonce annonce = this.getAnnonce(idAnnonceInt);
		if (annonce != null && annonce.getPrix() < valeurEnchere) {
			annonceRepository.changerPrixEnchere(idAnnonceInt, valeurEnchere, pseudoCompte);
			annonceRepository.augmenterUneEnchere(idAnnonceInt);
			return 0;
		}
		return 1;
	}
	
	public double euroToDollar(double prix) {
		return prix * 1.20;
	}

}
