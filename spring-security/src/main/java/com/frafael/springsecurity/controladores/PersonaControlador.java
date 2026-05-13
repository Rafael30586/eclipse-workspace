package com.frafael.springsecurity.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frafael.springsecurity.entidades.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {
	
	@GetMapping
	public List<Persona> devolverPersonas(){
		return List.of(
				new Persona("Rafael",37),
				new Persona("Emanuel",32)
				);
	}

}
