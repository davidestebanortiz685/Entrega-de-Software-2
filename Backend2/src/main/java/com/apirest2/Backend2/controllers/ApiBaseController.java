package com.apirest2.Backend2.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@ControllerAdvice
@OpenAPIDefinition(
    info = @Info(
        title = "API SOFTWARE 2",
        version="1.0",
        description = "API para el gestion de productos y ventas de Mandi Snap"
    ),
    tags={
        @Tag(name="Base Controller",
        description = "Controlador base para API, este controlador se extendera para todos los endpoints"
        )
    }
)
public class ApiBaseController {
    
}
