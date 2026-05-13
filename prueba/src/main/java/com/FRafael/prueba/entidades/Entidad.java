package com.FRafael.prueba.entidades;

public class Entidad {
	
	private int id;
	private String nombre;
	private boolean bool;
	
	public Entidad(int id, String nombre, boolean bool) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.bool = bool;
	}
	
	public Entidad() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	@Override
	public String toString() {
		return "Entidad [id=" + id + ", nombre=" + nombre + ", bool=" + bool + "]";
	}
	
	
	

}
