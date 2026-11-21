package com.rafael;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mensaje/{guest-id}")
public class MiWebSocket {
	
	@OnMessage
	public String mensaje(@PathParam("guest-id") String guestId ,String mensaje) { // La anotación PathParam sirve con Strings y datos primitivos
		return "El mensaje "+mensaje+ " del huésped "+guestId+ " ha sido recibido";
	}
	
	@OnClose // Esta anotacón sirve para realizar una acción cuando se cierra la sesión
	public void alCerrar() {
		System.out.println("Cerrando conexión");
	}
	
	@OnOpen // Esta anotación sirve para realizar una acción cuando se abre una sesión
	public void alAbrirConexion() {
		System.out.println("Abriendo conexión");
	}

}
