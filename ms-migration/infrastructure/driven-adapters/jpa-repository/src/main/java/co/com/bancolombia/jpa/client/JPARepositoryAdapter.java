package co.com.bancolombia.jpa.client;

import co.com.bancolombia.jpa.client.ClientData;
import co.com.bancolombia.jpa.client.JPARepository;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//Adapter para implementar metodos definidos en el repository del domain
@Repository
public class JPARepositoryAdapter extends AdapterOperations<Client/* change for domain model */, ClientData/* change for adapter model */, Long, JPARepository>
implements ClientRepository// implements ModelRepository from domain
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {

         // Could be use mapper.mapBuilder if your domain model implement builder pattern
         super(repository, mapper, d -> mapper.mapBuilder(d,Client.ClientBuilder.class).build());
         // Or using mapper.map with the class of the object model
        // super(repository, mapper, d -> mapper.map(d, Client.class/* change for domain model */));
    }

    @Override
    public List<Client> getClients() {
        return super.findAll();
    }

    @Override
    public Client getClientByMDMId(String mdmKey) {
        Optional<ClientData> client = this.repository.findClienByMDMId(mdmKey);
        return toEntity(client.orElse(new ClientData()));
    }
}
