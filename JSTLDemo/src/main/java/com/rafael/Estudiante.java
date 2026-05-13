package com.rafael;

public class Estudiante {
	
	int nroDeRol;
	String nombre;
	

	public Estudiante(int nroDeRol, String nombre) {
		super();
		this.nroDeRol = nroDeRol;
		this.nombre = nombre;
	}


	public int getNroDeRol() {
		return nroDeRol;
	}


	public void setNroDeRol(int nroDeRol) {
		this.nroDeRol = nroDeRol;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Estudiante [nroDeRol=" + nroDeRol + ", nombre=" + nombre + "]";
	}
	
	
	
	

}
