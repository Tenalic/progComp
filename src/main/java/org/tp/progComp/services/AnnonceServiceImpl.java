package org.tp.progComp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tp.progComp.bdd.AnnonceRepository;
import org.tp.progComp.entities.Annonce;

@Service
public class AnnonceServiceImpl implements AnnonceService {

	@Autowired
	AnnonceRepository annonceRepository;

	@Override
	public Iterable<Annonce> getAllAnnonce() {
		return annonceRepository.findAll();
	}

	@Override
	public Annonce getAnnonce(int id) {
		return annonceRepository.findAnnonceById(id);
	}

	@Transactional
	public Annonce createAnnonce(Annonce annonce) {
		if(annonce != null) {
			return annonceRepository.save(annonce);
		}
		return null;
	}

	@Transactional
	public int deleteAnnonce(Annonce annonce) {
		if(annonce != null) {
			annonceRepository.delete(annonce);
			// TODO la supr aussi du compte associer (dans en vente)
			// TODO verifier si sa la supr pas de vente eguallement ...
		}
		return 0;
	}

}
