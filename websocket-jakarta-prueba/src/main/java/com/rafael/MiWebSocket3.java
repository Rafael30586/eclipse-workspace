package com.rafael;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rafael.config.MyWebSocketConfigurator;

import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/mensaje-3", configurator = MyWebSocketConfigurator.class)
public class MiWebSocket3 {
	
	@OnMessage
	public String mensaje(String mensaje) {	
		return mensaje;
	}
    // Probar un cliente websocket con esta clase
}
