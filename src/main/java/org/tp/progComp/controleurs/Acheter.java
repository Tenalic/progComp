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

	@PostMapping("/acheter")
	public String acheter(@RequestParam(value = "idAnnonce") String idAnnonce, HttpSession session, Model model) {
		System.out.println("idAnnonce : " + idAnnonce);
		// todo creer service pour acheter
		// todo faire une secu pour qu'on se puisse pas acheter ces propre annonce (dans le html et service)
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
				model.addAttribute("Annonce", annonce);
				Compte compte = (Compte) session.getAttribute("compte");
				if (compte != null) {
					model.addAttribute("compte", compte);
				}
				return "Annonce";
			}
		}
		return "home";
	}

}
