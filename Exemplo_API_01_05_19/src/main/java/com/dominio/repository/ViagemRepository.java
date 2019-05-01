package com.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominio.entity.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {
	
	public Viagem findByLocalDeDestino(String localDeDestino);
	
}
