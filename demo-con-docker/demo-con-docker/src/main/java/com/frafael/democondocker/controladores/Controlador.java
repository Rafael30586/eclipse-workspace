package com.frafael.democondocker.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controlador {
	
	@GetMapping("/saludo")
	public String saludar() {
		return "Hola docker";
	}

}
