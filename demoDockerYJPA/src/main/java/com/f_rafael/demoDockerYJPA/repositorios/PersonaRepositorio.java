package com.f_rafael.demoDockerYJPA.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f_rafael.demoDockerYJPA.entidades.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona,Long>{

}
