package com.rafael;

import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
 
@ServerEndpoint("/mensaje-2")
public class MiWebSocket2 {
	
	@OnMessage
	public String mensaje(String mensaje, Session session) {
		return "El mensaje: "+mensaje+ " proviene de la sesión: "+ session.getId();
	}

}
