package com.openwejavi.spring.controladores;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.openwejavi.spring.modelo.Empleado;
import com.openwejavi.spring.servicios.EmpleadoService;
import com.openwejavi.spring.upload.storage.StorageFileNotFoundException;
import com.openwejavi.spring.upload.storage.StorageService;

@Controller // Se auto asigna
public class ControladorPrincipal {
	
	@Autowired
	private EmpleadoService servicio;
	
	@Autowired
	private  StorageService storageService;
	
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
	public String nuevoEmpleadoSubmit( @ModelAttribute("empleadoForm") Empleado nuevoEmpleado, Model model,
			BindingResult bindingresult, @RequestParam("file") MultipartFile file) {
		
		if(bindingresult.hasErrors()) {
			
			return "form";
			
		}else {
			if (!file.isEmpty()) {
				String avatar = storageService.store(file, nuevoEmpleado.getId());
				nuevoEmpleado.setImage(MvcUriComponentsBuilder.fromMethodName(ControladorPrincipal.class,
						"serveFile", avatar).build().toUriString());
			}
			servicio.add(nuevoEmpleado);
			
			return "redirect:/";
		}
		
		
	}
	
	
	@GetMapping("/empleado/edit/{id}")
	public String editarEmpleado(@PathVariable int id , Model model) {
		
		Empleado e = servicio.finById(id);
		if (e!=null) {
			model.addAttribute("empleadoForm", e);
			return "form";
		}else {
			return "redirect:/empleado/new";
		}
		
		
	}
	
	@PostMapping("/empleado/edit/submit")
	public String editarEmpleadoSubmit(@ModelAttribute("empleadoForm") Empleado editadoEmpleado, Model model,
			BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()) {
			
			return "form";
			
		}else {
			servicio.edit(editadoEmpleado);
			
			return "redirect:/";
		}
		
		
	}
	
	
	
	
	
	
	

	
	
	@GetMapping("/saludo/{name}")
	public String SaludoMayor(@PathVariable String name, Model model) { //PathVariable cambia la ruta solicitada
		
		model.addAttribute("saludo", "Hoooooooooooooooooooooooooooooooooooooloooooooooooooooooooooooo "+name);
		return "saludo";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/**@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}**/


	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().body(file);
	}


	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}
