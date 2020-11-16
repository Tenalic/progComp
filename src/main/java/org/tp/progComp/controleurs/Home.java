package org.tp.progComp.controleurs;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.entities.Produit;
import org.tp.progComp.services.ProduitService;

@Controller
public class Home {
	
	@Autowired
	ProduitService produitService;

	@RequestMapping("/")
	public String link() {
		return "Link";
	}

	@RequestMapping("/home")
	public String home(RedirectAttributes attributes, Model model, HttpSession session) {
		Compte compte = (Compte) session.getAttribute("compte");
		if (compte != null) {
			model.addAttribute("compte", compte);
		}
		return "Home";
	}

	@GetMapping("/deconnexion")
	public String deconnexion(HttpSession session) {
		session.removeAttribute("compte");
		return "redirect:home";
	}

	@PostMapping("/home")
	public String rechercheVente(@RequestParam(value = "nomProduit", required = true) String nomProduit,
			HttpSession session, Model model) {
		System.out.println("aa");
		Produit produit = produitService.findByNomProduit("test2");

		if (produit == null) {
			System.out.println("c'est null");
		} else {
			System.out.println("c'est pas null");
		}
		if (produit != null) {
			// juste test avec 1 seul
			model.addAttribute("produit", produit);
			System.out.println(produit.getPseudoVendeur());
			return "Home";
			// Faire tableau dynamique
		} else {
			model.addAttribute("error", "Erreur : champs nom remplies");
			return "Home";
			// afficher pas de resultat;
		}

	}

}
