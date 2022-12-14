package com.openwejavi.spring.servicios;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.openwejavi.spring.modelo.Empleado;

@Service
public class EmpleadoService {

	private ArrayList<Empleado> repositorio = new ArrayList<Empleado>();
	
	public void add(Empleado e) {
		repositorio.add(e);
	}
	
	public ArrayList<Empleado> get(){
		return repositorio;
	}
	
	@PostConstruct
	public void init() {
		repositorio.addAll(
				Arrays.asList(new Empleado("1", "Pepe", "pepe@gmail.com", "6600111111", "33"),
								new Empleado("2", "Manolo", "manolo@gmail.com", "62517623843", "21"),
								new Empleado("3", "Juan", "juan@gmail.com", "647382923", "45"))
				);
	}
	
}
