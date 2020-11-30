package org.tp.progComp.bdd;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.tp.progComp.entities.Annonce;

public class AnnonceRepositoryImpl implements AnnonceRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public void changerPrix(int id, float prix) {
		Annonce annonce = em.find(Annonce.class, id);
		annonce.setPrix(prix);
		em.merge(annonce);
	}

	@Override
	public void changerPrixEnchere(int id, float prix, String pseudo) {
		Annonce annonce = em.find(Annonce.class, id);
		annonce.setPrix(prix);
		annonce.setPseudoPlusHautEnchere(pseudo);
		em.merge(annonce);
	}

	@Override
	public void changerNombreEnchere(int id, int nombre) {
		Annonce annonce = em.find(Annonce.class, id);
		annonce.setNombreEnchere(nombre);
		em.merge(annonce);
	}

	@Override
	public void augmenterUneEnchere(int id) {
		Annonce annonce = em.find(Annonce.class, id);
		annonce.setNombreEnchere(annonce.getNombreEnchere() + 1);
		em.merge(annonce);
	}

}
