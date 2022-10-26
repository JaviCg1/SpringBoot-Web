package com.openwejavi.spring.modelo;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



public class Empleado {
	
	@Min(2)
	private int id;
	private String nombre;
	private String email;
	
	private String telefono;
	private String edad;
	
	

	public Empleado(int id, String nombre, String email, String telefono, String edad) {
		
		
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado() {}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, email, id, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(edad, other.edad) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", edad=" + edad + ", id="
				+ id + "]";
	}

	
	

	
}
