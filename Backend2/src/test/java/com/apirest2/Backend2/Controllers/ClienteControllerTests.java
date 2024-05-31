package com.apirest2.Backend2.Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.http.MediaType;


import com.apirest2.Backend2.controllers.cliente_controller;
import com.apirest2.Backend2.models.cliente;
import com.apirest2.Backend2.repositories.cliente_repository;

@WebMvcTest(cliente_controller.class)
public class ClienteControllerTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private cliente_repository clienterepository;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testGetAllClientes() throws Exception {
        when(clienterepository.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/clientes/"))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
        verify(clienterepository, times(1)).findAll();
    }

    @Test
    public void testGetClienteById() throws Exception{
        cliente cliente = new cliente();
        cliente.setIdCliente(1L);
        when(clienterepository.findById(1L)).thenReturn(Optional.of(cliente));
        mockMvc.perform(get("/api/clientes/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.idCliente").value(1));
        verify(clienterepository,times(1)).findById(1L);
    }
    @Test
    public void testCreateCliente() throws Exception{
        cliente cliente = new cliente();        
        cliente.setIdCliente(1L);
        when(clienterepository.save(any(cliente.class))).thenReturn(cliente);
        mockMvc.perform(post("/api/clientes")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\":null, \"nombrec\": null, \"email\": null, \"telefono\": null"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.idCliente").value(1));
        verify(clienterepository,times(1)).save(any(cliente.class));
    }

    @Test
    public void testUpdateCliente() throws Exception{
        cliente cliente = new cliente();        
        cliente.setIdCliente(1L);
        when(clienterepository.findById(1L)).thenReturn(Optional.of(cliente));
        mockMvc.perform(put("/api/clientes")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"id\":null, \"nombrec\": null, \"email\": null, \"telefono\": null"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.idCliente").value(1));
        verify(clienterepository,times(1)).findById(1L);
    }

    @Test
    public void testDeleteClienteByID() throws Exception{
        doNothing().when(clienterepository).deleteById(1L);
        mockMvc.perform(delete("/api/clientes/1"))
            .andExpect(status().isOk());
        verify(clienterepository, times(1)).deleteById(1L);
    }
}
