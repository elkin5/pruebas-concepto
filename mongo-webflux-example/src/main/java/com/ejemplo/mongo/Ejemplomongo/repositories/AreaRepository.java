package com.ejemplo.mongo.Ejemplomongo.repositories;

import com.ejemplo.mongo.Ejemplomongo.models.Area;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AreaRepository extends ReactiveMongoRepository<Area, String> {
    Mono<Area> findByNombre(String name);
}
