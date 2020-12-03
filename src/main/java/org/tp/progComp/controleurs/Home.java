package org.tp.progComp.controleurs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.entities.Produit;
import org.tp.progComp.services.AnnonceService;
import org.tp.progComp.services.ProduitService;

@Controller
public class Home {

	@Autowired
	ProduitService produitService;

	@Autowired
	AnnonceService annonceService;

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

	@GetMapping("/home")
	public String afficherAnnonce(Model model, HttpSession session) {
		final List<Annonce> a = new ArrayList<Annonce>();
		String devise = (String) session.getAttribute("devise");
		if (devise != null) {
			model.addAttribute("devise", devise);
		} else {
			model.addAttribute("devise", "€");
			devise = "€";
		}
		model.addAttribute("compte", (Compte) session.getAttribute("compte"));
		Iterable<Annonce> itr = annonceService.getAllAnnonce();
		for (Annonce an : itr) {
			switch (devise) {
			case "$":
				an.setPrix(annonceService.euroToDollar(an.getPrix()));
				break;
			}
			a.add(an);
		}
		model.addAttribute("listeAnnonce", a);
		return "Home";
	}

	@PostMapping("/home")
	public String recherche1Annonce(@RequestParam(value = "nomProduit", required = true) String nomProduit,
			HttpSession session, Model model, RedirectAttributes attributes) {
		ArrayList<Annonce> a = new ArrayList<Annonce>();
		String devise = (String) session.getAttribute("devise");
		if (devise != null) {
			model.addAttribute("devise", devise);
		} else {
			model.addAttribute("devise", "€");
			devise = "€";
		}
		model.addAttribute("compte", (Compte) session.getAttribute("compte"));
		Iterable<Annonce> itr = annonceService.getAllAnnonce();
		ArrayList<Produit> listProduit = produitService.findByNomProduit(nomProduit);
		for (Annonce an : itr) {
			if (listProduit.contains(an.getProduit())) {
				switch (devise) {
				case "$":
					an.setPrix(annonceService.euroToDollar(an.getPrix()));
					break;
				}
				a.add(an);
			}

		}
		model.addAttribute("retour", true);
		model.addAttribute("listeAnnonce", a);
		return "Home";
	}

	@PostMapping("Home")
	public String rechercheCategorie(@RequestParam(value = "categorie", required = true) String categorie,
			HttpSession session, Model model, RedirectAttributes attributes) {
		model.addAttribute("compte", (Compte) session.getAttribute("compte"));
		String devise = (String) session.getAttribute("devise");
		if (devise != null) {
			model.addAttribute("devise", devise);
		} else {
			model.addAttribute("devise", "€");
			devise = "€";
		}
		Iterable<Annonce> itr = annonceService.getAllAnnonce();
		ArrayList<Annonce> listAnnonce = new ArrayList<Annonce>();
		ArrayList<Produit> listProduit = produitService.findByCategorie(categorie);
		for (Annonce an : itr) {
			if (listProduit.contains(an.getProduit())) {
				switch (devise) {
				case "$":
					an.setPrix(annonceService.euroToDollar(an.getPrix()));
					break;
				}
				listAnnonce.add(an);
			}

		}
		model.addAttribute("retour", true);
		model.addAttribute("listeAnnonce", listAnnonce);
		return "Home";
	}

	@GetMapping("/changer_devise")
	public String changerDevise(@RequestParam(value = "devise") String devise, HttpSession session, Model model) {
		session.setAttribute("devise", devise);
		return "redirect:home";
	}

}
