package com.f_rafael.demoDockerYJPA.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.f_rafael.demoDockerYJPA.entidades.Persona;
import com.f_rafael.demoDockerYJPA.servicios.PersonaServicio;

@RestController
@RequestMapping("/api/personas")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicio personaServicio;
	
	@GetMapping("/todas")
	public List<Persona> mostrarTodas(){
		return personaServicio.devolverTodas();
	}
	
	@PostMapping(value = "/guardar",consumes = {"application/json","application/xml"})
	public void guardarUna(@RequestBody Persona persona) {
		personaServicio.guardarUna(persona);
	}
	
	@DeleteMapping("/borrar/{id}")
	public void borrarUna(@PathVariable Long id) {
		personaServicio.borrarUna(id);
	}
	
	@DeleteMapping("/borrar-todas")
	public void borrarTodas() {
		personaServicio.borrarTodas();
	}

}
