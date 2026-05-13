package com.frafael.springsecurityuncledave.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoControlador {
	
	@GetMapping("/saludo")
	public String saludar() {
		return "Hola mundo";
	}

}
