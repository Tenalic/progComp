package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.services.CompteService;
import org.tp.progComp.services.Utils;

@Controller
public class Inscription {

	@Autowired
	private CompteService compteService;

	@Autowired
	private Utils utils;

	private String INSCRIPTION = "Inscription";

	private String HOME = "home";

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
			@RequestParam(value = "vendeur") String vendeur, Model model, HttpSession session) {
		if (nom != null && prenom != null && speudo != null && email != null && password != null) {
			if (compteService.findCompteByEmail(email) == null) {
				if (compteService.findCompteBySpeudo(speudo) == null) {
					Compte compte = null;
					if ("oui".equals(vendeur)) {
						compte = compteService.createCompte(nom, prenom, email, speudo, utils.generateHash(password),
								true);
					} else {
						compte = compteService.createCompte(nom, prenom, email, speudo, utils.generateHash(password),
								false);
					}
					if (compte != null) {
						session.setAttribute("compte", compte);
						model.addAttribute("compte", compte);
						return "redirect:" + HOME;
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
			model.addAttribute("error", "Erreur : champs nom remplies");
		}
		return INSCRIPTION;
	}

}
