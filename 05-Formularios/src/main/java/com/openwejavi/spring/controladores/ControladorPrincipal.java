package com.openwejavi.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openwejavi.spring.modelo.Empleado;
import com.openwejavi.spring.servicios.EmpleadoService;

@Controller // Se auto asigna
public class ControladorPrincipal {
	
	@Autowired
	private EmpleadoService servicio;
	
	
	@GetMapping({"/", "empleado/list"})
	public String listado(Model model) {
		model.addAttribute("listaEmpleados", servicio.get());
		return "index";
	}
	
	@GetMapping("/empleado/new")
	public String nuevoEmpleado(Model model) {
		model.addAttribute("empleadoForm", new Empleado());
		return "form";
	}
	
	@PostMapping("/empleado/new/submit")
	public String nuevoEmpleadoSubmit(@ModelAttribute("empleadoForm") Empleado nuevoEmpleado, Model model) {
		servicio.add(nuevoEmpleado);
		
		return "redirect:/";
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	@GetMapping("/saludo/{name}")
	public String SaludoMayor(@PathVariable String name, Model model) { //PathVariable cambia la ruta solicitada
		
		model.addAttribute("saludo", "Hoooooooooooooooooooooooooooooooooooooloooooooooooooooooooooooo "+name);
		return "saludo";
	}
}
