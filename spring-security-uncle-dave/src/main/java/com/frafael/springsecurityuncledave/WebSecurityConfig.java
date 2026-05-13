package com.frafael.springsecurityuncledave;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {//Administrador de credenciales de usuario
		
		var user = User.withUsername("rafael")
				.password("789")
				.roles("read")
				.build();
		
		return new InMemoryUserDetailsManager(); 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() { //Maneja las contrasenias
		return NoOpPasswordEncoder.getInstance();
	}

}
