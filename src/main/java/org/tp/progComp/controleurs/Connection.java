package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.services.CompteService;

@Controller
public class Connection {

	private String CONNECTION = "connection";

	private String HOME = "home";

	@Autowired
	private CompteService compteService;

	@GetMapping("/connection")
	public String connectionGet() {
		return CONNECTION;
	}

	@PostMapping("/connection")
	public String connectionPost(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, Model model, HttpSession session) {
		if (email != null && password != null) {
			Compte compte = this.compteService.Connection(email, password);
			if (compte != null) {
				session.setAttribute("compte", compte);
				model.addAttribute("compte", compte);
				return "redirect:" + HOME;
			}
		}
		model.addAttribute("error", "Erreur : nom de compte ou mot de passe incorecte");
		return CONNECTION;
	}

}
