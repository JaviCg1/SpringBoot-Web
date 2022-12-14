package com.openwejavi.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Se auto asigna
public class ControladorPrincipal {

	@GetMapping("/") // Metodo se invoca cuando haces una peticion get
	public String welcome(@RequestParam(name="name", required=false, defaultValue="Mundo") String name, Model model) {
		
		model.addAttribute("nombre", name);
		return "index";

	}

	@GetMapping("/saludo")
	public String Saludo(Model model) {
		model.addAttribute("saludo", "Hoooooooooooooooooooooooooooooooooooooloooooooooooooooooooooooo");
		return "saludo";
	}
	
	
	@GetMapping("/saludo/{name}")
	public String SaludoMayor(@PathVariable String name, Model model) { //PathVariable cambia la ruta solicitada
		
		model.addAttribute("saludo", "Hoooooooooooooooooooooooooooooooooooooloooooooooooooooooooooooo "+name);
		return "saludo";
	}
}
