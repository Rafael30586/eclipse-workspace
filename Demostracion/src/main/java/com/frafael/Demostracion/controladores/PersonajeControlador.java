package com.frafael.Demostracion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frafael.Demostracion.entidades.Personaje;
import com.frafael.Demostracion.servicios.PersonajeServicio;

@RestController
@RequestMapping("/api/personajes")
public class PersonajeControlador {
	
	@Autowired
	private PersonajeServicio personajeServicio;
	
	@GetMapping("/saludo") //funciona
	public String saludo() {
		return "Hola";
	}
	
	@GetMapping("/todos")
	public List<Personaje> mostrarTodos(){
		return personajeServicio.devolverTodos();
	}
	
	@PostMapping(value="/guardar",consumes={"application/json","application/xml"})
	public void guardarUno(@RequestBody Personaje personaje) {
		personajeServicio.guardarUno(personaje);
	}

}
