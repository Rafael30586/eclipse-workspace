package com.frafael.Demostracion.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.frafael.Demostracion.entidades.Personaje;

@Repository
public interface PersonajeRepositorio extends MongoRepository<Personaje, String>{

}
