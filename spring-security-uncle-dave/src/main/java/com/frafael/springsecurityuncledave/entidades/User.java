package com.frafael.springsecurityuncledave.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_authority",
	          joinColumns = @JoinColumn(name="user_id")
			)
	private List<Authority> authorities;

}
