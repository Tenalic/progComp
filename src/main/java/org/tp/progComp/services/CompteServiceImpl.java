package org.tp.progComp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tp.progComp.bdd.CompteConnectionRepository;
import org.tp.progComp.bdd.CompteRepository;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.entities.CompteConnection;

@Service
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private CompteConnectionRepository compteConnectionRepository;

	@Autowired
	private Utils ultils;

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
	public Compte createCompte(String nom, String prenom, String email, String speudo, String motDePasse,
			Boolean vendeur) {
		if (this.findCompteByEmail(email) == null && this.findCompteBySpeudo(speudo) == null) {
			compteConnectionRepository.save(new CompteConnection(email, motDePasse));
			return compteRepository.save(new Compte(nom, prenom, email, speudo, true, vendeur));
		} else {
			return null;
		}
	}

	@Override
	public Compte Connection(String email, String password) {
		CompteConnection compteConnection = this.compteConnectionRepository.findByEmail(email);
		if (compteConnection != null) {
			if (compteConnection.getPassword().equals(ultils.generateHash(password))) {
				return this.compteRepository.findByEmail(email);
			}
		}
		return null;
	}

}
