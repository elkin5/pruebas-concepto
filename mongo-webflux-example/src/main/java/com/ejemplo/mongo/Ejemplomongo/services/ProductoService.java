package com.ejemplo.mongo.Ejemplomongo.services;

import com.ejemplo.mongo.Ejemplomongo.models.Producto;
import com.ejemplo.mongo.Ejemplomongo.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public Flux<Producto> getProductos() {
        return repository.findAll();
    }

    public Mono<Producto> crearProducto(Producto producto) {
        return repository.save(producto);
    }
}
