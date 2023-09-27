package com.ejemplo.mongo.Ejemplomongo.controllers;

import com.ejemplo.mongo.Ejemplomongo.models.Producto;
import com.ejemplo.mongo.Ejemplomongo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public Flux<Producto> getProductos() {
        return service.getProductos();
    }

    @PostMapping
    public Mono<Producto> crearProducto(@RequestBody Producto producto) {
        return service.crearProducto(producto);
    }
}
