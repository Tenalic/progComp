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
			if (compteService.findCompteByEmail(email) == null) {
				if (compteService.findCompteBySpeudo(speudo) == null) {
					String response = null;
					if ("oui".equals(vendeur)) {
						response = compteService.createCompte(nom, prenom, email, speudo, password, true);
					} else {
						response = compteService.createCompte(nom, prenom, email, speudo, password, false);
					}
					if (response != null) {
						return HOME;
					} else {
						model.addAttribute("error", "Erreur : problème lors de la creation du compte");
					}
				} else {
					model.addAttribute("error", "Erreur : speudo déjà utilisé");
				}
			} else {
				model.addAttribute("error", "Erreur : email déjà utilisé");
			}
		} else {
			model.addAttribute("error", "Erreur : champ nom remplie");
		}
		return INSCRIPTION;
	}

}
