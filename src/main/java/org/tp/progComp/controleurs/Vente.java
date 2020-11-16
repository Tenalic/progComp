package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.entities.Produit;
import org.tp.progComp.services.ProduitService;

@Controller
public class Vente {

	private String VENTE = "Vente";

	private String HOME = "Home";

	
	//produitService
	
	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/vente")
	public String venteGet()
	{
		return VENTE;
	}
	
	public String notUser(HttpSession session) {
		if((Compte) session.getAttribute("compte")== null)
		{
			return "redirect:connection";  
		}
		return VENTE;
		
	}
	
	
	@PostMapping("/vente")
	public String ventePost(@RequestParam(value = "nomProduit", required = true) String nomProduit,
			@RequestParam(value = "categorie", required = true) String categorie,
			@RequestParam(value = "miniCategorie", required = true) String miniCategorie,
			Model model, HttpSession session) {
		if (nomProduit != null && categorie != null && miniCategorie != null ) {
					Compte compte = (Compte) session.getAttribute("compte");
					Produit produit = null;
					if (compte == null) {
						model.addAttribute("error", "Erreur : problème lors de la creation du compte");
					} else {
						produit = produitService.createProduit(nomProduit, categorie, miniCategorie, compte.getSpeudo());
						model.addAttribute("produit", produit);
						
					}
		} else {
			model.addAttribute("error", "Erreur : champs nom remplies");
		}
		return VENTE;
	}
	
	
}
