package com.rafael.model;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable{
	
	private Integer salario;

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	
		

}
