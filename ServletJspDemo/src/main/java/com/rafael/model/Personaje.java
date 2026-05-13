package com.rafael.model;

public class Personaje {
	
	private int pid;
	private String nombre;
	private String apodo;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	@Override
	public String toString() {
		return "Personaje [pid=" + pid + ", nombre=" + nombre + ", apodo=" + apodo + "]";
	}
	
	

}
