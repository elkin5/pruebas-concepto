package com.ejemplo.mongo.Ejemplomongo.services;

import com.ejemplo.mongo.Ejemplomongo.models.Area;
import com.ejemplo.mongo.Ejemplomongo.repositories.AreaRepository;
import com.ejemplo.mongo.Ejemplomongo.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AreaService {
  @Autowired private AreaRepository areaRepository;
  @Autowired private EmpleadoRepository empleadoRepository;

  public Flux<Area> obtenerAreas() {
    return areaRepository.findAll();
  }

  public Mono<Area> crearArea(Area area) {
    return empleadoRepository
        .findByDocumento(area.getJefe().getDocumento())
        .defaultIfEmpty(area.getJefe())
        .flatMap(
            emp -> {
              if (emp.getId() == null) {
                return empleadoRepository.save(emp); // Se crea el nuevo empleado
              } else {
                return Mono.just(emp); // Se retorna el empleado encontrado
              }
            })
        .flatMap(
            emp ->
                areaRepository
                    .findByNombre(area.getNombre()) // Se busca el area si existe
                    .defaultIfEmpty(area)
                    .flatMap(
                        a -> {
                          a.setJefe(emp); // Se agrega el empleado como jefe de area
                          return areaRepository.save(a);
                        }));
  }

  public Mono<Area> eliminarArea(String id) {
    return areaRepository
        .findById(id)
        .flatMap(
            ar -> {
              ar.getEmpleados().forEach(e -> empleadoRepository.deleteById(e));
              areaRepository.delete(ar).subscribe();
              return Mono.just(ar);
            });
  }

  public Mono<Area> actualizarArea(Area area) {
      return areaRepository.findById(area.getId()).flatMap(ar -> {
          if (area.getEmpleados() != null) {
              ar.setEmpleados(area.getEmpleados());
          }
          if (area.getNombre() != null){
              ar.setNombre(area.getNombre());
          }
          if (area.getJefe() != null) {
              ar.setJefe(area.getJefe());
          }

          return areaRepository.save(ar);
      });
  }

  public Mono<Area> obtenerAreaPorId(String id) {
    return areaRepository.findById(id);
  }
}
