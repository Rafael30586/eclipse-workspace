package com.frafael.springsecurity.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frafael.springsecurity.entidades.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
	
	@GetMapping
	public List<Usuario> devolverUsuarios(){
		return List.of(
				new Usuario(56L,"Monica",true),
				new Usuario(109L,"Fabián",false)
				);
	}

}
