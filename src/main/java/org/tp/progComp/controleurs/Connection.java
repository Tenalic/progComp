package org.tp.progComp.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.tp.progComp.entities.Compte;
import org.tp.progComp.services.CompteService;

@Controller
public class Connection {

	private String CONNECTION = "Connection";

	private String HOME = "Home";

	@Autowired
	private CompteService compteService;

	@RequestMapping("/")
	public String link() {
		return "Link";
	}

	@RequestMapping("/connection")
	public String connectionGet() {
		return CONNECTION;
	}

	@PostMapping("/connection")
	public String connectionPost(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, Model model/*, RedirectAttributes attributes*/) {
		if (email != null && password != null) {
			Compte compte = this.compteService.Connection(email, password);
			if (compte != null) {
				//attributes.addAttribute("compte", compte);
				model.addAttribute("compte", compte);
				//return new RedirectView(HOME);
				return HOME;
			}
		}
		model.addAttribute("error", "Erreur : nom de compte ou mot de passe incorecte");
		//return new RedirectView(CONNECTION);
		return CONNECTION;
	}
	
	@RequestMapping("/home")
	public String home(RedirectAttributes attributes, Model model) {
		model.addAttribute("compte", attributes.getAttribute("compte"));
		return "Home";
	}

}
