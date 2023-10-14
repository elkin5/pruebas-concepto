package co.com.bancolombia.jpa.client;

import co.com.bancolombia.jpa.client.ClientData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

// interface que hace uso de spring jpa para crear operacionea basicas de crud y operaciones
// construidas con JPQL
public interface JPARepository
    extends CrudRepository<ClientData /* change for adapter model */, Long>,
        QueryByExampleExecutor<ClientData /* change for adapter model */> {
  @Query("SELECT c FROM ClientData c where c.mdmKey = :mdmKey")
  Optional<ClientData> findClienByMDMId(@Param("mdmKey") String mdmKey);
}
