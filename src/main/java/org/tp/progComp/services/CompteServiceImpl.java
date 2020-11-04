package org.tp.progComp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tp.progComp.bdd.CompteRepository;
import org.tp.progComp.entities.Compte;

@Service
public class CompteServiceImpl implements CompteService {

	@Autowired
	CompteRepository compteRepository;

	@Override
	public Compte findCompteByEmail(String email) {
		System.out.println("Compte");
		return compteRepository.findByEmail(email);
	}

	@Override
	public Compte findCompteBySpeudo(String speudo) {
		System.out.println("Speudo");
		return compteRepository.findBySpeudo(speudo);
	}

	@Transactional
	public String createCompte(String nom, String prenom, String email, String speudo, String motDePasse, Boolean vendeur) {
		if(this.findCompteByEmail(email) == null && this.findCompteBySpeudo(speudo) == null) {
			return compteRepository.save(new Compte(nom, prenom, email, speudo, true, vendeur)).getSpeudo();
		} else {
			return null;
		}
	}
	
}
