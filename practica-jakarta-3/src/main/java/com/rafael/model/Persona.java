package com.rafael.model;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private String nombres;
	private String apellido;
	
	public Persona() {
	}

	public Persona(String nombres, String apellido) {
		this.nombres = nombres;
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
