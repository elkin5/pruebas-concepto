package com.ejemplo.mongo.Ejemplomongo.repositories;

import com.ejemplo.mongo.Ejemplomongo.models.Empleado;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmpleadoRepository extends ReactiveMongoRepository<Empleado, String> {
  Mono<Empleado> findByDocumento(Long documento);
}
