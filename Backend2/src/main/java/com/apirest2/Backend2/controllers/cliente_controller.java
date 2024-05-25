package com.apirest2.Backend2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.apirest2.Backend2.models.cliente;
import com.apirest2.Backend2.repositories.cliente_repository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/clientes")
public class cliente_controller {  
    @Autowired
    private   cliente_repository cliente_Repository;

    @GetMapping
    public List<cliente> GetAllClientes(){
        return cliente_Repository.findAll();
    }
    @GetMapping("/{id}")
    public cliente GetClientesById(@PathVariable Long id){
        return cliente_Repository.findById(id).orElse(null);
    }

    @PostMapping
    public cliente CreateCliente(@RequestBody cliente cliente){

        return cliente_Repository.save(cliente);
    }
    @PutMapping("/{id}")
    public cliente UpdateCliente(@PathVariable Long id, @RequestBody cliente cliente){
        cliente.setIdCliente(id);
        return cliente_Repository.save(cliente);
    }
    @DeleteMapping("/{id}")
    public void  DeleteCliente(@PathVariable Long id){
        cliente_Repository.deleteById(id);
    }
}
