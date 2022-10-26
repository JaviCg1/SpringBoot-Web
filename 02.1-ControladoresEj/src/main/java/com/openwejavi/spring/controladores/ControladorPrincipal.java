package com.openwejavi.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Tienda de Madalenas");
		return "index";
	}
	
	@GetMapping("/que")
	public String que(Model model) {
		model.addAttribute("que", "Que Ofrecemos");
		return "que";
	}
	
	@GetMapping("/contacto")
	public String contacto(Model model) {
		model.addAttribute("contacto", "Puedes contactarnos con: ");
		return "contacto";
	}
}
