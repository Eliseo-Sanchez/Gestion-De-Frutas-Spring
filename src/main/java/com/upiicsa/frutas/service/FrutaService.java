package com.upiicsa.frutas.service;

import java.util.List;

import com.upiicsa.frutas.entities.Fruta;

public interface FrutaService {

    List<Fruta> obtenerTodas();

    Fruta obtenerPorId(Long id);

    Fruta crearFruta(Fruta fruta);

    Fruta actualizarFruta(Long id, Fruta fruta);

    void eliminarFruta(Long id);

}
