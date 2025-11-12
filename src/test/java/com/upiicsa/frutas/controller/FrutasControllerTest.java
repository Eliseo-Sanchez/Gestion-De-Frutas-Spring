package com.upiicsa.frutas.controller;

import com.upiicsa.frutas.entities.Fruta;
import com.upiicsa.frutas.repositories.FrutasRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FrutasController.class)
class FrutasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FrutasRepositorio repo;

    @Test
    void listarFrutas_devuelveLista() throws Exception {
        Fruta f = new Fruta(1L, "Pera", 10, 5.0);
        when(repo.findAll()).thenReturn(List.of(f));

        mockMvc.perform(get("/frutas/listar"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("listaFrutas"))
                .andExpect(view().name("listar"));
    }

    @Test
    void guardarFruta_redirigeYGuarda() throws Exception {
        mockMvc.perform(post("/frutas/formulario")
                .param("nombre", "Manzana")
                .param("cantidad", "5")
                .param("precio", "2.5"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/frutas/listar"));

        verify(repo).save(any(Fruta.class));
    }
}
