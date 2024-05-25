package com.apirest2.Backend2.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest2.Backend2.models.producto;
import com.apirest2.Backend2.repositories.producto_repository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
public class producto_controller {  
    @Autowired
    private   producto_repository producto_Repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<producto> GetAllProductos(){
        return producto_Repository.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public producto GetProductosById(@PathVariable Long id){
        return producto_Repository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> CreateProducto(@RequestBody producto producto){
         producto_Repository.save(producto);
         return ResponseEntity.ok("producto creado exitosamente");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateProducto(@PathVariable Long id, @RequestBody producto  producto){
        producto.setId(id);
        producto_Repository.save(producto);
        return ResponseEntity.ok("Producto actualizado correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
      producto_Repository.deleteById(id);
      ResponseEntity<String> response = ResponseEntity.ok("Producto eliminado");
      return response;
    }
}

