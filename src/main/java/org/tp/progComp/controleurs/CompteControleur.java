package org.tp.progComp.controleurs;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.services.CompteService;

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
			Iterable<Annonce> listeAnnonce = compteGet.getListeProduitEnVente();
			model.addAttribute("compte", compte);
			model.addAttribute("listeAnnonce", listeAnnonce);
			for(Annonce annonce : listeAnnonce) {
				System.out.println(annonce.getDescription());
			}
			return "Compte";
		}
		return "redirect:" + CONNECTION;
	}

}
