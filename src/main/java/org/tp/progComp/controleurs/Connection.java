package org.tp.progComp.controleurs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Connection {

	private String CONNECTION = "Connection";

	private String HOME = "Home";

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
			@RequestParam(value = "password", required = true) String password, Model model) {
		if ("a@gmail.com".equals(email) && "123".equals(password)) {
			model.addAttribute("email", email);
			model.addAttribute("password", password);
			return HOME;
		}
		model.addAttribute("error", "Erreur : nom de compte ou mot de passe incorecte");
		return CONNECTION;
	}

}
