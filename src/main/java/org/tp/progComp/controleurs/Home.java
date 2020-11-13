package org.tp.progComp.controleurs;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tp.progComp.entities.Compte;

@Controller
public class Home {

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
}
