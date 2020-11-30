package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.services.AnnonceService;

@Controller
public class Acheter {

	@Autowired
	private AnnonceService annonceService;

	@PostMapping("/encherir")
	public String enchere(@RequestParam(value = "idAnnonce") String idAnnonce,
			@RequestParam(value = "enchere") int enchere, HttpSession session) {
		Compte compte = (Compte) session.getAttribute("compte");
		Integer idAnnonceInt = null;
		try {
			idAnnonceInt = Integer.parseInt(idAnnonce);
		} catch (Exception e) {
			idAnnonceInt = null;
		}
		if (compte != null && idAnnonceInt != null) {
			int id = idAnnonceInt;
			annonceService.encherir(compte.getSpeudo(), id, enchere);
			return "redirect:home";
		}
		return "Annonce";
	}

	@PostMapping("/acheter")
	public String acheter(@RequestParam(value = "idAnnonce") String idAnnonce, HttpSession session, Model model) {
		Compte compte = (Compte) session.getAttribute("compte");
		Integer idAnnonceInt = null;
		try {
			idAnnonceInt = Integer.parseInt(idAnnonce);
		} catch (Exception e) {
			idAnnonceInt = null;
		}
		if (compte != null && idAnnonceInt != null) {
			int id = idAnnonceInt;
			annonceService.acheterAnnonce(compte.getSpeudo(), id);
		}
		return "redirect:home";
	}

	@PostMapping("/supprimer")
	public String supprimerAnnonce(@RequestParam(value = "idAnnonce") String idAnnonce, HttpSession session,
			Model model) {
		Compte compte = (Compte) session.getAttribute("compte");
		Integer idAnnonceInt = null;
		try {
			idAnnonceInt = Integer.parseInt(idAnnonce);
		} catch (Exception e) {
			idAnnonceInt = null;
		}
		if (compte != null && idAnnonceInt != null) {
			int id = idAnnonceInt;
			annonceService.supprimerAnnonce(id, compte.getSpeudo());
		}
		return "redirect:home";
	}

	@GetMapping("/acheter")
	public String acheterGet(@PathParam(value = "id") String id, HttpSession session, Model model) {
		if (id != null) {
			Annonce annonce = null;
			try {
				annonce = annonceService.getAnnonce(Integer.parseInt(id));
			} catch (Error e) {
				annonce = null;
			} catch (Exception e) {
				annonce = null;
			}
			if (annonce != null) {
				String devise = (String) session.getAttribute("devise");
				if (devise == null) {
					devise = "€";
				}
				model.addAttribute("devise", devise);
				switch (devise) {
				case "$":
					annonce.setPrix(annonceService.euroToDollar(annonce.getPrix()));
					break;
				}
				model.addAttribute("Annonce", annonce);
				Compte compte = (Compte) session.getAttribute("compte");
				if (compte != null) {
					model.addAttribute("compte", compte);
					if (compte.getSpeudo().equals(annonce.getVendeur().getSpeudo())) {
						model.addAttribute("supprimer", true);
					} else {
						model.addAttribute("supprimer", false);
						if (annonce.isEnchere()) {
							model.addAttribute("enchereMin", annonce.getPrix() + 1);
						}
					}
				}
				model.addAttribute("dollar", annonceService.euroToDollar(annonce.getPrix()));
				return "Annonce";
			}
		}
		return "redirect:home";
	}

}
