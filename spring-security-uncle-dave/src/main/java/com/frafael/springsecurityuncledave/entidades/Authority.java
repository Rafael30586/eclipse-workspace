package com.frafael.springsecurityuncledave.entidades;

import com.frafael.springsecurityuncledave.utils.AuthorityName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name="authorities")
@Getter
@Setter
@AllArgsConstructor
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private AuthorityName name;

}
