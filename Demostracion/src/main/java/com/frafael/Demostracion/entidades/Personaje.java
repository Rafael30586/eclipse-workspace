package com.frafael.Demostracion.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="characters")
public class Personaje {
	
	@Id
	private String id;
	private String name;
	private boolean esBueno;
	
	public Personaje(String id, String name, boolean esBueno) {
		this.id = id;
		this.name = name;
		this.esBueno = esBueno;
	}

	public Personaje() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEsBueno() {
		return esBueno;
	}

	public void setEsBueno(boolean esBueno) {
		this.esBueno = esBueno;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id + ", name=" + name + ", esBueno=" + esBueno + "]";
	}
	
}
