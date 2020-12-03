package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.services.CompteService;
import org.tp.progComp.services.Utils;
import org.tp.progComp.entities.Vente;

@Controller
public class CompteControleur {

	String CONNECTION = "connection";

	String COMPTE = "Compte";

	@Autowired
	Utils utils;

	@Autowired
	CompteService compteService;

	@GetMapping("/monCompte")
	public String myCompte(HttpSession session, Model model) {
		Compte compte = (Compte) session.getAttribute("compte");
		String devise = (String) session.getAttribute("devise");
		if (devise != null) {
			model.addAttribute("devise", devise);
		} else {
			model.addAttribute("devise", "€");
			devise = "€";
		}
		if (compte != null) {
			Compte compteGet = compteService.findCompteByEmail(compte.getEmail());
			if (compteGet.isVendeur()) {
				if (!compteGet.getListeProduitEnVente().isEmpty()) {
					Iterable<Annonce> listeAnnonce = compteGet.getListeProduitEnVente();
					listeAnnonce = utils.changerPrixAnnonce(listeAnnonce, devise);
					model.addAttribute("listeAnnonce", listeAnnonce);
				}
				if (!compteGet.getListeVente().isEmpty()) {
					Iterable<Vente> listeVente = compteGet.getListeVente();
					listeVente = utils.changerPrixVente(listeVente, devise);
					model.addAttribute("listeVente", listeVente);
				}
			}
			if (!compteGet.getListeAchat().isEmpty()) {
				Iterable<Vente> listeAchat = compteGet.getListeAchat();
				listeAchat = utils.changerPrixVente(listeAchat, devise);
				model.addAttribute("listeAchat", listeAchat);
			}
			model.addAttribute("compte", compte);
			return "Compte";
		}
		return "redirect:" + CONNECTION;
	}

}
