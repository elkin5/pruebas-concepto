package com.ejemplo.mongo.Ejemplomongo.repositories;

import com.ejemplo.mongo.Ejemplomongo.models.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {}
