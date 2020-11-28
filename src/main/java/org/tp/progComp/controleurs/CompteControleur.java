package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.services.CompteService;
import org.tp.progComp.entities.Vente;

@Controller
public class CompteControleur {

	String CONNECTION = "connection";

	String COMPTE = "Compte";

	@Autowired
	CompteService compteService;

	@GetMapping("/monCompte")
	public String myCompte(HttpSession session, Model model) {
		Compte compte = (Compte) session.getAttribute("compte");
		if (compte != null) {
			Compte compteGet = compteService.findCompteByEmail(compte.getEmail());
			if (compteGet.isVendeur()) {
				if(!compteGet.getListeProduitEnVente().isEmpty()) {
					Iterable<Annonce> listeAnnonce = compteGet.getListeProduitEnVente();
					model.addAttribute("listeAnnonce", listeAnnonce);
				}
				if(!compteGet.getListeVente().isEmpty()) {
					Iterable<Vente> listeVente = compteGet.getListeVente();
					model.addAttribute("listeVente", listeVente);
				}
			}
			if (!compteGet.getListeAchat().isEmpty()) {
				Iterable<Vente> listeAchat = compteGet.getListeAchat();
				model.addAttribute("listeAchat", listeAchat);
			}
			model.addAttribute("compte", compte);
			return "Compte";
		}
		return "redirect:" + CONNECTION;
	}

}
