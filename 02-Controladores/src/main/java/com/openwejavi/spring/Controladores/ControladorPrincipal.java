package com.openwejavi.spring.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Se auto asigna
public class ControladorPrincipal {

	@GetMapping("/") // Metodo se invoca cuando haces una peticion get
	public String welcome(Model model) {
		model.addAttribute("mensaje", "Hola a todos");
		return "index";

	}

	@GetMapping("/saludo")
	public String Saludo(Model model) {
		model.addAttribute("saludo", "Hoooooooooooooooooooooooooooooooooooooloooooooooooooooooooooooo");
		return "saludo";
	}
}
