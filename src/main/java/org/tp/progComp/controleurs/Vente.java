package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.entities.Produit;
import org.tp.progComp.services.AnnonceService;
import org.tp.progComp.services.ProduitService;

@Controller
public class Vente {

	private String VENTE = "Vente";

	// produitService

	@Autowired
	private ProduitService produitService;

	@Autowired
	private AnnonceService annonceService;

	@GetMapping("/vente")
	public String venteGet() {
		return VENTE;
	}

	@GetMapping("/mise_en_vente")
	public String mettreEnVente(HttpSession session) {
		Compte compte = (Compte) session.getAttribute("compte");
		if (compte != null && compte.isVendeur()) {
			return "Mettre_en_vente";
		}
		return "redirect:connection";
	}

	@PostMapping("/mise_en_vente")
	public String mettreEnVente(@RequestParam(value = "nomProduit", required = true) String nomProduit,
			@RequestParam(value = "categorie", required = true) String categorie,
			@RequestParam(value = "miniCategorie") String miniCategorie,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "prix", required = true) float prix,
			@RequestParam(value = "enchere", required = true) String enchere, Model model, HttpSession session) {
		Compte compte = (Compte) session.getAttribute("compte");
		if (compte != null) {
			Produit produit = produitService.createProduit2(nomProduit, categorie, miniCategorie, compte.getSpeudo());
			if (produit != null) {
				Annonce annonce = null;
				if ("oui".equals(enchere)) {
					annonce = new Annonce(description, produit, compte, prix, true);
				} else {
					annonce = new Annonce(description, produit, compte, prix, false);
				}
				Annonce result = null;
				if (annonce != null) {
					result = annonceService.createAnnonce(annonce);
				}
				if (result != null) {
					return "redirect:home";
				} else {
					model.addAttribute("error", "Erreur lors de la creation de l'annonce");
				}
			} else {
				model.addAttribute("error", "Erreur lors de la creation de l'objet");
			}

		} else {
			model.addAttribute("error", "erreur : non connecté");
		}
		return "Mettre_en_vente";
	}

}
