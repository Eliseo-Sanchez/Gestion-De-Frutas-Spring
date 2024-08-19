package com.upiicsa.frutas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.upiicsa.frutas.entities.Fruta;
import com.upiicsa.frutas.repositories.FrutasRepositorio;

public class FrutaServiceImpl implements FrutaService {

    @Autowired
    private FrutasRepositorio repo;

    @Override
    public List<Fruta> obtenerTodas() {
        return repo.findAll();
    }

    @Override
    public Fruta obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Fruta crearFruta(Fruta fruta) {
        return repo.save(fruta);
    }

    @Override
    public Fruta actualizarFruta(Long id, Fruta fruta) {
        Fruta nuevaFruta = repo.findById(id).orElse(null);

        if (nuevaFruta != null) {
            nuevaFruta.setNombre(fruta.getNombre());
            nuevaFruta.setCantidad(fruta.getCantidad());
            nuevaFruta.setPrecio(fruta.getPrecio());
            return repo.save(nuevaFruta);
        }
        return null;
    }

    @Override
    public void eliminarFruta(Long id) {
        repo.deleteById(id);
    }

}
