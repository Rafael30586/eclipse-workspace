package com.frafael.Demostracion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frafael.Demostracion.entidades.Personaje;
import com.frafael.Demostracion.repositorio.PersonajeRepositorio;

@Service
public class PersonajeServicio {
	
	@Autowired
	private PersonajeRepositorio personajeRepositorio;
	
	public List<Personaje> devolverTodos(){
		return personajeRepositorio.findAll();
	}
	
	public void guardarUno(Personaje personaje) {
		personajeRepositorio.save(personaje);
	
	}

}
