package com.rafael;

import jakarta.websocket.OnMessage;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mensaje")
public class MiWebSocket {
	
	@OnMessage
	public String mensaje(String mensaje) {
		return "Hola desde el sevidor "+mensaje;
	}

}
