package com.ejemplo.mongo.Ejemplomongo.services;

import com.ejemplo.mongo.Ejemplomongo.models.Empleado;
import com.ejemplo.mongo.Ejemplomongo.repositories.AreaRepository;
import com.ejemplo.mongo.Ejemplomongo.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmpleadoService {
  @Autowired private EmpleadoRepository empleadoRepository;
  @Autowired private AreaRepository areaRepository;

  public Flux<Empleado> obtenerEmpleados() {
    return empleadoRepository.findAll();
  }

  public Mono<Empleado> crearEmpleado(Empleado empleado) {
    return areaRepository
        .findById(empleado.getAreaId())
        .flatMap(
            ar ->
                empleadoRepository
                    .findByDocumento(empleado.getDocumento())
                    .defaultIfEmpty(empleado)
                    .flatMap(
                        emp -> {
                          if (emp.getId() == null) {
                            return empleadoRepository.save(emp);
                          } else {
                            return Mono.just(emp);
                          }
                        })
                    .flatMap(
                        emp -> {
                          ar.getEmpleados().add(emp.getId());
                          areaRepository.save(ar).subscribe();
                          return Mono.just(emp);
                        }));
  }

  public Mono<Empleado> eliminarEmpleado(Long documento) {
    return empleadoRepository
        .findByDocumento(documento)
        .flatMap(
            emp -> {
              empleadoRepository.delete(emp).subscribe();
              return Mono.just(emp);
            })
        .flatMap(
            emp -> {
              areaRepository
                  .findById(emp.getAreaId())
                  .map(
                      ar -> {
                        ar.getEmpleados().remove(emp.getId());
                        areaRepository.save(ar).subscribe();
                        return Mono.just(ar);
                      })
                  .subscribe();
              return Mono.just(emp);
            });
  }

  public Mono<Empleado> actualizarEmpleado(Empleado empleado) {
      return empleadoRepository.findById(empleado.getId()).flatMap(em -> {
          if (empleado.getNombre() != null) {
              em.setNombre(empleado.getNombre());
          }
          if (empleado.getSalario() != null){
              em.setSalario(empleado.getSalario());
          }
          if (empleado.getAreaId() != null) {
              em.setAreaId(empleado.getAreaId());
          }
          if (empleado.getDocumento() != null) {
              em.setDocumento(empleado.getDocumento());
          }

          return empleadoRepository.save(em);
      });
  }
}
