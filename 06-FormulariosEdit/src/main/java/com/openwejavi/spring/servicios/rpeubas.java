package com.openwejavi.spring.servicios;

import java.util.ArrayList;
import java.util.Arrays;

import com.openwejavi.spring.modelo.Empleado;

public class rpeubas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Empleado> repositorio = new ArrayList<Empleado>();
		repositorio.addAll(
				Arrays.asList(new Empleado(1, "Pepe", "pepe@gmail.com", "6600111111", "33"),
								new Empleado(2, "Manolo", "manolo@gmail.com", "62517623843", "21"),
								new Empleado(3, "Juan", "juan@gmail.com", "647382923", "45"))
				);
		
		
		Empleado emp = new Empleado();
		emp.setId(99);
		Boolean encontrado=false;
		for (Empleado e : repositorio) {
			if (e.getId()==2) {
				e.setId(99);
				encontrado = true;
				break;
			}
		}
		System.out.println(repositorio.toString());
		System.out.println(encontrado);
	}

}
