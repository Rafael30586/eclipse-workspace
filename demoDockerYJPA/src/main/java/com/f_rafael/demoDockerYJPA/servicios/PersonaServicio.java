package com.f_rafael.demoDockerYJPA.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f_rafael.demoDockerYJPA.entidades.Persona;
import com.f_rafael.demoDockerYJPA.repositorios.PersonaRepositorio;

@Service
public class PersonaServicio {
	
	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	public List<Persona> devolverTodas(){
		/*
		List<Persona> personas; 
		personas = personaRepositorio.findAll();
		return personas;*/
		return personaRepositorio.findAll();
	}
	
	public void guardarUna(Persona persona) {
		personaRepositorio.save(persona);
	}
	
	public void borrarUna(Long id) {
		personaRepositorio.deleteById(id);
	}
	
	public void borrarTodas() {
		personaRepositorio.deleteAll();
	}

}
