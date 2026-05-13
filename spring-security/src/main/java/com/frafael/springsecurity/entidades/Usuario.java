package com.frafael.springsecurity.entidades;

public class Usuario {
	
	private Long id;
	private String nombre;
	private boolean registrado;
	
	public Usuario(Long id, String nombre, boolean registrado) {
		
		this.id = id;
		this.nombre = nombre;
		this.registrado = registrado;
	}

	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", registrado=" + registrado + "]";
	}
	
}
