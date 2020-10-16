package org.tp.progComp.controleurs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Inscription {

	private String INSCRIPTION = "Inscription";
	
	private String HOME = "Home";
	
	@GetMapping("/inscription")
	public String inscriptionGet() {
		return INSCRIPTION;
	}
	
	@PostMapping("/inscription")
	public String inscriptionPost() {
		return HOME;
	}

}
