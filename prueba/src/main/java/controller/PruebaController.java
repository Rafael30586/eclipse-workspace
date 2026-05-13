package controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRafael.prueba.entidades.Entidad;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PruebaController {
	
	@GetMapping("/saludo")
	public String saludar() {
		return "Hello world";
	}
	
	@GetMapping("/entidades")
	public List<Entidad> mostrarEntidades(){
		return List.of(new Entidad(3,"SSSS",true),new Entidad(6,"HHHH",false),new Entidad(12,"YYYY",true));
	}

}
