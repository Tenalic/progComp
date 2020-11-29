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
				this.deleteAnnonce(annonce);
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
			// TODO la supr aussi du compte associer (dans en vente)
			// TODO verifier si sa la supr pas de vente eguallement ...
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

}
