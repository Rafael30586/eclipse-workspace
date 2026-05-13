package com.frafael.springsecuritypractica;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("rafael")
				.password("4567").roles("ADMIN").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("miguel")
				.password("123").roles("USER").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("fabiana")
				.password("389").roles("USER").build());
		return manager; //No se recomienda el withDefaultPasswordEncoder() para aplicaciones destinadas a la venta...
		//...o cuestiones importantes en general
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		   .authorizeHttpRequests(authorize->authorize.anyRequest().authenticated())
		   .formLogin(Customizer.withDefaults())
		   .httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	/*
	@Bean
	public PasswordEncoder passwordEncoder() { Esto me da error, probablemente sea porque mas arriba ya se usa un...
		return new BCryptPasswordEncoder(); ...encoder por defecto cuando se crean los usuarios
	}*/
	
}
