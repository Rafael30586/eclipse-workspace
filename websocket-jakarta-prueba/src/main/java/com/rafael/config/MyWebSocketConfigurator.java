package com.rafael.config;

import jakarta.websocket.server.ServerEndpointConfig;

public class MyWebSocketConfigurator extends ServerEndpointConfig.Configurator{
	
	@Override
    public boolean checkOrigin(String origin) {

        return "*".equals(origin);
    }

}
