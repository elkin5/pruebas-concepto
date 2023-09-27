package com.ejemplo.mongo.Ejemplomongo.controllers;

import com.ejemplo.mongo.Ejemplomongo.models.Empleado;
import com.ejemplo.mongo.Ejemplomongo.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("empleados")
public class EmpleadoController {
  @Autowired private EmpleadoService service;

  @GetMapping
  public Flux<Empleado> obtenerEmpleados() {
    return service.obtenerEmpleados();
  }

  @PostMapping
  public Mono<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
    return service.crearEmpleado(empleado);
  }

  @DeleteMapping("/{document}")
  public Mono<Empleado> eliminarEmpleado(@PathVariable(value = "document") Long document) {
    return service.eliminarEmpleado(document);
  }

  @PutMapping
  public Mono<Empleado> actualizarEmpleado(@RequestBody Empleado empleado) {
    return service.actualizarEmpleado(empleado);
  }

  /* @GetMapping("/{id}")
  public Mono<Empleado> obtenerEmpleadoPorId(@PathVariable(value="id") String id) {
    return service.obtenerEmpleadoPorId(id);
  }*/
}
