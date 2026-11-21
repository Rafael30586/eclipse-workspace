package com.rafael;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.websocket.OnMessage;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mensaje-3")
public class MiWebSocket3 {
	
	@OnMessage
	public String mensaje(String mensaje, HandshakeRequest handshakeRequest) {
		Map<String, List<String>> cabeceras = handshakeRequest.getHeaders();
		Set<String> nombreCabeceras = cabeceras.keySet();
		
		for(String nombreCabacera : nombreCabeceras) {
			System.out.println(nombreCabacera);
		}
		
		return mensaje;
	}

}
