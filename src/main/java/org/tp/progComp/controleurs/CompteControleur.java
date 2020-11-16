package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tp.progComp.entities.Compte;

@Controller
public class CompteControleur {

	String CONNECTION = "connection";

	String COMPTE = "Compte";

	@GetMapping("/monCompte")
	public String myCompte(HttpSession session, Model model) {
		Compte compte = (Compte) session.getAttribute("compte");
		if (compte != null) {
			model.addAttribute("compte", compte);
			return "Compte";
		}
		return "redirect:" + CONNECTION;
	}

}
