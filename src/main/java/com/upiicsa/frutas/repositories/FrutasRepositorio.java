package com.upiicsa.frutas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upiicsa.frutas.entities.Fruta;

public interface FrutasRepositorio extends JpaRepository<Fruta, Long> {
}
