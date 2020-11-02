package org.tp.progComp.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tp.progComp.services.CompteService;

@Controller
public class Inscription {

	@Autowired
	CompteService compteService;

	private String INSCRIPTION = "Inscription";

	private String HOME = "Home";

	@GetMapping("/inscription")
	public String inscriptionGet() {
		return INSCRIPTION;
	}

	@PostMapping("/inscription")
	public String inscriptionPost(@RequestParam(value = "nom", required = true) String nom,
			@RequestParam(value = "prenom", required = true) String prenom,
			@RequestParam(value = "speudo", required = true) String speudo,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "vendeur") String vendeur, Model model) {
		if (nom != null && prenom != null && speudo != null && email != null && password != null) {
			System.out.println("ici1");
			if ("oui".equals(vendeur)) {
				System.out.println("ici2");
				compteService.createCompte(nom, prenom, email, speudo, password, true);
			} else {
				System.out.println("ici3");
				compteService.createCompte(nom, prenom, email, speudo, password, false);
			}/*
			if (compteService.findCompteByEmail(email) == null) {
				if (compteService.findCompteBySpeudo(speudo) == null) {
					if ("oui".equals(vendeur)) {
						compteService.createCompte(nom, prenom, email, speudo, password, true);
					} else {
						compteService.createCompte(nom, prenom, email, speudo, password, false);
					}
					return HOME;
				} else {
					model.addAttribute("error", "Erreur : speudo deja utilisé");
				}
			} else {
				model.addAttribute("error", "Erreur : email deja utilisé");
			}*/
		} else {
			model.addAttribute("error", "Erreur : champ nom valide");
		}
		return INSCRIPTION;
	}

}
