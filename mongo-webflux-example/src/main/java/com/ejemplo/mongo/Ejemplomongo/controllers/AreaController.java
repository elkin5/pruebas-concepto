package com.ejemplo.mongo.Ejemplomongo.controllers;

import com.ejemplo.mongo.Ejemplomongo.models.Area;
import com.ejemplo.mongo.Ejemplomongo.models.Empleado;
import com.ejemplo.mongo.Ejemplomongo.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("areas")
public class AreaController {
  @Autowired private AreaService service;

  @GetMapping
  public Flux<Area> obtenerAreas() {
    return service.obtenerAreas();
  }

  @PostMapping
  public Mono<Area> crearArea(@RequestBody Area area) {
    return service.crearArea(area);
  }

  @GetMapping("/{id}")
  public Mono<Area> obtenerAreaPorId(@PathVariable(value = "id") String id) {
    return service.obtenerAreaPorId(id);
  }

  @DeleteMapping("/{id}")
  public Mono<Area> eliminarEmpleado(@PathVariable(value="id") String id) {
    return service.eliminarArea(id);
  }

  @PutMapping
  public Mono<Area> actualizarArea(@RequestBody Area area) {
    return service.actualizarArea(area);
  }
}
