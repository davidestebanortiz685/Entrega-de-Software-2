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


import com.apirest2.Backend2.controllers.producto_controller;
import com.apirest2.Backend2.models.producto;
import com.apirest2.Backend2.repositories.producto_repository;

@WebMvcTest(producto_controller.class)
public class ProductoControllerTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private producto_repository productorepository;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testGetAllClientes() throws Exception {
        when(productorepository.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/productos/"))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
        verify(productorepository, times(1)).findAll();
    }

    @Test
    public void testGetClienteById() throws Exception{
        producto producto = new producto();
        producto.setId(1L);
        when(productorepository.findById(1L)).thenReturn(Optional.of(producto));
        mockMvc.perform(get("/api/productos/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
        verify(productorepository,times(1)).findById(1L);
    }
    @Test
    public void testCreateProducto() throws Exception{
        producto producto = new producto();
        producto.setId(1L);
        when(productorepository.save(any(producto.class))).thenReturn(producto);
        mockMvc.perform(post("/api/productos")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\":null, \"nombrep\": null, \"precio\": null, \"peso\": null"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
        verify(productorepository,times(1)).save(any(producto.class));
    }

    @Test
    public void testUpdateCliente() throws Exception{
        producto producto = new producto();
        producto.setId(1L);
        when(productorepository.findById(1L)).thenReturn(Optional.of(producto));
        mockMvc.perform(put("/api/productos")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"id\":null, \"nombrep\": null, \"precio\": null, \"peso\": null"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1));
        verify(productorepository,times(1)).findById(1L);
    }

    @Test
    public void testDeleteClienteByID() throws Exception{
        doNothing().when(productorepository).deleteById(1L);
        mockMvc.perform(delete("/api/productos/1"))
            .andExpect(status().isOk());
        verify(productorepository, times(1)).deleteById(1L);
    }
}